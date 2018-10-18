import java.util.*;

public class Solver {
	
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
		for(String valueInDomain : csp.variable[indexOfUnassignedVariable].domain){
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
		
		for(int i=0; i<csp.variable.length; i++){
			if(csp.variable[i].assignment==null)
				return false;
		}
		
		return true;
	}


	public static boolean isComplete(CSP csp, int job){			
		for(int i=0; i<csp.variable.length; i++){
			if(csp.variable[i].value==0)
				return false;
		}
		
		return true;
	}
	
	//takes a value from domain and returns true if it is consistent else false
	public boolean isConsistent(CSP csp, int index, int value){
		
		csp.variable[index].value = value;
		
		//Job shop problem
		if(csp.problemType==2){
			//+System.out.println("isConsistent");
			boolean test1 = isJobConsistentPart1(csp);
			boolean test2 = isJobConsistentPart2(csp);
			//System.out.println(test1);
			if(test1 == false) {
				return false; 
			//} else if (test2 == false){
				//return false; 
			} 
			if(test2 == false){
				return false; 
			}
			else {
				return true; 
			}
			//if(test1 == false) {
				//return false; 
			//}
			
		}
		
		return false;
	}
	
	//takes a value from domain and returns true if it is consistent else false
	public boolean isConsistent(CSP csp, int index, String value){
		
		csp.variable[index].assignment = value;
		
		//Map problem
		if(csp.problemType==1){
			return isMapConsistent(csp);
		}
		
		//N-Queens problem
		if(csp.problemType==3){
			return isQueensConsistent(csp);
		}
		
		return false;
	}
	
	//checks constraint consistency for Map problem
	public static boolean isMapConsistent(CSP csp){
		
		for (int i = 0; i<csp.constraintA.size(); i++) {
			String cityA = csp.constraintA.get(i);
			String cityB = csp.constraintB.get(i);
			
			String assignmentA = "";
			String assignmentB = "";
			
			for(int j=0; j<csp.variable.length; j++){
				if(csp.variable[j].name == cityA){
					assignmentA = csp.variable[j].assignment;
				}
				if(csp.variable[j].name == cityB){
					assignmentB = csp.variable[j].assignment;
				}
			}
			
			if(  (assignmentA!=null) && (assignmentA==assignmentB)  )
				return false;			
		}
		
		return true;
	}
	
	//checks constraint part 1 consistency for Job problem
	public static boolean isJobConsistentPart1(CSP csp){
		int indexBreakCount = 0;
		//Iterates through the set of precedent constraints and tests to see if the constraint has been violated 
		for(indexBreakCount=0; indexBreakCount<csp.constraintA.size(); indexBreakCount++) {
			
			//System.out.println("Constraint A" + csp.constraintA.size());
			//System.out.println("i" + i);
			
			String lessThan = csp.constraintA.get(indexBreakCount);
			//System.out.println("Less Than" + lessThan);
			String greaterThan = csp.constraintB.get(indexBreakCount);
			//System.out.println("Greater Than" + greaterThan);
			
			int valueA = 0; 
			int valueB = 0; 
			int inspect = 0; 
			
			
			//Iterates through the variable array 
			for(int j =0; j <csp.variable.length; j++) {
				
				//System.out.println("Variable Name" + csp.variable[j].name);
				
				//Less than Inspect 
				if(csp.variable[j].name.equals("Inspect")){
					inspect = csp.variable[j].value;
				}
				//If the less than side has the same name
				if(csp.variable[j].name.equals(lessThan)) {
					
					//Time
					//String time = lessThan; 
					switch(lessThan) {
						case "AxleF": 
							valueA = csp.variable[j].value + 10; 
							break; 
						case "AxleB":
							valueA = csp.variable[j].value + 10; 
							break;
						case "WheelRF":
							valueA = csp.variable[j].value + 1; 
							break;
						case "WheelLF":
							valueA = csp.variable[j].value + 1; 
							break;
						case "WheelRB":
							valueA = csp.variable[j].value + 1; 
							break;
						case "WheelLB":
							valueA = csp.variable[j].value + 1; 
							break;
						case "NutsRF":
							valueA = csp.variable[j].value + 2; 
							break;
						case "NutsLF":
							//System.out.println("NutsLF" + valueA);
							valueA = csp.variable[j].value + 2; 
							break;
						case "NutsRB":
							valueA = csp.variable[j].value + 2; 
							break;
						case "NutsLB":
							valueA = csp.variable[j].value + 2; 
							break;
						default:
							valueA = csp.variable[j].value; 
							break; 	
					}					
				}
				
				//Get value for right side
				if(csp.variable[j].name.equals(greaterThan)) {
					valueB = csp.variable[j].value; 
				}
			}
			
			
			//If the precedence constraint has been violated 
			if(((valueA > valueB)  && valueA !=0 && valueB !=0) || ((valueA>inspect) && valueA!=0 && inspect !=0)) {
				//System.out.println("ValueA " + valueA + " ValueB " + valueB);
				//System.out.println("valueA violated: " + valueA + "valueB" + valueB);
				return false; 
			}
			
			//If also has been violated 
			//Switch statement to take into account the previous value 
		
			/*
			switch(lessThan) {
				case "WheelRF":
					//Also check the previous value 
					int AxleFVal = csp.variable[0].value + 10; 
					if((AxleFVal > valueA) && AxleFVal != 0) {
						return false; 
					}
					break;
				
				case "WheelLF":
					int AxleFVal1 = csp.variable[0].value + 10; 
					if((AxleFVal1 > valueA) && AxleFVal1 != 0) {
						return false; 
					}
					break;
				case "WheelRB":
					int AxleBVal = csp.variable[1].value + 10; 
					if((AxleBVal > valueA) && AxleBVal != 0) {
						return false; 
					} 
					break;
				case "WheelLB":
					int AxleBVal1 = csp.variable[1].value + 10; 
					if((AxleBVal1 > valueA) && AxleBVal1 != 0) {
						return false; 
					}  
					break;
				case "NutsRF":
					int WheelRF = csp.variable[2].value + 1; 
					if((WheelRF > valueA) && WheelRF != 0) {
						return false; 
					}  
					break;
				case "NutsLF":
					int WheelLF = csp.variable[3].value + 1; 
					if((WheelLF > valueA) && WheelLF != 0) {
						return false; 
					}  
					break;
				case "NutsRB":
					int WheelRB = csp.variable[4].value + 1; 
					if((WheelRB > valueA) && WheelRB != 0) {
						return false; 
					}  
					break;
				case "NutsLB":
					int WheelLB = csp.variable[5].value + 1; 
					if((WheelLB > valueA) && WheelLB != 0) {
						return false; 
					}  
					break;
				default:
					break; 	
	
			}
			*/
			
		}
		
	
		return true; 		
	}
	
	//Checks disjunctive constraints 
	public static boolean isJobConsistentPart2(CSP csp) {

		//Disjunctive constraint 
		//Returns Null Pointer Exception
		for(int a = 0; a<csp.constraintC.size(); a++) {
			
			String disjunct1 = csp.constraintC.get(a);
			String disjunct2 = csp.constraintD.get(a);
			
			int val1 = 0;
			int val2 = 0; 
			
			//Iterate through the array 
			for(int b = 0; b<csp.variable.length; b++) {
				//If it has the same name
				if(csp.variable[b].name.equals(disjunct1)) {
					val1 = csp.variable[b].value;
				}
				
				//If it has the same name 
				if(csp.variable[b].name.equals(disjunct2)){
					val2 = csp.variable[b].value; 
				}
				
				//Test to see disjunct constraint has been violated 
				if((!(((val1+10)<=val2)||((val2+10)<=val2))) && val1!=0 && val2 !=0) {
					return false; 
				}
			 }
			
			}
		return true; 
	}

	//Backtrack function for job search
	public CSP backtrack(CSP csp, int jobsearch){
		//checking if assignment is complete
		if( isComplete(csp, 0) ){
			return csp;
		}
	
		//finding index of the next unassigned variable
		int indexOfUnassignedVariable = 0;
		for(int i=0; i<csp.variable.length; i++){
			//System.out.println("Variable length" + csp.variable.length);
			//System.out.println("HELLO!");
			if(csp.variable[i].value==0){
				//System.out.println("indexOfUnassignedVariable" + indexOfUnassignedVariable);
				indexOfUnassignedVariable = i;
				break;
			}
		}

		
		//assigning value to variable
		for(Integer valueInDomain : csp.variable[indexOfUnassignedVariable].jobDomain){
			if(indexOfUnassignedVariable == 7) {
				//System.out.println("NutsLF Value in Domain" + valueInDomain);
			}
			//System.out.println("Assigning value, starting with domain 1" + valueInDomain + "csp valu" + csp.variable[indexOfUnassignedVariable].jobDomain);
			if( isConsistent(csp, indexOfUnassignedVariable, valueInDomain)){
				if(indexOfUnassignedVariable == 7) {
					//System.out.println("NutsLF is Consistent" + valueInDomain);
				}
				//System.out.println("is it getting here?");
				csp.variable[indexOfUnassignedVariable].value = valueInDomain; 
				CSP result = backtrack(csp, 0);
				if (result != null){
					return result;
				}
			}
		}
		
		//null represents failure
		return null;
	}
	
	//checks constraint consistency for N-queens problem
	public static boolean isQueensConsistent(CSP csp){
		//n can be 4 and above
		int n = csp.variable.length;
		
		int sameRow = 0;
		int diagonalUp = 0;
		int diagonalDown = 0;
		
		//same row, diagonal up and diagonal down checker
		for(int i=0;i<n; i++){
			
			if(csp.variable[i].assignment == null)
				return true;
			
			int queen1 = Integer.parseInt(csp.variable[i].assignment);
			diagonalUp = queen1;
			diagonalDown = queen1;
			
			for(int j=i+1; j<n; j++){
				
				if(csp.variable[j].assignment == null)
					return true;
			
				diagonalUp+=1;
				diagonalDown-=1;
				int queen2 = Integer.parseInt(csp.variable[j].assignment);
				if( (queen1==queen2) || (queen2==diagonalUp) || (queen2==diagonalDown) )
					return false;
			}
		}
		
		return true;
	}

	
}
