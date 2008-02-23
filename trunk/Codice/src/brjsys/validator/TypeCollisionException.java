package brjsys.validator;

import org.antlr.runtime.RecognitionException;

public class TypeCollisionException extends RecognitionException{

	private static final long serialVersionUID = 1L;
	protected Class first;
	protected Class second;
	
	public TypeCollisionException(Class a,Class b){first=a;second=b;}
	
	public void printStackTrace(){
		System.err.println("COLLISION:"+first.getCanonicalName()+"!="+second.getCanonicalName());
		super.printStackTrace();
	}
}
