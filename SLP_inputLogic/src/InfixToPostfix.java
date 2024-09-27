

import java.util.Stack;
/**
 *  This class is responsible for converting a given infix expression string into a postfix expression string. 
 * The infix string must have spaces between each element of the expression in order to separate elements.
 * This program doesn't check if the infix expression actually contains any numbers.  
 */
public class InfixToPostfix
{
 /**
  * infixToPostfix is the main method for converting infix to postfix. It implements a stack in order to sort operators.
  * The stack must have the highest priority operator at the top, since it is done first
  * @param input An infix expression string
  * @return A postfix expression string
  */
 public String infixToPostfix(String input)
 {
  Stack<String> stack = new Stack<String>(); //Create a stack for storing operators
  String regex = "(?<=[-+*/()^])(?=.)|(?<=.)(?=[-+*/()^])"; //regex to split input into numbers and operators
  String[] array = input.split(regex); //Split the given infix expression into smaller strings containing operators and operands
  String expression = ""; //create an empty string for the postfix expression
  for(String str : array) //Run for each string in the array
  {
   if (str.equals ("(")) //If the string is an open parenthesis, push it onto the stack, since it has the highest priority
   {
	stack.push(str);
   }
   else if (str.equals(")")) //If the string is a closed parenthesis, pop the stack until you see an open parenthesis
   {
    while(!stack.empty() && !stack.peek().equals("("))
	{
	 expression = expression + " " + stack.pop(); //Add whatever is in the stack to the postfix expression
	}
    if (!stack.empty()) //pop the open parenthesis, but don't add it to the string
    {
     stack.pop();
    }
   }
   else if (isOperator(str)) //Check if the string is a recognized operator
   {
	while(!stack.empty() && (priority(str) <= priority(stack.peek()))) //Check if the priority of the string is less than the priority of the top of the stack
	{
    if(stack.peek().equals("(")) //If the string is an open parenthesis, don't do anything
     {
      break; 
     }
     else
     {
      expression = expression + " " + stack.pop(); //The string is a higher priority than the top of the stack, so pop until the top of stack has a higher priority
     }
	}
	stack.push(str); //push the operator onto the stack
   }
   else
   {
	expression = expression + " " + str; //if the string is not an operator, add it to the expression. 
   }
  }
  while(!stack.empty()) //Pop every element of the stack in order to complete the expression
  {
   if(stack.peek().equals("(")) //don't add parenthesis to the expression
   {
    stack.pop(); 
   }
   else
   {
    expression = expression + " " + stack.pop(); //add the string to the expression
   }
  }
  return(expression); //return the postfix expression
 }
 
 /**
  * The priority method is where the class assigns a priority to operators
  * @param operator The given operator string
  * @return the priority of the operator
  */
 public static int priority(String operator)
 {
  switch (operator)
   {
    case "+": //addition and subtraction have the lowest priority
    case "-":
     return(1);
    case "*": //multiplication and division have higher priority than addition and subtraction, but lower than exponentiation. 
    case "/":
     return(2);
    case "^": //exponentiation is the highest priority operator
     return(3);
    default:
     return(4);
  }
 }
 /**
  * isOperator determines if a given string is an operator. It is also where operators are assigned 
  * @param operator a string to be checked if it is an operator
  * @return True if the string is recognized, false if not. 
  */
 static public boolean isOperator(String operator) 
 {
  switch(operator)
  {
   case "+":
   case "-":
   case "*":
   case "/":
   case "^":
   case "(": //Doesn't need to be here, nice for documentation 
   return(true);
  default:
   return(false);
  }
 }
}

 
