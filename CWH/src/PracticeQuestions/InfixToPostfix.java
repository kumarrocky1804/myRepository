package PracticeQuestions;

import java.util.Stack;

public class InfixToPostfix 
{
	public static int precedence(char operator)
	{
		switch(operator)
		{
		case '+': return 1;
		case '-': return 1;
		case '*': return 2;
		case '/': return 2;
		case '^': return 3;
		/* we are returning less precedence for "(" and ")" as well */
		default: return -1;
		}
	}

	public static String Infix2Postfix(String infix)
	{
		Stack<Character> stack = new Stack<Character>();
		String postfix = "";
		for(int i=0; i<infix.length();i++)
		{
			// if not operator
			if(infix.charAt(i) != '+' && infix.charAt(i) != '-' &&
					infix.charAt(i) != '*' && infix.charAt(i) != '/' && infix.charAt(i) != '^'&&
					infix.charAt(i) != '(' && infix.charAt(i) != ')')
			{
				postfix = postfix + infix.charAt(i);
			}
			else if(infix.charAt(i) == '(')
			{
				stack.push(infix.charAt(i));
			}
			else if(infix.charAt(i) == ')')
			{
				char stackElement = stack.pop();
				while(stackElement != '(')
				{
					postfix = postfix + stackElement;
					stackElement = stack.pop();
				}
			}
			// if it is operator
			// if stack is empty
			else if(stack.isEmpty())
			{
				stack.push(infix.charAt(i));
			}
			// if current character has higher precedence, push it
			else if(precedence(infix.charAt(i))>precedence(stack.peek())/*|| 
					stack.peek() == '('*/)
			{
				stack.push(infix.charAt(i));
			}
			// if current character has lesser precedence
			else
			{
				while(precedence(stack.peek())>=precedence(infix.charAt(i))/*||
						stack.peek()!= '('*/)
				{
					postfix = postfix + stack.pop();
					if(stack.isEmpty())
						break;
				}
				stack.push(infix.charAt(i));
			}
		}

		while(!stack.isEmpty())
		{
			postfix = postfix + stack.pop();
		}
		return postfix;
	}
	
	public static int evaluate(String postfix)
	{
		Stack<Integer> stack = new Stack<Integer>();
		int temp;
		for(int i=0; i<postfix.length();i++)
		{
			if(postfix.charAt(i)=='+')
			{
				temp = stack.pop() + stack.pop();
				stack.push(temp);
			}
			else if(postfix.charAt(i)=='*')
			{
				temp = stack.pop() * stack.pop();
				stack.push(temp);
			}
			else if(postfix.charAt(i)=='-')
			{
				temp = stack.pop();
				temp = stack.pop() - temp;
				stack.push(temp);
			}
			else if(postfix.charAt(i)=='/')
			{
				temp = stack.pop();
				temp = stack.pop() / temp;
				stack.push(temp);
			}
			else if(postfix.charAt(i)=='^')
			{
				temp = stack.pop();
				temp = stack.pop()^temp;
				stack.push(temp);
			}
			else
			{
				stack.push(Character.getNumericValue(postfix.charAt(i)));
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) 
	{	
		String infix = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println("Infix - ");
		System.out.println(infix);
		System.out.println("PostFix - ");
		System.out.println(Infix2Postfix(infix));
		String postfix = "231*+9-";
		System.out.println(evaluate(postfix));
	}
}
