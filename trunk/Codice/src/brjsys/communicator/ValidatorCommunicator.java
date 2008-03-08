package brjsys.communicator;

import org.xmldb.api.base.*;

/**
 * Consente al validatore di disporre dei metodi necessari per comunicare con
 *  eXist
 * @author Michele  Bortolato
 * @version 0.9 3 Mar 2008
 * 
 */
public class ValidatorCommunicator {
	/**Interfaccia con eXist*/
	private Communicator queryService=null;
	/**
	 * Costruttore
	 * 
	 * @param username Username in ingresso
	 * @param password Password in ingresso
	 * 
	 * @exception Exception Descrive la tipologia del fallimento.
	 * */
	public ValidatorCommunicator(String username, String password) 
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
	 * Inserisce un elemento XML regola nel repository soltanto se ha un nome 
	 * diverso da tutte le altre regole gia' presenti.
	 * 
	 * @param rule Stringa che rappresenta la business rule in XML
	 * @param idRule Nome della business rule da inserire
	 * 
	 * @return true se la regola e' stata inserita, altrimenti false.
	 * */
	public boolean insertRule(String rule, String idRule){
		//Guardo se nel repository non esiste gia' una br con il mio stesso nome
		try {
			long test=queryService.makeQuery("let $i:=//BusinessRule[@name='"+
					idRule+"'] return $i").getSize();

			if (test>0) {
				//gia' altre regole hanno quel nome
				return false;
			}

			//inserisco la br

			queryService.makeQuery("update insert "+
					rule+" into /BusinessRules");
		} catch (XMLDBException e) {
			//non dovrebbe mai accadere
			e.printStackTrace();
			System.exit(1);
		}

		return true;
	}

}
