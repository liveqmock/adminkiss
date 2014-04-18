package com.adminkiss.crm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adminkiss.core.common.AjaxResponse;
import com.adminkiss.core.utils.StringUtils;
import com.adminkiss.crm.service.CommonService;

@Controller
public class HomeController {
	
	@Autowired
	private CommonService commonService;
	
	/**
	 * 进入首页
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
		return index(request, model);
	}

	/**
	 * 进入首页
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model) {
		model.addAttribute("activeMenu","0");
		return "index.ftl";
	}
	
	/**
	 * 进入登录页面
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, Model model, 
			@RequestParam(value="refurl", required=false) String refurl,
			@RequestParam(value="error", required=false) String error) {
		if(StringUtils.isNotEmpty(refurl)) {
			model.addAttribute("refurl", refurl);
		}
		return "login.ftl";
	}
	
	/**
	 * 登录验证
	 * @return
	 */
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse doLogin(HttpServletRequest request, HttpServletResponse response, Model model, 
			@RequestParam("username") String username, @RequestParam("password") String password) {
		AjaxResponse ajax = new AjaxResponse();
		try {
			int result = commonService.login(request, username, password);
			if(result==1) {
				ajax.setCode(AjaxResponse.SUCCESS);
				ajax.setResult(result);
			} else {
				ajax.setCode(AjaxResponse.FAILURE);
				ajax.setResult(result);
			}
		} catch (Exception e) {
			ajax.setCode(AjaxResponse.ERROR);
			e.printStackTrace();
		}
		return ajax;
	}
	
	/**
	 * 退出系统
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, Model model) {
		commonService.logout(request);
		return "redirect:/login";
	}
	
	/**
	 * 内部系统错误
	 * @return
	 */
	@RequestMapping(value = "/error/500")
	public String uncaughtException(HttpServletRequest request, Model model, Throwable exception) {
		Throwable ex = null;
		if (exception != null) {
			ex = exception;
		}
		if (request.getAttribute("javax.servlet.error.exception") != null) {
			ex = (Throwable) request.getAttribute("javax.servlet.error.exception");
			model.addAttribute("msg", ex.getMessage());
		}
		//记录日志
		Logger logger = LoggerFactory.getLogger("500");
		logger.error(ex.getMessage(), ex);
		return "error/500.ftl";
	}
	
	/**
	 * 资源不存在
	 * @return
	 */
	@RequestMapping(value = "/error/404")
	public String resourceNotFound(HttpServletRequest request, Model model) {
		return "error/404.ftl";
	}
	
	/**
	 * 没有权限
	 * @return
	 */
	@RequestMapping(value = "/error/403")
	public String notPermission(HttpServletRequest request, Model model) {
		return "error/403.ftl";
	}

}
