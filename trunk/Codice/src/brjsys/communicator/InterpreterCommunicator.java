package brjsys.communicator;

import org.w3c.dom.NodeList;
import org.xmldb.api.base.XMLDBException;

public class InterpreterCommunicator {

	private Communicator queryService=null;

	public InterpreterCommunicator(String username, String password) throws XMLDBException{
		queryService=new Communicator(username, password);
	}
	
	public NodeList getRules(String associated){
		
		//faccio la query
		//let $i := //BusinessRule[@associated='Articolo'] return $i
		//la inglobo tutta dentro ad un unico tag
		
		return null;
	}
	
}
