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
			lex = new descrittore3Lexer(new ANTLRFileStream("prova.txt"));
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

			return read(root, tree.getChild(0));


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	private Element read2(Element root, Tree tree) throws Exception {

		//scorro tutti i primi figli di tree

		for (int i=0;i<tree.getChildCount(); i++) {
			//controllo del tipo
			Tree tmp=tree.getChild(i);

			if (tokenNames[tmp.getChild(0).getType()].equals("Atom")) {
				//Valore Atomico
			} else {
				//Array o oggetto

				//Recupero il nome dell'oggetto
				String nameObj=tmp.getChild(1).getText();

				if (tmp.getChild(0).getText().equals("(")) {
					//Oggetto
					//Cambio di contesto
					Tree subTree=null;
					if (tmp.getChild(1).getChildCount()==0) {
						subTree=oggettiBase.get(nameObj);
						if (subTree==null) throw new Exception("Hash Sbagliata");
					}
					else {
						subTree=tmp.getChild(1);
					}

					//Cambio contesto nel XML

					Element subEl=findElement(nameObj, root);

					if (subEl==null) {
						//Non c'e'
					} else {
						read2(subEl, subTree);
					}

				} else {
					//Array
				}
			}
		}

		return root;
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

	private Element read(Element root, Tree tree) throws Exception {
		//scorro tutti i figli dell'albero, e ogni volta guardo se sono presenti anche nel XML
		//se non ci sono e non anno default, posso andare oltre, altrimenti devo creare un nuovo 
		//elemento col valore di default, la funzione e' ricorsiva

		Tree tmp=null;
		String name=null;

		for (int i=0;i<tree.getChildCount(); i++) {

			tmp=tree.getChild(i);
			name=tmp.getText();

			//e' di valore atomico?
			if (tokenNames[tmp.getChild(0).getType()].equals("Atom")) {
				//Valore Atomico
				String def=this.obbligatorio(tmp);
				if (def!=null) {
					//Deve Esserci
					Element item=this.findElement(name, root);
					if (item==null) {
						//Non c'e'
						//Insert
						Element el=doc.createElement(tmp.getText());

						String type=def.getClass().toString();
						type=type.substring(type.lastIndexOf(".")+1, type.length());

						el.setAttribute("type", type);

						el.setAttribute("value", def.toString());

						root.appendChild(el);
					}
				}
			} else {
				/*Obj*/
				//Aggiorno tree, hash o sottotipo
				
				
				if (true/*!Array*/) {
					if (false/*!Presente*/) {
						//ERRORE!?
					} else {
						//Trovo elemento in XML
						//Ricorsione
					}
				} else {
					//Array
					//Trovo elemento in XML
					for (;;/*ogni elemento in XML di tipo opportuno*/) {
						//Ricorsione
					}
				}
			}

			System.out.println(tokenNames[tmp.getChild(0).getType()]+"---"+tmp.getChild(0).getText());

			/**if (tokenNames[tmp.getChild(0).getType()].equals("Atom")) {
				//e' presente?
				if(list.getLength()==0) {
					//System.out.println(tmp.getText());
					//Non e' presente
					//!!!DA CHIARIRE
					//Controllo se richiede valore di default
					Object value=findDefault(tmp);
					System.out.println(value);
					if (value!=null) {
						System.out.println("ADD");
						Element el=doc.createElement(tmp.getText());

						String type=value.getClass().toString();
						type=type.substring(type.lastIndexOf(".")+1, type.length());

						el.setAttribute("type", type);

						el.setAttribute("value", value.toString());

						root.appendChild(el);
					}
				}

			} else {
				System.out.println("ELSE");
				//e' un sottotipo. il fatto che sia un array o un oggetto non mi importa nulla, penso
				//E' presente?
				if(list.getLength()==0) { 
					//Da chiarire
				} else {
					System.out.println("ELSEELSE");
					//E' definito sotto oppure riferito nella Hash table?
					//se e' definito altrove non ha figli!
					//Dunque devo guardare i figli del primo figlio, se sono 0 devo cercarlo nell'hash
					if(tmp.getChild(0).getChildCount()==0) {
						System.out.println("ELSEELSEIF");
						//Se non trovo la definizione nell'hash sono problemi
						Tree newType=oggettiBase.get(tmp.getChild(0).getText());
						if (newType==null) {throw new Exception("Problema");}
						System.out.println(tmp.getChild(0).getText());
						parsetree(newType);
						read((Element)list.item(0), newType);
					} else {
						//e' definito sotto
						read((Element)list.item(0),tmp.getChild(0));
					}
				}
				//Chiamata ricorsiva
			}**/

		}


		return root;
	}

	private String obbligatorio(Tree tmp) {
		//La cardinalita' e' definita sull'ultimo figlio
		//Per convenzione se e' presente l'attibuto default l'elemento
		//deve esserci
		int childs=tmp.getChildCount();
		//Comunque se ha un figlio solo non ho un valore di default da 
		//inserire...
		if (childs==1){
			//Obbligatorio ma non ho default
			return new String("");
		}

		if (childs==3) {
			//Estrapolo il default
			return tmp.getChild(1).getText().substring(1, tmp.getChild(1).getText().length()-1);
		}
		//Ho 2 figli
		Tree second=tmp.getChild(1);
		if (tokenNames[second.getType()].equals("Card"))	{
			if (second.getText().equals("+")) return new String("");
			else return null;
		} else {
			//Ho il default
			
			return second.getText().substring(1,second.getText().length()-1);
		}
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

		Writer2 w=new Writer2("{\"a\": \"s3\",\"b\": [{\"ca\": [\"a\",\"b\",\"c\"]}, {\"ca\": [\"x\",\"y\",\"z\"	]},	{\"ca\": [],\"q\": \"ciao\"}]}");

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
		//Result dest = new StreamResult(new File("out.xml"));
		StringWriter st=new StringWriter();
		Result dest=new StreamResult(System.out);
		try {
			aTransformer.transform(src, dest);
		} catch (TransformerException e) {
			//In teoria non dovrebbe mai accadere
			e.printStackTrace();
			System.exit(1);
		}
	}
}