package com.sun.app.process.front.index;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.rmi.runtime.Log;

import com.sun.app.process.BaseProcess;

public class IndexProcess extends BaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		String ip = getIP(request);
		Map map = getServMgr().getContactService().queryForMap(1);
		model.put("contact", map);
		List<HashMap> typeIdList = getFsMgr().getProjectService().getHomeType();
		ListIterator<HashMap> typeIt = typeIdList.listIterator();
		while (typeIt.hasNext()) {
			HashMap next = typeIt.next();
			List homeProject = getFsMgr().getProjectService().getProjectList(
					(Integer) next.get("id"));
			model.put("homeProject" + typeIt.nextIndex(), homeProject);
			model.put("homeType" + typeIt.nextIndex(), next);
		}

		List topProject = getFsMgr().getProjectService().getProjectByIsHome();
		List homeNews = getFsMgr().getFrontnewsService().getHomeNews();
		model.put("topProject", topProject);
		model.put("topNews", homeNews);
		List links = getServMgr().getLinkService().getHomeLink();
		model.put("links", links);
		request.getSession().setAttribute("links", links);
		String flashPath = getServMgr().getSysService().queryForFlash();
		model.put("fpath", flashPath);
		return model;
	}

}