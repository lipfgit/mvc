package com.yu.mvc.form;

import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;

public class FullForm {

	
	public FullForm() {
		// TODO Auto-generated constructor stub
	}
	
	public static ActionForm getFull(HttpServletRequest req,String classpath){
		
		ActionForm form = null;
		try {
			Class clazz = Class.forName(classpath);
			form = (ActionForm)clazz.newInstance();
			Field[] fields = clazz.getDeclaredFields();
			for(Field f: fields){
				f.setAccessible(true);
				f.set(form, req.getParameter(f.getName()));
				f.setAccessible(false);
			}
		} catch (Exception e) {
			System.err.println("—œ÷ÿ£∫javaBean ◊∞‘ÿ ß∞‹£°£°");
			e.printStackTrace();
		}
		
		return form;
		
		
		
	}
	
	
}
