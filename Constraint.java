import java.util.ArrayList;

//Constraint Class
public class Constraint  {

	//Create 2D array to hold the constraints for the australian map problem -> should have 9 constraint values each with 2 set values 
	Variable [][] notequal = new Variable[2][9];
	Variable empty = new Variable("empty");
	
	
	public Constraint() {
		super();
		//Initialize the 2D array to null 
		for(int i= 0; i < notequal.length; i++) {
			for(int j = 0; j<notequal.length;j++) {
				notequal[i][j] = empty; 
			}
		}
	}

	//Adds to the list of constraints -> returns a 2d array that contains the set of unequal constraints 
	public Variable [][] addNotEqualConstraint(Variable state1, Variable state2){

		//Probably should think of another way to add things to the 2d array
		for(int i= 0; i < notequal.length; i++) {
			for(int j = 0; j<notequal.length;j++) {
				if(notequal[i][j].value.equals("empty")) {
					//Not sure why this is giving an error
					notequal[i][j] = state1; 
					notequal[i][j+1] = state2; 
					System.out.println(notequal[i][j]);
				}
			}
		}
		return notequal;
	}	

}