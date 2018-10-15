import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//Domain of CSP -> Make it a generic type
public class Domain<T>{

	//Domain is a set of values
	//Use hashset b/c easy to remove and add values -> takes constant time
	Set<T> domain;


	public Domain() {
		domain = new HashSet<T>(); 
	}

	public void add(T value) {
		domain.add(value);
	}




}

