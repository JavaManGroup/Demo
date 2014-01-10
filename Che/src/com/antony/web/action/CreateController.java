package com.antony.web.action;

//import javax.inject.Inject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/create")
public class CreateController extends BaseController {

	@RequestMapping("")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("uuid", 10001);

		return "/create/c0001";
	}

	@RequestMapping("select_friends")
	public String select_friends(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("dd");
		return "/create/c0002";
	}

}