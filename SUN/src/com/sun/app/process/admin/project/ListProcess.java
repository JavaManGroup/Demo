package com.sun.app.process.admin.project;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sun.app.process.PagingBaseProcess;
import com.sun.core.common.PagingList;

public class ListProcess extends PagingBaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		List allProtype = getServMgr().getAdminProjectService().getALlProjectType();
		model.put("allProtype", allProtype);
		String page = request.getParameter("page");
		if(page!=null)
			if (request.getMethod() == "POST" && page.equals("false")) {
				doPost(request, response, model);
				return model;
			}
		
		PagingList projectPageList = getServMgr().getAdminProjectService()
				.getProjectPageList(request);
		List list = projectPageList.getList();
		Iterator it = list.iterator();
		// 统计工程的图片
		while (it.hasNext()) {
			Map project = (Map) it.next();
			Integer projectId = (Integer) project.get("id");
			Integer count = getServMgr().getAdminProjectService()
					.getProjectImageCount(projectId);
			Integer userId = (Integer) project.get("user_id");
			Map user;
			try {
				user = getServMgr().getUserService().getUserById(userId);
				project.put("author", user.get("realname"));
			} catch (Exception e) {
				project.put("author", null);
			}
			project.put("count", count);
		}
		model.put("allproject", projectPageList);
		return model;
	}

	public HashMap<String, Object> doPost(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		String typeId = request.getParameter("typeId");
		
		PagingList projectPageList = getServMgr().getAdminProjectService()
				.getProjectSearch(request);
		List list = projectPageList.getList();
		Iterator it = list.iterator();
		// 统计工程的图片
		while (it.hasNext()) {
			Map project = (Map) it.next();
			Integer projectId = (Integer) project.get("id");
			Integer count = getServMgr().getAdminProjectService()
					.getProjectImageCount(projectId);
			Integer userId = (Integer) project.get("user_id");
			Map user;
			try {
				user = getServMgr().getUserService().getUserById(userId);
				project.put("author", user.get("realname"));
			} catch (Exception e) {
				project.put("author", null);
			}
			project.put("count", count);
		}
		model.put("allproject", projectPageList);
		return model;
	}

}