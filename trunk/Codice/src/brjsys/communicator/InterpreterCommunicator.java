package brjsys.communicator;

import org.w3c.dom.*;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XMLResource;

public class InterpreterCommunicator {
	/**
	 * s
	 */
	private Communicator queryService=null;

	public InterpreterCommunicator(String username, String password) 
	throws Exception{
		try{
			queryService=new Communicator(username, password);
		} catch (XMLDBException error){
			throw new Exception("Autenticazione fallita");		
		}
	}

	public NodeList getRules(String associated) throws XMLDBException{

		//faccio la query
		//
		ResourceSet set=queryService.makeQuery("let $i := //*[@associated='"+
				associated+"'] return <a>{$i}</a>");
		//la inglobo tutta dentro ad un unico tag
		ResourceIterator i=set.getIterator();
		String val="";
		XMLResource r = (XMLResource)i.nextResource();
		val=((String)r.getContent());
		System.out.println("++++"+val);
		Node node=r.getContentAsDOM();

		NodeList list=node.getChildNodes();
		Element el=(Element)list.item(0);
		NodeList list2=el.getElementsByTagName("BusinessRule");

		for(int x=0;x<list2.getLength();x++){
			System.out.println(list2.item(x).getNodeName());
		}

		return list2;
	}
}
