import java.util.*;

public class Solver<T> {
	
	//pseudocode for backtracking algorithm
    /*public void BT(CSP csp){
        backtrack({}, CSP csp)
    }

    private CSP backtrack(Assignment assignment, CSP csp){
        if (assignment is complete){
            return assignment;
        }
        var = SelectUnassignedVar(csp);
        for(value : OrderDomainValues(var, assignment, csp)){
            if(value is consistent with assignment){
                add <var,value> to assignment
                result = backtrack(assignment, csp)
                if (result != failure){
                    return result
                }
                else{
                    remove <var,value> from assignment
                }
            }
        }
        return failure;
    }
    */
	
	
	public CSP backtrack(CSP csp){
		//checking if assignment is complete
		if( isComplete(csp) ){
			return csp;
		}
		
		//finding index of the next unassigned variable
		int indexOfUnassignedVariable = 0;
		for(int i=0; i<csp.variable.length; i++){
			if(csp.variable[i].assignment==null){
				indexOfUnassignedVariable = i;
				break;
			}
		}
		
		//assigning value to variable
		for(T valueInDomain : csp.variable[indexOfUnassignedVariable].domain){
			if( isConsistent(csp, indexOfUnassignedVariable, valueInDomain)){
				csp.variable[indexOfUnassignedVariable].assignment = valueInDomain;
				CSP result = backtrack(csp);
				if (result != null){
					return result;
				}
			}
		}
		
		//null represents failure
		return null;
	}
	
	
	//takes a csp and returns true if assignment is complete
	public static boolean isComplete(CSP csp){
		
		for(int i=0; i<variable.size(); i++){
			if(csp.variable[i].assignment==null)
				return false;
		}
		
		return true;
	}

	//takes a value from domain and returns true if it is consistent else false
	public boolean isConsistent(CSP csp, int index, T value){
		
		csp.variable[index] = value;
		
		//Map problem
		if(this.constraint.problemType==1){
			return isMapConsistent(csp);
		}
		
		//Job shop problem
		if(this.constraint.problemType==2){
			return isJobConsistent(csp);
		}
		
		//N-Queens problem
		if(this.constraint.problemType==3){
			return isQueensConsistent(csp);
		}
		
		return false;
	}
	
	//checks constraint consistency for Map problem
	public static boolean isMapConsistent(CSP csp){
		
		for (int i = 0; i<linkedListA.size(); i++) {
			String cityA = csp.constraintA.get(i);
			String cityB = csp.constraintB.get(i);
			
			String assignmentA;
			String assignmentB;
			
			for(int j=0; j<csp.variable.length; j++){
				if(csp.variable[j].name == cityA){
					assignmentA = csp.variable[j].assignment;
				}
				if(csp.variable[j].name == cityB){
					assignmentB = csp.variable[j].assignment;
				}
			}
			
			if(assignmentA==assignmentB)
				return false;			
		}
		
		return true;
	}
	
	//checks constraint consistency for Job problem
	public static boolean isJobConsistent(CSP csp){
		return false;
	}
	
	//checks constraint consistency for N-queens problem
	public static boolean isQueensConsistent(CSP csp){
		return false;
	}

	
}
