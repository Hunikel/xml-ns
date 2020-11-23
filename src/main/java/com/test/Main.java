package com.test;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.dom.DOMResult;

import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.test.pkg.Animal;
import com.test.pkg.root1.Zoo;
import com.test.pkg.root2.Parc;

public class Main {
	
	public static void main(String[] args) {
		try {
			new Main();
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (FactoryConfigurationError e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	public Main() throws JAXBException, XMLStreamException, FactoryConfigurationError, ParserConfigurationException {
		Zoo zoo = new Zoo();
		Parc parc = new Parc();
		Animal animal = new Animal("Bird");
		zoo.setAnimal(animal);
		
		JAXBContext context = JAXBContextFactory.createContext(new Class[] {Zoo.class, Parc.class}, null);
		Marshaller jaxbMarshaller = context.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		StringWriter xmlWriter = new StringWriter();
		
		Document document = dbf.newDocumentBuilder().newDocument();
		XMLStreamWriter writer = new WrapperXMLStreamWriter(XMLOutputFactory.newInstance().createXMLStreamWriter(new DOMResult(document)));
		jaxbMarshaller.marshal(zoo, writer);
		
		Element element = document.getDocumentElement();
		parc.setZoo(element);
		jaxbMarshaller.marshal(parc, xmlWriter);
		
		System.out.println(xmlWriter.toString());
	}
	
}
