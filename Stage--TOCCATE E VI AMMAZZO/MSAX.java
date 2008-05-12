import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class MSAX {

	public static void main(String[] args) { 
		try {
			SAXParserFactory parserFactory = 
				SAXParserFactory.newInstance();
			SAXParser parser = 	parserFactory.newSAXParser(); 
			
			parser.parse(new File("out.xml"),new MySAXParser()); 
		}
		catch(Exception e) { 
			e.printStackTrace(); 
		} 
	}
} 

