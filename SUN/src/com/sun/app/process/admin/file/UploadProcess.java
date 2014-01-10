package com.sun.app.process.admin.file;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;

import com.sun.app.bean.FileUploadBean;
import com.sun.app.process.BaseProcess;
import com.sun.app.process.FileUploadBaseProcess;

public class UploadProcess extends BaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		Object attribute = request.getAttribute("fileName");
		String name = (String) attribute;
		model.put("id", "1000");
		model.put("fileName", name);
		model.put("attachmentPath", "sdf");
		model.put("attachmentSize", "123");
		return model;
	}

}