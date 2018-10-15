import java.util.*;

public class Solver<T> {
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
		if( csp.isComplete() ){
			return csp;
		}
		
		//finding index of unassigned variable
		int indexOfUnassignedVariable = 0;
		for(int i=0; i<csp.variable.size(); i++){
			if(csp.variable[i].assignment==null){
				indexOfUnassignedVariable = i;
				break;
			}
		}
		
		Variable var = new Variable( csp.variable[indexOfUnassignedVariable].name, null, csp.variable[indexOfUnassignedVariable].domain);;
		
		//replace pseudocode with real code
		//assigning value to unassigned variable
		T valueInDomain = null;
		for(each valueInDomain in csp.variable[indexOfUnassignedVariable].domain.domain){
			if(csp.isConsistent(indexOfUnassignedVariable, valueInDomain)){
				csp.variable[indexOfUnassignedVariable].assignment = valueInDomain;
				CSP result = backtrack(csp);
				if (result != null){
					return result;
				}
			}
		}
		
		return null; //null represents failure
	
	
}
