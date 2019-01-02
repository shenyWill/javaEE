package com.yuanwill.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Listener1 implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("context 销毁了。。。");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("context 创建了。。。");
	}
	
}
