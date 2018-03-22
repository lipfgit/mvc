package com.yu.mvc.form;

import java.util.HashMap;
import java.util.Map;

public class XmlBean {

	
	public XmlBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	private String beanName = "";
	
	private String path = "";
	
	private String actionClass = "";
	
	private String formClass = "";
	
	private Map<String,String> actionForward = new HashMap<String,String>();

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}


	public String getActionClass() {
		return actionClass;
	}

	public void setActionClass(String actionClass) {
		this.actionClass = actionClass;
	}

	public String getFormClass() {
		return formClass;
	}

	public void setFormClass(String formClass) {
		this.formClass = formClass;
	}

	public Map<String, String> getActionForward() {
		return actionForward;
	}

	public void setActionForward(Map<String, String> actionForward) {
		this.actionForward = actionForward;
	}
	
	
	public String toString(){
		
		return "&name="+this.beanName+" || path="+this.path+"|| actionClass = "+this.actionClass+"|| formClass="+this.formClass;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
