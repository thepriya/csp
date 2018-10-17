import java.util.*;

public class CSP {
	
	// 1(Australia Map problem)  2(Job Shop problem)  3(n-Queens problem)
	int problemType;
	
	//a CSP has some variables(each with its own domain) and constraints
	Variable[] variable;
	
	//Constraints
	LinkedList<String> constraintA = new LinkedList();
	LinkedList<String> constraintB = new LinkedList();
	
	//Used for job search disjunctive constraints 
	LinkedList<String> constraintC = new LinkedList();
	LinkedList<String> constraintD = new LinkedList();
	

}
