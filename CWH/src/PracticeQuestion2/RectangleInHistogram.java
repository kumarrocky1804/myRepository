package PracticeQuestion2;

import java.util.Stack;

/**
 * The problem is to find the rectangle in histogram with max area.
 * 
 * LINK - https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 * 
 * Solution - we are using stack. Max area with current bar will be current bar length multiplied
 *            by the difference in indices of lesser bar than it on its right and left.
 *            stack will carry the lesser bar indices from left and i in the loop will carry
 *            lesser bar indices from right.
 * @author rocky.kumar
 *
 */

public class RectangleInHistogram 
{
	static int getMaxArea(int hist[], int n)
    {
        // Create an empty stack. The stack holds indexes of hist[] array
        // The bars stored in stack are always in increasing order of their
        // heights. Stack will store indices not the actual value so that, we
		// can calculate area by comparing indices
        Stack<Integer> stack = new Stack<Integer>();
         
        int max_area = 0; // Initialize max area
        int top;  // To store top of stack
        int area_with_top; // To store area with top bar as the smallest bar
        
        // Run a loop for all elements of the array
        int i=0;
        while(i<n)
        {
        	// if stack is empty or current bar is higher than top of stack
        	if(stack.isEmpty() || hist[i]>=hist[stack.peek()])
        	{
        		stack.push(i);
        		i++;
        	}
        	
        	// otherwise, the next bar is lower than current stack top
        	// so, pop the top element and calculate the max area with that bar
        	// do not increment i, so that the loop continues to do it for rest
        	// of the stack elements too until current bar is greater than top bar
        	// of stack
        	else
        	{
        		top = stack.pop();
        		
        		// calculation of area, remember if there is any element in the 
        		// stack, they are smaller that top element
        		// stack.peek() will tell the smaller element on the left
        		// and i will tell the smaller element on the right
        		area_with_top = hist[top] * (stack.isEmpty() ? i : i-stack.peek()-1);
        		
        		if(max_area<area_with_top)
        			max_area = area_with_top;
        	}
        }
        
        // do the same for any elements left in the stack
        while(!stack.isEmpty())
        {
        	top = stack.pop();
    		
    		// calculation of area, remember if there is any element in the 
    		// stack, they are smaller that top element
    		
    		area_with_top = hist[top] * (stack.isEmpty() ? i : i-stack.peek()-1);
    		
    		if(max_area<area_with_top)
    			max_area = area_with_top;
        }
        
        return max_area;
 
    }
     
    // Driver program to test above function
    public static void main(String[] args)
    {
        int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
        System.out.println("Maximum area is " + getMaxArea(hist, hist.length));
    }
}
