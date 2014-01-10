package com.sun.app.process.front;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;
import com.sun.core.common.PagingList;

public class SearchProcess extends BaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("检索");
		String s = request.getParameter("s");
		String typeId = request.getParameter("typeId");
		if(typeId.equals("1")){
			System.out.println("-------------------->");
			List list  = getServMgr().getNewsService().homeSearch(s,request);
			System.out.println(list);
			model.put("list", list);
			model.put("key",s);
			model.put("typeId", typeId);
			model.put("url", "news.do?command=detail&newsId");
		}
		if(typeId.equals("2")){
			System.out.println("-------------------->");
			List list  = getServMgr().getAdminProjectService().homeSearch(s,request);
			System.out.println(list);
			model.put("list", list);
			model.put("key",s);
			model.put("typeId", typeId);
			model.put("url", "project.do?command=detail&projectId");
		}
		if(typeId.equals("3")){
			System.out.println("-------------------->");
			List list  = getServMgr().getZhaopinService().homeSearch(s,request);
			System.out.println(list);
			model.put("list", list);
			model.put("key",s);
			model.put("typeId", typeId);
			model.put("url", "zhaopin.do?command=detail&zhaopinId");
			
		}
		String flashPath = getServMgr().getSysService().queryForFlash();
		model.put("fpath", flashPath);
		return model;
	}

}