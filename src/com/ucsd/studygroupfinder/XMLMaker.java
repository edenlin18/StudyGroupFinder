package com.ucsd.studygroupfinder;

import java.io.*;
import java.util.*;
import java.io.FileWriter; 
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
import org.jdom2.Attribute;
import org.jdom2.output.Format;

public class XMLMaker {  
  	private Writer out;
  	public XMLMaker(Writer out){
		this.out = out;
	}
	public XMLMaker(){
	}
 	public boolean createXml(String subject, String school, String address, String description,
                            String date, String time, String creatorId) {  
  
  	try {  
			Element root = new Element("group");
			Document doc = new Document(root);
      root.addContent(new Element("subject").setText(subject));
			root.addContent(new Element("school").setText(school));
			root.addContent(new Element("address").setText(address));
			root.addContent(new Element("description").setText(description));
			root.addContent(new Element("dateTime").setText("" + date + " " + time));
			root.addContent(new Element("creatorId").setText("" + creatorId));
			
   		// get object to see output of prepared document  
   		XMLOutputter xmlOutput = new XMLOutputter();  
  
   		// passsed System.out to see document content on console  
   		xmlOutput.output(doc, System.out);  

/* 
 * socket output  
 * xmlOutput.output(doc, out);
 */

   		// passed fileWriter to write content in specified file  
   		xmlOutput.setFormat(Format.getPrettyFormat());  
   		xmlOutput.output(doc, new FileWriter("generatedXml.xml")); 
   		return true;

  		} catch (IOException io) {  
   			System.out.println(io.getMessage()); 
   			return false; 
  		}  
 	}  
}  
