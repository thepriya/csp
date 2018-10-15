import java.util.*;

//CSP is a graph class with a node
public class CSP {
	
	
	//a CSP has some variables(each with its own domain) and constraints
	Variable[] variable;
	Constraint constraint;
	
	//constructor (unfinished...will finish -Priya)
	public CSP(Variable[] variable, Constraint constraint){
		int numberOfVariable = variable.size();
		Variable[] newArrayOfVariables = new Variable[numberOfVariable];
		
		//to do: copy contents of variable into newArrayOfVariables
		
		this.variable = newArrayOfVariables;
		this.constraint = constraint;
	}
	
	
	//takes a csp and returns true if assignment is complete
	public boolean isComplete(){
		
		for(int i=0; i<variable.size(); i++){
			if(variable[i].assignment==null)
				return false;
		}
		
		return true;
	}
	

}
