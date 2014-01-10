package com.sun.app.process.front.news;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;
import com.sun.app.process.PagingBaseProcess;

public class NewsProcess extends PagingBaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		String flashPath = getServMgr().getSysService().queryForFlash();
		model.put("fpath", flashPath);
		List<HashMap> typeIdList = getFsMgr().getFrontnewsService()
				.getNewsType();

		List types = getServMgr().getNewsService().getHomeNewsType();
		System.out.println(typeIdList);
		ListIterator<HashMap> typeIt = typeIdList.listIterator();
		while (typeIt.hasNext()) {
			HashMap next = typeIt.next();
			System.out.println(next.get("id"));
			List newsList = getFsMgr().getFrontnewsService().getNewsList(
					(Integer) next.get("id"));
			model.put("newsList" + typeIt.nextIndex(), newsList);
			model.put("newsType" + typeIt.nextIndex(), next);
		}
		List allType = getFsMgr().getFrontnewsService().getAllType();
		model.put("allType", allType);
		return model;
	}

}