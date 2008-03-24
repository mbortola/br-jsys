package InterpreterCommunicatorTester;

import org.w3c.dom.*;

import brjsys.communicator.InterpreterCommunicator;

public class InterpreterCommunicatorTester {

	InterpreterCommunicator i=null;
	
	public InterpreterCommunicatorTester(String username, String password){
		try {
			i=new InterpreterCommunicator(username, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static void main(String[] args) {

		InterpreterCommunicatorTester tester=new InterpreterCommunicatorTester("admin","");
		
		NodeList list=tester.i.getRules("Articolo");
		System.out.println(list.getLength()+" regole.");
		
		Element el=null;
		String name, rule=null;
		for(int index=0;index<list.getLength();index++) {
			el=(Element)list.item(index);
			name=el.getAttribute("name");
			rule=el.getAttribute("rule");
			
			System.out.println(name+':'+rule);
			
		}
	}

}
