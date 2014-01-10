package com.sun.app.process.admin.honour;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
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
		System.out.println("荣誉");
		PagingList all = getServMgr().getHonourService().queryForPagingList(
				request);
		ListIterator it = all.getList().listIterator();
		while (it.hasNext()) {
			Map next = (Map) it.next();
			System.out.println(next);
			Integer count = getServMgr().getHonourService().getHonourCount(
					(Integer) next.get("id"));
			next.put("count", count);
		}
		System.out.println(all.getList());
		model.put("all", all);
		return model;
	}

}