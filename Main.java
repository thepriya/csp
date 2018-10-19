import java.util.*;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.Static;

public class Main{
	
	public static void main(String args[]){
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Project #2: Constraint Satisfaction Problems");
			
		boolean quit = true; 
		
		while(quit) {
			System.out.println("Enter 1 to run the Australian Map Problem, 2 to run the Job Search Problem, 3 to run the n-Queens Problem or 4 to quit.");
			int userEntry = scanner.nextInt(); 
			if(userEntry == 1) {
				AustraliaMap(); 
			} 
			if(userEntry == 2) {
				JobCSP();  
			}
			if(userEntry == 3) {
				Queens(); 
			}
			if(userEntry ==4) {
				break; 
			}
		}
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
		
		HashSet<Integer> domain = new HashSet<Integer>();
		
		//Add domain values ranged from 1 to 27 
		domain.add(1);
		domain.add(2);
		domain.add(3);
		domain.add(4);
		domain.add(5);
		domain.add(6);
		domain.add(7);
		domain.add(8);
		domain.add(9);
		domain.add(10);
		domain.add(11);
		domain.add(12);
		domain.add(13);
		domain.add(14);
		domain.add(15);
		domain.add(16);
		domain.add(17);
		domain.add(18);
		domain.add(19);
		domain.add(20);
		domain.add(21);
		domain.add(22);
		domain.add(23);
		domain.add(24);
		domain.add(25);
		domain.add(26);
		domain.add(27);
		
		//Variables for each task of the car, where the value of it is when the time of the task starts 
		Variable AxleF = new Variable("AxleF", 0, domain);
		Variable AxleB = new Variable("AxleB", 0, domain);
		Variable WheelRF = new Variable("WheelRF", 0, domain);
		Variable WheelLF = new Variable("WheelLF", 0, domain);
		Variable WheelRB = new Variable("WheelRB", 0, domain);
		Variable WheelLB = new Variable("WheelLB", 0, domain);
		Variable NutsRF = new Variable("NutsRF", 0, domain);
		Variable NutsLF = new Variable("NutsLF", 0, domain);
		Variable NutsRB = new Variable("NutsRB", 0, domain);
		Variable NutsLB = new Variable("NutsLB", 0, domain);
		Variable CapsRF = new Variable("CapsRF", 0, domain);
		Variable CapsLF = new Variable("CapsLF", 0, domain);
		Variable CapsRB = new Variable("CapsRB", 0, domain);
		Variable CapsLB = new Variable("CapsLB", 0, domain);
		Variable Inspect = new Variable("Inspect", 0, domain);
		
		//{AxleF , AxleB,WheelRF ,WheelLF ,WheelRB,WheelLB, NutsRF ,NutsLF , NutsRB, NutsLB, CapRF , CapLF , CapRB, CapLB, Inspect}
		//Variable[] variableList = {AxleF, AxleB, WheelRF, WheelLF, WheelRB, WheelLB, NutsRF, NutsLF, NutsRB, NutsLB, CapsRF, CapsLF, CapsRB, CapsLB, Inspect};
		Variable[] variableList = {AxleF, AxleB, WheelRF, WheelLF, WheelRB, WheelLB, NutsRF, NutsLF, NutsRB, NutsLB, CapsRF, CapsLF, CapsRB, CapsLB, Inspect};
		
		job.variable = variableList;
		
		//Adding constraints 
		job.constraintA.add("AxleF");
		job.constraintB.add("WheelRF"); 
		job.constraintA.add("AxleB");
		job.constraintB.add("WheelRB"); 
		job.constraintA.add("AxleF");
		job.constraintB.add("WheelLF");
		job.constraintA.add("AxleB"); 
		job.constraintB.add("WheelLB");
		
		job.constraintA.add("WheelRF");
		job.constraintB.add("NutsRF");
		job.constraintA.add("WheelLF");
		job.constraintB.add("NutsLF");
		job.constraintA.add("WheelRB"); 
		job.constraintB.add("NutsRB");
		job.constraintA.add("WheelLB");
		job.constraintB.add("NutsLB");
		
		job.constraintA.add("NutsRF");
		job.constraintB.add("CapsRF");
		job.constraintA.add("NutsLF"); 
		job.constraintB.add("CapsLF");
		job.constraintA.add("NutsRB");
		job.constraintB.add("CapsRB");
		job.constraintA.add("NutsLB");
		job.constraintB.add("CapsLB");
		
	//	for(int i=0; i<job.constraintA.size(); i++){
		//	System.out.println("Constraint A" + job.constraintB.get(i));
		//}
		//Disjunctive Constraints 
		//job.constraintC.add("AxleB");
		//job.constraintD.add("AxleF");
		
		Solver solver = new Solver();
		job= solver.backtrack(job, 0);
		
		//printing assignment
		
		//System.out.println("variable length" + job.variable.length);
		for(int i=0; i<job.variable.length; i++){
			System.out.println("Time Start for Task " + job.variable[i].name + " is at minute " + job.variable[i].value);
		}	
		
	}
	
	
	public static void Queens() {
		CSP queen = new CSP();
		
		queen.problemType = 3;
		
		//take input from user for n
		int n = 6;
		HashSet domain = new HashSet();
		for(int i=1; i<=n; i++){
			domain.add(""+i);
		}
		
		//Variable col1 = new Variable("1", "4", domain); //n-queens has no solution with queen at corner 
		//Variable[] variableList = {col1};
		Variable[] variableList = {};

		for(int i=0; i<n; i++){
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
				System.out.println("col" + queen.variable[i].name + "=" + queen.variable[i].assignment);
			}
		}
		
	}

}
