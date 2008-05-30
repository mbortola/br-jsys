package writer;

import java.io.*;

import javax.xml.parsers.*;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.*;

class vuoto{
	private static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
	private static final String JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";
	private static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
	public void c(){


		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setNamespaceAware(true);
		factory.setValidating(true);
		SAXParser parser;
		try {
			parser = factory.newSAXParser();

			parser.setProperty(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
			//String schemaURI=null, docURI=null;
			parser.setProperty(JAXP_SCHEMA_SOURCE, new File("schemavzm.xsd"));
			DefaultHandler handler = new DummyHandler();
			parser.parse(new FileInputStream("default.TRACCE_vzm"), handler);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[]args) {
		new vuoto().c();
	}
}