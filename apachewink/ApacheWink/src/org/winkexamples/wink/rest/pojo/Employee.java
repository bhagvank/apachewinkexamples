package org.winkexamples.wink.rest.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="employee")
public class Employee {

	long id;
	String name;
	
	@XmlAttribute
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	@XmlElement(name="name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		String strForm="id=" + this.id + ", name=" + this.name;
		return strForm;
	}
}
