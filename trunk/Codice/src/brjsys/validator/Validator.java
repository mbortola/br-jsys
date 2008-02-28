package brjsys.validator;


import java.io.*;
import java.util.*;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;
//import org.xmldb.api.base.XMLDBException;

import brjsys.businessrules.BusinessRule;
import brjsys.communicator.ValidatorCommunicator;

public class Validator {
	private ValidatorCommunicator repository;
	public Validator(String username, String password){// throws XMLDBException/*errore in connessione*/{
		repository=new ValidatorCommunicator(username, password);
	}
	public boolean validate(BusinessRule Brule){
		// create a CharStream that reads from standard input
		ANTLRStringStream input;
		CommonTokenStream tokens=null;
		try {
			System.out.println("Enter try");
			input = new ANTLRStringStream(Brule.rule);
			// create a lexer that feeds off of input CharStream
			BusinessRuleLexer lexer = new BusinessRuleLexer(input);
			System.out.println("Exit Lexer");
			// create a buffer of tokens pulled from the lexer
			tokens = new CommonTokenStream(lexer);
			System.out.println("Exit cts");
			// create a parser that feeds off the tokens buffer
			BusinessRuleParser parser = new BusinessRuleParser("Articolo", tokens);
			
			// begin parsing at rule r
			BusinessRuleParser.start_return r=parser.start();
			System.out.println("Exit Parser");
			CommonTree tree=(CommonTree)r.getTree();
			System.out.println("Exit ctr");
			XMLParser tree2XML =new XMLParser();
			String result=tree2XML.parse(tree, Brule);
			System.out.println("Exit XMLParser");
			return true;//repository.insertRule(result, Brule.name);
			
		} catch (RecognitionException e) {
			System.out.println(e);
		}finally{}

		return true;
	}
	public static void main(String[] args){
		try {
			
			Validator v=new Validator("admin","michele");
			BusinessRule rule=new BusinessRule("uno","art","12=0","no");
			q("nome:");
			rule.name=(new BufferedReader(new InputStreamReader(System.in))).readLine();
			q("associated:");
			rule.associated=(new BufferedReader(new InputStreamReader(System.in))).readLine();
			q("rule:");
			rule.rule=(new BufferedReader(new InputStreamReader(System.in))).readLine();
			q("comment:");
			rule.comment=(new BufferedReader(new InputStreamReader(System.in))).readLine();
			p(v.validate(rule)?"yes":"no");
			
		}/* catch (XMLDBException e) {
			System.out.println("errore in connessione");
			e.printStackTrace();
		} */catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void p(String s){
		System.out.println(s);
	}
	public static void q(String s){
		System.out.print(s);
	}
}