package com.adminkiss.core.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * 项目底层工具类 模块描述：数字工具类。继承lang3中的NumberUtils。
 * 
 */
public class NumberUtils extends org.apache.commons.lang3.math.NumberUtils {

	/**
	 * 输出数字的格式,如:1,234,567.89
	 * 
	 * @param bd
	 *            BigDecimal 要格式华的数字
	 * @param format
	 *            String 格式 "###,##0"
	 * @return String
	 */
	public static String numberFormat(double bd, String format) {
		DecimalFormat decimalFormat = new DecimalFormat(format);
		return decimalFormat.format(bd);
	}

	/**
	 * 格式化货币
	 * 
	 * @param d
	 *            double
	 * @param pattern
	 *            String "￥#,###.00" :显示为 ￥1，234，234.10
	 * @param l
	 *            Locale
	 * @return String
	 */
	public static String formatCurrency(double d, String pattern, Locale l) {
		DecimalFormat decimalFormat = (DecimalFormat) NumberFormat
				.getCurrencyInstance(l);
		decimalFormat.applyPattern(pattern);
		return decimalFormat.format(d);
	}

	/**
	 * 使用默认区域的指定方式显示货币
	 * 
	 * @param d
	 *            double
	 * @param pattern
	 *            String
	 * @return String
	 */
	public static String formatCurrency(double d, String pattern) {
		return formatCurrency(d, pattern, Locale.getDefault());
	}

	/**
	 * 将数字字符串转化为 long 数据类型
	 * 
	 * @param str
	 * @return
	 */
	public static long paserLong(String str) {
		return Long.parseLong(str);
	}

	/**
	 * 数字比较大小(true代表sourceNum<targetNum)
	 * 
	 * @param sourceNum
	 * @param targetNum
	 * @return
	 */
	public static boolean isLessThan(Object sourceNum, Object targetNum) {
		if (sourceNum == null || targetNum == null) {
			return false;
		}
		BigDecimal source = NumberUtils.createBigDecimal(sourceNum.toString());
		BigDecimal target = NumberUtils.createBigDecimal(targetNum.toString());
		int result = source.compareTo(target);
		if (result == -1) {
			return true;
		}
		return false;
	}
	
	/**
	 * 随机生成一定范围随机数
	 * @param max
	 * @return
	 */
	public static int randomNumber(int max) {
		return (int)(Math.random()*max);
	}

}