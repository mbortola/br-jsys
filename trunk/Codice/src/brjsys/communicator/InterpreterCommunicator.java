package brjsys.communicator;

import org.w3c.dom.*;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XMLResource;

/**
 * Consente all'interprete di disporre dei metodi necessari per comunicare
 *  con eXist
 * @author Michele  Bortolato
 * @version 0.9 3 Mar 2008
 * 
 */
public class InterpreterCommunicator {

	/**Interfaccia con Exist*/
	private Communicator queryService=null;

	/**
	 * Costruttore
	 * 
	 * @param username Username in ingresso
	 * @param password Password in ingresso
	 * 
	 * @exception Exception Descrive la tipologia del fallimento.
	 * */
	public InterpreterCommunicator(String username, String password) 
	throws Exception{
		try{
			queryService=new Communicator(username, password);
		} catch (XMLDBException error){
			int er=error.errorCode;
			switch (er){
			case ErrorCodes.PERMISSION_DENIED: 
				throw new Exception("Autenticazione fallita");

			default:
				throw new Exception("Server eXist spento.");	
			}
		}
	}

	/**
	 * Ottieni le Business rule associate ad associated.
	 * 
	 * @param associated Nome del oggetto associato.
	 * 
	 * @return Lista degli elementi che rappresentano le business rules 
	 * associate ad associated
	 * */
	public NodeList getRules(String associated) {
		//faccio la query
		try {
			ResourceSet set=queryService.makeQuery("let $i :=//*[@associated='"+
					associated+"'] return <a>{$i}</a>");
			//la inglobo tutta dentro ad un unico tag
			ResourceIterator i;
			i = set.getIterator();
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
		} catch (XMLDBException e) {
			//Non dovrebbe mai accadere
			e.printStackTrace();
			System.exit(0);
		}
		return null;
	}
}
