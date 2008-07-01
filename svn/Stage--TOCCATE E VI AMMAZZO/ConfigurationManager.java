
import grammatiche.descrittoreLexer;
import grammatiche.descrittoreParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

import javax.xml.transform.TransformerException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import stage.util.XSLTransform;
import writer.Writer;

/**Eccezzione costrutita ad hoc per identificare un errore nella struttura del 
 * DOM di input.*/
class MyError extends Exception {
	private static final long serialVersionUID = 1L;
	public MyError(String msg){
		super(msg);
	}
}


/**Consente la gestione dei file di configurazione.
 * @author Michele
 */
public class ConfigurationManager {

	/**Tabella che associa al tipo radice di un elemento nel file di configurazione
	 * il suo relativo albero di parsing.*/
	private Hashtable<String, Tree> oggettiBase=new Hashtable<String, Tree>();

	/**DOM da elaborare.*/
	private Document doc;

	/**Lista dei nomi dei token usata dal parser.*/
	private String[] tokenNames;

	/**AST*/
	private CommonTree tree;

	/**Costruttore
	 * @param cfgFilePath Path del descrittore del file di configurazione.
	 * @throws IOException 
	 * @throws RecognitionException
	 */
	public ConfigurationManager(String cfgFilePath) 
	throws IOException, RecognitionException {

		descrittoreLexer lex =
			new descrittoreLexer(new ANTLRFileStream(cfgFilePath));

		CommonTokenStream tokens = new CommonTokenStream(lex);
		descrittoreParser g = new descrittoreParser(tokens);
		descrittoreParser.start_return ret=g.start();
		tree= (CommonTree)ret.getTree();

		//figli al primo livello nella hash
		for(int i=0;i<tree.getChildCount();i++) {
			oggettiBase.put(tree.getChild(i).getText(), tree.getChild(i));
		}
		tokenNames=descrittoreParser.tokenNames;
	}


	/** Ricerca di un elemento nel sottoalbero di un nodo elemento.
	 * @param nameObj Nome dell'elemento da cercare.
	 * @param root Elemento da analizzare
	 * @return L'eventuale elemento, <p>null</p> se l'elemento non e' presente.
	 */
	private Element findElement(String nameObj, Element root) {

		NodeList childs=root.getChildNodes();

		for (int i=0;i<childs.getLength();i++) {
			Node tmp=childs.item(i);
			if (tmp.getNodeType()==Node.ELEMENT_NODE &&	
					tmp.getNodeName().equals(nameObj)) {
				return (Element)tmp;
			}
		}
		return null;
	}

	/** Dice se l'albero rappresenta un Array
	 * @param tree L'albero da analizzare
	 * @return Risultato se test.
	 */
	private boolean isArray(Tree tree) {
		try {
			String val=tree.getChild(tree.getChildCount()-1).getText();

			if (val.equals("*")||val.equals("+")) return true;
		} catch (NullPointerException e) {return false;}
		return false;

	}

	/**Scorre un nodo di parsing alla ricerca di incongruenze.
	 * 
	 * @param root Elemento DOM da analizzare.
	 * @param tree Il nodo dell'albero di parsing 
	 * 
	 * @return l'Elemento aggiornato.
	 * @throws MyError Errore nella lettura.
	 * */
	private Element read(Element root, Tree tree) throws MyError {

		int cc=tree.getChildCount();

		for (int i=0;i<cc;i++) {
			//scorro tutti i figli dell'albero, e ogni volta guardo se sono presenti
			//anche nel XML se non ci sono e non hanno default, posso andare oltre,
			//altrimenti devo creare un nuovo elemento col valore di default,
			//la funzione e' ricorsiva

			Tree tmp=null;
			String name=null;

			boolean tmpIsArray=false,tmpIsOpz=false;


			//Analizzo il figlio i
			tmp = tree.getChild(i);
			name = tmp.getText();
			String type=tokenNames[tmp.getType()];

			if (!type.equals("Card")) {

				tmpIsArray = isArray(tmp);
				tmpIsOpz=this.opzionale(tmp);

				if (tmp.getChildCount() == 0) {
					//array base
					if (tokenNames[tmp.getType()].equals("Atom")) {
						//array Atom
						//Tecnicamente se capito qui non devo fare niente, 
						//non sono tenuto a generare elementi di default 
						//qualora mancassero, ne fermare il programma in caso di 
						//elemento non trovato.
					} else {
						//Secondo le specifiche del linguaggio non posso mai 
						//capitare in questa sezione di codice.
						System.out.println("??");
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
								throw new MyError(name+":Oggetto obbligatorio " +
								"non presente.");
							}
							if (e!=null) {
								NodeList items = e.getElementsByTagName("Item");

								int len=items.getLength();

								for (int x = 0; x <len; x++) {
									Element itemx=(Element)items.item(x);
									if (itemx.getParentNode().equals(e)) {
										read(itemx, newTree);
									}
								}
							}
						} else {
							//Definito sotto
							if (e==null && !tmpIsOpz) {
								throw new MyError(name+":Oggetto obbligatorio " +
								"non presente.");
							}
							if (e!=null) {
								//E' opzionale ma c'e lo stesso
								NodeList items = e.getElementsByTagName("Item");

								int len=items.getLength();

								for (int x = 0; x <len; x++) {
									Element itemx=(Element)items.item(x);
									if (itemx.getParentNode().equals(e)) {
										read(itemx, tmp);
									}
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
									//Se sono qui e' perche' ho a che fare con un
									//oggetto non presente ma che dovrebbe esserci.
									throw new MyError(name+":Oggetto obbligatorio " +
									"non presente.");
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
					}
				}
			}
		}
		return root;
	}

	/**Dice se l'albero rappresenta un element opzionale
	 * @param tree L'albero da analizzare.
	 * @return <p>true</p> se l'elemento e' opzionale.
	 * <p>false</p> altrimenti.
	 */
	private boolean opzionale(Tree tree) {

		//Recupero i figli
		int cc=tree.getChildCount();
		for (int i=0;i<cc; i++) {
			String val=tree.getChild(i).getText();
			if(tokenNames[tree.getChild(i).getType()].equals("Def")) return false;
			if(val.equals("*")||val.equals("?")) return true;
		}
		return false;
	}
	
	/**Ritorna il DOM.
	 * @return Document.
	 */
	public Document getDoc(){return doc;}

	/** Trova l'elemento di default.
	 * @param tree L'albero da controllare  
	 * @return L'oggetto di default.
	 */
	private Object findDefault(Tree tree) {

		String t="";
		for (int i=0;i<tree.getChildCount();i++) {
			if (tokenNames[tree.getChild(i).getType()].equals("Atom")) {
				t=tree.getChild(i).getText();
			}
			if (tokenNames[tree.getChild(i).getType()].equals("Def")) {
				String val=tree.getChild(i).getText();
				String type=tree.getChild(i-1).getText();
				if (type.equals("str")) {
					return val.substring(1, val.length()-1);
				}
				if (type.equals("int")) {return new Integer(val);}
				if (type.equals("bool")) {return new Boolean(val);}
			}
		}
		if (t.equals("int"))return new Integer(0);
		if (t.equals("bool"))return new Boolean(true);
		return new String("");
	}

	/**Stampa su schermo la struttura dell'albero di parsing
	 * @param tree  L'albero da leggere.
	 */
	public void parsetree(Tree tree) {
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

	/** Avvia la lettura del file di configurazione e il controllo per i rimpiazzamenti.
	 * @param source DOM sorgente.
	 * 
	 * @return L'elemento aggiornato.
	 * @throws MyError 
	 */
	public void reader(Document source) throws MyError{
		doc=source;
		Element root=source.getDocumentElement();
		//parsetree(tree);
		//Lo parserizzo 
		if (tree.getText()==null)read(root, tree.getChild(0));
		else read(root,tree);
	}

	/**Analizza il DOM e pone il risultato in un file.
	 * @param doc DOM da analizzare.
	 * @param outPath File di output.
	 * @throws MyError 
	 */
	public void reader(Document input, String outPath) throws MyError {
		try {
			reader(input);
			XSLTransform.prettyPrintDOM(doc, outPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	/**Analizza una Stringa JSON e pone il risultato in un file
	 * @param json Stringa JSON.
	 * @param outPath Path del file di output.
	 * @throws MyError 
	 * @throws Exception 
	 */
	public void reader(String json, String outPath) throws MyError {
		Writer w=new Writer(json);
		w.run();
		reader(w.getDoc(), outPath);
	}

	public static void main(String args[]) throws Exception {

		ConfigurationManager cmain=null;
		if (args.length!=3){
			System.out.println("Utilizzo:\njava -jar ConfigurationManager " +
					"<Path file configurazione> " +
			"<Path file xml di input> <Path file di output>");			
		} else {
			try {
				cmain = new ConfigurationManager(args[0]);
			} catch (IOException e) {
				// Errore, file inesistente
				e.printStackTrace();
				System.exit(1);
			} catch (RecognitionException e) {
				// Errore di compilazione.
				e.printStackTrace();
				System.exit(1);
			}
			try {
				FileReader in=new FileReader(new File(args[1]));
				BufferedReader bin=new BufferedReader(in);
				String json="", test=bin.readLine();

				while(test!=null) {
					json+=test;
					test=bin.readLine();
				}
				//System.out.println(json);
				cmain.reader(json, args[2]);
			} catch (MyError e) {
				// Errore strutturale nel DOM di input.
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// File input inesistente.
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}