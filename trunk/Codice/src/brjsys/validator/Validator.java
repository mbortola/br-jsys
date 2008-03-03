package brjsys.validator;


import java.io.*;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;
import brjsys.businessrules.BusinessRule;
import brjsys.communicator.ValidatorCommunicator;

/**
 * 
 */

public class Validator {
	/**
	 * Fa comunicare Validator con eXist
	 *
	 */
	private ValidatorCommunicator repository;

	public Validator (String username, String password) throws Exception {
		repository=new ValidatorCommunicator(username, password);
	}
	
	public boolean validate(BusinessRule Brule) throws Exception{
		// create a CharStream that reads from standard input
		ANTLRStringStream input;
		CommonTokenStream tokens=null;
		try {
			input = new ANTLRStringStream(Brule.rule);
			
			BusinessRuleLexer lexer = new BusinessRuleLexer(input);

			tokens = new CommonTokenStream(lexer);

			BusinessRuleParser parser = new BusinessRuleParser(Brule.associated, tokens);

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
			} catch (IOException e) {
				e.printStackTrace();
			}catch (Exception e) {
				System.out.println("errore in connessione");
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