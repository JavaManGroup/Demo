/**
 * @Create Time：2010-7-9 上午10:35:08 
 * @author ZhouRongyu
 * © 2010-2015 SunCompany. All rights reserved
 */
package com.sun.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	public static String dateToDatetime(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = df.format(date);
		return time;
	}
}
/* 使用TimeUtil.dateToDatetime(new Date()) */
