package com.test.pkg.root1;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.test.pkg.Animal;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document", namespace = "namespace1")
@XmlRootElement(name = "Zoo", namespace = "namespace1")
public class Zoo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "animal", required = true)
	protected Animal animal;
	
	public Zoo() {
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
}
