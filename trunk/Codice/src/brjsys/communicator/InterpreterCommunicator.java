package brjsys.communicator;

import org.w3c.dom.*;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XMLResource;

/**
 * Consente all'interprete di disporre dei metodi necessari per comunicare
 *  con eXist
 * @author Michele  Bortolato
 * @version 1.2 14 Mar 2008
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
			switch (error.errorCode){
			case ErrorCodes.INVALID_COLLECTION: 
				throw new Exception("Server eXist spento.");
			case ErrorCodes.VENDOR_ERROR:
				throw new Exception("Autenticazione fallita");
			default:
				throw new Exception("Errore Inaspettato!");
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
			XMLResource r = (XMLResource)i.nextResource();
			Node node=r.getContentAsDOM();

			NodeList list=node.getChildNodes();
			Element el=(Element)list.item(0);
			NodeList list2=el.getElementsByTagName("BusinessRule");

			return list2;
		} catch (XMLDBException e) {
			//Non dovrebbe mai accadere
			e.printStackTrace();
			System.exit(0);
		}
		return null;
	}
}
