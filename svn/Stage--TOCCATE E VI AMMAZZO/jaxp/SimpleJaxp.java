package jaxp;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

import org.xml.sax.SAXException;


/**
 * A simple demo of JAXP 1.1
 */
public class SimpleJaxp {


	public void serializerWithDOE()
	throws TransformerException,
	SAXException, IOException, ParserConfigurationException {


		System.setProperty("Djavax.xml.transform.TransformerFactory","net.sf.saxon.TransformerFactoryImpl");

		//activate in JAXP: XPath2.0 from Saxon9 (standard XPath of JAXP is XPath1.0)
		System.setProperty("Djavax.xml.xpath.XPathFactory","net.sf.saxon.xpath.XPathFactoryImpl");

		//test XSL-Transformer
		TransformerFactory instance = TransformerFactory.newInstance();
		System.out.println("\n>>>activ XSLT-Transformer: " + instance.getClass().getName());
	}
	/**
	 * Accept two command line arguments: the name of
	 * an XML file, and the name of an XSLT stylesheet.
	 * The result of the transformation
	 * is written to stdout.
	 */
	public static void main(String[] args) {
		try {
			new SimpleJaxp().serializerWithDOE();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}