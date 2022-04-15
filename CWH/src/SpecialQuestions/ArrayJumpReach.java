package SpecialQuestions;

/**
 * The problem is to reach the end of the array with arr[i] showing the maximum jump
 * it can make in the array.
 * 
 * Solution - Greedy algorithm
 * @author rocky.kumar
 *
 */

public class ArrayJumpReach 
{
	static int canReach(int[] a, int n) {
        // code here
        int i=0, jump=0;
        
        // if reached second last element  and this element is not 0, we are fine
        while(i<n-1)
        {
        	// initialize first jump
            if(i==0)
            {
                jump = a[i];
            }
            
            if(a[i] == 0 && jump==0)
                return 0;
            
            // max jump will be remaining energy from previous jumps or current jump
            jump = Math.max(a[i],jump);
            
            // reduce jump energy by 1
            jump--;
            
            i++;
        }
        return 1;
    }
	
	public static void main(String[] args) {
		int[] arr = new int[] {5,9,0,3,0,0,3,2,0,0};
		
		System.out.println("Can reach last element - " + canReach(arr, arr.length));
	}
}
