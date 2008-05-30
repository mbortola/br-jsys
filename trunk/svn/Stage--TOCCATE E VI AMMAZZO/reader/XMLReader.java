package reader;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLReader {

	Document doc;

	public XMLReader(String path) {
		File file = new File("out.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;

		try {
			db = dbf.newDocumentBuilder();
			doc = db.parse(file);
		} catch (ParserConfigurationException e) {
			// 
			e.printStackTrace();
		} catch (SAXException e) {
			// 
			e.printStackTrace();
		} catch (IOException e) {
			// 
			e.printStackTrace();
		}

	}

	public static void main(String argv[]) {

		XMLReader r=new XMLReader("out.xml");

		try {
			System.out.println(r.parse());
		} catch (JSONException e) {
			// 
			e.printStackTrace();
			System.exit(1);
		}

	}

	public JSONObject parse() throws JSONException {

		Element root=doc.getDocumentElement();
		root.normalize();

		NodeList list=root.getChildNodes();

		JSONObject result=new JSONObject();
		for (int i=0;i<list.getLength();i++) {
			Node x=list.item(i);

			if (x.getNodeType()==Node.ELEMENT_NODE) {
				Element y=(Element)x;
				String type=y.getAttribute("type");
				if (type.equals("JSONObject")) result.put(y.getTagName(), putObj(y));
				else if (type.equals("JSONArray")) result.put(y.getTagName(), putArray(y));
				else result.put(y.getTagName(), putValue(y));
			}

		}

		return result;

	}

	private static JSONObject putObj(Element root) throws JSONException {
		//NON AVRO' MAI ELEMENTI VUOTI!!!!!
		System.out.println(root.getTagName());
		JSONObject result=new JSONObject();

		NodeList list = root.getChildNodes();
		//oggetto vuoto.

		for (int i = 0; i < list.getLength(); i++) {
			//Solo elementi
			if (list.item(i).getNodeType()==Node.ELEMENT_NODE) {
				Element el = (Element)list.item(i);
				String type=el.getAttribute("type");
				//JSONObject
				if (type.equals("JSONObject")) {
					result.put(el.getTagName(),putObj(el));
				}
				//JSONArray
				else if (type.equals("JSONArray")) {
					result.put(el.getTagName(),putArray(el));
				}
				//valore
				else  {result.put(el.getTagName(), putValue(el));}
			}
		}

		return result;
	}

	private static JSONArray putArray(Element root) throws JSONException {
		System.out.println("A"+root.getTagName());
		JSONArray arr=new JSONArray();
		NodeList list=root.getChildNodes();

		int element=0;

		for (int i=0;i<list.getLength();i++) {
			Node x=list.item(i);
			//Solo elementi
			if (x.getNodeType()==Node.ELEMENT_NODE) {
				Element el = (Element)x;
				element=Integer.parseInt(el.getAttribute("position"));
				String type=el.getAttribute("type");

				//JSONObject
				if (type.equals("JSONObject")) {
					arr.put(element, putObj(el));
				}
				//JSONArray
				else if (type.equals("JSONArray")) {
					arr.put(element,putArray(el));
				}
				//valore
				else  {arr.put(element, putValue(el));}
			}
		} 
		System.out.println(arr.toString());
		return arr;
	}

	private static Object putValue(Element el)throws JSONException {
		// 
		String type=el.getAttribute("type");
		String value=el.getAttribute("value");

		if (type.equals("Integer")) {return new Integer(value);}
		if (type.equals("Boolean")) {return new Boolean(value);}
		if (type.equals("Double")) {return  new Double(value);}
		if (type.equals("String")) {return new String(value);}
		if (type.equals("Long")) {return new Long(value);}

		return JSONObject.NULL;
	}


}
