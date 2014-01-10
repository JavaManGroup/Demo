package com.antony.web.action.mac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import com.antony.util.MainApnsSend;

public class pushServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(ServletRequest request, ServletResponse res)
			throws ServletException, IOException {
		/*第一步：设置编码*/
		request.setCharacterEncoding("UTF-8");
		/*第二步：获取请求的参数*/
		String device = request.getParameter("deviceToken");//设备号
		String content = request.getParameter("content");//要发送的内容
		/*第三步：获取参数值，并设置证书*/
		try{
			MainApnsSend.sendCommerceAPNS();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("push succeed");
	}
}
