package brjsys.validator;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;

public class TypeCollisionException extends RecognitionException{

	private static final long serialVersionUID = 1L;
	protected Class first;
	protected Class second;
	
	public TypeCollisionException(Class a,Class b){first=a;second=b;}
	
	public TypeCollisionException(Class a,Class b,Token t){first=a;second=b;token=t;}
	
	public void printStackTrace(){
		System.err.println("COLLISION:"+first.getCanonicalName()+"!="+second.getCanonicalName());
		super.printStackTrace();
	}
	public String toString(){
		return "errore in confronto:"+first+"!="+second+" al token:"+token.getText();
	}
}
