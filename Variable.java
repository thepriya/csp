
//Variables in a CSP element
public class Variable{

	//Each variable has its value and the domain that it belongs to
	String value;
	Domain domain;
	boolean assigned = false;

	//Constructor
	public Variable (String value, Domain domain, boolean assigned) {
		this.value = value;
		this.domain = domain;
		this.assigned = assigned;
	}

}
