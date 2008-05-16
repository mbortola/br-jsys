import java.io.FileNotFoundException;

import javax.xml.transform.TransformerException;


public class test {
	public static void main(String[]args) {
		try {
			XSLTrasform.parse("out2.xml", "neu.xml", "prova1.xsl");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
