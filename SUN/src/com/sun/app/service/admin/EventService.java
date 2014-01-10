package com.sun.app.service.admin;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.app.service.BaseService;
import com.sun.core.common.PagingList;
import com.sun.dao.EventMapper;
import com.sun.vo.Event;

public class EventService extends BaseService {

	@Autowired
	private EventMapper eventMapper;
	private static final String SQL_ALL_EVENT = "" + "select e.*,u.nick "
			+ "from event e,event_user u " + "where e.user_id = u.id";

	public PagingList getAllEventPaging(HttpServletRequest request) {
		// TODO Auto-generated method stub
		request.setAttribute("pageSize", 20);
		return getPagingList(SQL_ALL_EVENT, request);
	}

	public Integer addEventInAdmin(HttpServletRequest request, String ip) {
		// TODO Auto-generated method stub

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Map pMap = request.getParameterMap();
		Event event = (Event) request.getAttribute("e");
		Event e = new Event();
		int r = 0;
		try {
			e.setTitle(request.getParameter("title"));
			e.setContent(request.getParameter("content"));
			try {
				e.setStarttime(format.parse(request.getParameter("starttime")));
				e.setEndtime(format.parse(request.getParameter("endtime")));
			} catch (ParseException e1) {
			}
			e.setCount(0);
			e.setImage("asdf.jpg");
			e.setMax(Integer.valueOf(request.getParameter("max")));
			e.setUserId(Integer.valueOf(request.getParameter("userId")));
			e.setOpened("1");
			e.setPlace(request.getParameter("place"));
			e.setPrivilege(request.getParameter("privilege"));
			try {
				r = eventMapper.insert(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
			}
		} catch (NumberFormatException e1) {
		}

		return r;
	}

	private static final String SQL_ALL_EVENT_USER = "select id,nick from event_user";

	public List getEventUsers() {
		// TODO Auto-generated method stub
		return jt.queryForList(SQL_ALL_EVENT_USER);
	}

	public PagingList getAllEventHome(HttpServletRequest request) {
		// TODO Auto-generated method stub
		request.setAttribute("pageSize", 20);
		return getPagingList(SQL_ALL_EVENT, request);
	}

	@Override
	public Integer add(HttpServletRequest request, String ip) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(HttpServletRequest request, String ip) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(HttpServletRequest request, String ip) {
		// TODO Auto-generated method stub
		return null;
	}
}
