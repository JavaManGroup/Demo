package com.sun.core.interceptor;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sun.core.Constants;
import com.sun.core.util.CommonUtil;
import com.sun.dao.SysFileMapper;
import com.sun.vo.SysFile;

/**
 * 文件上传拦截器
 * 
 * @author LH
 * 
 */
public class FileUploadInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private SysFileMapper fileMapper;

	private List<String> adapterURLs;// 适用的URL
	private boolean exactMatch = true;

	public void setExactMatch(boolean exactMatch) {
		this.exactMatch = exactMatch;
	}

	public void setAdapterURLs(List<String> adapterURLs) {
		this.adapterURLs = adapterURLs;
	}

	private String uploadPath;
	// 0:不建目录 1:按天存入目录 2:按月存入目录
	private String dirType = "1";

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public void setDirType(String dirType) {
		this.dirType = dirType;
	}
	

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		if (adapterURL(request.getServletPath())) {
			System.out.println("文件上传拦截器");
			response.setContentType("text/html"); // 必须，否则会抛异常
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			MultipartFile file = multipartRequest.getFile("file");
			File uploadfile = CommonUtil.CommonFileUploadUtil(uploadPath,
					dirType, request, file);
			
			String fileFolder = "";
			if (dirType.equalsIgnoreCase("1"))
				fileFolder = new SimpleDateFormat("yyyyMMdd").format(new Date());;
			if (dirType.equalsIgnoreCase("2"))
				fileFolder = new SimpleDateFormat("yyyyMM").format(new Date());
			
			/*文件存储的相对路径*/
			String saveDirPath = uploadPath +fileFolder + "/";
			
			request.setAttribute("fileName", uploadfile.getName());
			request.setAttribute("attachmentPath", saveDirPath+uploadfile.getName());
			request.setAttribute("attachmentSize", file.getSize());
			System.out.println(file.getOriginalFilename() + "拦截器！！！！！！！！！");
			
			
		}
		return true;
	}

	private boolean adapterURL(String sourceURL) {
		if (exactMatch) {
			return adapterURLs.contains(sourceURL);
		} else {
			for (String url : adapterURLs) {
				if (url.endsWith("/*")) {
					if (sourceURL.startsWith(url.replace("/*", ""))) {
						return true;
					}
				} else if (url.equals(sourceURL)) {
					return true;
				}
			}
		}
		return false;
	}

	public String getIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("x-forward-for");
			if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}
		}
		return ip;
	}

}
