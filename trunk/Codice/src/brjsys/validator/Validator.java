package brjsys.validator;


import java.io.*;
import java.util.*;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.xmldb.api.base.XMLDBException;

import brjsys.businessrules.BusinessRule;
import brjsys.communicator.ValidatorCommunicator;

public class Validator {
	private ValidatorCommunicator repository;
	public Validator(String username, String password) throws XMLDBException/*errore in connessione*/{
		repository=new ValidatorCommunicator(username, password);
	}
	public boolean validate(BusinessRule Brule){
		// create a CharStream that reads from standard input
		ANTLRInputStream input;
		CommonTokenStream tokens=null;
		try {
			input = new ANTLRInputStream(System.in);
			// create a lexer that feeds off of input CharStream
			BusinessRuleLexer lexer = new BusinessRuleLexer(input);
			// create a buffer of tokens pulled from the lexer
			tokens = new CommonTokenStream(lexer);
			// create a parser that feeds off the tokens buffer
			BusinessRuleParser parser = new BusinessRuleParser("Articolo", tokens);
			// begin parsing at rule r
			parser.start();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RecognitionException e) {
			System.out.println(e);
		}finally{}

		return true;
	}
	public static void main(String[] args){

		//System.out.println(tokens.get(5).getText());}
	}

}