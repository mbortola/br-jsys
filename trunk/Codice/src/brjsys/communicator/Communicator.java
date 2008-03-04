package brjsys.communicator;


import org.exist.xmldb.CollectionManagementServiceImpl;
import org.exist.xmldb.XmldbURI;
import org.xmldb.api.*;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.*;
/**
 * Classe che si interfaccia ad eXist e comunica col repository tramite
 *  linguaggio XQuery 
 * @author Michele  Bortolato
 * @version 0.9 3 Mar 2008
 * 
 */
public class Communicator {
	
	/**Consente di interrogare il repository tramite XQuery*/
	private static XPathQueryService service=null;

	/**Dopo una corretta autenticazione conterra' l'username d'accesso*/
	private String correctUsername=null;
	
	/**Dopo una corretta autenticazione conterra' la password d'accesso*/
	private String correctPassword=null;

	/**
	 * Costruttore.Controlla inoltre che il repository sia presente nel DBMS, 
	 * in caso contrario verra' ceato un repository vuoto.
	 * @param username Username 
	 * @param password Password
	 * @exception XMLDBException Connessione rifuitata a causa di dati in 
	 * ingresso errati o di server eXist non avviato
	 */	
	public Communicator(String username, String password) throws XMLDBException{
		if(service!=null){//sono gia' connesso
			if (username!=correctUsername || password!=correctPassword) {
				//username sbagliato!
				//devo lanciare una eccezzione
			}
		}else{
			//prima connessione, procedura di connessione
			String driver = "org.exist.xmldb.DatabaseImpl";
			Class cl;
			Collection cpointer=null;
			try {
				cl = Class.forName(driver);
				Database database = (Database) cl.newInstance();
				try {
					DatabaseManager.registerDatabase(database);
				} catch (XMLDBException e) {
					e.printStackTrace();
				}
				cpointer= DatabaseManager.getCollection(
						"xmldb:exist://localhost:8080/exist/xmlrpc/db",
						username, password);
				//controllo se c'e repository
				if (cpointer.getChildCollection("BR-jsys")==null) {
					//se non c'e' lo creo
					
					CollectionManagementServiceImpl co=
						(CollectionManagementServiceImpl)cpointer.getService(
								"CollectionManagementService", "1.0");
					
					co.createCollection(XmldbURI.create("BR-jsys"));
					
					cpointer =cpointer.getChildCollection("BR-jsys");
					
					
					XMLResource document= 
						(XMLResource)cpointer.createResource(
								"Repository.xml","XMLResource");

					document.setContent("<BusinessRules/>");
				
					cpointer.storeResource(document);
					//aggiungo la XMLResource alla Collezione BR-jsys
				}else{cpointer =cpointer.getChildCollection("BR-jsys");}

				service = 
					(XPathQueryService) cpointer.getService(
							"XPathQueryService", "1.0");
				service.setProperty("indent", "yes");
				//XPathQueryService e' un servizio 
				//che consente di fare query con eXist
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} 
		}
	}

	/**Consente di interrogare il repository tramite XQuery.
	 * 
	 * @param query Query da eseguire.
	 * 
	 * @return Il risultato della query.
	 * 
	 * @exception XMLDBException Query mal posta.
	 * */
	public ResourceSet makeQuery(String query)throws XMLDBException {
			return service.query(query);		
	}
}
