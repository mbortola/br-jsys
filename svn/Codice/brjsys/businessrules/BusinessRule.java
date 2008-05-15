package brjsys.businessrules;

/**
 * Classe per rappresentare una business rule
 * @author Michele  Bortolato
 * @version 1.2 14 Mar 2008
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
	
	/**Costruttore.
	 * 
	 * @param nameR Nome della regola.
	 * @param associatedR Business object associato alla regola.
	 * @param ruleR Regola inserita.
	 * @param commentR Commento.
	 * */
	public BusinessRule(String nameR, String associatedR, String ruleR, 
			String commentR) {
		name=nameR;
		associated=associatedR;
		rule=ruleR;
		comment=commentR;
		
	}
}
