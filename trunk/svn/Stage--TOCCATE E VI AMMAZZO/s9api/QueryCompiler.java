package s9api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.Serializer;
import net.sf.saxon.s9api.XQueryCompiler;
import net.sf.saxon.s9api.XQueryExecutable;

public class QueryCompiler {

	/**Converte il contenuto di un file in una stringa.
	 * 
	 * @param file Nome file.
	 * */
	public String readFile(String file) {
		FileInputStream fis;
		try {
			fis = new FileInputStream("buildtree2.xquery");
			int x= fis.available();
			byte b[]= new byte[x];
			fis.read(b);
			return new String(b);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
		
	}


	public void run() throws SaxonApiException {
		
		Processor proc = new Processor(false);
		
		XQueryCompiler comp = proc.newXQueryCompiler();
		XQueryExecutable exp = comp.compile(readFile("buildtree.xml"));
		
		Serializer out = new Serializer();
		
		out.setOutputProperty(Serializer.Property.METHOD, "xml");
		//out.setOutputProperty(Serializer.Property.INDENT, "yes");
		//out.setOutputProperty(Serializer.Property.OMIT_XML_DECLARATION, "yes");
		
		out.setOutputFile(new File("out.xml"));
		
		//out.setOutputStream(System.out);
		Long inizio=System.currentTimeMillis();
		exp.load().run(out);
		Long fine=System.currentTimeMillis();
		
		System.out.println(fine-inizio);
	}

	public static void main(String[]args) throws SaxonApiException {
		new QueryCompiler().run();
	}

}

