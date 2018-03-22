package com.yu.mvc.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yu.mvc.form.ActionForm;
import com.yu.mvc.form.FullForm;
import com.yu.mvc.form.XmlBean;


public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = this.getPath(request.getServletPath());
		Map<String,XmlBean> map = (Map<String, XmlBean>) this.getServletContext().getAttribute("struts");
		XmlBean bean = map.get(path);
		String formclass = bean.getFormClass();
		ActionForm actForm = FullForm.getFull(request,formclass);
		String actClass = bean.getActionClass();
		Action action = null;
		String url = null;
		try {
			Class clazz = Class.forName(actClass);
			action =  (Action)clazz.newInstance();
			url = action.execute(request, response, actForm, bean.getActionForward());
		} catch (Exception e) {
			System.err.println("严重 ： 控制器异常！");
		}
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private String getPath(String servletPath){
		String res = servletPath.split("\\.")[0];
		return res;
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
