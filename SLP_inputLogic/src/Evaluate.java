
import java.util.Stack;
import java.lang.Math;
/**
 * This class takes a postfix expression, then implements a stack in order to evaluate the expression and return a double.
 * The input string must be in the form "operand1 operand2 operator" with spaces denoting a new element of the expression.
 * The operands must be valid numbers, and the operands must be contained in the calc method.
 * This class assumes that the given string is formated correctly and therefore has no error handling. 
 */
public class Evaluate
{
 /**
 * main method for computing an expression string
 * @param input a valid postfix expression
 * @return evaluated double
 */
public static double evaluate(String input)
 {
  Stack<String> stack = new Stack<String>(); //Create a stack of strings where the operands are stored
  String[] array = input.split(" "); //Array is the input string split up into fields. The fields should be split so that each element is a complete operand or operator
  for(String str : array) //Loop for each string contained in the array
  {
   if(InfixToPostfix.isOperator(str) && !stack.empty()) //Check if the current string is an operator as defined in InfixToPostfix, and check if the stack isn't empty
   {
	String op1 = stack.pop(); //An operator will cause the topmost element of the stack to be popped, which will be the first operand
	if(!stack.empty()) //Make sure the stack is still not empty before popping
	{
	 String op2 = stack.pop(); //Pop the second operand
	 double result = calc(str, op1, op2); //Pass calc the operator, the 1st operand, and the second operand. 
	 stack.push("" +result);
    }
   }
   else
   {
    stack.push(str); //If str is not an operator, then str is an operand and should be pushed onto the stack. 
   }
  }
  
  double answer = Double.parseDouble(stack.pop()); //When completed, there should only be a single string in the stack, which should just be the resulting number
  return(answer);
 }
 
 /**
 *  The calc method handles evaluating a simple 2 operator 1 operand expression. 
 * @param operator The operation to be done on op1 and op2
 * @param op1 The first operand
 * @param op2 The second operand
 * @return the resulting double from the given expression
 */
public static double calc(String operator, String op1, String op2)
 {
  double num1 = Double.parseDouble(op1); //Convert op1 to a double
  double num2 = Double.parseDouble(op2); ///Convert op2 to a double
  switch(operator) //calculate the expression
  {
   case "+":
    return(num2 + num1);
   case "*":
	return(num2 * num1);
   case "/":
	return(num2 / num1);
   case "-":
	return(num2 - num1);
   case "^":
    return(Math.pow(num2,num1));
   default: //Default statement, should be redundant if given a valid string
	return(0);
  }
 }
}

