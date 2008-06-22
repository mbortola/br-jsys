package grammatiche;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Hashtable;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import writer.Writer2;


public class ConfigurationManager {

    private Hashtable<String, Tree> oggettiBase=new Hashtable<String, Tree>();

    private Document doc;

    private String[] tokenNames;


    private Element reader(Document source) throws Exception {

	doc=source;

	Element root=source.getDocumentElement();

	descrittore3Lexer lex;
	try {
	    lex = new descrittore3Lexer(new ANTLRFileStream("Prova.txt"));
	    CommonTokenStream tokens = new CommonTokenStream(lex);

	    descrittore3Parser g = new descrittore3Parser(tokens);

	    descrittore3Parser.start_return ret=g.start();

	    CommonTree tree= (CommonTree)ret.getTree();

	    //figli al primo livello nella hash

	    for(int i=0;i<tree.getChildCount();i++) {
		oggettiBase.put(tree.getChild(i).getText(), tree.getChild(i));
	    }

	    tokenNames=descrittore3Parser.tokenNames;

	    parsetree(tree);

	    //Lo parserizzo 

	    System.out.println(tree.getChild(0).getText()+"!!");

	    if (tree.getText()==null)return read(root, tree.getChild(0));

	    else return read(root,tree);


	} catch (IOException e) {
	    e.printStackTrace();
	} catch (RecognitionException e) {
	    e.printStackTrace();
	}
	return null;

    }

    private Element findElement(String nameObj, Element root) {

	NodeList childs=root.getChildNodes();

	for (int i=0;i<childs.getLength();i++) {
	    Node tmp=childs.item(i);
	    if (tmp.getNodeType()==Node.ELEMENT_NODE &&	tmp.getNodeName().equals(nameObj)) {
		return (Element)tmp;
	    }
	}
	return null;
    }

    /**Scorre un nodo di parsing alla ricerca di incongruenze.
     * 
     * @param root Elemento DOM da analizzare.
     * @param tree Il nodo dell'albero di parsing 
     * */
    private Element read(Element root, Tree tree) throws Exception {
	//scorro tutti i figli dell'albero, e ogni volta guardo se sono presenti anche nel XML
	//se non ci sono e non anno default, posso andare oltre, altrimenti devo creare un nuovo 
	//elemento col valore di default, la funzione e' ricorsiva

	Tree tmp=null;
	String name=null;

	boolean tmpIsArray=false,tmpIsOpz=false;

	for (int i=0;i<tree.getChildCount(); i++) {
	    //Analizzo il figlio i
	    tmp = tree.getChild(i);
	    name = tmp.getText();
	    String type=tokenNames[tmp.getType()];
	    System.out.println("Analisi:" + tmp.getText());
	    if (!type.equals("Card")) {

		tmpIsArray = isArray(tmp);
		tmpIsOpz=this.opzionale(tmp);

		if (tmp.getChildCount() == 0) {
		    //array base
		    if (tokenNames[tmp.getType()].equals("Atom")) {
			//array Atom
		    } else {
			//riferimento esterno
			//Controllo se presente

			Element e = findElement(name, root);

			if (e == null) {
			    //l'elemento non c'e'
			    System.out.println("ERR0:" + name);
			} else {
			    //Cambio contesto
			    Tree newTree = oggettiBase.get(name);
			    if (newTree == null) {
				System.out.println("Err");
				System.exit(1);
			    } else {
				//devo scorrere tutti gli elementi e parsarli
				NodeList items = root
				.getElementsByTagName("Item");

				for (int x = 0; x < items.getLength(); x++) {
				    System.out.println("item");
				    read((Element) items.item(x), newTree);
				}
			    }
			}
		    }
		} else {
		    //tmp ha dei figli
		    Element e=this.findElement(name, root);
		    if (tmpIsArray) {
			//Test per vedere se e' un riferimento
			Tree c0=tmp.getChild(0);

			if (tokenNames[c0.getType()].equals("STRING") && 
				c0.getChildCount()==0) {
			    //Riferimento
			    Tree newTree=oggettiBase.get(c0.getText());
			    if (e==null && !tmpIsOpz) {
				System.out.println("ERRORE");
				System.exit(1);
			    }
			    if (e!=null) {
				NodeList items = e.getElementsByTagName("Item");
				for (int x = 0; x < items.getLength(); x++) {
				    read((Element) items.item(x), newTree);
				}
			    }
			} else {
			    //Definito sotto
			    if (e==null && !tmpIsOpz) {
				System.out.println("ERRORE");
				System.exit(1);
			    }
			    if (e!=null) {
				//E' opzionale ma c'e lo stesso
				NodeList items=e.getElementsByTagName("Item");
				for (int x=0;x<items.getLength();x++) {
				    read((Element)items.item(x),tmp);
				}
			    }
			}
		    }
		    else {
			//Non e' un array
			if (!(e==null && tmpIsOpz)) {
			    //Gurdo se e' un oggetto o un valore atomico
			    Tree c0=tmp.getChild(0);
			    if (tokenNames[c0.getType()].equals("Atom")) {
				//Valore atomico
				if (e==null) {
				    //Aggiungo
				    Object value = findDefault(tmp);
				    Element el = doc.createElement(tmp.getText());

				    String val = value.getClass().toString();
				    val = val.substring(val.lastIndexOf(".") + 1,
					    val.length());

				    el.setAttribute("type", val);

				    el.setAttribute("value", value.toString());

				    root.appendChild(el);
				}
			    } else {
				//Sotto oggetto
				if (e==null) {
				    System.out.println("ERROR");
				}
				//.equals("STRING")
				if (c0.getChildCount()==0) {
				    //Riferimento
				    Tree newTree=oggettiBase.get(c0.getText());
				    read(e,newTree);
				} else {
				    //definito sotto   
				    read(e,tmp);
				}
			    }
			}
			System.out.println("xx");
		    }
		    /*Object value = findDefault(tmp);
			//System.out.println(value);
			//aggiungo elemento
			System.out.println("ADD");
			Element el = doc.createElement(tmp.getText());

			String val = value.getClass().toString();
			val = val.substring(
				val.lastIndexOf(".") + 1, val
				.length());

			el.setAttribute("type", val);

			el.setAttribute("value", value.toString());

			root.appendChild(el);*/
		}
	    }
	    //Resetto la variabile
	    tmpIsArray=false;
	}
	return root;
    }

    private boolean isArray(Tree tree) {

	try {
	    String val=tree.getChild(tree.getChildCount()-1).getText();

	    System.out.println("val:"+val);

	    if (val.equals("*")||val.equals("+")) return true;
	} catch (NullPointerException e) {return false;}
	return false;

    }

    private boolean opzionale(Tree tree) {
	for (int i=0;i<tree.getChildCount();i++) {
	    String val=tree.getChild(i).getText();
	    if(tokenNames[tree.getChild(i).getType()].equals("Def")) return false;
	    if(val.equals("*")||val.equals("?")) return true;
	}

	return false;
    }

    private Object findDefault(Tree tmp) {
	for (int i=0;i<tmp.getChildCount();i++) {
	    if (tokenNames[tmp.getChild(i).getType()].equals("Def")) {
		String val=tmp.getChild(i).getText();
		String type=tmp.getChild(i-1).getText();
		if (type.equals("str")) {
		    return val.substring(1, val.length()-1);
		}
		if (type.equals("int")) {return new Integer(val);}
		if (type.equals("bool")) {return new Boolean(val);}
	    }
	}
	return new String("");
    }

    private void parsetree(Tree tree) {
	System.out.print(tree.getText()+"["+tokenNames[tree.getType()]+"]");

	int c=tree.getChildCount();
	if (c>0) {
	    System.out.print("(");
	    for (int i = 0; i < tree.getChildCount(); i++) {
		parsetree(tree.getChild(i));
	    }
	    System.out.print(")\n");
	}
    }


    public static void main(String args[]) throws Exception {

	ConfigurationManager cm=new ConfigurationManager();

	//Writer Z=new Writer("{a:{b:8}}");

	String v1="{z:[{x:5,y:\"str\"},{x:4},{y:\"abc\"}]}";

	String v2="{\"a\": \"s3\",\"b\": [{\"ca\": [\"a\",\"b\",\"c\"]}, {\"ca\": [\"x\",\"y\",\"z\"]}]}";

	String v3="{z:[{x:3},{y:\"str\"},{x:5,y:\"aaa\"}]}";

	String v4="{z:{x:int}}";
	String v5="{k1:6,w:[{r:3},{r:90}],q:[{p:3},{p:45}]" +
			",x2:{f:9},q:{p:8}}";

	Writer2 w=new Writer2(v5);

	w.run();

	Element result =cm.reader(w.doc);

	TransformerFactory tranFactory = TransformerFactory.newInstance();
	Transformer aTransformer=null;
	try {
	    aTransformer = tranFactory.newTransformer();
	} catch (TransformerConfigurationException e1) {
	    //In teoria non dovrebbe mai accadere
	    e1.printStackTrace();
	}
	Source src = new DOMSource(cm.doc);
	//Result dest = new StreamResult(new File("out2.xml"));
	StringWriter st=new StringWriter();
	Result dest=new StreamResult(st);
	try {
	    aTransformer.transform(src, dest);
	    System.out.print(w.prettyPrint(st.toString()));
	} catch (TransformerException e) {
	    //In teoria non dovrebbe mai accadere
	    e.printStackTrace();
	    System.exit(1);
	}
    }
}