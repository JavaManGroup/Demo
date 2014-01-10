package org.antonyframework.support.mac;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antonyframework.core.bean.BeanManager;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.antony.service.ServiceManager;
import com.google.gson.Gson;

public class FileUploads extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int len = 0;// 处理流
	private int mm = 0;// 重命名
	private static String systemDir;

	private static String baseDir = "/uploads/";// 上传文件存储目录
	private static String flexDir = "/COMBOIMG/";// 上传文件存储目录

	private static String quanDir = "/uploads/";// 上传文件存储目录

	private static String fileExt = "jpg,jpeg,bmp,gif,png";
	private static Long maxSize = 0l;
	// 0:不建目录 1:按天存入目录 2:按月存入目录 3:按扩展名存目录 建议使用按天存
	private static String dirType = "1";

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub

		try {
			ResourceBundle resourceBundle;
			resourceBundle = ResourceBundle.getBundle("/combo");
			baseDir = resourceBundle.getString("baseDir");
			fileExt = resourceBundle.getString("fileExt");
			maxSize = Long.valueOf(resourceBundle.getString("maxSize"));

			flexDir = resourceBundle.getString("flexDir");
			dirType = resourceBundle.getString("dirType");
			systemDir = resourceBundle.getString("systemDir");

			quanDir = resourceBundle.getString("quanDir");

			quanDir = "/uploads/quan/";

			flexDir = "/uploads/";
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.init();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileUploads() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("上传图片");

		String realBaseDir = systemDir + flexDir;
		File baseFile = new File(realBaseDir);
		if (!baseFile.exists()) {
			baseFile.mkdirs();
		}
		// 生成目录名称
		String fileFolder = "";
		if (dirType.equalsIgnoreCase("1"))
			fileFolder = new SimpleDateFormat("yyyyMMdd").format(new Date());
		if (dirType.equalsIgnoreCase("2"))
			fileFolder = new SimpleDateFormat("yyyyMM").format(new Date());

		String dirPath = systemDir + flexDir + fileFolder + "/";
		File DirFile = new File(dirPath);
		if (!DirFile.exists()) {
			DirFile.mkdirs();
		}

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);

			Iterator items;
			try {
				items = upload.parseRequest(request).iterator();
				while (items.hasNext()) {
					FileItem item = (FileItem) items.next();
					if (!item.isFormField()) {
						String name = item.getName();
						System.out.println(item.getName());
						SimpleDateFormat fileFormatter = new SimpleDateFormat(
								"yyyyMMddHHmmssSSS");
						String format = fileFormatter.format(new Date());
						String last = name.substring(name.indexOf("."),
								name.length());
						String fileName = name.substring(
								name.lastIndexOf('\\') + 1, name.length());
						String path = dirPath + File.separatorChar + format
								+ last;

						File uploaderFile = new File(path);
						item.write(uploaderFile);
						response.setContentType("text/html;charset=UTF-8");
						try {
							Map m = new HashMap();
							m.put("status", 200);
							m.put("name", "/" + fileFolder + "/" + fileName);
							System.out.println("log    name:" + name);

							Map param = getUserInfo(name);
							param.put("PIC",
									"http://www.ycombo.com/che/uploads/"
											+ fileFolder + "/" + format + last);
							System.out.println("log    param:" + param);
							int i = getServMgr().getUserService()
									.updateUserFromMap(param);

							response.getWriter().print(new Gson().toJson(m));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			} catch (Exception e) {
				Map m = new HashMap();
				m.put("status", 300);
				response.getWriter().print(new Gson().toJson(m));
			}

		}

	}

	public ServiceManager getServMgr() {
		return (ServiceManager) BeanManager.getBean("ServiceManager");
	}

	public static Map getUserInfo(String s) {
		int b_s = s.indexOf("b___");
		int b_e = s.indexOf("c___");
		int c_s = s.indexOf("c___");
		int c_e = s.indexOf("d___");
		int d_s = s.indexOf("d___");
		int d_e = s.indexOf("e___");
		int e_s = s.indexOf("e___");
		int e_e = s.indexOf("f___");
		int f_s = s.indexOf("f___");
		int f_e = s.indexOf("g___");
		int g_s = s.indexOf("g___");
		int g_e = s.indexOf("h___");
		Map map = new HashMap();
		System.out.println();
		String uuid = s.substring(4, 9);
		System.out.println();
		String nick = s.substring(b_s + 4, b_e);
		System.out.println();
		String age = s.substring(c_s + 4, c_e);
		System.out.println();
		String sex = s.substring(d_s + 4, d_e);
		System.out.println();
		String city = s.substring(e_s + 4, e_e);
		System.out.println();
		String local = s.substring(f_s + 4, f_e);
		System.out.println();
		String des = s.substring(g_s + 4, g_e);

		map.put("UUID", Integer.valueOf(uuid));
		map.put("NICK", nick);
		map.put("SEX", sex);
		map.put("AGE", Integer.valueOf(age));
		map.put("CITY", city);
		map.put("LOCAL", local);
		map.put("DES", des);
		return map;
	}

}
