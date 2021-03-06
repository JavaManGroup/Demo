/*
 * @(#) EPMConnectionFactory.java
 * Copyright 2002 by SK C&C. All rights reserved.
 * �� Program�� �Ϻ� �Ǵ� ��θ� SK C&C���� ���Ǿ��� 
 * ����, ����, �����ϴ� ������ ������ �����Ǿ� �ֽ��ϴ�.
 */
package org.antonyframework.service.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.antonyframework.core.bean.BeanManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * COMBO Connection
 * 
 */
public class SYSConnectionFactory implements IConnectionFactory {

	private static final Log logger = LogFactory
			.getLog(SYSConnectionFactory.class);

	private static SYSConnectionFactory connectionFactory = new SYSConnectionFactory();
	private static final String URL = "jdbc:mysql://www.ycombo.com:3306/antony?&useUnicode=true&characterEncoding=UTF-8";
	private static final String USER_ID = "ycombo";
	private static final String PASSWORD = "ycombo1234";

	private DataSource ds = null;
	private boolean flag = false;

	private SYSConnectionFactory() {
		try {
			ds = (DataSource) BeanManager.getBean("antonyDataSource");
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
	}

	public static SYSConnectionFactory getInstance() {
		return connectionFactory;
	}

	public Connection getConnection() throws SQLException {
		Connection con = null;
		if (flag) {
			return ds.getConnection();
		} else {
			try {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				con = DriverManager.getConnection(URL, USER_ID, PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
}
