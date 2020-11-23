package com.test.pkg.root2;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.w3c.dom.Element;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document", namespace = "namespace2")
@XmlRootElement(name = "Parc", namespace = "namespace2")
public class Parc implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlAnyElement
	protected Element zoo;

	public Parc() {
	}

	public Element getZoo() {
		return zoo;
	}

	public void setZoo(Element zoo) {
		this.zoo = zoo;
	}

}
