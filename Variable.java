
//Variables in a CSP element
public class Variable{

	//Each variable has its value and the domain that it belongs to
	String value;
	Domain domain;
	
	//For Job Search Problem 
	int time; 

	//Constructor
	public Variable (String value, Domain domain) {
		this.value = value;
		this.domain = domain;
	}
	
	public Variable(int time) {
		this.time = time;
	}

}
