import java.io.*;
import java.util.*;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
import org.jdom2.Attribute;

/* 
 *  PrintWriter out;
 *	new XMLMaker(out).createGroupsXML(new Group(.....));
 */


public class XMLMaker{
	private Writer out;
	public XMLMaker(Writer out){
		this.out = out;
	}
	public boolean createXML(Group g){
		try{
			Element root = new Element("group");
			Document doc = new Document(root);
				
				root.addContent(new Element("groupName").setText("" + g.getGroupName()));
				root.addContent(new Element("school").setText(g.getSchool()));
				root.addContent(new Element("subject").setText(g.getSubject()));
				root.addContent(new Element("address").setText(g.getAddress()));
				root.addContent(new Element("description").setText(g.getDescription()));
				root.addContent(new Element("date Time").setText("" + g.getDate() + " " + g.getTime()));
				root.addContent(new Element("creatorID").setText("" + g.getCreatorID()));
				
				doc.getRootElement().addContent(root);
			

			XMLOutputter xmlOutput = new XMLOutputter();
			//xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(doc, out);
			return true;
		}catch(IOException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public void setOut(Writer out){
		this.out = out;
	}
}