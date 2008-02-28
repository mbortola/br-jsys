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

	static private Hashtable generateSimbols(){
		Hashtable hash=new Hashtable();
		Scanner in;
		try {
			in = new Scanner(new File("files/BusinessRule.tokens"));
			String line=null;
			int index=0;
			while(in.hasNext()){
				line=in.nextLine();
				index=line.indexOf("=");
				hash.put(new Integer(Integer.parseInt(line.substring(index+1))),line.substring(0,index));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return hash;
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
				tag=(String)simbols.get(new Integer(treeChild.getType()));
				//operazioin per unificare alcuni tags
				
				if(tag=="Oprule"||tag=="OpBool")tag="OBool";
				if(tag=="Bconf")tag="Conf";
				if(tag=="OpA"||tag=="OpM")tag="OFloat";
				
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
		base.setAttribute("rule",rule.rule);
		if(rule.comment!=null){
			base.setAttribute("comment",rule.comment);
		}
		doc.appendChild(base);
		Element root=doc.createElement((String)simbols.get(new Integer(AST.getType())));
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
/*<BusinessRule associated="Articolo" comment="commento" name="r12">
    <AstRuleVersion value="(OR (OR (AND (= 12 0) (!= (&amp;&amp; (|| true false) (NOT false)) scontato (message &#34;msg&#34;))) (!= &#34;ciao&#34; nome)) (&lt;= (- (+ entrate 1.2322) (/ (SUM uscite) (AVG 5))) (COUNT (AVG (SUM (COUNT prezzoBase)))) (message &#34;mes&#34;)))"/>
    <OpRule type="OR">
        <OpRule type="OR">
            <OpRule type="AND">
                <Bconf type="=">
                    <FLOAT>12</FLOAT>
                    <FLOAT>0</FLOAT>
                </Bconf>
                <Bconf type="!=">
                    <OpBool type="&amp;&amp;">
                        <OpBool type="||">
                            <BOOL>true</BOOL>
                            <BOOL>false</BOOL>
                        </OpBool>
                        <BoFun type="NOT">
                            <BOOL>false</BOOL>
                        </BoFun>
                    </OpBool>
                    <FIELD>scontato</FIELD>
                    <Msg type="message">
                        <STRING>"msg"</STRING>
                    </Msg>
                </Bconf>
            </OpRule>
            <Bconf type="!=">
                <STRING>"ciao"</STRING>
                <FIELD>nome</FIELD>
            </Bconf>
        </OpRule>
        <Conf type="&lt;=">
            <OpA type="-">
                <OpA type="+">
                    <FIELD>entrate</FIELD>
                    <FLOAT>1.2322</FLOAT>
                </OpA>
                <OpM type="/">
                    <FlFun type="SUM">
                        <FIELD>uscite</FIELD>
                    </FlFun>
                    <FlFun type="AVG">
                        <FLOAT>5</FLOAT>
                    </FlFun>
                </OpM>
            </OpA>
            <Count type="COUNT">
                <FlFun type="AVG">
                    <FlFun type="SUM">
                        <Count type="COUNT">
                            <FIELD>prezzoBase</FIELD>
                        </Count>
                    </FlFun>
                </FlFun>
            </Count>
            <Msg type="message">
                <STRING>"mes"</STRING>
            </Msg>
        </Conf>
    </OpRule>
</BusinessRule>*/