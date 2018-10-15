import java.util.HashSet;
import java.util.Set;

//Implements the CSP Abstract Interface
public class AustraliaMapCSP {

	//Variables in Australia CSP are each of the countries

	//Domain with type String
	Domain<String> domain = new Domain<String>();
	//Add red, blue, and green to the domain
	domain.add("red");
	domain.add("blue");
	domain.add("green");

	//Variables for the map, which would be the states and territories
	Variable WA = new Variable("WA", domain);
	Variable NT = new Variable("NT", domain);
	Variable Q = new Variable("Q", domain);
	Variable NSW = new Variable("NSW", domain);
	Variable V = new Variable("V", domain);
	Variable SA = new Variable("T", domain);

	//Will store the constraint set 
	Variable [][] constraintSet; 
	
	//This will add the constraints into a 2D array but does not actually check if the constraints were violated
	Constraint unequalconstraint = new Constraint("Australian Map Problem", constraintSet);
	unequalconstraint.addNotEqualConstraint(SA, WA, constraintSet); 
	unequalconstraint.addNotEqualConstraint(SA, NT, constraintSet); 
	unequalconstraint.addNotEqualConstraint(SA, Q, constraintSet); 
	unequalconstraint.addNotEqualConstraint(SA, NSW, constraintSet); 
	unequalconstraint.addNotEqualConstraint(SA, V, constraintSet);
	unequalconstraint.addNotEqualConstraint(WA, NT, constraintSet); 
	unequalconstraint.addNotEqualConstraint(NT, Q, constraintSet);
	unequalconstraint.addNotEqualConstraint(Q, NSW, constraintSet);
	unequalconstraint.addNotEqualConstraint(NSW, V, constraintSet);
	
	
	
	
	
	



}
