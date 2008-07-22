package saxon;

import java.io.File;

import javax.xml.transform.stream.StreamSource;

import net.sf.saxon.s9api.*;


public class SimpleSaxon {

    public void run() throws SaxonApiException {
	Processor proc = new Processor(false);
	XsltCompiler comp = proc.newXsltCompiler();
	XsltExecutable exp = comp.compile(new StreamSource(new File("buildtree.xsl")));
	XdmNode source = proc.newDocumentBuilder().build(new StreamSource(new File("features.xml")));
	Serializer out = new Serializer();

	out.setOutputProperty(Serializer.Property.METHOD, "xml");
	out.setOutputProperty(Serializer.Property.INDENT, "yes");		

	out.setOutputFile(new File("tree1.xml"));
	XsltTransformer trans = exp.load();
	trans.setInitialContextNode(source);
	trans.setDestination(out);
	trans.transform();

	System.err.println("Output written to tree1.xml");
    }

    public void transform(String input, String output, String xslt) throws SaxonApiException {
	Processor proc = new Processor(false);
	XsltCompiler comp = proc.newXsltCompiler();
	XsltExecutable exp = comp.compile(new StreamSource(new File(xslt)));
	XdmNode source = proc.newDocumentBuilder().build(new StreamSource(new File(input)));
	Serializer out = new Serializer();

	out.setOutputProperty(Serializer.Property.METHOD, "xml");
	out.setOutputProperty(Serializer.Property.INDENT, "yes");		

	out.setOutputFile(new File(output));
	XsltTransformer trans = exp.load();
	trans.setInitialContextNode(source);
	trans.setDestination(out);
	long str=System.currentTimeMillis();
	trans.transform();
	long end=System.currentTimeMillis()-str;
	System.err.println("Output written to "+output+" in "+end);

    }
    
    public static void main(String[]args) {
	try {
	    new SimpleSaxon().transform("big.xml", "result.xml", "no-muench.xsl");
	} catch (SaxonApiException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
}