package brjsys.communicator;

import java.io.StringWriter;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XMLResource;

public class InterpreterCommunicator {
	/**
	 * s
	 */
	private Communicator queryService=null;

	public InterpreterCommunicator(String username, String password) throws XMLDBException{
		queryService=new Communicator(username, password);
	}

	public NodeList getRules(String associated) throws XMLDBException{

		//faccio la query
		//
		ResourceSet set=queryService.makeQuery("let $i := //*[@associated='"+associated+"'] return <a>{$i}</a>");
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
	public static void main(String[]args){
		try {
			InterpreterCommunicator c=new InterpreterCommunicator("admin","happy");
			NodeList rules=c.getRules("Archivio");
			System.out.println(rules.getLength());
			for(int index=0;index<rules.getLength();index++){
				System.out.println(rules.item(index).getNodeName());
			}
			TransformerFactory tranFactory = TransformerFactory.newInstance();
			Transformer aTransformer=null;
			try {
				aTransformer = tranFactory.newTransformer();
			} catch (TransformerConfigurationException e1) {

				e1.printStackTrace();
			}
			StringWriter st=new StringWriter();
			Source src = new DOMSource(rules.item(0));
			Result dest = new StreamResult(st);
			try {
				aTransformer.transform(src, dest);
			} catch (TransformerException e) {

				e.printStackTrace();
			}
			System.out.println(st);
		} catch (XMLDBException e) {
			// TODO Auto-generated catch block
			System.out.println("....");
		}
	}
}
