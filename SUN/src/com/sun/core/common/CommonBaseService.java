package com.sun.core.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Service 基类 设置log及基本的数据库访问<BR>
 * 基于Spring
 * 
 * @author Nanlei
 */
public class CommonBaseService {

	public Boolean CheckImageType(String contentType) {
		if (!contentType.equals("image/jpg")
				&& !contentType.equals("image/png")
				&& !contentType.equals("image/jpeg")
				&& !contentType.equals("image/gif")
				&& !contentType.equals("image/jpeg")) {
			return false;
		}
		return true;
	}

	protected final Log log = LogFactory.getLog(getClass());

	/* JdbcTemplate */
	protected JdbcTemplate jt;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jt = jdbcTemplate;
	}

	public JdbcTemplate getJdbc() {
		return this.jt;
	}

	/* NamedParameterJdbcTemplate */
	protected NamedParameterJdbcTemplate npjt;

	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.npjt = namedParameterJdbcTemplate;
	}

	public PagingList getPagingList(String srcSql, HttpServletRequest request) {
		int pageNum = 1;
		int pageSize = 10;

		if (request.getParameter("pageNum") != null) {
			System.out.println("@");
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}

		if (request.getAttribute("pageSize") != null) {
			pageSize = Integer.parseInt(String.valueOf(request
					.getAttribute("pageSize")));
		} else {
			if (request.getParameter("pageSize") != null) {
				pageSize = Integer.parseInt(request.getParameter("pageSize"));
			} else {
				pageSize = 10;
			}
		}
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageSize", pageSize);
		return new PagingList(srcSql, pageNum, pageSize, jt);
	}

	public PagingList getPagingList(String srcSql, HttpServletRequest request,
			Object... parameterObject) {
		int pageNum = 1;
		int pageSize = 10;
		if (request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		if (request.getAttribute("pageSize") != null) {
			pageSize = Integer.parseInt(String.valueOf(request
					.getAttribute("pageSize")));
		} else {
			if (request.getParameter("pageSize") != null) {
				pageSize = Integer.parseInt(request.getParameter("pageSize"));
			} else {
				pageSize = 10;
			}
		}
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageSize", pageSize);
		return new PagingList(srcSql, pageNum, pageSize, jt, parameterObject);
	}

	public static String getCountSql(String srcSql) {
		return "SELECT COUNT(*) FROM ( " + srcSql + " ) CTBL_";
	}

	public Integer getMax(String columnName, String tableName) {
		try {
			return jt.queryForInt("SELECT MAX(" + columnName + ") FROM "
					+ tableName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}
}