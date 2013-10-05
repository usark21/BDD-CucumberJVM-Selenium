package com.ravi.cucumberjvm.appdemo.util;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ObjectRepository {
	private static final String xml_file = System.getProperty("user.dir")
			+ "//src//main//resources//META-INF//object_repository.xml";
	private static Document doc = null;
	private static String tagname = "element";
	private static String tagAttribute = "name";

	public static String getElementProperty(final String elementName) {
		if (doc == null) {
			documentBuilder();
		}
		NodeList nodes = doc.getElementsByTagName(tagname);
		for (int nodeIndex = 0; nodeIndex < nodes.getLength(); nodeIndex++) {
			Node node = nodes.item(nodeIndex);
			if (node.getNodeType() == Node.ELEMENT_NODE
					&& ((Element) node).getAttribute(tagAttribute).equals(
							elementName)) {
				return ((Element) node).getElementsByTagName("xpath").item(0)
						.getTextContent();
			}
		}
		return null;
	}

	private static Document documentBuilder() {
		File fXmlFile = new File(xml_file);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doc;
	}
}
