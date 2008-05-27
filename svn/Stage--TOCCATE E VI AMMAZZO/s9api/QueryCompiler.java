package s9api

public class QueryCompiler {

	public void run() throws SaxonApiException {
		Processor proc = new Processor(false);
		XQueryCompiler comp = proc.newXQueryCompiler();
		XQueryExecutable exp = comp.compile("<a b='c'>{5+2}</a>");
		Serializer out = new Serializer();
		out.setOutputProperty(Serializer.Property.METHOD, "xml");
		out.setOutputProperty(Serializer.Property.INDENT, "yes");
		out.setOutputProperty(Serializer.Property.OMIT_XML_DECLARATION, "yes");
		out.setOutputStream(System.out);
		exp.load().run(out);
	}
}
}
