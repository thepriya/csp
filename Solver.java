import java.util.*;

public class Solver<T> {
	
	//pseudocode for backtracking algorithm
    /*
	public void BT(CSP csp){
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
		if( csp.isComplete() ){
			return csp;
		}
		
		//finding index of the next unassigned variable
		int indexOfUnassignedVariable = 0;
		for(int i=0; i<csp.variable.size(); i++){
			if(csp.variable[i].assignment==null){
				indexOfUnassignedVariable = i;
				break;
			}
		}
		
		//assigning value to variable
		for(T valueInDomain : csp.variable[indexOfUnassignedVariable].domain.domain){
			if(csp.isConsistent(indexOfUnassignedVariable, valueInDomain)){
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
	
}
