package brjsys.validator;

import brjsys.businessrules.BusinessRule;
import brjsys.communicator.ValidatorCommunicator;

public class Validator {
	private ValidatorCommunicator repository;
	public Validator(String username, String password)/*errore in conessione*/{
		repository=new ValidatorCommunicator(username, password);
	}
	public boolean validate(BusinessRule Brule){
		
		
		return true;
	}
}
