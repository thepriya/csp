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

	Constraint unequalconstraint = new Constraint();
	unequalconstraint.addNotEqualConstraint(SA, WA); 
	unequalconstraint.addNotEqualConstraint(SA, NT); 
	unequalconstraint.addNotEqualConstraint(SA, Q); 
	unequalconstraint.addNotEqualConstraint(SA, NSW); 
	unequalconstraint.addNotEqualConstraint(SA, V);
	unequalconstraint.addNotEqualConstraint(WA, NT); 
	unequalconstraint.addNotEqualConstraint(NT, Q);
	unequalconstraint.addNotEqualConstraint(Q, NSW);
	unequalconstraint.addNotEqualConstraint(NSW, V); 
	
	
	
	



}
