package brjsys.businessrules;

public class BusinessRule {
	public String name;
	public String associated;
	public String rule;
	public String comment;
	public BusinessRule(String string, String string2, String string3,String string4) {
		name=string;
		associated=string2;
		rule=string3;
		comment=string4;
	}
	public String toString(){
		return name+' '+associated+' '+rule+' '+(comment==null||comment==""?"":comment);
	}
	
}
