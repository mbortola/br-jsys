package test;

import brjsys.businessrules.BusinessRule;
import brjsys.validator.Validator;

public class ValidatorTester {

	Validator v;

	public static void main(String[] args) {
		ValidatorTester vt=new ValidatorTester();
		try {
			vt.v=new Validator("admin","happy");

			BusinessRule[] array=new BusinessRule[3];

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
