import java.util.*;

public class Main{
	
	public static void main(String args[]){
		//AustraliaMap();
		Queens();
		
	}
	
	
	public static void AustraliaMap(){		
		
		CSP aus = new CSP();
		
		aus.problemType = 1;
		
		HashSet domain = new HashSet();
		domain.add("R");
		domain.add("G");
		domain.add("B");		
		Variable WA = new Variable("WA", null, domain);
		Variable NT = new Variable("NT", null, domain);
		Variable Q = new Variable("Q", null, domain);
		Variable NSW = new Variable("NSW", null, domain);
		Variable V = new Variable("V", null, domain);
		Variable SA = new Variable("SA", null, domain);
		Variable T = new Variable("T", null, domain);		
		Variable[] variableList = {WA, NT, Q, NSW, V, SA, T};
		aus.variable = variableList;
		
		//adding the constraints
		aus.constraintA.add("SA");
		aus.constraintB.add("WA");
		aus.constraintA.add("SA");
		aus.constraintB.add("NT");
		
		aus.constraintA.add("SA");
		aus.constraintB.add("Q");
		aus.constraintA.add("SA");
		aus.constraintB.add("NSW");
		
		aus.constraintA.add("SA");
		aus.constraintB.add("V");
		aus.constraintA.add("WA");
		aus.constraintB.add("NT");
		
		aus.constraintA.add("NT");
		aus.constraintB.add("Q");
		aus.constraintA.add("Q");
		aus.constraintB.add("NSW");
		
		aus.constraintA.add("NSW");
		aus.constraintB.add("V");
		
		
		Solver solver = new Solver();
		aus=solver.backtrack(aus);
		
		//printing assignment
		for(int i=0; i<aus.variable.length; i++){
			System.out.println(aus.variable[i].name + "=" + aus.variable[i].assignment);
		}

		
	}

	
	public static void JobCSP() {
		CSP job = new CSP();
		
		job.problemType = 2;
		
		HashSet domain = new HashSet();
		domain.add("");
		
	}
	
	
	public static void Queens() {
		CSP queen = new CSP();
		
		queen.problemType = 3;
		
		//take input from user for n
		int n = 7;
		HashSet domain = new HashSet();
		for(int i=1; i<=n; i++){
			domain.add(""+i);
		}
		
		Variable col1 = new Variable("1", "2", domain); //n-queens has no solution with queen at corner 
		Variable[] variableList = {col1};
		
		for(int i=1; i<n; i++){
			Variable var = new Variable(""+(i+1), null, domain);
			Variable[] temp = new Variable[(variableList.length)+1];
			for(int j=0; j<variableList.length; j++){
				temp[j] = variableList[j];
			}
			temp[variableList.length] = var;
			variableList = temp;
		}
		
		queen.variable = variableList;
		
		
		Solver solver = new Solver();
		//System.out.println(solver.isComplete(queen));
		queen = solver.backtrack(queen);
		
		if(queen==null){ //if no solution found
			System.out.println("assignment incomplete");
		}
		else{
			//printing assignment
			for(int i=0; i<n; i++){
				System.out.println("row" + queen.variable[i].name + "=" + queen.variable[i].assignment);
			}
		}
		
	}

}
