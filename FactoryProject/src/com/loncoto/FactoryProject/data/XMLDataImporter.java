package com.loncoto.FactoryProject.data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLDataImporter extends DataImporter {
	private File xmlFile;
	
	public XMLDataImporter(String filename) {
		xmlFile = new File(filename);
		
	}

	@Override
	public Map<String, String> importData() {
		HashMap<String, String> data = new HashMap<String, String>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(xmlFile);
			NodeList nl = doc.getElementsByTagName("entry");
			for (int i = 0; i < nl.getLength(); i++) {
				Element el = (Element)nl.item(i);
				data.put(el.getAttribute("type"), el.getAttribute("name"));
				
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

}
