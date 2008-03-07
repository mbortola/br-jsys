package brjsys.validator;

import java.io.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.antlr.runtime.tree.Tree;
import org.w3c.dom.*;

import brjsys.businessrules.BusinessRule;

/**
 * Consente di convertire un AST in un elemento analogo XML.
 * @author Michele  Bortolato
 * @version 0.9 3 Mar 2008
 * 
 */
public class XMLParser {
	/**Lista che associa l'identificativo del token al token stesso.*/
	String[] tokenList;

	/**
	 * Costruttore
	 * @param tList Array che associa il nome dei token al numero che li 
	 * identifica
	 * */
	public XMLParser (String[]tList) {
		tokenList=tList;
	}

	/**
	 * Metodo interno per scorrere l'AST ed effetturare il parsing in XML.
	 * 
	 * @param AST il nodo dell'albero sintattico da analizzare
	 * @param root L'elemento padre al quale aggiungere i figli
	 * @param doc Classe necessaria per istanziare nuovi nodi
	 * 
	 * @see org.w3c.dom
	 * */
	private void scanAST(Tree AST, Element root, Document doc){
		//root e' gia stato inserito la chiamata precedente, 
		//ora devo impostargli il suo valore interno
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
	 * Effettua il parsing da AST a XML.
	 *
	 * @param 	AST		Rappresenta l'albero sintattico prodotto dal parser.
	 * @param	rule	Rappresenta la Business rule validata dal parser.
	 * @return  La stringa XML che rappresenta la Business rule.
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
		//Crea un Document
		Document doc = docBuilder.newDocument();
		//Crea l'elemento radice
		Element base = doc.createElement("BusinessRule");

		//Inserisco gli attributi alla Business rule
		base.setAttribute("name",rule.name);
		base.setAttribute("associated",rule.associated);
		base.setAttribute("rule",rule.rule);
		//Controllo se la regola ha un commento
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
			//In teoria non dovrebbe mai accadere
			e1.printStackTrace();
			System.exit(1);
		}
		StringWriter st=new StringWriter();
		Source src = new DOMSource(doc);
		Result dest = new StreamResult(st);
		try {
			aTransformer.transform(src, dest);
		} catch (TransformerException e) {
			//In teoria non dovrebbe mai accadere
			e.printStackTrace();
			System.exit(1);
		}

		//devo togliergli l'intestazione!
		String result=st.toString();
		result=result.substring(result.indexOf(">")+1);

		return result;

	}
}