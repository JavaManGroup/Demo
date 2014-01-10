package com.sun.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import com.sun.core.Constants;
import com.sun.vo.Project;
import com.sun.vo.SysNews;

public class ClassUtil {

	public static Object convert(HttpServletRequest request, Class c)
			throws Exception {
		// TODO Auto-generated method stub
		Class r = Class.forName(c.getName());
		Object obj = r.newInstance();
		Field[] fields = c.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			try {
				String MethodStr = "set"
						+ fields[i].getName().replaceFirst(
								fields[i].getName().substring(0, 1),
								fields[i].getName().substring(0, 1)
										.toUpperCase());
				String fileStr = fields[i].getType().toString().split(" ")[1];
				String parameter = request.getParameter(fields[i].getName());
				Method method = c.getMethod(MethodStr, Class.forName(fileStr));
				if (fields[i].getName().equalsIgnoreCase("userId")) {
					Object userId = request.getSession().getAttribute(
							Constants.LOGIN_USER_ID);
					System.out.println("方法"+method.getName()+":"+userId);
					method.invoke(obj, (Integer) userId);
				} else if (fields[i].getName().equalsIgnoreCase("updatetime")) {
					System.out.println("方法"+method.getName()+":"+new Date());
					method.invoke(obj, new Date());
				} else if (fields[i].getName().equalsIgnoreCase("isDel")) {
					System.out.println("方法"+method.getName()+":"+0);
					method.invoke(obj, 0);
				} else if (fileStr.equalsIgnoreCase("java.lang.Integer")) {
					System.out.println("方法"+method.getName()+":"+parameter);
					method.invoke(obj, Integer.valueOf(parameter));
				} else if (fileStr.equalsIgnoreCase("java.lang.String")) {
					System.out.println("方法"+method.getName()+":"+parameter);
					method.invoke(obj, parameter);
				} else if (fileStr.equalsIgnoreCase("java.util.Date")) {
					System.out.println("方法"+method.getName()+":"+parameter);
					DateFormat format = new SimpleDateFormat(Constants.DATEFORMAT);
					method.invoke(obj, format.parse(parameter));
				}
			} catch (Exception e) {
				System.out.println(fields[i].getType() + "   "
						+ fields[i].getName());
			}
		}

		// 这里是里获取属性的值
		return obj;
	}

	public static void main(String[] args) {
		Project project = new Project();
		SysNews news = new SysNews();
		HttpServletRequest request = null;
		try {
			convert(request, Vo.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
