package brjsys.validator;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;
import brjsys.businessrules.BusinessRule;
import brjsys.communicator.ValidatorCommunicator;

/**
 * Consente la validazione di una business rule
 * @author Michele  Bortolato
 * @version 0.9 3 Mar 2008
 * 
 */

public class Validator {
	/**
	 * Fa comunicare Validator con eXist
	 */
	private ValidatorCommunicator repository;

	public Validator (String username, String password) throws Exception {

		repository=new ValidatorCommunicator(username, password);
	}
	
	/**
	 * Valida la business rule
	 * 
	 * @param 
	 * */
	public boolean validate(BusinessRule bRule) throws Exception{
		// create a CharStream that reads from standard input
		ANTLRStringStream input;
		CommonTokenStream tokens=null;
		
		try {
			input = new ANTLRStringStream(bRule.rule);
			
			BusinessRuleLexer lexer = new BusinessRuleLexer(input);

			tokens = new CommonTokenStream(lexer);

			BusinessRuleParser parser = 
				new BusinessRuleParser(bRule.associated, tokens);

			BusinessRuleParser.start_return r=parser.start();

			CommonTree tree= (CommonTree)r.getTree();

			XMLParser tree2XML =new XMLParser(BusinessRuleParser.tokenNames);
			
			String result=tree2XML.parse(tree, bRule);

			return repository.insertRule(result, bRule.name);

		} catch (RecognitionException e) {
			//Qui faccio il controllo di tutti gli errori lanciati dal validatore
			if (e instanceof TypeCollisionException) {
				throw new Exception(e);
			}
			if (e instanceof NoViableAltException) {

			}
			throw e;
		}
	}

}