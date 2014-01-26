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
 	public boolean createXml(Group g) {  
  
  		try {  
			Element root = new Element("group");
			Document doc = new Document(root);
			root.addContent(new Element("groupName").setText("" + g.getGroupName()));
			root.addContent(new Element("school").setText(g.getSchool()));
			root.addContent(new Element("subject").setText(g.getSubject()));
			root.addContent(new Element("address").setText(g.getAddress()));
			root.addContent(new Element("description").setText(g.getDescription()));
			root.addContent(new Element("dateTime").setText("" + g.getDate() + " " + g.getTime()));
			root.addContent(new Element("creatorID").setText("" + g.getCreatorID()));
			
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
