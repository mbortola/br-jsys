package test;

import brjsys.businessrules.BusinessRule;
import brjsys.validator.Validator;

public class ValidatorTester {

	Validator v;

	public static void main(String[] args) {
		ValidatorTester vt=new ValidatorTester();
		try {
			vt.v=new Validator("admin","michele");

			BusinessRule[] array=new BusinessRule[42];
			array[0] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			array[1] = new BusinessRule("BR","Articolo","entrate=3 AND uscite=4","");
			array[2] = new BusinessRule("","Articolo","entrate=5 AND uscite=3","Commento");
			array[3] = new BusinessRule("BR","Articolo","entrate=3 OR uscite=5","Commento");
			array[4] = new BusinessRule("BR","Articolo","","Commento");
			array[5] = new BusinessRule("","Articolo","","");
			array[6] = new BusinessRule("BR","Articolo","uscite=5 AND uscite=5 OR uscite=5 AND ( uscite=5 OR uscite=5 AND ( uscite=5 OR (uscite=5 AND uscite=5 AND uscite=5 AND uscite=5) OR uscite=5) OR uscite=5 AND ( uscite=5 OR uscite=5) OR uscite=5) AND uscite=5","Commento");
			array[7] = new BusinessRule("BR","Articolo","uscite=5 AND uscite=5 OR uscite=5 AND uscite=5 OR uscite=5 AND uscite=5 OR uscite=5 AND uscite=5 AND uscite=5 AND uscite=5 OR uscite=5 OR uscite=5 AND uscite=5 OR uscite=5 OR uscite=5 AND uscite=5 ","Commento");
			array[8] = new BusinessRule("BR","Articolo","entrate=5+2","Commento");
			array[9] = new BusinessRule("BR","Articolo","entrate=SUM(prezzoBase)","Commento");
			array[10] = new BusinessRule("BR","Articolo","entrate=AVG(prezzoBase)+2 message(\"errore nel confronto\")","Commento");
			array[11] = new BusinessRule("BR","Articolo","uscite<2 AND entrate>3 OR (uscite<=2 AND entrate>=3 OR (uscite=5 AND entrate!=2) )","Commento");
			array[12] = new BusinessRule("BR","Articolo","uscite=(2+2-(3*4))/5","Commento");
			array[13] = new BusinessRule("BR","Articolo","uscite=(2+entrate-(uscite*4))/entrate","Commento");
			array[14] = new BusinessRule("BR","Articolo","uscite=(uscite+entrate-(uscite*entrate))/entrate","Commento");
			array[15] = new BusinessRule("BR","Articolo","uscite=(2+prezzoBase)+(prezzoBase*4) +(prezzoBase/4)+(prezzoBase-3)","Commento");
			array[16] = new BusinessRule("BR","Articolo","(entrate+prezzoBase) +(prezzoBase*uscite) +(prezzoBase/entrate)+(prezzoBase-uscite)","Commento");
			array[17] = new BusinessRule("BR","Articolo","(prezzoBase+prezzoBase)+(prezzoBase*prezzoBase)+(prezzoBase/prezzoBase)+(prezzoBase-prezzoBase)","Commento");
			array[18] = new BusinessRule("BR","Articolo","(matricePrezzi+matricePrezzi)+(matricePrezzi*matricePrezzi)+(matricePrezzi/matricePrezzi)+(matricePrezzi-matricePrezzi)","Commento");
			array[19] = new BusinessRule("BR","Articolo","(matricePrezzi+2) +(matricePrezzi*3) +(matricePrezzi/4) +(matricePrezzi-5)","Commento");
			array[20] = new BusinessRule("BR","Articolo","(matricePrezzi+entrate)+(matricePrezzi*entrate)+(matricePrezzi/entrate)+(matricePrezzi-entrate)","Commento");
			array[21] = new BusinessRule("BR","Articolo","(matricePrezzi+prezzoBase)+(matricePrezzi*prezzoBase)+(matricePrezzi/prezzoBase)+(matricePrezzi-prezzoBase)","Commento");
			array[22] = new BusinessRule("BR","Articolo","(matricePrezzi+grafico)+(matricePrezzi*grafico)+(matricePrezzi/grafico)+(matricePrezzi-grafico)","Commento");
			array[23] = new BusinessRule("BR","Articolo","matricePrezzi=\"ArticoloUno\" AND prezziScontati=3 OR uscite=true","Commento");
			array[24] = new BusinessRule("BR","Articolo","uscite=2*3*4+4-3*5-5+3/2*3","Commento");
			array[25] = new BusinessRule("BR","Articolo","uscite=((((2*((3*4)+(4)-(3*5)-5)+3)/2)*3)+7)","Commento");
			array[26] = new BusinessRule("BR","Articolo","\"ArticoloUno\">\"ArticoloUno\" AND \"ArticoloUno\">=\"ArticoloUno\" AND \"ArticoloUno\"<\"ArticoloUno\" AND \"ArticoloUno\"<=\"ArticoloUno\" AND \"ArticoloUno\" *nome AND \"ArticoloUno\"-nome AND \"ArticoloUno\"/nome AND \"ArticoloUno\"+nome","Commento");
			array[27] = new BusinessRule("BR","Articolo","nome=\"ArticoloUno\"  AND nome!=\"ArticoloDue\"","Commento");
			array[28] = new BusinessRule("BR","Articolo","((scontato||scontato) && scontato) = true AND (true || false && NOT(true))=scontato","Commento");
			array[29] = new BusinessRule("BR","Articolo","SUM(prezzoBase) = 12 AND COUNT(entrate)=1, AND AVG(prezzoBase)=4 ","Commento");
			array[30] = new BusinessRule("BR","Articolo","SUM(prezzoBase)","Commento");
			array[31] = new BusinessRule("BR","Articolo","SUM(prezzoBase)=","Commento");
			array[32] = new BusinessRule("BR","Articolo","12 = 2entrate","Commento");
			array[33] = new BusinessRule("BR","Articolo","uscite = 2 entrate","Commento");
			array[34] = new BusinessRule("BR","Articolo","uscite = 2 AND","Commento");
			array[35] = new BusinessRule("BR","Articolo","((2+4)=uscite","Commento");
			array[36] = new BusinessRule("BR","Articolo","uscite=(((( 2*(( 3* 4)+( 4)-( 3* 5)-5)+3)/ 2)* 3)+7)","Commento");
			array[37] = new BusinessRule("a` e` i` o` u` A` E` I` O` U` \"test\", 'test', &, >, <","Articolo","scontato=true","a` e` i` o` u` A` E` I` O` U` \"test\", 'test', &, >, <");
			array[38] = new BusinessRule("BR","Articolo","scontato=true message(\"abc.. ABC.. 0..9 .?!^_-\")","Commento");
			array[39] = new BusinessRule("BR","Articolo","scontato=true message(\"#[]{}—=+-*$%\")","Commento");

			for(int index=0;index<array.length;index++){
				try{
					System.out.println("Esito test "+index+":\n");
					System.out.println(vt.v.validate(array[index]));

				}catch(Exception error){
					System.out.println(error.getMessage());
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
