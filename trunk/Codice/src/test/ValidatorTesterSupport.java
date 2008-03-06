package test;

import brjsys.businessrules.BusinessRule;
import brjsys.validator.Validator;

public class ValidatorTesterSupport {

	Validator v;

	public static void main(String[] args) {
		ValidatorTesterSupport vt=new ValidatorTesterSupport();
		try {
			vt.v=new Validator("admin","happy");

			BusinessRule[] array=new BusinessRule[40];

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
