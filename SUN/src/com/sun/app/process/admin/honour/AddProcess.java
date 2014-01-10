package com.sun.app.process.admin.honour;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sun.app.process.AjaxDwzResultProcess;
import com.sun.app.process.BaseProcess;
import com.sun.app.process.DefaultProcess;
import com.sun.core.util.CommonUtil;

public class AddProcess extends AjaxDwzResultProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {

		int r = getServMgr().getHonourService().add(request, getIP(request));
		System.out.println(appName);
		if(r == -2){
			model.putAll(ForwardJson(300, "请上传图片", appName,"honour.do"));
			return model;
		}
		if (r > 0)
			model.putAll(ForwardJson(200, "操作成功", appName,"honour.do"));
		else
			model.putAll(ForwardJson(300, "操作失败", appName,"honour.do"));
		return model;
	}
}