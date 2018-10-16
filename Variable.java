import java.util.*;

public class Variable{

	//Each variable has its name, assignment and domain
	String name;
	String assignment = null; //initially null
	HashSet<String> domain = null;

	//Constructor
	public Variable (String name, String assignment, HashSet<String> domain) {
		this.name = name;
		this.assignment = assignment;
		this.domain = domain;
	}

}
