import java.util.*;

//Variables in a CSP element
public class Variable<T>{

	//Each variable has its name and the domain that it belongs to
	String name;
	T assignment = null; //assignment is initially null
	Domain domain;

	//Constructor
	public Variable (String nam, T assignment, Domain domain) {
		this.name = name;
		this.assignment = assignment;
		this.domain = domain;
	}

}
