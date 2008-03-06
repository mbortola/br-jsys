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
			BusinessRule[1] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[2] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[3] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[4] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[5] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[6] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[7] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[8] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[9] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[10] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[11] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[12] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[13] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[14] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[15] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[16] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[17] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[18] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[19] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[20] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[21] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[22] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[23] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[24] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[25] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[26] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[27] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[28] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[29] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");
			BusinessRule[30] = new BusinessRule("BR","Articolo","entrate=0 AND NOT(scontato)=true","Commento");


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
