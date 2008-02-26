package brjsys.communicator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.xmldb.api.base.*;

import brjsys.businessrules.BusinessRule;

public class GUICommunicator {
	private Communicator queryService=null;
	
	public GUICommunicator(String username, String password) throws XMLDBException{
			queryService=new Communicator(username, password);
	}
	
	public boolean deleteRuleByName(String id){
		//Guardo se esiste la regola con questo nome
		
		try {
			long test=queryService.makeQuery("let $i:=//BusinessRule[@name='"+id+"'] return $i").getSize();
			if(test>0)return false;
		} catch (XMLDBException e) {e.printStackTrace();}
		//Cancello la regola con questo id
		queryService.makeQuery("for $i in //BusinessRule[@name='"+id+"'] return update delete $i");
		return true;
	}
	
	public String makeQuery(String query) throws XMLDBException{
		//controllo che la query non mi modifichi il repository
		
		if(query.contains("update")){
			if(query.contains("insert")||query.contains("replace")||query.contains("delete")||query.contains("value")||query.contains("rename")){
				//query cattiva
			}
		}
		
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
	
	public BusinessRule[] getListRules(){
		//ritorno una stringa per br coi campi separati e li gestisco a mano
		try {
			String informations=this.makeQuery(
					"for $i:=//BusinessRule return concat($i/@name,'^',$i/@rule,'^',$i/@comment,'^',$i/@associated,'$$')");
			
			/*$$ separa br tra di loro
			 * ^ separa tra di loro i vari campi delle br
			 * usare split....e ricordarsi di mettere il tag comment non alla fine
			 */
			
			String[] numBR=informations.split("$$");
			String[] temp=new String[4];
			BusinessRule[] result=new BusinessRule[numBR.length];
			for(int index=0;index<numBR.length;index++){
				temp=numBR[index].split("^");
				result[index]=new BusinessRule(temp[0],temp[3],temp[1],temp[2]);
			}
			return result;
			
		} catch (XMLDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void x() throws XMLDBException{//debug
		queryService.showResource();
	}
	
	public static void main(String[]args){//debug
		GUICommunicator v=null;
		try {
			try {
				v=new GUICommunicator("admin","happy");
			} catch (XMLDBException e) {
				System.err.println("errore in connessione");
				System.exit(1);
			}
			//v.x();Debug
			String x=null,result=null;
			while(true){
				x=(new BufferedReader(new InputStreamReader(System.in))).readLine();
				try {
					result=v.makeQuery(x);
					System.out.println("<<<\n"+result);
				} catch (XMLDBException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
