package s9api;

import java.io.File;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.Serializer;
import net.sf.saxon.s9api.XdmNode;
import net.sf.saxon.s9api.XsltCompiler;
import net.sf.saxon.s9api.XsltExecutable;
import net.sf.saxon.s9api.XsltTransformer;

import org.w3c.dom.Document;

public class XSLParser {
	
	/**Scrive un Document(da DOM)su di un file*/
    public static void writeXmlFile(Document doc, String filename) {
        try {
            // Prepare the DOM document for writing
            Source source = new DOMSource(doc);
    
            // Prepare the output file
            //File file = new File(filename);
            
            //file.createNewFile();
            
            Result result = new StreamResult(System.out);
    
            // Write the DOM document to the file
            Transformer xformer = TransformerFactory.newInstance().newTransformer();
            xformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
        	e.printStackTrace();
        } catch (TransformerException e) {
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
        out.setOutputFile(new File("data.xml"));
						        
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
