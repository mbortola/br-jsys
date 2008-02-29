package brjsys.validator;


import java.io.*;
import java.util.*;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;
import org.xmldb.api.base.XMLDBException;

import brjsys.businessrules.BusinessRule;
import brjsys.communicator.ValidatorCommunicator;

public class Validator {
	private ValidatorCommunicator repository;
	public Validator(String username, String password)throws XMLDBException/*errore in connessione*/{
		repository=new ValidatorCommunicator(username, password);
	}
	public boolean validate(BusinessRule Brule) throws Exception{
		// create a CharStream that reads from standard input
		ANTLRStringStream input;
		CommonTokenStream tokens=null;
		try {

			input = new ANTLRStringStream(Brule.rule);
			// create a lexer that feeds off of input CharStream
			BusinessRuleLexer lexer = new BusinessRuleLexer(input);

			// create a buffer of tokens pulled from the lexer
			tokens = new CommonTokenStream(lexer);

			// create a parser that feeds off the tokens buffer
			BusinessRuleParser parser = new BusinessRuleParser(Brule.associated, tokens);
			// begin parsing at rule r
			BusinessRuleParser.start_return r=parser.start();

			CommonTree tree=(CommonTree)r.getTree();

			XMLParser tree2XML =new XMLParser(BusinessRuleParser.tokenNames);
			String result=tree2XML.parse(tree, Brule);

			return repository.insertRule(result, Brule.name);

		} catch (RecognitionException e) {
			//Qui faccio il controllo di tutti gli errori lanciati dal validatore
			if(e instanceof TypeCollisionException){
				throw new Exception(e);
			}
			if(e instanceof NoViableAltException){
				
			}
			throw e;
		}
	}
	public static void main(String[] args){
		while (true) {
			try {
				Validator v=new Validator("admin","happy");
				BusinessRule rule=new BusinessRule("uno","art","12=0","no");
				q("nome:");
				rule.name=(new BufferedReader(new InputStreamReader(System.in))).readLine();
				q("associated:");
				rule.associated=(new BufferedReader(new InputStreamReader(System.in))).readLine();
				q("rule:");
				rule.rule=(new BufferedReader(new InputStreamReader(System.in))).readLine();
				q("comment:");
				rule.comment=(new BufferedReader(new InputStreamReader(System.in))).readLine();
				try {
					p(v.validate(rule)?"yes":"no");
				} catch (Exception e) {
					System.out.println("ERRORE!!!!!\n"+e.getMessage());
				}
			} catch (XMLDBException e) {
				System.out.println("errore in connessione");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public static void p(String s){
		System.out.println(s);
	}
	public static void q(String s){
		System.out.print(s);
	}
}