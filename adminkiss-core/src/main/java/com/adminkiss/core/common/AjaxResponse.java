package com.adminkiss.core.common;

/**
 * ajax操作返回信息
 */
public class AjaxResponse {
	
	public static final String ERROR = "-1";
	
	public static final String SUCCESS = "1";
	
	public static final String FAILURE = "0";
	
	private String code;
	
	private String msg;
	
	private Object result;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
}