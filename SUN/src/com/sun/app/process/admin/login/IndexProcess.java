package com.sun.app.process.admin.login;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.common.Process;
import com.sun.app.common.Result;

public class IndexProcess extends Process {

	@Override
	public Result process(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Object> model = new HashMap<String, Object>();
		String method = request.getMethod();
		if (method == "POST") {
			String rand = (String) request.getSession().getAttribute("rand");
			String code = request.getParameter("code");
			System.out.println(rand);
			System.out.println(code);
		} else {
		}
		System.out.println(method);
		
		return new Result(this.getFailureView(), model);
	}

}