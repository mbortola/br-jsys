package brjsys.communicator;

import org.xmldb.api.base.*;

import brjsys.businessrules.BusinessRule;

public class GUICommunicator {
	/**Interfaccia con eXist*/
	private Communicator queryService=null;

	/**
	 * */
	public GUICommunicator(String username, String password) 
	throws Exception{
		try{
			queryService=new Communicator(username, password);
		} catch (XMLDBException error){
			throw new Exception("Autenticazione fallita");		
		}
	}

	public boolean deleteRuleByName(String id){
		//Guardo se esiste la regola con questo nome
		try {
			long test=queryService.makeQuery("let $i:=//BusinessRule[@name='"
					+id+"'] return $i").getSize();
			if(test<=0)return false;
		} catch (XMLDBException e) {e.printStackTrace();}
		//Cancello la regola con questo id
		queryService.makeQuery("for $i in //BusinessRule[@name='"+id
				+"'] return update delete $i");
		return true;
	}

	public String makeBadQuery(String query) throws XMLDBException{
		ResourceSet result=queryService.makeQuery(query);

		ResourceIterator i = result.getIterator();
		//System.out.println(result.getSize());debug
		String val="";
		while(i.hasMoreResources()) {
			Resource r = i.nextResource();
			val+=((String)r.getContent());
		}
		return val;
	}

	public String makeQuery(String query) throws XMLDBException{
		//controllo che la query non mi modifichi il repository

		if(query.contains("update")){
			if(query.contains("insert")
					||query.contains("replace")||query.contains("delete")
					||query.contains("value")||query.contains("rename")){
				throw new XMLDBException(ErrorCodes.PERMISSION_DENIED, 
						"Non puoi fare query di modifica!");
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

	public BusinessRule[] getListRules(){
		//ritorno una stringa per br coi campi separati e li gestisco a mano
		try {
			String informations=this.makeQuery(
			"for $i in //BusinessRule return concat($i/@name,':',$i/@rule,':',"
					+"$i/@comment,':',$i/@associated,':::')");

			String[] numBR=informations.split(":::");
			for(int i=0;i<numBR.length;i++){
				System.out.println(numBR[i]);
			}

			String[] temp=new String[4];
			BusinessRule[] result=new BusinessRule[numBR.length];
			for(int index=0;index<numBR.length;index++){
				temp=numBR[index].split(":");
				result[index]=new BusinessRule(temp[0],temp[3],temp[1],temp[2]);
			}
			return result;

		} catch (XMLDBException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
