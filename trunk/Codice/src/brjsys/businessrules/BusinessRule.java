package brjsys.businessrules;

/**
 * Classe per rappresentare una business rule
 * @author Michele  Bortolato
 * @version 0.9 3 Mar 2008
 * 
 */
public class BusinessRule {
	/**Nome della regola*/
	public String name;
	/**Business object associato alla regola*/
	public String associated;
	/**Rappresentazione testuale della regola*/
	public String rule;
	/**Commento opzionale alla regola*/
	public String comment;
	
	/**Costruttore.*/
	public BusinessRule(String string, String string2, String string3,String string4) {
		name=string;
		associated=string2;
		rule=string3;
		comment=string4;
	}
}
