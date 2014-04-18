package com.adminkiss.crm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SystemController {
	
	/**
	 * 系统参数设置
	 */
	@RequestMapping(value = "/system/setting", method = RequestMethod.GET)
	public String userAdd(HttpServletRequest request, Model model) {
		model.addAttribute("activeMenu","2");
		return "system/setting.ftl";
	}

	/**
	 * 权限信息管理
	 */
	@RequestMapping(value = "/system/right", method = RequestMethod.GET)
	public String right(HttpServletRequest request, Model model) {
		model.addAttribute("activeMenu","3");
		return "system/right.ftl";
	}
	
	/**
	 * 数据字典管理
	 */
	@RequestMapping(value = "/system/dictionary", method = RequestMethod.GET)
	public String dictionary(HttpServletRequest request, Model model) {
		model.addAttribute("activeMenu","4");
		return "system/dictionary.ftl";
	}
	
	/**
	 * 系统备份/恢复
	 */
	@RequestMapping(value = "/system/backup", method = RequestMethod.GET)
	public String backup(HttpServletRequest request, Model model) {
		model.addAttribute("activeMenu","5");
		return "system/backup.ftl";
	}
	
}