package com.sun.app.process.admin.project;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sun.app.process.BaseProcess;
import com.sun.core.util.CommonUtil;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class UploadProcess extends BaseProcess {

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
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		String method = request.getMethod();
		if (method == "POST") {
			doPost(request, response, model);
		}
		model.put("method", method);
		return model;
	}

	public HashMap<String, Object> doPost(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("file");
		/* 获取文件上传路径名称 */
		String fileNameLong = file.getOriginalFilename();
		String contentType = file.getContentType();
		if (!contentType.equals("image/jpg")
				&& !contentType.equals("image/png")
				&& !contentType.equals("image/jpeg")
				&& !contentType.equals("image/gif")
				&& !contentType.equals("image/pjpeg")
				&& !contentType.equals("image/jpeg")) {
			model.put("fileName", "上传格式错误");
			model.put("attachmentPath", "/themes/default/images/fengmian.jpg");

			return model;
		}
		/* 获取文件扩展名 */
		/* 索引加1的效果是只取xxx.jpg的jpg */
		String extensionName = fileNameLong.substring(fileNameLong
				.lastIndexOf(".") + 1);
		String newFileName = "";
		/* 获取文件上传存储的相当路径 */
		String realBaseDir = request.getSession().getServletContext()
				.getRealPath(uploadPath);
		File baseFile = new File(realBaseDir);
		if (!baseFile.exists()) {
			baseFile.mkdir();
		}

		// 0:不建目录, 1:按天存入目录, 2:按月存入目录, 3:按扩展名存目录.建议使用按天存.
		String fileFolder = "";
		if (dirType.equalsIgnoreCase("1"))
			fileFolder = new SimpleDateFormat("yyyyMMdd").format(new Date());
		;
		if (dirType.equalsIgnoreCase("2"))
			fileFolder = new SimpleDateFormat("yyyyMM").format(new Date());

		/* 文件存储的相对路径 */
		String saveDirPath = uploadPath + fileFolder + "/";

		/* 文件存储在容器中的绝对路径 */
		String saveFilePath = request.getSession().getServletContext()
				.getRealPath("")
				+ saveDirPath;

		/* 构建文件目录以及目录文件 */
		File fileDir = new File(saveFilePath);
		if (!fileDir.exists()) {
			fileDir.mkdirs();
		}

		/* 重命名文件 */
		String filename = UUID.randomUUID().toString();
		File savefile = new File(saveFilePath + filename.substring(0, 7) + "."
				+ extensionName);

		// 这个地方根据项目的不一样，需要做一些特别的定制。
		newFileName = saveDirPath + filename.substring(0, 7) + "."
				+ extensionName;

		try {

			FileCopyUtils.copy(file.getBytes(), savefile);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		model.put("fileName", saveDirPath + savefile.getName());
		model.put("attachmentPath", newFileName);
		return model;
	}

}
