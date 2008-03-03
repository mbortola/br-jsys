package brjsys.validator;

import java.io.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.antlr.runtime.tree.Tree;
import org.w3c.dom.*;

import brjsys.businessrules.BusinessRule;

public class XMLParser {
	/**
	 * Lista che associa l'identificativo del token al token stesso
	 * 
	 * */
	String[] tokenList;

	XMLParser (String[]tList) {
		tokenList=tList;
	}
	private void scanAST(Tree AST, Element root, Document doc){
		//root e' gia stato inserito la chiamata precedente,ora devo impostargli il suo valore interno
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
				tag=tokenList[treeChild.getType()];
				//operazioin per unificare alcuni tags
				if(tag.equals("OpRule")||tag.equals("OpBool")){
					tag="OBool";
				}
				if(tag.equals("Bconf")){
					tag="Conf";
				}
				if(tag.equals("OpA")||tag.equals("OpM")){
					tag="OFloat";
				}
				//creo un elemento
				e=doc.createElement(tag);
				root.appendChild(e);
				scanAST(treeChild,e,doc);
			}
		}else {
			root.setTextContent(AST.getText());
		}
	}

	/**
	 * Effettua il parsing da AST a XML
	 *
	 * @param 	AST		Rappresenta l'albero sintattico prodotto dal parser
	 * @param	rule	Rappresenta la Business rule validats dal parser
	 * @return  La stringa XML che rappresenta la Business rule
	 * 
	 */
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
		base.setAttribute("rule",rule.rule);
		if(rule.comment!=null){
			base.setAttribute("comment",rule.comment);
		}
		doc.appendChild(base);
		Element root=doc.createElement(tokenList[AST.getType()]);
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