package brjsys.validator;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;

public class TypeCollisionException extends RecognitionException{

	String message;
	
	private static final long serialVersionUID = 1L;
			
	public TypeCollisionException(Class a,Class b,Token t){
		message=("errore in confronto:"+a+"!="+b+" al token:"+t.getText());
	}
	
	public TypeCollisionException(String s){
		message=s;
	}
	
	public String toString(){
		return message;
	}
	
}
