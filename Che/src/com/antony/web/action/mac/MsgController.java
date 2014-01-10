package com.antony.web.action.mac;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.antony.util.HTTPUtil;
import com.antony.util.PassUtil;
import com.antony.web.action.BaseController;

@Controller
@RequestMapping("/mac/msg")
public class MsgController extends BaseController {

	@RequestMapping("")
	public void index(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("大幅度反弹幅度");
		getServMgr().getMessageService().createMsg();
		Map json = new HashMap();
		json.put("status", 200);
		sendJson(response, json);
	}
	
	//服务器根据传入的用户的邮箱mail，并将新密码发至此邮箱；
	@RequestMapping("IF00067")
	public void IF00067(HttpServletRequest request, HttpServletResponse response) {
		//获取变量
		String mail = request.getParameter("mail");
		//生成新密码
		String pass = PassUtil.genRandomNum(6);
		String s1 = HTTPUtil.sendPost("http://localhost:8080/antony/mac/api/IF00067", "mail="+mail+"&pass="+pass);  
        System.out.println(s1);
        //修改密码
        int i = getServMgr().getUserService().updatePassForget(mail,pass);
        
        if(i>0){
    		//返回结果
    		Map json = new HashMap();
    		json.put("status", 200);
    		sendJson(response, json);
        }else{
        	//返回结果
    		Map json = new HashMap();
    		json.put("status", 300);
    		sendJson(response, json);
        }
	}

	@RequestMapping("IF00060")
	public void IF00060(HttpServletRequest request, HttpServletResponse response) {

		// 获取变量

		String uuid = request.getParameter("uuid");

		System.out.println("IF00060   uuid:" + uuid);
		Map count = getServMgr().getMessageService().getMsgCount(uuid);
		Map json = new HashMap();
		json.put("status", 200);
		json.put("party_count", count.get("PARTY_COUNT"));
		json.put("friend_count", count.get("FRIEND_COUNT"));
		json.put("system_count", count.get("SYSTEM_COUNT"));

		sendJson(response, json);
	}

	@RequestMapping("IF00061")
	public void IF00061(HttpServletRequest request, HttpServletResponse response) {
		// 获取变量
		String uuid = request.getParameter("uuid");
		String type = request.getParameter("m_type");
		System.out.println("IF00061   uuid:" + uuid + " m_type :" + type);
		int i = getServMgr().getMessageService().resetMsgCount(uuid, type);
		Map json = new HashMap();
		json.put("status", 200);
		sendJson(response, json);
	}

	@RequestMapping("IF00062")
	public void IF00062(HttpServletRequest request, HttpServletResponse response) {
		// 获取变量
		String uuid = request.getParameter("uuid");
		String token = request.getParameter("token");
		System.out.println("IF00061   uuid:" + uuid + " token :" + token);
		int i = getServMgr().getMessageService().updateToken(uuid, token);
		Map json = new HashMap();
		json.put("status", 200);
		sendJson(response, json);
	}

}
