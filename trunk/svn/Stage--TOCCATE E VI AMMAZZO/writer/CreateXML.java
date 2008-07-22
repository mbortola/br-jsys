package writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXML {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
	String f="big.xml";

	FileWriter fw=new FileWriter(new File(f));

	fw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<root>\n");

	int t=0,val=0,txx=0;

	String start="";

	for(int i=0;i<200000;i++){
	    if(i%10000==0)System.out.println(i);
	    t=(int)(Math.random()*10);
	    val=(int)(Math.random()*120);
	    txx=(int)(Math.random()*10000);
	    start="\t<item   ord='"+t+"'  value='"+val+"'>\n\t\t"+txx+"\n\t</item>\n";
	    fw.write(start);
	    start="";
	}
	fw.write("</root>\n");
	fw.flush();
	fw.close();

    }

}
