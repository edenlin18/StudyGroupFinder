import java.net.*;
import java.io.*;
import java.util.*;

public class JdomImplementation {  
 	private PrintWriter out=null;
	public static void main(String[] args) {  
    
  		// write xml to a file  
  		XMLMaker createXml = new XMLMaker();  
  		createXml.createXml("cse","ucsd","gilman dr","computer science","01/26/14","2:10AM","1");  
 	}  
}  