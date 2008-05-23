package jaxp;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.TransformerException;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import net.sf.saxon.FeatureKeys;
import net.sf.saxon.TransformerFactoryImpl;
import net.sf.saxon.event.SaxonOutputKeys;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * A simple demo of JAXP 1.1
 */
public class SimpleJaxp {


	public void serializerWithDOE()
	throws TransformerException,
	SAXException, IOException, ParserConfigurationException {

		TransformerFactoryImpl tf = new TransformerFactoryImpl();

//		Following is needed to ensure Saxon recognizes the JAXP-defined processing instructions
		tf.setAttribute(FeatureKeys.USE_PI_DISABLE_OUTPUT_ESCAPING, Boolean.TRUE);

		
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