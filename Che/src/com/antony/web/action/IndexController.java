package com.antony.web.action;

//import javax.inject.Inject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController extends BaseController {

	@RequestMapping("")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("uuid", 10001);

		return "/home/index";
	}

	@RequestMapping("party/{Id}")
	public String party(@PathVariable("Id") int Id, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("dd");
		request.setAttribute("partyId", Id);

		return "/home/party";
	}

	@RequestMapping("party_add/{Id}")
	public String partyAdd(@PathVariable("Id") int Id, Model model) {
		System.out.println("dd");

		return "/home/party_add";
	}

	@RequestMapping("party_invite/{Id}")
	public String partyInvite(@PathVariable("Id") int Id,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("dd");
		request.setAttribute("partyId", Id);
		return "/home/party_inviter";
	}

	@RequestMapping("message")
	public String message(HttpServletRequest request,
			HttpServletResponse response) {

		return "/home/message";
	}

	@RequestMapping("message_system")
	public String message_system(HttpServletRequest request,
			HttpServletResponse response) {

		return "/home/message_system";
	}

	@RequestMapping("message_friend")
	public String message_friend(HttpServletRequest request,
			HttpServletResponse response) {

		return "/home/message_friend";
	}

	@RequestMapping("message_party")
	public String message_party(HttpServletRequest request,
			HttpServletResponse response) {

		return "/home/message_party";
	}

}