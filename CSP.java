import java.util.*;

//CSP is a graph class with a node
public class CSP {


	//a CSP has some variables(each with its own domain) and constraints
	Variable[] variable;
//	Constraint constraint;

	//constructor (unfinished...will finish -Priya)
	public CSP(Variable[] variable){
		int numberOfVariable = variable.size();
		Variable[] newArrayOfVariables = new Variable[numberOfVariable];

		//to do: copy contents of variable into newArrayOfVariables

		this.variable = newArrayOfVariables;
	//this.constraint = constraint;
	}


	//takes a csp and returns true if assignment is complete
	public boolean isComplete(){

		for(int i=0; i<variable.size(); i++){
			if(variable[i].assignment==null)
				return false;
		}

		return true;
	}

	//unfinished
	//takes a value from domain and returns true if it is consistent else false
	public boolean isConsistent(int index, T value){

	}

	/*Ruki's Part
		Problem #1 -> Tests to see if constraints have been violated for Austrailian Map Problem
		Variables [] variabes = variables with red/green/blue values in the Map Problem
	*/
		public boolean violationMap (Variable [] variables){
			//If the variables are complete
			if(isComplete()){
				for(int i = 0; i<variables.size(); i++){
					//Gets the values for each state
					//Assignment in this case would be if it is green, blue, or red
					if(variable[i].name.equals("SA")){
						String SAval = variables[i].assignment;
					}
					if(variable[i].name.equals("WA")){
						String WAval = variables[i].assignment;
					}
					if(variable[i].name.equals("NT")){
						String NTval = variables[i].assignment;
					}
					if(variable[i].name.equals("Q")){
						String Qval = variables[i].assignment;
					}
					if(variable[i].name.equals("NSW")){
						String NSWval = variables[i].assignment;
					}
					if(variable[i].name.equals("V")){
						String Vval = variables[i].assignment;
					}
					if(variable[i].name.equals("T")){
						String Tval = variables[i].assignment;
					}

					//Constraints

					//SA != WA
					if(SAval.equals(WAval)){ return false; }
					//SA != NT
					if(SAval.equals(NTval)){ return false; }
					//SA != Q
					if(SAval.equals(Qval)){ return false; }
					//SA != NSW
					if(SAval.equals(NSWval)){ return false; }
					//SA != V
					if(SAval.equals(Vval)){ return false; }
					//WA != NT
					if(WAval.equals(NTval)){ return false; }
					//NT != Q
					if(NTval.equals(Qval)){ return false; }
					//Q != NSW
					if(Qval.equals(NSWval)){ return false; }
					//NSW != V
					if(NSWval.equals(Vval)){ return false; }

					return true;
				}
			}
		}


		//Problem #2 -> Tests to see if the constraints have been violated for the Job Search Problem
		public boolean violateJob(Variables [] variables){
			//Tests to see if the set is isComplete
			if(isComplete()){
					for(int i = 0; i<variables.size(); i++){

						//Gets values of the variables
						if(variable[i].name.equals("AxleF")){
							int AxleF = variables[i].assignment;
						}
						if(variable[i].name.equals("AxleB")){
							int AxleB = variables[i].assignment;
						}
						if(variable[i].name.equals("WheelRF")){
							int WheelRF = variables[i].assignment;
						}
						if(variable[i].name.equals("WheelLF")){
							int WheelLF = variables[i].assignment;
						}
						if(variable[i].name.equals("WheelLB")){
							int WheelLB = variables[i].assignment;
						}
						if(variable[i].name.equals("WheelRB")){
							int WheelRB = variables[i].assignment;
						}
						if(variable[i].name.equals("NutsLF")){
							int NutsLF = variables[i].assignment;
						}
						if(variable[i].name.equals("NutsRB")){
							int NutsRB = variables[i].assignment;
						}
						if(variable[i].name.equals("NutsRF")){
							int NutsRF = variables[i].assignment;
						}
						if(variable[i].name.equals("NutsLB")){
							int NutsLB = variables[i].assignment;
						}
						if(variable[i].name.equals("CapLB")){
							int CapLB = variables[i].assignment;
						}
						if(variable[i].name.equals("CapLF")){
							int CapLF = variables[i].assignment;
						}
						if(variable[i].name.equals("CapRB")){
							int CapRB = variables[i].assignment;
						}
						if(variable[i].name.equals("CapRF")){
							int CapRF = variables[i].assignment;
						}
						if(variable[i].name.equals("Inspect")){
							int Inspect = variables[i].assignment;
						}

						//Constraints

						//Precedence Constraints && less than Inspect Total
						if(!(((AxleF + 10) <= WheelRF) && ((AxleF + 10)<= Inspect))) { return false; }
						if(!(((AxleB + 10) <= WheelRB)&& ((AxleB + 10)<= Inspect))) { return false; }
						if(!(((AxleF + 10) <= WheelLF)&& ((AxleF + 10)<= Inspect))) { return false; }
						if(!(((AxleB + 10) <= WheelLB)&& ((AxleF + 10)<= Inspect))) { return false; }

						if(!(((WheelRF +1) <= NutsRF)&& ((AxleF + 10)<= Inspect))){ return false; }
						if(!(((WheelLF +1) <= NutsLF)&& ((AxleF + 10)<= Inspect))){ return false; }
						if(!(((WheelRB +1) <= NutsRB)&& ((AxleF + 10)<= Inspect))){ return false; }
						if(!(((WheelLB +1) <= NutsLB)&&((AxleF + 10) <= Inspect))){ return false; }

						if(!(((NutsRF+2) <= CapRF)&& ((AxleF + 10)<= Inspect))) { return false; }
						if(!(((NutsLF+2) <= CapLF)&& ((AxleF + 10)<= Inspect))) { return false; }
						if(!(((NutsRB+2) <= CapRB)&& ((AxleF + 10)<= Inspect))) { return false; }
						if(!(((NutsLB+2) <= CapLB)&& ((AxleF + 10)<= Inspect))) { return false; }

						//Disjunctive Constraints
						if(!(((AxleF+10)<= AxleB)|| (AxleB +10 <= AxleF))) { return false; }

						//Else return true
						return true; 
					}
			}
		}
}
