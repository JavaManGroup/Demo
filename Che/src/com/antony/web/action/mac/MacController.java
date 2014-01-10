package com.antony.web.action.mac;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.antony.web.action.BaseController;

@Controller
@RequestMapping("/mac")
public class MacController extends BaseController {
	@RequestMapping("")
	public String index(HttpServletRequest request, HttpServletResponse response) {
			List list = getServMgr().getUserService().getTest();
			System.out.println(list);
		return "/home/index";
	}

	@RequestMapping(value = "test/{Id}", method = RequestMethod.GET)
	public void test(@PathVariable("Id") String Id, HttpServletRequest request,
			HttpServletResponse response) {
		Map json = new HashMap();

		System.out.println(Id);
		json.put("status", 300);
		json.put("statusCode", 300);
		json.put("message", "你的Id是" + Id);
		sendJson(response, json);
	}

	@RequestMapping(value = "key", method = RequestMethod.POST)
	public void key(HttpServletRequest request, HttpServletResponse response) {
		Map json = new HashMap();
		System.out.println("dfdfdfs");
		String status = request.getParameter("status");
		System.out.println(status);
		String message = request.getParameter("message");
		System.out.println(message);
		json.put("status", 300);
		json.put("statusCode", 300);
		json.put("message", "你的Id是");
		sendJson(response, json);
	}

	@RequestMapping(value = "root")
	public void root(HttpServletRequest request, HttpServletResponse response) {
		String city = request.getParameter("city");
		
		String lng = request.getParameter("lng");
		String lat = request.getParameter("lat");
		String rc = request.getParameter("rc");
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		
		System.out.println("city:"+city+",lng:"+lng+"lat:"+lat+",rc:"+rc+",from:"+from+",to"+to);
		
		Map creater = new HashMap();
		creater.put("sc_name", "Jone");
		creater.put("sc_sex", "M");
		creater.put("sc_imageurl", "http://192.168.0.103:8080/che/uploads/1.jpg");
		List uni_creaters =  new ArrayList();
		Map url1 = new HashMap();
		url1.put("cimage_url", "http://192.168.0.103:8080/che/uploads/1.jpg");
		Map url2 = new HashMap();
		url2.put("cimage_url", "http://192.168.0.103:8080/che/uploads/2.jpg");
		uni_creaters.add(url1);
		uni_creaters.add(url2);
		uni_creaters.add(url1);
		uni_creaters.add(url2);
		
		Map json = new HashMap();
		json.put("total", "300");
		json.put("indexnum", "121286");
		List names = new ArrayList();
		Map name1 = new HashMap();
		Map name2 = new HashMap();
		name1.put("party_name", "告别星空2012”K歌联盟");
		name1.put("party_addr", "西城区西直门交大东路46号(佰金KTV对面胡同里)");
		name1.put("party_id", "1");
		name1.put("party_type", "购物吧");
		name1.put("party_time", "2013年1月18日, AM 10:32:10");
		name1.put("start_creater", creater);
		name1.put("uni_creaters", uni_creaters);
		
		
		names.add(name1);
		names.add(name1);
		json.put("names", names);
		sendJson(response, json);
	}

	@RequestMapping(value = "party")
	public void party(HttpServletRequest request, HttpServletResponse response) {
		String party_id = request.getParameter("party_ id");
		System.out.println("party_ id:"+party_id);
		Map creater = new HashMap();
		creater.put("c_name", "Ann");
		creater.put("user_id", "123456");
		creater.put("c_imageurl", "http://www.dsffd");
		List uni_creaters =  new ArrayList();
		Map partic = new HashMap();
		partic.put("p_name", "Ann");
		partic.put("p_imageurl", "http://www.dsffd");
		Map json = new HashMap();
		json.put("lng", "120.256");
		json.put("lat", "145.236");
		json.put("creater_num", "3");
		json.put("creater_num", "12");
		json.put("party_name", "告别星空2012”K歌联盟");
		json.put("party_addr", "西城区西直门交大东路46号(佰金KTV对面胡同里)");
		json.put("party_type", "购物吧");
		json.put("party_typeid", "145");
		json.put("party_time", "2013年2月15号 12：30");
		json.put("party_des", "海底捞餐饮有限责任公司成立于1994年，是一家以经营川味火锅为主,融汇各 地火锅特色为一体的大型连锁餐饮民营企业。公司自成立以来，始终奉行“服务至上，顾客至上”的理念，以贴心，周到，优质的服务，赢得了纷至沓来的顾客 和社会广泛赞誉.公司始终高扬...");
		List creats = new ArrayList();
		List participants = new ArrayList();
		creats.add(creater);
		creats.add(creater);
		participants.add(partic);
		participants.add(partic);
		json.put("creats", creats);
		json.put("participants", participants);
		sendJson(response, json);
	}
	



}