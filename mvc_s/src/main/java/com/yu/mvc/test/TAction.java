package com.yu.mvc.test;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yu.mvc.action.Action;
import com.yu.mvc.form.ActionForm;

public class TAction implements Action {

	public String execute(HttpServletRequest req, HttpServletResponse res, ActionForm form,
			Map<String, String> forword) {
		TForm  tform = (TForm) form;
		String url = "fail";
		if(tform.getName().equals("lpf")){
			url = "success";
		}
		return forword.get(url);
	}

}
