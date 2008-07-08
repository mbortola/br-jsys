package writer;

import java.io.FileNotFoundException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import stage.util.XSLTransform;

/**Effettua il parsing di un oggetto JSON in un elemento XML.
 * @author Michele
 */
public class Writer {

	/**Indirizzo del file di input*/
	private JSONObject obj;

	/**Il DOM risultato*/
	private Document doc;

	
	
	/**Costruttore
	 * @param o Oggetto da trasformare.
	 */
	public Writer(JSONObject o) {
		o= obj;
	}

	/**Costruttore
	 * @param p Oggetto JSON da convertire in formato stringa.
	 */
	public Writer(String p) {
		try {
			obj=new JSONObject(p);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**Scrive dom su un file di testo.
	 * @param outPath Path del file di output.
	 */
	public void writeDocOnFile(String outPath) {
		if (doc==null) return;
		try {
			XSLTransform.parseFromDOM(doc, outPath, "prettyprint.xsl");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** Avvia la conversione*/
	public void run() {
		DocumentBuilderFactory factory =
			DocumentBuilderFactory.newInstance();
		//Get the DocumentBuilder
		DocumentBuilder docBuilder = null;
		try {
			docBuilder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			System.exit(1);
		}
		//Inuizializzo un Document
		doc = docBuilder.newDocument();

		try {
			writeJSONObj(obj, null, "VZM", -1);
		} catch (JSONException e2) {
			e2.printStackTrace();
		}

		TransformerFactory tranFactory = TransformerFactory.newInstance();
		Transformer aTransformer=null;
		try {
			aTransformer = tranFactory.newTransformer();
		} catch (TransformerConfigurationException e1) {
			//In teoria non dovrebbe mai accadere
			e1.printStackTrace();
		}
		Source src = new DOMSource(doc);

		StringWriter st=new StringWriter();
		Result dest=new StreamResult(st);
		try {
			aTransformer.transform(src, dest);
		} catch (TransformerException e) {
			//In teoria non dovrebbe mai accadere
			e.printStackTrace();
			System.exit(1);
		}
		//String pp=prettyPrint(st.toString());
		
		//attributo doc aggiornato
	}

	/** Effettua l'identazione di una stringa che rappresenta un elemento XML
	 * @param st La stringa da elaborare.
	 * @return La stringa identata.
	 */
	public String prettyPrint(String st) {
		//un tag per riga
		st=st.replace("<", "%<");

		String[] array =st.split("%");
		int nTab=0;
		String n="", result=array[1];
		boolean succ=false;
		//parto da 2 in modo che il tag intestazione non venga considerato
		for(int i=2;i<array.length;i++) {	

			succ=!array[i].contains("/");

			if (array[i].contains("</")) nTab--;

			for (int x=0;x<nTab;x++) n+="\t";
			array[i]=n+array[i];
			n="";
			result+="\n"+array[i];
			if (succ)nTab++;
		}
		return result;
	}

	/**Scrive un oggetto JSON.
	 * @param o l'oggetto da scrivere.
	 * @param root L'elemento radice.
	 * @param name il Nome del nuovo oggetto.
	 * @param position Qualora o fosse un elemento di un array indica la sua
	 *  posizione.v Il valore -1 non viene considerato.
	 * @return <code>true</code> L'oggetto non era vuoto ed e' stato scritto.
	 * <code>false</code> L'oggetto era vuoto e non e' stato scritto.
	 * @throws JSONException
	 */
	protected boolean writeJSONObj(JSONObject o, Element root, String name, int position)
	throws JSONException{
		JSONArray list=o.names();
		if (list==null)return false;

		//Var temporanee
		Object value=null;
		String tagName=null;
		boolean notEmpty=false;

		//intanto creo un elemento che casomai aggiungero' al XML
		Element start=doc.createElement(name);

		for (int i=0;i<list.length();i++) {
			tagName=list.getString(i);
			value=o.get(tagName);

			//controllo sul tipo
			if (value instanceof JSONObject) {
				if (writeJSONObj((JSONObject)value, start, tagName, -1)) {
					//Ho almeno un elemento non vuoto, posso scrivere.
					notEmpty=true;
				}
			} else if (value instanceof JSONArray) {
				//E' un JSONArray
				if (writeJSONArray((JSONArray)value, start, tagName)) {
					//Ho almeno un elemento non vuoto.
					notEmpty=true;
				}
			} else 
				if (!value.equals("")) {
					//Almeno che sia una stringa
					Element el2 = doc.createElement(tagName);
					String type=value.getClass().toString();
					type=type.substring(type.lastIndexOf(".")+1, type.length());
					el2.setAttribute("value", value.toString());
					el2.setAttribute("type", type);
					start.appendChild(el2);
					notEmpty = true;
				}
		}

		/***/
		if (notEmpty) {
			//Almeno un elemento
			if (position>-1) start.setAttribute("position", new Integer(position).toString());

			if (name.equals("VZM"))doc.appendChild(start);
			else root.appendChild(start);

			return true;				
		} else return false;
	}

	/**Scrive un JSONArray
	 * @param a Array da scrivere.
	 * @param root Elemento radice.
	 * @param name Nome del nuovo elemento.
	 * @return <code>true</code> L'array non era vuoto ed e' stato scritto.
	 * <code>false</code> L'Array era vuoto e non e' stato scritto.
	 * @throws JSONException
	 */
	private boolean writeJSONArray(JSONArray a, Element root, String name) throws JSONException {
		//L'array puo contenere oggetti di tipo valore o di tipo JSONObject
		if (a.length()==0) return false;
		Element el=doc.createElement(name);
		Object value=null;
		boolean notEmpty=false;
		Integer elements=0;
		for (int i=0;i<a.length();i++) {
			value=a.get(i);

			if (value instanceof JSONObject) {
				if (writeJSONObj((JSONObject)value, el, "Item", elements)) {
					//Ho almeno un elemento non vuoto, posso scrivere.
					elements++;
					notEmpty=true;
				} 
			} else 
				if (!value.equals("")) {
					//
					Element el2 = doc.createElement("Item");
					el2.setAttribute("position", new Integer(i).toString());
					String type=value.getClass().toString();
					type=type.substring(type.lastIndexOf(".")+1, type.length());
					el2.setAttribute("value", value.toString());
					el2.setAttribute("type", type);
					el.appendChild(el2);
					elements++;
					notEmpty = true;
				}
		}

		if (notEmpty&&(name!=null)) {
			el.setAttribute("type", "list");
			el.setAttribute("elements", elements.toString());
			root.appendChild(el);
			return true;
		} else return false;
	}

	/**Ritorna il DOM;
	 * @return Il DOM.
	 */
	public Document getDoc(){return doc;}
	
	public static void main(String[]args) {
		Writer w=new Writer("{name:\"editor\", records:[{val1:3, val2:\"Kg\"},"+
				"{val2:\"sec\",val3:[{id:9},{value:\"valore\"}]}," +
				"{val3:[{id:12,value:\"pz\"},{id:9}]}]}");
		w.run();
		w.writeDocOnFile("test.xml");
	}
}

