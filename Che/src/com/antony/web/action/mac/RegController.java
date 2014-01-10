package com.antony.web.action.mac;

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

public class RegController extends HttpServlet {
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
	public RegController() {
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
		System.out.println("sdfsdff");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("sdfdf");
		System.out.println("上传图片");
		System.out.println("reg  00");
		String realBaseDir = systemDir + flexDir;
		File baseFile = new File(realBaseDir);
		if (!baseFile.exists()) {
			baseFile.mkdirs();
		}
		System.out.println("reg  01");
		// 生成目录名称
		String fileFolder = "";
		if (dirType.equalsIgnoreCase("1"))
			fileFolder = new SimpleDateFormat("yyyyMMdd").format(new Date());
		if (dirType.equalsIgnoreCase("2"))
			fileFolder = new SimpleDateFormat("yyyyMM").format(new Date());

		System.out.println("reg  03");
		String dirPath = systemDir + flexDir + fileFolder + "/";
		File DirFile = new File(dirPath);
		if (!DirFile.exists()) {
			DirFile.mkdirs();
		}
		System.out.println("reg  1");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			System.out.println("reg  2");
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);

			System.out.println("reg  3");
			Iterator items;
			try {
				System.out.println("reg  4");
				items = upload.parseRequest(request).iterator();
				while (items.hasNext()) {
					System.out.println("reg  5");
					FileItem item = (FileItem) items.next();
					if (!item.isFormField()) {
						String name = item.getName();
						System.out.println(item.getContentType());
						System.out.println(item.getName());
						SimpleDateFormat fileFormatter = new SimpleDateFormat(
								"yyyyMMddHHmmssSSS");
						String format = fileFormatter.format(new Date());
						String last = ".jpg";
						System.out.println("reg  6");
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
							Map param = getCreateUserInfo(name);
							param.put("PIC",
									"http://www.ycombo.com/che/uploads/"
											+ fileFolder + "/" + format + last);
							// int i = getServMgr().getUserService()
							// .updateUserFromMap(param);
							System.out.println("log     name"+name);
							System.out.println("log     param" +param);
							int createUser = getServMgr().getUserService()
									.creatUserFromMap(param);
							System.out.println(" log     uuid" + createUser);
							if (createUser == 0) {
								Map s = new HashMap();
								s.put("status", 300);
								System.out.println(" log  error    uuid"
										+ createUser);
								response.getWriter()
										.print(new Gson().toJson(s));
								return;
							}
							System.out.println("reg  7");
							m.put("uuid", createUser);
							response.getWriter().print(new Gson().toJson(m));
							return;
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println("reg  8");
						}

					}
				}
			} catch (Exception e) {
				Map m = new HashMap();
				m.put("status", 300);
				response.getWriter().print(new Gson().toJson(m));
				System.out.println("reg  9");
			}

		}

	}

	public ServiceManager getServMgr() {
		return (ServiceManager) BeanManager.getBean("ServiceManager");
	}

	public static Map getCreateUserInfo(String s) {
		int a_s = s.indexOf("a___");
		int a_e = s.indexOf("b___");
		int b_s = s.indexOf("b___");
		int b_e = s.indexOf("c___");
		int c_s = s.indexOf("c___");
		int c_e = s.indexOf("d___");
		int d_s = s.indexOf("d___");
		int d_e = s.indexOf("e___");
		int f_e = s.indexOf("f___");
		System.out.println();
		String email =  s.substring(a_s + 4, a_e);
		System.out.println();
		String pass = s.substring(b_s + 4, b_e);
		System.out.println();
		String nick = s.substring(c_s + 4, c_e);
		System.out.println();
		String city = s.substring(d_s + 4, d_e);
		System.out.println("重要测试  city" +city);
		String sex = s.substring(d_e + 4,f_e);
		Map map = new HashMap();
		map.put("EMAIL", email);
		map.put("PASS", pass);
		map.put("NICK", nick);
		map.put("AGE", city);
		map.put("SEX", sex);
		return map;
	}

	public static Map getUserInfo(String s) {
		int b_s = s.indexOf("b_");
		int b_e = s.indexOf("c_");
		int c_s = s.indexOf("c_");
		int c_e = s.indexOf("d_");
		int d_s = s.indexOf("d_");
		int d_e = s.indexOf("e_");
		int e_s = s.indexOf("e_");
		int e_e = s.indexOf("f_");
		int f_s = s.indexOf("f_");
		int f_e = s.indexOf(".jpg");
		Map map = new HashMap();
		System.out.println();
		String uuid = s.substring(4, 7);
		if (uuid != "0000") {

		}
		System.out.println();
		String nick = s.substring(b_s + 4, b_e);
		System.out.println();
		String sex = s.substring(c_s + 4, c_e);
		System.out.println();
		String city = s.substring(d_s + 4, d_e);
		System.out.println();
		String local = s.substring(e_s + 4, e_e);
		System.out.println();
		String des = s.substring(f_s + 4, f_e);
		map.put("UUID", uuid);
		map.put("NICK", nick);
		map.put("SEX", sex);
		System.out.println("重要测试  city" +city);
		if(!city.equals("(null)"))
			map.put("CITY", city);
		else
			map.put("CITY", "北京");
		System.out.println("重要测试  local" +local);
		if(!local.equals("(null)"))
			map.put("LOCAL", local);
		else
			map.put("LOCAL", "北京");
		map.put("DES", des);
		System.out.println(map);
		return map;
	}

}
