import java.util.HashSet;
import java.util.Set;

//Implementing the CSP interface
public class NQueensCSP implements CSP{

    //Domain with type String
	Domain<int> domain = new Domain<int>();
	//Add Queen and Empty to domain
	domain.add(1);
	domain.add(0);

	//Variables for the board, consists of all possible board states
    Variable OneA = new Variable("OneA", domain);
    Variable OneB = new Variable("OneB", domain);
    Variable OneC = new Variable("OneC", domain);
    Variable OneD = new Variable("OneD", domain);
    Variable OneE = new Variable("OneE", domain);
    Variable OneF = new Variable("OneF", domain);
    Variable OneG = new Variable("OneG", domain);
    Variable OneH = new Variable("OneH", domain);

    Variable TwoA = new Variable("TwoA", domain);
    Variable TwoB = new Variable("TwoB", domain);
    Variable TwoC = new Variable("TwoC", domain);
    Variable TwoD = new Variable("TwoD", domain);
    Variable TwoE = new Variable("TwoE", domain);
    Variable TwoF = new Variable("TwoF", domain);
    Variable TwoG = new Variable("TwoG", domain);
    Variable TwoH = new Variable("TwoH", domain);

    Variable ThreeA = new Variable("ThreeA", domain);
    Variable ThreeB = new Variable("ThreeB", domain);
    Variable ThreeC = new Variable("ThreeC", domain);
    Variable ThreeD = new Variable("ThreeD", domain);
    Variable ThreeE = new Variable("ThreeE", domain);
    Variable ThreeF = new Variable("ThreeF", domain);
    Variable ThreeG = new Variable("ThreeG", domain);
    Variable ThreeH = new Variable("ThreeH", domain);

    Variable FourA = new Variable("FourA", domain);
    Variable FourB = new Variable("FourB", domain);
    Variable FourC = new Variable("FourC", domain);
    Variable FourD = new Variable("FourD", domain);
    Variable FourE = new Variable("FourE", domain);
    Variable FourF = new Variable("FourF", domain);
    Variable FourG = new Variable("FourG", domain);
    Variable FourH = new Variable("FourH", domain);

    Variable FiveA = new Variable("FiveA", domain);
    Variable FiveB = new Variable("FiveB", domain);
    Variable FiveC = new Variable("FiveC", domain);
    Variable FiveD = new Variable("FiveD", domain);
    Variable FiveE = new Variable("FiveE", domain);
    Variable FiveF = new Variable("FiveF", domain);
    Variable FiveG = new Variable("FiveG", domain);
    Variable FiveH = new Variable("FiveH", domain);

    Variable SixA = new Variable("SixA", domain);
    Variable SixB = new Variable("SixB", domain);
    Variable SixC = new Variable("SixC", domain);
    Variable SixD = new Variable("SixD", domain);
    Variable SixE = new Variable("SixE", domain);
    Variable SixF = new Variable("SixF", domain);
    Variable SixG = new Variable("SixG", domain);
    Variable SixH = new Variable("SixH", domain);

    Variable SevenA = new Variable("SevenA", domain);
    Variable SevenB = new Variable("SevenB", domain);
    Variable SevenC = new Variable("SevenC", domain);
    Variable SevenD = new Variable("SevenD", domain);
    Variable SevenE = new Variable("SevenE", domain);
    Variable SevenF = new Variable("SevenF", domain);
    Variable SevenG = new Variable("SevenG", domain);
    Variable SevenH = new Variable("SevenH", domain);

    Variable EightA = new Variable("EightA", domain);
    Variable EightB = new Variable("EightB", domain);
    Variable EightC = new Variable("EightC", domain);
    Variable EightD = new Variable("EightD", domain);
    Variable EightE = new Variable("EightE", domain);
    Variable EightF = new Variable("EightF", domain);
    Variable EightG = new Variable("EightG", domain);
    Variable EightH = new Variable("EightH", domain);

	Constraint constraint = new Constraint();

}