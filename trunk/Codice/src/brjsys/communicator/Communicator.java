package brjsys.communicator;

import java.io.File;

import org.exist.xmldb.CollectionManagementServiceImpl;
import org.exist.xmldb.XmldbURI;
import org.xmldb.api.*;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.*;

public class Communicator {
	private static XPathQueryService service=null;

	private static Collection cpointer=null;//debug

	String correctUsername=null;
	String correctPassword=null;

	public Communicator(String username, String password) throws XMLDBException{
		if(service!=null){//sono già connesso
			if(username!=correctUsername || password!=correctPassword){
				//username sbagliato!
				//devo lanciare una eccezzione
			}
		}else{
			//prima connessione, procedura di connessione
			String driver = "org.exist.xmldb.DatabaseImpl";
			Class cl;
			try {
				cl = Class.forName(driver);
				Database database = (Database) cl.newInstance();
				try {
					DatabaseManager.registerDatabase(database);
				} catch (XMLDBException e) {e.printStackTrace();}
				cpointer= DatabaseManager.getCollection("xmldb:exist://localhost:8080/exist/xmlrpc/db", username, password);
				//controllo se c'e repository
				if(cpointer.getChildCollection("BR-jsys")==null){
					//se non c'è lo creo
					CollectionManagementServiceImpl co=(CollectionManagementServiceImpl)cpointer.getService("CollectionManagementService", "1.0");
					co.createCollection(XmldbURI.create("BR-jsys"));
					//Metodo rognoso per creare una nuova collection, apprenderlo mi è costato molti sacrifici
					cpointer =cpointer.getChildCollection("BR-jsys");
					//File rep=new File("files/Repository.xml");
					//il file Repository.xml si trova al path sopra citato, potrei creare un file temporaneo ma non lo so fare...per ora
					XMLResource document=(XMLResource)cpointer.createResource("Repository.xml","XMLResource");

					//document.setContent(rep);!!Prova

					cpointer.storeResource(document);
					//aggiungo la XMLResource alla Collezione BR-jsys
				}else{cpointer =cpointer.getChildCollection("BR-jsys");}

				service =	(XPathQueryService) cpointer.getService("XPathQueryService", "1.0");
				service.setProperty("indent", "yes");
				//XPathQueryService è un servizio che consente di fare query con eXist
			}
			catch (ClassNotFoundException e) {e.printStackTrace();} 
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();} 
		}
	}

	public void showResource() throws XMLDBException{//debug
		String[] col=cpointer.listChildCollections();
		String[] res=cpointer.listResources();
		for(int i=0;i<col.length;i++){
			System.out.println(col[i]);
		}
		for(int i=0;i<res.length;i++){
			System.out.println(res[i]);
		}
	}

	public ResourceSet makeQuery(String query){
		try {
			return service.query(query);		
		} catch (XMLDBException e) {
			e.printStackTrace();
		}
		return null;
	}
}
