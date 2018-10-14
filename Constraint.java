import java.util.ArrayList;

//Constraint Class
public class Constraint  {

	//Create 2D array to hold the constraints for the australian map problem
	Variable [][] notequal = new Variable[10][10];
	Variable [] constraint = new Variable[2];

	//Adds to the list of constraints -> returns a 2d array that contains the set of unequal constraints 
	public Variable [][] addNotEqualConstraint(Variable state1, Variable state2){
		//Add to the array
		constraint[0] = state1;
		constraint[1] = state2;

		//Probably should think of another way to add things to the 2d array
		for(int i= 0; i < notequal.length; i++) {
			for(int j = 0; j<notequal.length;j++) {
				if(notequal[i][j].equals(null)) {
					//Not sure why this is giving an error
					notequal[i][j] = constraint;
				}
			}
		}
		return notequal;
	}

}
