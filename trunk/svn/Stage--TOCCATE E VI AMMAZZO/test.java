import java.io.FileNotFoundException;

import javax.xml.transform.TransformerException;

import stage.util.XSLTransform;


public class test {
	public static void main(String[]args) {
		try {
			XSLTransform.parse("out2.xml", "neu.xml", "prova1.xsl");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String x=new String("abc");
		String k=x;
		k=k.replace('a', 'z');
		System.out.println(x+' '+k);
		
	}
}
