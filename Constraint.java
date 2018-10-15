import java.util.ArrayList;

//Constraint Class
public class Constraint  {
	
	/*The constraint class is a 2D array that contains the set of values in the constraint comparison. 
	 * Australian Map Problem: Constructor creates a 2D array of the size 2x9 where each row contains the two nodes
	 * that cannot be next to each other. In the AddNotEqualConstraint method, it adds the elements into the array as such: {{SA, VT}, {VT, WA} ...} (random states)
	 * 
	 * Job Search Problem: Constructor creates TWO 2D arrays of the size 3x12 and 3x2. The first set constraints the constraints relating to precedence.
	 * The second set contains constraints related to disjunctive constraints. Each row contains the first value, then the time, then the second value. 
	 * For example, Axles + 10 < Wheel, where axle = the first value, 10 = time, and wheel = second value. Similarly, the method add precedence and add disjunct
	 * puts such into the 2D array. 
	 * 
	 */

	
	Variable empty = new Variable("empty");
	
	//Holds the constraints 
	Variable[][] constraintMapSet;
	Variable[][] constraintJobSet; 
	Variable[][] disjunctiveJobSet; 
		
	public Constraint(String type) {
		super();
		this.constraintSet = constraintSet; 
		this.disjunctiveSet = disjunctiveSet;
		//Problem #1
		if(type.equals("Australian Map Problem")) {
			//Create 2D array to hold the constraints for the australian map problem -> should have 9 constraint values each with 2 set values 
			constraintSet = new Variable[2][9];
			//Initialize the 2D array to empty 
			for(int i= 0; i < constraintSet.length; i++) {
				for(int j = 0; j<constraintSet.length;j++) {
					constrain tSet[i][j] = empty; 
				}
			}
		}
		//Problem #2
		if (type.equals("Job Search Problem")) {
			//2D array to hold constraint (pg 205) 
			constraintSet = new Variable[3][12];
			//Initialize the 2D array to empty 
			for(int i= 0; i < constraintJobSet.length; i++) {
				for(int j = 0; j<constraintJobSet.length;j++) {
					constraintSet[i][j] = empty; 
				}
			}
			//For the disjunctive constraint 
			disjunctiveSet = new Variable[3][2];
			//Initialize the 2D array to empty 
			for(int i= 0; i < disjunctiveJobSet.length; i++) {
				for(int j = 0; j<disjunctiveJobSet.length;j++) {
					precedence[i][j] = empty; 
				}
			}
		}
	}
	

	//Adds to the list of constraints -> returns a 2d array that contains the set of unequal constraints 
	public Variable[][] addNotEqualConstraint(Variable state1, Variable state2){
		//Probably should think of another way to add things to the 2d array
		for(int i= 0; i < constraintSet.length; i++) {
			for(int j = 0; j<constraintMapSet.length;j++) {
				if(constraintMapSet[i][j].value.equals("empty")) {
					//Not sure why this is giving an error
					constraintMapSet[i][j] = state1; 
					constraintMapSet[i][j+1] = state2; 
				}
			}
		}
		return constraintSet;
	}	
	
	//For problem 2, will add the left value then variable to be added then right value -> returns a 2d array that contains the set of unequal constraints 
	//PRECEDENCE
	public void addPrecedenceConstraint(Variable task1, Variable time, Variable task2){
		for(int i = 0; i<constraintJobSet.length;i++) {
			for(int j = 0; j<constraintJobSet; j++) {
				if(constraintJobSet[i][j].value.equals("empty")) {
					//Not sure why this is giving an error
					constraintJobSet[i][j] = task1; 
					constraintJobSet[i][j+1] = time; 
					constraintJobSet[i][j+2] = task2; 
				}
			}
		}
	}
	
	//DISJUNCTIVE
	public void addDisjunctiveConstraint(Variable task1, Variable time, Variable task2){
		for(int i = 0; i<disjunctiveJobSet.length;i++) {
			for(int j = 0; j<disjunctiveJobSet; j++) {
				if(disjunctiveJobSet[i][j].value.equals("empty")) {
					//Not sure why this is giving an error
					disjunctiveJobSet[i][j] = task1; 
					disjunctiveJobSet[i][j+1] = time; 
					disjunctiveJobSet[i][j+2] = task2; 
				}
			}
		}
	}
	


}