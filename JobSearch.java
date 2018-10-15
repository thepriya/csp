
public class JobSearch {
	/*Domain for job search is the time it takes to complete the task, considering inspection is 3 minutes
	the max a search can be is 27 minutes, hence falls in the range between 1-27 
	*/
	//Domain
	Domain jobDomain = new Domain(); 
	
	//This is giving an error, pretend like this is working atm 
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
	
	//Variables = parts of the car assembly 
	Variable AxleF = new Variable("AxleF", jobDomain);
	Variable AxleB = new Variable("AxleB", jobDomain);
	Variable WheelRF = new Variable("WheelRF", jobDomain);
	Variable WheelLF = new Variable("WheelLF", jobDomain);
	Variable WheelLB = new Variable("WheelLB", jobDomain);
	Variable WheelRB = new Variable("WheelRB", jobDomain);
	Variable NutsRF = new Variable("NutsRF", jobDomain);
	Variable NutsLF = new Variable("NutsLF", jobDomain);
	Variable NutsRB = new Variable("NutsRB", jobDomain);
	Variable NutsLB = new Variable("NutsLB", jobDomain);
	Variable CapRF = new Variable("CapRF", jobDomain);
	Variable CapLF = new Variable("CapLF", jobDomain);
	Variable CapRB = new Variable("CapRB", jobDomain);
	Variable CapLB = new Variable("CapLB", jobDomain);
	Variable Inspect = new Variable("Inspect", jobDomain);
	
	//Constraints 
	
	//To store the constraints 
	Variable [][] constraintSetJob; 
	Constraint jobConstraint = new Constraint("Job Search Problem", constraintSetJob);
	jobConstraint.add()
	

	
	
}
