package brjsys.validator;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;

public class TypeCollisionException extends RecognitionException{

	private static final long serialVersionUID = 1L;
	protected Class first;
	protected Class second;
	
	protected String message=null;
		
	public TypeCollisionException(Class a,Class b,Token t){
		first=a;
		second=b;
		token=t;
		message="errore in confronto:"+first+"!="+second+" al token:"+token.getText();
	}
	
	public TypeCollisionException(String msg){
		message=msg;
	}
	
	public String toString(){
		return message;
	}
}
