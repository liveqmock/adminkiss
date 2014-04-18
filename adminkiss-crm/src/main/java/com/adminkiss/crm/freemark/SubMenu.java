package com.adminkiss.crm.freemark;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.adminkiss.core.auth.AuthMenu;
import com.adminkiss.core.cache.MemcachedType;
import com.adminkiss.core.cache.SpyMemcachedClient;
import com.adminkiss.crm.service.CommonService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 自定义权限菜单
 * @author tulf
 * 
 * <@subMenu roleId=loginUser.roleId context=contextPath/>
 */
public class SubMenu implements TemplateDirectiveModel {
	
	@Autowired
	private SpyMemcachedClient memcachedClient;
	
	@Autowired
	private CommonService commonService;
	
	@Override
	@SuppressWarnings("rawtypes")
	public void execute(Environment env, Map params, TemplateModel[] loopVars, 
			TemplateDirectiveBody body) throws TemplateException, IOException {
		String showStr = "";
		try {
			String roleId = String.valueOf(params.get("roleId"));
			String context = String.valueOf(params.get("context"));
			if (StringUtils.isNotEmpty(roleId)) {
				showStr = getCacheMenuList(context, roleId);
			}
			env.getOut().write(showStr);
		} catch (RuntimeException e) {
			e.printStackTrace();
			env.getOut().write("");
		}
	}

	private String getCacheMenuList(String context, String roleId) {
		String key = MemcachedType.SUM_MENU_BY_ROLEID.getPrefix()+roleId;
		String menuStr = memcachedClient.get(key);
		if (StringUtils.isEmpty(menuStr)) {
			StringBuilder result = new StringBuilder();
			List<AuthMenu> menus = commonService.selectMenuByRoleId(Long.valueOf(roleId));
			result.append("<ul>");
			// 首页
			result.append("<li id='leftMenu0'><a href='");
			result.append(buildUrl(context, "/index"));
			result.append("'><i class='fa fa-lg fa-fw fa-home'></i><span class='menu-item-parent'>首页</span></li>");
			result = buildMenuStr(context, result, menus);
			result.append("</ul>");
			menuStr = result.toString();
			if (StringUtils.isNotEmpty(menuStr)) {
				memcachedClient.set(key, MemcachedType.SUM_MENU_BY_ROLEID.getExpiredTime(), menuStr);
			}
		}
		return menuStr;
	}
	
	private StringBuilder buildMenuStr(String context, StringBuilder result, List<AuthMenu> menus) {
		for (AuthMenu menu:menus) {
			if (menu.getLeaf()==1) {
				result.append("<li id='leftMenu");
				result.append(menu.getId());
				result.append("'><a href='#'>");
				if (StringUtils.isNotEmpty(menu.getIconSkin())) {
					result.append("<i class='fa fa-lg fa-fw ");
					result.append(menu.getIconSkin());
					result.append("'></i>");
				}
				result.append("<span class='menu-item-parent'>");
				result.append(menu.getName());
				result.append("</span></a>");
				result.append("<ul>");
				result = buildMenuStr(context, result, menu.getChild());
                result.append("</ul></li>");
			} else {
				result.append("<li id='leftMenu");
				result.append(menu.getId());
				result.append("'><a href='");
				result.append(buildUrl(context, menu.getUrl()));
				result.append("'>");
				if (StringUtils.isNotEmpty(menu.getIconSkin())) {
					result.append("<i class='fa fa-lg fa-fw ");
					result.append(menu.getIconSkin());
					result.append("'></i>");
				}
				result.append("<span>");
				result.append(menu.getName());
				result.append("</span></a></li>");
			}
		}
		return result;
	}
	
	private String buildUrl(String context, String uri) {
		if(StringUtils.isNotEmpty(context)&&!context.equals("/")) {
			return context + uri;
		}
		return uri;
	}

}