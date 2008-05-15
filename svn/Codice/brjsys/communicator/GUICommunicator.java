package brjsys.communicator;

import org.xmldb.api.base.ErrorCodes;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;

import brjsys.businessrules.BusinessRule;

/**
 * Consente alla gui di disporre dei metodi necessari per comunicare con eXist
 * @author Michele  Bortolato
 * @version 1.2 14 Mar 2008
 * 
 */
public class GUICommunicator {
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
	public GUICommunicator(String username, String password) 
	throws Exception{
		try{
			queryService=new Communicator(username, password);
		} catch (XMLDBException error){
			switch (error.errorCode){
			case ErrorCodes.INVALID_COLLECTION: 
				throw new Exception("ERR00: Server eXist spento.");
			case ErrorCodes.VENDOR_ERROR:
				throw new Exception("ERR01: Autenticazione fallita");
			default:
				throw new Exception("Errore Inaspettato!");
			}
		}
	}

	/**
	 * Cancella una business rule dato il suo nome.
	 * 
	 * @param id Il nome della business rule
	 * 
	 * @return true se business rule e' stata cancellata, false se la regola
	 *  non era presente nel repository.
	 * */
	public boolean deleteRuleByName(String id){
		//Guardo se esiste la regola con questo nome
		try {
			long test= 
				queryService.makeQuery("let $i:=//BusinessRule[@name='"
					+id+"'] return $i").getSize();

			if (test<=0) {
				//Non esiste nel repository una regola con questo nome
				return false;
			}
			//Cancello la regola con questo id
			queryService.makeQuery("for $i in //BusinessRule[@name='"+id
					+"'] return update delete $i");
		} catch (XMLDBException e) {
			//non dovrebbe mai accadere
			e.printStackTrace();
			System.exit(1);
		}
		return true;
	}

	/**
	 * Permette di fare query che non intaccano l'integrita' del repository.
	 * 
	 * @param query Query in ingresso.
	 * @return Il risultato sotto forma di dato String.
	 * @exception Exception Query mal posta.
	 * */
	public String makeQuery(String query) throws Exception{
		//controllo che la query non mi modifichi il repository

		if(query.contains("update")){
			if (query.contains("insert")
					||query.contains("replace")||query.contains("delete")
					||query.contains("value")||query.contains("rename")) {
				throw new Exception("Non puoi fare query di modifica!");
			}
		}
		ResourceSet result=queryService.makeQuery(query);

		ResourceIterator i = result.getIterator();

		String value="";
		while(i.hasMoreResources()) {
			Resource r = i.nextResource();
			value+=((String)r.getContent());
		}
		return value;
	}

	/**
	 * Ritorna le informazioni su tutte le regole presenti nel repository
	 * 
	 * @return Array con tutte le business rules.
	 * */
	
	public BusinessRule[] getListRules(){
        //ritorno una stringa per br coi campi separati e li gestisco a mano
        String informations;
        try {
            informations = this.makeQuery(
                    "for $i in //BusinessRule return "+
                    "concat($i/@name,':',$i/@rule,':',"
                    +"$i/@comment,':',$i/@associated,':::')");

            String[] numBR=informations.split(":::");
            if (informations.equals("")) {
                return new BusinessRule[0];
            }
            String[] temp=new String[4];
            BusinessRule[] result=new BusinessRule[numBR.length];
            for(int index=0;index<numBR.length;index++){
                temp=numBR[index].split(":");
                result[index]=
                    new BusinessRule(temp[0],temp[3],temp[1],temp[2]);
            }
            return result;
        } catch (Exception e) {
            //Non dovrebbe mai accadere
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
