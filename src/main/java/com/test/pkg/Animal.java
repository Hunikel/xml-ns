package com.test.pkg;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "animal")
public class Animal implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "name", required = true)
	protected String name;
	
	public Animal() {
	}
	
	public Animal(String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
