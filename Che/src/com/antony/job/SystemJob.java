package com.antony.job;


import org.antonyframework.core.bean.BeanManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.antony.service.ServiceManager;

public class SystemJob extends QuartzJobBean {
	private static final Log LOG = LogFactory.getLog(SystemJob.class);
	private int id;
	public void setId(int id) {
		this.id = id;
	}

	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		LOG.info("系统正在运行...");
		getServMgr().getMessageService().updateStatus();
	}
	
	public ServiceManager getServMgr() {
		return (ServiceManager) BeanManager.getBean("ServiceManager");
	}
}