import java.util.*;

public class Main<T>{
	
	public static CSP AustraliaCSP() {
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
		
		return aus;
	}

	public static void main(String args[]){
		System.out.println("Print");
		CSP csp = AustraliaCSP();
		Solver solver = new Solver();
		if(solver.backtrack(csp) == null)
			System.out.println("null");
		System.out.println("Print");
		
	}

}
