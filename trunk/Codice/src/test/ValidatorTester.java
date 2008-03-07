package test;

import brjsys.businessrules.BusinessRule;
import brjsys.validator.Validator;

public class ValidatorTester {

	Validator v;

	public static void main(String[] args) {
		ValidatorTester vt=new ValidatorTester();
		try {
			vt.v=new Validator("admin","happy");

			BusinessRule[] array=new BusinessRule[40];
			BusinessRule[0] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[1] = new BusinessRule("BR","Articolo","entrate=3 AND uscite=4","");
			BusinessRule[2] = new BusinessRule("","Articolo","entrate=5 AND uscite=3","Commento");
			BusinessRule[3] = new BusinessRule("BR","","entrate=3 OR uscite=5","Commento");
			BusinessRule[4] = new BusinessRule("BR","Articolo","","Commento");
			BusinessRule[5] = new BusinessRule("","","","");
			BusinessRule[6] = new BusinessRule("BR","Articolo","(uscite=5 OR uscite=5)  AND ( uscite=5 OR uscite=5)","Commento");
			BusinessRule[7] = new BusinessRule("BR","Articolo","uscite=5 OR uscite=5  AND  uscite=5 OR uscite=5","Commento");
			BusinessRule[8] = new BusinessRule("BR","Articolo","entrate=5+2","Commento");
			BusinessRule[9] = new BusinessRule("BR","Articolo","entrate=SUM(prezzoBase)","Commento");
			BusinessRule[10] = new BusinessRule("BR","Articolo","entrate=AVG(prezzoBase)+2 message(\"errore nel confronto\")","Commento");
			BusinessRule[11] = new BusinessRule("BR","Articolo","uscite<2 AND uscite>2 AND uscite<=2 AND uscite>=2 AND uscite=2 AND uscite!=2","Commento");
			BusinessRule[12] = new BusinessRule("BR","Articolo","uscite=(2+2-(3*4))/5","Commento");
			BusinessRule[13] = new BusinessRule("BR","Articolo","uscite=(2+entrate-(uscite*4))/entrate","Commento");
			BusinessRule[14] = new BusinessRule("BR","Articolo","uscite=(uscite+entrate-(uscite*entrate))/entrate","Commento");
			BusinessRule[15] = new BusinessRule("BR","Articolo","uscite=(2+prezzoBase)+(prezzoBase*4) +(prezzoBase/4)+(prezzoBase-3)","Commento");
			BusinessRule[16] = new BusinessRule("BR","Articolo","(entrate+prezzoBase) +(prezzoBase*uscite) +(prezzoBase/entrate)+(prezzoBase-uscite)","Commento");
			BusinessRule[17] = new BusinessRule("BR","Articolo","(prezzoBase+prezzoBase)+(prezzoBase*prezzoBase)+(prezzoBase/prezzoBase)+(prezzoBase-prezzoBase)","Commento");
			BusinessRule[18] = new BusinessRule("BR","Articolo","(matricePrezzi+matricePrezzi)+(matricePrezzi*matricePrezzi)+(matricePrezzi/matricePrezzi)+(matricePrezzi-matricePrezzi)","Commento");
			BusinessRule[19] = new BusinessRule("BR","Articolo","(matricePrezzi+2) +(matricePrezzi*3) +(matricePrezzi/4) +(matricePrezzi-5)","Commento");
			BusinessRule[20] = new BusinessRule("BR","Articolo","(matricePrezzi+entrate)+(matricePrezzi*entrate)+(matricePrezzi/entrate)+(matricePrezzi-entrate)","Commento");
			BusinessRule[21] = new BusinessRule("BR","Articolo","(matricePrezzi+prezzoBase)+(matricePrezzi*prezzoBase)+(matricePrezzi/prezzoBase)+(matricePrezzi-prezzoBase)","Commento");
			BusinessRule[22] = new BusinessRule("BR","Articolo","(matricePrezzi+grafico)+(matricePrezzi*grafico)+(matricePrezzi/grafico)+(matricePrezzi-grafico)","Commento");
			BusinessRule[23] = new BusinessRule("BR","Articolo","matricePrezzi=\"ArticoloUno\" AND prezziScontati=3 OR uscite=true","Commento");
			BusinessRule[24] = new BusinessRule("BR","Articolo","uscite=2*3*4+4-3*5-5+3/2*3","Commento");
			BusinessRule[25] = new BusinessRule("BR","Articolo","uscite=((((2*((3*4)+(4)-(3*5)-5)+3)/2)*3)+7)","Commento");
			BusinessRule[26] = new BusinessRule("BR","Articolo","\"ArticoloUno\">\"ArticoloUno\" AND \"ArticoloUno\">=\"ArticoloUno\" AND \"ArticoloUno\"<\"ArticoloUno\" AND \"ArticoloUno\"<=\"ArticoloUno\" AND \"ArticoloUno\" *nome AND \"ArticoloUno\"-nome AND \"ArticoloUno\"/nome AND \"ArticoloUno\"+nome","Commento");
			BusinessRule[27] = new BusinessRule("BR","Articolo","nome=\"ArticoloUno\"  AND nome!=\"ArticoloDue\"","Commento");
			BusinessRule[28] = new BusinessRule("BR","Articolo","((scontato||scontato) && scontato) = true AND (true || false && NOT(true))=scontato","Commento");
			BusinessRule[29] = new BusinessRule("BR","Articolo","SUM(prezzoBase) = 12 AND COUNT(entrate)=1, AND AVG(prezzoBase)=4 ","Commento");
			BusinessRule[30] = new BusinessRule("BR","Articolo","SUM(prezzoBase)","Commento");
			BusinessRule[31] = new BusinessRule("BR","Articolo","SUM(prezzoBase)=","Commento");
			BusinessRule[32] = new BusinessRule("BR","Articolo","12 = 2entrate","Commento");
			BusinessRule[33] = new BusinessRule("BR","Articolo","uscite = 2 entrate","Commento");
			BusinessRule[34] = new BusinessRule("BR","Articolo","uscite = 2 AND","Commento");
			BusinessRule[35] = new BusinessRule("BR","Articolo","((2+4)=uscite","Commento");
			BusinessRule[36] = new BusinessRule("BR","Articolo","uscite=(((( 2*(( 3* 4)+( 4)-( 3* 5)-5)+3)/ 2)* 3)+7)","Commento");
			BusinessRule[37] = new BusinessRule("a` e` i` o` u` A` E` I` O` U` \"test\", 'test', &, >, <","Articolo","scontato=true","a` e` i` o` u` A` E` I` O` U` \"test\", 'test', &, >, <");
			BusinessRule[38] = new BusinessRule("BR","Articolo","scontato=true message(\"abc.. ABC.. 0..9 .?!^_-\")","Commento");
			BusinessRule[39] = new BusinessRule("BR","Articolo","scontato=true message(\"#[]{}—=+-*$%\")","Commento");
			BusinessRule[40] = new BusinessRule("BR","Articolo","scontato=true +","Commento");


			for(int index=0;index<array.length;index++){
				try{
					System.out.println("Esito test "+index+":/n");
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
