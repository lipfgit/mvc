package com.yu.mvc.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yu.mvc.form.ActionForm;

public interface Action {

	public String execute(HttpServletRequest req,HttpServletResponse res,ActionForm form,Map<String,String> forword);
	
}
