package com.vigoss.shop.sys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Bootstrap implements ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(Bootstrap.class);
    private ClassPathXmlApplicationContext context;

    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.startUp();
        try {
            Object lock = new Object();
            synchronized (lock) {
                while (true) {
                    lock.wait();
                }
            }
        } catch (InterruptedException ex) {
            LOGGER.error("ignore interruption", ex);
        }
    }

    /**
     * Start the service.
     */
    protected void startUp() {
        LOGGER.info("===================shop-serviceTART ....==========================");
        context = new ClassPathXmlApplicationContext(new String[]{"spring-jdbc.xml"});
        context.start();
        context.registerShutdownHook();
        LOGGER.info("shop-service service started successfully");


    }

    /**
     * Stop the service.
     */
    protected void shutDown() throws Exception {
        context.stop();
        LOGGER.info("service stopped successfully");
    }

    /**
     *
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.info("shop-service service started ");
        try {
            startUp();
        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error("ignore interruption ");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            shutDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
