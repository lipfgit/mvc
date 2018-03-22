package com.yu.mvc.form;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;


public class Struts_xml {

	
	public Struts_xml() {
	}
	
	public static Map<String,XmlBean> analysisXML(String xmlPath) throws JDOMException, IOException{
		Map<String,XmlBean> actMap = new HashMap<String,XmlBean>();
		SAXBuilder builder = new SAXBuilder();
		Document document = builder.build(new File(xmlPath));
		Element root = document.getRootElement();
		Element action_mapping = root.getChild("action-mapping");
		List<Element> actions = action_mapping.getChildren();
		for(Element action:actions){
			XmlBean action_xml = new XmlBean();
			String name = action.getAttributeValue("name");
			action_xml.setBeanName(name);
			Element actionForm = root.getChild("formbeans");
			List<Element> form = actionForm.getChildren();
			for(Element e:form){
				if(name.equals(e.getAttributeValue("name"))){
					String clas = e.getAttributeValue("class");
					action_xml.setFormClass(clas);
					break;
				}
			}
			String type = action.getAttributeValue("type");
			String path = action.getAttributeValue("path");
			action_xml.setActionClass(type);
			action_xml.setPath(path);
			List<Element> forwords = action.getChildren();
			Map<String,String> fMap = new HashMap<String,String>();
			for(Element forword:forwords){
				String fname = forword.getAttributeValue("name");
				String fvalue = forword.getAttributeValue("value");
				fMap.put(fname, fvalue);
			}
			action_xml.setActionForward(fMap);
			actMap.put(path,action_xml);
		}
		
		return actMap;
	}
}
