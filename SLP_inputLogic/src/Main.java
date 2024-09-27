
public class Main
{
public static void main(String [] args)
 {
   String str = "((8+3^2)/(5*7+2))+(6^3/(4+9*2))-((3+5)/(2^3*7))";
   InfixToPostfix postfix = new InfixToPostfix();
   String endstring = postfix.infixToPostfix(str);
   System.out.println("result =" + endstring);
   double result = Evaluate.evaluate(endstring);
   System.out.println("Answer = " + result);
 }
}
