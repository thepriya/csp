import java.util.HashSet;
import java.util.Set;
import com.sun.org.apache.xpath.internal.operations.Variable;
import java.util.Iterator;
import java.util.Set;

//Implementing the CSP interface
public class NQueensCSP implements CSP{
    int n = 8;
    //Domain with type int
	Domain<int> domain = new Domain<int>();
	//Add Queen and Empty to domain
	for(int i = 1; i <= n; i++){
        domain.add(i);
    }

	
    Set<Variable> variables = new HashSet<Variable>();
    for(int j = 1; j <= n; j++){
        variables.add(new Variable(("Column" + Integer.toString(j)),domain));
    }

	Constraint constraint = new Constraint();

}