package com.sun.app.process.admin.project;

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
	// 0:不建目录 1:按天存入目录 2:按月存入目录
	private String dirType = "1";
	private String uploadPath;

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		String typeId = request.getParameter("typeId");
		if (typeId.equals("0")) {
			model.putAll(ForwardJson(300, "请选择分类", appName));
			return model;
		}
		String fileName = request.getParameter("dwz.attachment.fileName");
		if(fileName.isEmpty()){
			model.putAll(ForwardJson(300, "请上传图片", appName));
			return model;
		}
		if(fileName.equals("上传格式错误")){
			model.putAll(ForwardJson(300, "上传文件格式错误", appName));
			return model;
		}

		int r = getServMgr().getAdminProjectService().addProjectMain(request);
		if (r > 0)
			model.putAll(ForwardJson(200, "操作成功", appName));
		else
			model.putAll(ForwardJson(300, "操作失败", appName));
		return model;
	}

}