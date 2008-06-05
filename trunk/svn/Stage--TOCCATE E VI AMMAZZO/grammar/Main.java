package grammar;

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;


public class Main {
	public static void main(String[]args) {
		CommonTokenStream tokens=null;

		ANTLRFileStream file=null;

		try {
			file = new ANTLRFileStream("schema.txt");

			descrittoreLexer lexer = new descrittoreLexer(file);

			tokens = new CommonTokenStream(lexer);

			descrittoreParser parser=new descrittoreParser(tokens);
			
			parser.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
