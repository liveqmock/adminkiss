package com.adminkiss.core.utils;


/**
 * 字符串处理工具类
 * 
 */
public class StringUtils {
	
	public static final String TOP_CATEGORY_CODE = "A";
	
	public static final String ROOT_CATEGORY_CODE = "A001";
	
	public static final String DEFAULT_CATEGORY_CODE_FORMAT = "000";
	
	/**
	 * 判断是否为空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if (str!=null && str.trim().length()>0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return !isNotEmpty(str);
	}
	
	/**
	 * 清楚所有首尾空格
	 * @param str
	 * @return
	 */
	public static String trim(String str) {
		return str == null ? "" : str.trim();
	}
	
	/**
	 * 创建同级下一类别（类别，类别格式A001B001C001） 输入参数：@param categoryCode 类别 　　　　　@param
	 * number 序号
	 */
	public static String getNextCategory(String categoryCode) {
		if (StringUtils.isEmpty(categoryCode)) {
			return getChildCategory(ROOT_CATEGORY_CODE);
		}
		String num = categoryCode.substring(categoryCode.length() - 3,
				categoryCode.length());
		categoryCode = categoryCode.substring(0, categoryCode.length() - 3);
		int nextNum = Integer.parseInt(num) + 1;
		String newNum = NumberUtils.numberFormat(nextNum,
				DEFAULT_CATEGORY_CODE_FORMAT);
		return categoryCode + newNum;
	}
	
	/**
	 * 创建新的子类别（父子类别，类别格式A001B001C001） 输入参数：@param parentCode 父类类别 　　　　　@param
	 * number 序号
	 */
	public static String getChildCategory(String parentCode) {
		if (StringUtils.isEmpty(parentCode)) {
			parentCode = TOP_CATEGORY_CODE;
		} else {
			char num = parentCode.charAt(parentCode.length() - 4);
			parentCode = parentCode + (++num);
		}
		String newNum = NumberUtils.numberFormat(1,
				DEFAULT_CATEGORY_CODE_FORMAT);
		return parentCode + newNum;
	}
	
}