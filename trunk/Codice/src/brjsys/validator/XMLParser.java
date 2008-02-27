package brjsys.validator;

import java.io.*;
import java.util.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.antlr.runtime.tree.Tree;
import org.w3c.dom.*;

import brjsys.businessrules.BusinessRule;

public class XMLParser {
	private static Hashtable simbols=generateSimbols();

	static private Hashtable<Integer, String> generateSimbols(){
		Hashtable<Integer,String> hash=new Hashtable<Integer,String>();
		Scanner in;
		try {
			in = new Scanner(new File("BusinessRule.tokens"));
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

	private void scanAST(Tree AST, Element root, Document doc){
		//root è gia stato inserito la chiamata precedente,ora devo impostargli il suo valore interno
		int childs=AST.getChildCount();
		String tag=null;
		Element e=null;
		Tree treeChild=null;
	
		if (childs>0) {
			if (!root.hasAttribute("name")) {
				root.setAttribute("type", AST.getText());
			}			
			for (int index=0; index<childs; index++) {
				//treeChild si riferisce al figlio
				treeChild=AST.getChild(index);
				//tag diventa il nome del Token secondo il linguaggio
				tag=(String)simbols.get(treeChild.getType());
				//creo un elemento
				e=doc.createElement(tag);
				root.appendChild(e);
				scanAST(treeChild,e,doc);
			}
		}else{
			root.setTextContent(AST.getText());}
	}

	public String parse(Tree AST, BusinessRule rule){
		//Eseguo il parsing in XML
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//Get the DocumentBuilder
		DocumentBuilder docBuilder = null;
		try {
			docBuilder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			System.exit(1);
		}
		//Create blank DOM Document
		Document doc = docBuilder.newDocument();
		//create the root element
		Element base = doc.createElement("BusinessRule");
		//all it to the xml tree

		//Inserisco gli attributi alla Business rule
		base.setAttribute("name",rule.name);
		base.setAttribute("associated",rule.associated);
		if(rule.comment!=null){
			base.setAttribute("comment",rule.comment);
		}
		doc.appendChild(base);
		Element root=doc.createElement((String)simbols.get(AST.getType()));
		Element astRule=doc.createElement("AstRuleVersion");
		astRule.setAttribute("value",AST.toStringTree());
		//appendChild pone alla fine!!!
		base.appendChild(astRule);
		base.appendChild(root);
		scanAST(AST,root,doc);

		TransformerFactory tranFactory = TransformerFactory.newInstance();
		Transformer aTransformer=null;
		try {
			aTransformer = tranFactory.newTransformer();
		} catch (TransformerConfigurationException e1) {
			
			e1.printStackTrace();
		}
		StringWriter st=new StringWriter();
		Source src = new DOMSource(doc);
		Result dest = new StreamResult(st);
		try {
			aTransformer.transform(src, dest);
		} catch (TransformerException e) {
			
			e.printStackTrace();
		}
		System.out.println(st);
		//devo togliergli l'intestazione!

		String string=st.toString();
		string=string.substring(string.indexOf(">")+1);
		
		return string;

	}
}
