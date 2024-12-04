package com.geyao.springbootgeyao.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class GeyaoListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("监听器执行了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
