package brjsys.validator;

import org.antlr.runtime.RecognitionException;

public class TypeCollisionException extends RecognitionException{

	String message;
	
	private static final long serialVersionUID = 1L;
				
	public TypeCollisionException(String s){
		message=s;
	}
	
	public String toString(){
		return message;
	}
	
}
