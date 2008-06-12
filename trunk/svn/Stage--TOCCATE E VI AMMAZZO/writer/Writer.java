package writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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

public class Writer {

	String path;
	
	public Document doc;

	public Writer(String p) {
		path=p;
	}

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
		//Crea l'elemento radice
		Element base = doc.createElement("VZM");

		doc.appendChild(base);

		//String x="{\"Table\":\"tab_fattura_m\",\"Cols\":[{\"id\":\"ojxbjhoamx\",\"field\":\"id_fattura\",\"title\":\"id_fattura\",\"link\":\"\",\"target\":\"\",\"tooltip\":\"\",\"picture\":\"\",\"isImage\":0,\"inExtGrid\":0,\"Layer\":[],\"enable_HTML\":0},{\"id\":\"qgxyvexcrs\",\"field\":\"fk_cliente\",\"title\":\"fk_cliente\",\"link\":\"\",\"target\":\"\",\"tooltip\":\"\",\"picture\":\"\",\"isImage\":0,\"inExtGrid\":0,\"Layer\":[],\"enable_HTML\":0},{\"id\":\"crlmeuvucr\",\"field\":\"fk_articolo\",\"title\":\"fk_articolo\",\"link\":\"\",\"target\":\"\",\"tooltip\":\"\",\"picture\":\"\",\"isImage\":0,\"inExtGrid\":0,\"Layer\":[{\"id\":\"bqquxvdabx\",\"field\":\"data_ora\",\"title\":\"data_fattura\",\"link\":\"\",\"target\":\"\",\"tooltip\":\"\",\"picture\":\"DD-MM-YYYY hh:mm:ss\",\"isImage\":0,\"inExtGrid\":0,\"Layer\":[],\"exp\":undefined,\"descr\":undefined,\"groupby\":undefined,\"enable_HTML\":0},{\"id\":\"mjqnrygopd\",\"field\":\"data\",\"title\":\"data_fatt\",\"link\":\"\",\"target\":\"\",\"tooltip\":\"\",\"picture\":\"DD-MM-YYYY\",\"isImage\":0,\"inExtGrid\":0,\"Layer\":[],\"exp\":undefined,\"descr\":undefined,\"groupby\":undefined,\"enable_HTML\":0}],\"enable_HTML\":0},{\"id\":\"bxegknlxmd\",\"field\":\"prezzo\",\"title\":\"prezzo\",\"link\":\"\",\"target\":\"\",\"tooltip\":\"\",\"picture\":\"\",\"isImage\":0,\"inExtGrid\":0,\"Layer\":[{\"id\":\"sqoowybbni\",\"field\":\"totale_fattura\",\"title\":\"totale_fattura\",\"link\":\"\",\"target\":\"\",\"tooltip\":\"\",\"picture\":\"\",\"isImage\":0,\"inExtGrid\":0,\"Layer\":[],\"exp\":undefined,\"descr\":undefined,\"groupby\":undefined,\"enable_HTML\":0}],\"enable_HTML\":0}],\"RowLayer\":[{\"id\":\"rvmwtsmdos\",\"field\":\"quantita\",\"title\":\"quantita\",\"link\":\"\",\"target\":\"\",\"tooltip\":\"\",\"picture\":\"\",\"isImage\":0,\"inExtGrid\":0},{\"id\":\"fvqwuujlhi\",\"field\":\"tot_parziale\",\"title\":\"totale_parziale\",\"link\":\"\",\"target\":\"\",\"tooltip\":\"\",\"picture\":\"\",\"isImage\":0,\"inExtGrid\":0}],\"Fields\":[\"id_fattura\",\"fk_cliente\",\"fk_articolo\",\"data_ora\",\"data\",\"prezzo\",\"totale_fattura\",\"quantita\",\"tot_parziale\"],\"HideFields\":{},\"Configuration\":{\"VQRName\":\"BO:gs_fattura\",\"GridRows\":15,\"OrderBy\":false}}";

		//String y="{\"a\":{\"b\":12}}";
		
		try {
			writeJSONObj(new JSONObject(path), base, null, -1);
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
		//Result dest = new StreamResult(new File("out.xml"));
		StringWriter st=new StringWriter();
		Result dest=new StreamResult(st);
		try {
			aTransformer.transform(src, dest);
		} catch (TransformerException e) {
			//In teoria non dovrebbe mai accadere
			e.printStackTrace();
			System.exit(1);
		}
		String pp=prettyPrint(st.toString());

		try {
			PrintWriter w=new PrintWriter(new File("out.xml"));
			w.write(pp);
			w.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String prettyPrint(String st) {
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

	protected boolean writeJSONObj(JSONObject o, Element root, String name, int position) throws JSONException{
		JSONArray list=o.names();

		//intanto creo un elemento che casomai aggiungero' al XML

		Element el=null;// doc.createElement("VZM");

		if (name!=null) {el=doc.createElement(name);}
		else el=root;

		//l'oggetto non ha campi, non scrivo niente e ritorno false.
		if (list==null)return false;

		//FORSE non e' vuoto

		//Var temporanee
		Object value=null;
		String tagName=null;
		boolean notEmpty=false;

		for (int i=0;i<list.length();i++) {
			tagName=list.getString(i);
			value=o.get(tagName);

			//controllo sul tipo
			if (value instanceof JSONObject) {
				if (writeJSONObj((JSONObject)value, el, tagName, -1)) {
					//Ho almeno un elemento non vuoto, posso scrivere.
					notEmpty=true;
				}
			} else if (value instanceof JSONArray) {
				//E' un JSONArray
				if (writeJSONArray((JSONArray)value, el, tagName)) {
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
					el.appendChild(el2);
					notEmpty = true;
				}

		}

		if (notEmpty&&(name!=null)) {
			//Almeno un elemento
			if (position>-1) el.setAttribute("position", new Integer(position).toString());
			el.setAttribute("type", "JSONObject");
			root.appendChild(el);
			return true;				
		} else return false;
	}

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
				if (writeJSONObj((JSONObject)value, el, "JSONObject", elements)) {
					//Ho almeno un elemento non vuoto, posso scrivere.
					elements++;
					notEmpty=true;
				} 
			} else 
				if (!value.equals("")) {
					//
					Element el2 = doc.createElement("element");
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
			el.setAttribute("type", "JSONArray");
			el.setAttribute("elements", elements.toString());
			root.appendChild(el);
			return true;
		} else return false;
	}

	public static void main(String[]args) {
		Writer w=new Writer("{\"a\": \"s3\",\"b\": [{\"ca\": [\"a\",\"b\",\"c\"]}, {\"ca\": [\"x\",\"y\",\"z\"	]},	{\"ca\": [],\"q\": \"ciao\"}]}");
		w.run();
	}
}
