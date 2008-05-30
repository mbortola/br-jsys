package writer;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import org.json.XML;
import java.util.Iterator;
import java.io.*;

public class ConvertJSON {
	private String code;
	public static void main(String[] args) {
		String c="{\"Table\":\"tab_fattura_m\",\"Cols\":[{\"id\":\"ojxbjhoamx\",\"field\":\"id_fattura\",\"title\":\"id_fattura\",\"link\":\"\",\"target\":\"\",\"tooltip\":\"\",\"picture\":\"\",\"isImage\":0,\"inExtGrid\":0,\"Layer\":[],\"enable_HTML\":0},{\"id\":\"qgxyvexcrs\",\"field\":\"fk_cliente\",\"title\":\"fk_cliente\",\"link\":\"\",\"target\":\"\",\"tooltip\":\"\",\"picture\":\"\",\"isImage\":0,\"inExtGrid\":0,\"Layer\":[],\"enable_HTML\":0},{\"id\":\"crlmeuvucr\",\"field\":\"fk_articolo\",\"title\":\"fk_articolo\",\"link\":\"\",\"target\":\"\",\"tooltip\":\"\",\"picture\":\"\",\"isImage\":0,\"inExtGrid\":0,\"Layer\":[{\"id\":\"bqquxvdabx\",\"field\":\"data_ora\",\"title\":\"data_fattura\",\"link\":\"\",\"target\":\"\",\"tooltip\":\"\",\"picture\":\"DD-MM-YYYY hh:mm:ss\",\"isImage\":0,\"inExtGrid\":0,\"Layer\":[],\"exp\":undefined,\"descr\":undefined,\"groupby\":undefined,\"enable_HTML\":0},{\"id\":\"mjqnrygopd\",\"field\":\"data\",\"title\":\"data_fatt\",\"link\":\"\",\"target\":\"\",\"tooltip\":\"\",\"picture\":\"DD-MM-YYYY\",\"isImage\":0,\"inExtGrid\":0,\"Layer\":[],\"exp\":undefined,\"descr\":undefined,\"groupby\":undefined,\"enable_HTML\":0}],\"enable_HTML\":0},{\"id\":\"bxegknlxmd\",\"field\":\"prezzo\",\"title\":\"prezzo\",\"link\":\"\",\"target\":\"\",\"tooltip\":\"\",\"picture\":\"\",\"isImage\":0,\"inExtGrid\":0,\"Layer\":[{\"id\":\"sqoowybbni\",\"field\":\"totale_fattura\",\"title\":\"totale_fattura\",\"link\":\"\",\"target\":\"\",\"tooltip\":\"\",\"picture\":\"\",\"isImage\":0,\"inExtGrid\":0,\"Layer\":[],\"exp\":undefined,\"descr\":undefined,\"groupby\":undefined,\"enable_HTML\":0}],\"enable_HTML\":0}],\"RowLayer\":[{\"id\":\"rvmwtsmdos\",\"field\":\"quantita\",\"title\":\"quantita\",\"link\":\"\",\"target\":\"\",\"tooltip\":\"\",\"picture\":\"\",\"isImage\":0,\"inExtGrid\":0},{\"id\":\"fvqwuujlhi\",\"field\":\"tot_parziale\",\"title\":\"totale_parziale\",\"link\":\"\",\"target\":\"\",\"tooltip\":\"\",\"picture\":\"\",\"isImage\":0,\"inExtGrid\":0}],\"Fields\":[\"id_fattura\",\"fk_cliente\",\"fk_articolo\",\"data_ora\",\"data\",\"prezzo\",\"totale_fattura\",\"quantita\",\"tot_parziale\"],\"HideFields\":{},\"Configuration\":{\"VQRName\":\"BO:gs_fattura\",\"GridRows\":15,\"OrderBy\":false}}";
		ConvertJSON a = new ConvertJSON(c);
		String xml = a.convertML();
		try {
			FileOutputStream file = new FileOutputStream("D:/out.txt");
			PrintStream Output = new PrintStream(file);
			Output.println(xml);
			Output.close();
			file.close();
		} catch (IOException e){

		}
		try {
			FileInputStream fis=new FileInputStream("json.txt");
			InputStreamReader isr=new InputStreamReader(fis);
			BufferedReader br=new BufferedReader(isr);
			String linea=br.readLine();
			JSONObject oo = a.convertFromXML(linea);
			System.out.println(oo.toString());

			FileOutputStream file = new FileOutputStream("out.txt");
			PrintStream Output = new PrintStream(file);
			Output.println(oo.toString());
			Output.close();
			file.close();

		} catch (IOException e){
		}
	}

	/* public ConvertJSON() {
  ConvertJSON("");
 }*/
	public ConvertJSON(String cod) {
		code = cod;
	}
	/* public String convert(){
  JSONObject js= new JSONObject(code);
//  Iterator i = js.keys();
  /*while (i.hasNext()){
   String k = (String)i.next();
   JSONObject jo = (JSONObject)o;
  }
 }*/
	public String convertML() {
		try{
			JSONObject js= new JSONObject(code);
			return XML.toString(js);
		}catch(JSONException e){
			return "sbagliatissimo";
		}
	}
	public JSONObject convertFromXML(String xml) {
		try{
			return XML.toJSONObject(xml);
		} catch(JSONException e){
			return new JSONObject();
		}
	}
}













































