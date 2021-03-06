package com.fergalgribben.jenkinsxml2jobdsl.xml.model.project;

import javax.xml.bind.annotation.XmlAttribute;

import com.fergalgribben.jenkinsxml2jobdsl.jobdsl.Buildable;
import com.fergalgribben.jenkinsxml2jobdsl.jobdsl.Builder;

public class LocalRepository implements Buildable{
	
	@XmlAttribute(name="class")
	public String clazz;

	@Override
	public void build(Builder builder) {
		if (clazz.contains("Default")){
			builder.createMethod("localRepository").withConstantParameter("LocalRepositoryLocation.LOCAL_TO_EXECUTOR").endMethod();
		}
		else{
			builder.createMethod("localRepository").withConstantParameter("LocalRepositoryLocation.LOCAL_TO_WORKSPACE").endMethod();
		}
		
	}

}
