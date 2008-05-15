import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**Classe che offre soltanto il metodo statico per effettuare trasformate XSL.*/
public class XSLTrasform {

	/**Metodo statico per la trasformazione con XSL.
	 * 
	 * @param input Patrh del file di input.
	 * @param output Path del file di output.
	 * @param XSL Il foglio di stile.
	 * @throws TransformerException Errore nella trasformazione.
	 * @throws FileNotFoundException File di input errato.
	 * */
	public static void parse(String input, String output, String XSL) 
	throws FileNotFoundException, TransformerException{
		TransformerFactory tFactory = TransformerFactory.newInstance();

		Transformer transformer = null;
		transformer = tFactory.newTransformer(new StreamSource(XSL));

		transformer.transform(new StreamSource(input),
				new StreamResult(new FileOutputStream(output)));

	}
	
	/**Esegue il pretty printing di un file XML
	 * tramite il metodo parse ed un opportuna trasformata XSL.
	 * @param input File XML di input.
	 * @param output File XML di output. 
	 * @throws TransformerException 
	 * @throws FileNotFoundException 
	 * */
	public static void prettyPrint(String input, String output) 
	throws FileNotFoundException, TransformerException {
		parse(input, output, "prettyprint.xsl");
	}
}
