package brjsys.validator;

<<<<<<< .mine
import java.io.*;
import java.util.*;
=======
import brjsys.businessrules.BusinessRule;
import brjsys.communicator.ValidatorCommunicator;

public class Validator {
>>>>>>> .r485
	private ValidatorCommunicator repository;
	public Validator(String username, String password)/*errore in conessione*/{
		repository=new ValidatorCommunicator(username, password);
	}
	public boolean validate(BusinessRule Brule){
		
		
		return true;
	}
import javax.xml.parsers.*;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import org.w3c.dom.*;

import brjsys.businessrules.BusinessRule;

public class Validator{
	static private Document doc=null;
	static private Hashtable<Integer,String> simbols=SymbolTable();
	static private Hashtable<Integer, String> SymbolTable(){
		Hashtable<Integer,String> hash=new Hashtable<Integer,String>();
		Scanner in;
		try {
			in = new Scanner(new File("files/BusinessRule.tokens"));
			String line=null;
			int index=0;
			while(in.hasNext()){
				line=in.nextLine();
				index=line.indexOf("=");
				hash.put(Integer.parseInt(line.substring(index+1)),line.substring(0,index));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return hash;
	}
	public String validate(BusinessRule Brule){
		// Create an input character stream from standard in
		ANTLRStringStream input = new ANTLRStringStream(Brule.rule);
		// Create an BusinessRulerLexer that feeds from that stream
		BusinessRuleLexer lexer = new BusinessRuleLexer(input);
		// Create a stream of tokens fed by the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// Create a parser that feeds off the token stream
		BusinessRuleParser parser = new BusinessRuleParser(tokens);
		// Begin parsing at rule prog, get return value structure
		BusinessRuleParser.start_return r=null;
		try {	r = parser.start();

		// WALK RESULTING TREE
		CommonTree t = (CommonTree)r.getTree(); // get tree from parser

		// Create a tree node stream from resulting tree
		System.out.println(t.toStringTree());
		//Eseguo il parsing in XML
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//Get the DocumentBuilder
		DocumentBuilder docBuilder = factory.newDocumentBuilder();
		//Create blank DOM Document
		doc = docBuilder.newDocument();
		//create the root element
		Element base = doc.createElement("BusinessRule");
		//all it to the xml tree
		
		//Inserisco gli attributi alla Business rule
		base.setAttribute("name",Brule.name);
		base.setAttribute("associated",Brule.associated);
		if(Brule.comment!=null){
			base.setAttribute("comment",Brule.comment);
		}
		doc.appendChild(base);
		Element root=doc.createElement(simbols.get(t.getType()));
		Element astRule=doc.createElement("AstRuleVersion");
		astRule.setAttribute("value",t.toStringTree());
		//appendChild pone alla fine!!!
		base.appendChild(astRule);
		base.appendChild(root);
		parse(root,t);
		
		TransformerFactory tranFactory = TransformerFactory.newInstance();
        Transformer aTransformer = tranFactory.newTransformer();
        StringWriter st=new StringWriter();
        Source src = new DOMSource(doc);
        Result dest = new StreamResult(st);
        aTransformer.transform(src, dest);
        System.out.println(st);
        //devo togliergli l'intestazione!
        
        String string=st.toString();
        string=string.substring(string.indexOf(">")+1);
        //System.out.println(string);
        return string;
		}catch(Exception e){System.out.println("Eccezione in test");e.printStackTrace();System.exit(1);}
		return null;
	}
	static private void parse(Element root,Tree tree){
		//root è gia stato inserito la chiamata precedente,ora devo impostargli il suo valore interno
		int childs=tree.getChildCount();
		String tag=null;
		Element e=null;
		Tree treeChild=null;
	
		if (childs>0) {
			if (!root.hasAttribute("name")) {
				root.setAttribute("type", tree.getText());
			}			
			for (int index=0; index<childs; index++) {
				//treeChild si riferisce al figlio
				treeChild=tree.getChild(index);
				//tag diventa il nome del Token secondo il linguaggio
				tag = simbols.get(treeChild.getType());
				//creo un elemento
				e=doc.createElement(tag);
				root.appendChild(e);
				parse(e,treeChild);
			}
		}else{
			root.setTextContent(tree.getText());}
	}
}