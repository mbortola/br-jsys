package s9api;

import java.io.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;

import net.sf.saxon.s9api.*;

public class SingleTransform {

	
    public void DOMTrasform() throws SaxonApiException {
		Processor proc = new Processor(false);
		XsltCompiler comp = proc.newXsltCompiler();
		
		XsltExecutable first = comp.compile(new StreamSource(new File("provakey2.xsl")));
				
		XdmNode source = proc.newDocumentBuilder().build(new StreamSource(new File("1file.xml")));
		
        DocumentBuilderFactory dfactory = DocumentBuilderFactory.newInstance();
        dfactory.setNamespaceAware(true);
        Document dom;
             
        try {
            dom = dfactory.newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
            throw new SaxonApiException(e);
        }
        
        XsltTransformer trans = first.load();
		trans.setInitialContextNode(source);
		
		trans.setDestination(new DOMDestination(dom));
		
		long inizio=System.currentTimeMillis();
		trans.transform();
		long fine=System.currentTimeMillis()-inizio;
		
		XSLParser.writeXmlFile(dom, "");
		
		System.err.println("finito! Tempo="+fine+" millisecondi");        
    }
	
	/**Applica una doppia trasformazione XSL ad un XML usando le librerie s9api di saxon*/
	public void run() throws SaxonApiException {
		Processor proc = new Processor(false);
		XsltCompiler comp = proc.newXsltCompiler();
		
		XsltExecutable first = comp.compile(new StreamSource(new File("provakey2.xsl")));
		//XsltExecutable last = comp.compile(new StreamSource(new File("readtree2.xsl")));
		
		XdmNode source = proc.newDocumentBuilder().build(new StreamSource(new File("1file.xml")));
		
		
		
		Serializer out = new Serializer();
		
        out.setOutputProperty(Serializer.Property.METHOD, "xml");
        out.setOutputProperty(Serializer.Property.INDENT, "yes");
        out.setOutputFile(new File("tree.xml"));
						        
		XsltTransformer trans = first.load();//,trans2=last.load();
		trans.setInitialContextNode(source);
		
				
		trans.setDestination(out);
		
		long inizio=System.currentTimeMillis();
		trans.transform();
		long fine=System.currentTimeMillis()-inizio;
		
		System.err.println("finito! Tempo="+fine+" millisecondi");
	}


	public static void main(String[]args) {
		try {
			new SingleTransform().DOMTrasform();
		} catch (SaxonApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
