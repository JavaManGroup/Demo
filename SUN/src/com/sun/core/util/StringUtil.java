package com.sun.core.util;

public class StringUtil {
	/**
	 * 数值类型字符转换为Interger
	 * @param s
	 * @return
	 */
	public static Integer valueOf(String s) {
		Integer i = 0;
		try {
			i = Integer.valueOf(s);
		} catch (NumberFormatException e) {
		}
		return i;
	}

}
