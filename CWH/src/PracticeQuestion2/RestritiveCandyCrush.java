package PracticeQuestion2;

import java.util.Stack;

/**
 * Choose a group of K consecutive identical characters and remove them from the string.
 * SOlution - Use stack to store the character and its count
 * 
 * LINK - https://www.geeksforgeeks.org/reduce-the-string-by-removing-k-consecutive-identical-characters/
 * @author rocky.kumar
 */

public class RestritiveCandyCrush 
{
	static class candy
	{
		char ch;
		int count;
		
		candy(char ch, int count)
		{
			this.ch = ch;
			this.count = count;
		}
	}
	
	public static String candyCrush(String str, int k)
	{
		Stack<candy> stack = new Stack<candy>();
		
		// base case
		if(k==1)
			return "";
		
		for(int i=0; i<str.length(); i++)
		{
			char ch = str.charAt(i);
			
			if(stack.isEmpty())
			{
				stack.push(new candy(ch,1));
				continue;
			}
			
			// if current element is same as stack's top element
			if(stack.peek().ch == ch)
			{
				// increase the count
				candy candy = stack.peek();
				candy.count++;
				
				// pop the character
				stack.pop();
				
				// if count has become k, then character should not be pushed back
				// else push back with increased count
				if(candy.count==k)
					continue;
				else
					stack.push(candy);
			}
			//else push the character with count as 1
			else
			{
				stack.push(new candy(ch,1));
			}
		}
		// now stack has final string in reverse order with count
		StringBuilder builder = new StringBuilder();
		while(!stack.isEmpty())
		{
			candy candy = stack.pop();
			
			while(candy.count-->0)
				builder.append(candy.ch);
		}
		builder = builder.reverse();
		return builder.toString();
	}
	
	public static void main(String[] args) {
		String str = "geeksforgeeks";
		//String str = "geegsforgeeks";
		//String str = "qdxxxdd";
		System.out.println(candyCrush(str, 2));
	}
}
