package brjsys.validator;

import org.antlr.runtime.RecognitionException;

/**
 * Eccezione in fase di validazione. 
 * @author Michele  Bortolato
 * @version 0.9 6 Mar 2008
 * 
 */
public class TypeCollisionException extends RecognitionException{
	/**Messaggio d'errore.*/
	String message;
	
	private static final long serialVersionUID = 1L;
	
	/**Costruttore.*/			
	public TypeCollisionException(String s){
		message=s;
	}
	
	/**Ritorna il campo dati message.*/
	public String toString(){
		return message;
	}
	
}
