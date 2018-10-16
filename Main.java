import java.util.*;

public class Main<T>{
	
	public static void main(String args[]){
		AustraliaMap();
		
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

	/*
	public static CSP JobCSP() {
		CSP job = new CSP();
		
		job.problemType = 2;
		
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
	*/
	
	public static void Queens() {
		CSP queen = new CSP();
		
		queen.problemType = 3;
		
		HashSet domain = new HashSet();
		domain.add("1");
		domain.add("2");
		domain.add("3");		
		domain.add("4");		
		domain.add("5");		
		domain.add("6");		
		domain.add("7");		
		domain.add("8");		
		Variable col1 = new Variable("1", null, domain);
		Variable col2 = new Variable("2", null, domain);
		Variable col3 = new Variable("3", null, domain);
		Variable col4 = new Variable("4", null, domain);
		Variable col5 = new Variable("5", null, domain);
		Variable col6 = new Variable("6", null, domain);
		Variable col7 = new Variable("7", null, domain);
		Variable col8 = new Variable("8", null, domain);
		
		Variable[] variableList = {col1, col2, col3, col4, col5, col6, col7, col8};
		
		return queen;
	}

}
