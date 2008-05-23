package s9api;

import java.io.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;


import net.sf.saxon.s9api.*;

public class XSLParser {
	
	/**Scrive un Document(da DOM)su di un file*/
    public static void writeXmlFile(Document doc, String filename) {
        try {
            // Prepare the DOM document for writing
            Source source = new DOMSource(doc);
    
            // Prepare the output file
            File file = new File(filename);
            
            file.createNewFile();
            
            Result result = new StreamResult(file);
    
            // Write the DOM document to the file
            Transformer xformer = TransformerFactory.newInstance().newTransformer();
            xformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
        	e.printStackTrace();
        } catch (TransformerException e) {
        	e.printStackTrace();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	/**Applica una doppia trasformazione XSL ad un XML usando le librerie s9api di saxon*/
	public void run() throws SaxonApiException {
		Processor proc = new Processor(false);
		XsltCompiler comp = proc.newXsltCompiler();
		
		XsltExecutable first = comp.compile(new StreamSource(new File("provakey2.xsl")));
		XsltExecutable last = comp.compile(new StreamSource(new File("readtree2.xsl")));
		
		XdmNode source = proc.newDocumentBuilder().build(new StreamSource(new File("1file.xml")));
		        
		Serializer out = new Serializer();
		
        out.setOutputProperty(Serializer.Property.METHOD, "xml");
        out.setOutputProperty(Serializer.Property.INDENT, "yes");
        out.setOutputFile(new File("result.xml"));
						        
		XsltTransformer trans = first.load(),trans2=last.load();
		trans.setInitialContextNode(source);
		
		trans2.setDestination(out);
				
		trans.setDestination(trans2);
		
		long inizio=System.currentTimeMillis();
		trans.transform();
		Long fine=System.currentTimeMillis()-inizio;
		
		
		System.err.println("finito! Tempo="+fine+" millisecondi");
	}


	public static void main(String[]args) {
		try {
			new XSLParser().run();
		} catch (SaxonApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
