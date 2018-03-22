package com.yu.mvc.form;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.jdom.JDOMException;

public class ActionListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		System.err.println("信息：系统已经注销！");

	}

	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext context =  arg0.getServletContext();
		String xmlPath = context.getInitParameter("struts-config");
		String tomcatpath = context.getRealPath("\\").split("target")[0];
		try {
			Map<String,XmlBean> bean = Struts_xml.analysisXML(tomcatpath+xmlPath);
			context.setAttribute("struts", bean);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.err.println("信息：系统已经加载完成！");
		
	}

	
	
	
}
