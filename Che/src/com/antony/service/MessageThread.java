package com.antony.service;

import java.util.Vector;

import org.antonyframework.support.mail.MailBEAN;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MessageThread implements Runnable {

	Thread thread = null;
	private Vector vector = new Vector();
	private boolean runFlag = true;

	private static final Log LOG = LogFactory.getLog(MessageThread.class);

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (runFlag) {
			try {
				Object firstElement = vector.firstElement();
				if (firstElement != null) {
					LOG.info("启动  消息线程   nulll");
					try {
						vector.remove(0);
					} catch (Exception e) {
						// TODO: handle exception
					}
				} else {
					LOG.info("启动  消息线程   ");
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	public void close() {
		try {
			runFlag = false;
			// timer.cancel();
			// timer = null;
		} catch (Exception e) {
			LOG.warn("Cannot close MessageThread.", e);
		}
	}

	public void putMail(MailBEAN mBean) {
		System.out.println("MessageThread  putMail");
		synchronized (vector) {
			if (mBean == null)
				return;
			if (vector.isEmpty() && (thread == null || !thread.isAlive())) {
				vector.add(mBean);
				thread = new Thread(this);
				thread.start();
				LOG.debug("启动  Message Thread.");
			} else {
				vector.add(mBean);
			}
		}
	}

}
