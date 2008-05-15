import java.util.Stack;

import org.json.JSONObject;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class MySAXParser extends DefaultHandler { 

	private JSONObject result=null;
	Stack<Object> s=new Stack<Object>();
	boolean objOnTop=false;

	public MySAXParser(){}
	public JSONObject getResult() {return result;}

	public void startDocument() { 
		System.out.println("Inizio documento"); 
	} 
	public void endDocument() { 
		System.out.println("Fine documento"); 
	} 

	private void p(String msg) {System.out.println(msg);}

	public void startElement(String namespaceURI,String localName, String qName, Attributes atts) {
		if (qName.equals("VZM")) {
			p("VZM");
			result=new JSONObject();
			s.push(result);
			objOnTop=true;
		} else if (atts.getValue("type").equals("JSONObject")) {
			p("Obj");
		} else if (atts.getValue("type").equals("JSONArray")) {p("Arr");}
		else if (qName.equals("element")) {p("el");}
		else {p("other");}
	} 

	public void endElement() { 
		s.pop();
	} 
}
