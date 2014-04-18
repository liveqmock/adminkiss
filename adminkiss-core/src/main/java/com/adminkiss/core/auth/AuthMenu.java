package com.adminkiss.core.auth;

import java.io.Serializable;
import java.util.List;

public class AuthMenu implements Serializable {

	private static final long serialVersionUID = 844292884735412374L;
	
	public static final Long ROOT_MENU_ID = 0L;

	private Long id;// 主健ID、唯一标识

	private String name;// 菜单名称
	
	private String url;// 地址

	private String iconSkin;// 图标css样式
	
	private Short leaf;// 是否有子节点
	
	private Short sort;
	
	private List<AuthMenu> child;// 子类

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIconSkin() {
		return iconSkin;
	}

	public void setIconSkin(String iconSkin) {
		this.iconSkin = iconSkin;
	}

	public List<AuthMenu> getChild() {
		return child;
	}

	public void setChild(List<AuthMenu> child) {
		this.child = child;
	}

	public Short getSort() {
		return sort;
	}

	public void setSort(Short sort) {
		this.sort = sort;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Short getLeaf() {
		return leaf;
	}

	public void setLeaf(Short leaf) {
		this.leaf = leaf;
	}

}