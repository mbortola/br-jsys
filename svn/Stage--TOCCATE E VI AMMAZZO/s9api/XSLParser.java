package s9api;

import java.io.*;

import javax.xml.transform.stream.StreamSource;

import net.sf.saxon.s9api.*;

public class XSLParser {

	/**Applica una doppia trasformazione XSL ad un XML usando le librerie s9api di saxon*/
	public void run() throws SaxonApiException {
		Processor proc = new Processor(false);
		XsltCompiler comp = proc.newXsltCompiler();
		
		XsltExecutable first = comp.compile(new StreamSource(new File("buildtree.xsl")));
		XsltExecutable last = comp.compile(new StreamSource(new File("readtree.xsl")));
		
		XdmNode source = proc.newDocumentBuilder().build(new StreamSource(new File("features.xml")));
		Serializer out = new Serializer();
		
        out.setOutputProperty(Serializer.Property.METHOD, "xml");
       // out.setOutputProperty(Serializer.Property.INDENT, "yes");
        out.setOutputFile(new File("result.xml"));
						        
		XsltTransformer trans = first.load(),trans2=last.load();
		trans.setInitialContextNode(source);
		
		trans2.setDestination(out);
				
		trans.setDestination(trans2);
		
		trans.transform();

		System.err.println("finito!");
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
