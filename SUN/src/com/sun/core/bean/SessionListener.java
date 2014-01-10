package com.sun.core.bean;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
	private static int activeSessions = 0;

	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		activeSessions++;

	}
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub

	}

	public static int getActiveSessions() {
		System.out.println("SessionCounter.getActiveSessions() ");
		return activeSessions;
	}

}
