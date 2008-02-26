package brjsys.communicator;

import org.xmldb.api.base.*;

public class ValidatorCommunicator {
	
	private Communicator queryService=null;
	
	public ValidatorCommunicator(String username, String password) throws XMLDBException{
		queryService=new Communicator(username, password);
	}

	public boolean insertRule(String rule, String idRule){
		//Guardo se nel repository non esiste già una br con il mio stesso nome
		try {
			long test=queryService.makeQuery("let $i:=//BusinessRule[@name='"+idRule+"'] return $i").getSize();
			if(test>0)return false;
		} catch (XMLDBException e) {e.printStackTrace();}
		//inserisco la br
		
		queryService.makeQuery("update insert "+rule+" into /BusinessRules");
		
		return true;
	}
	
}
