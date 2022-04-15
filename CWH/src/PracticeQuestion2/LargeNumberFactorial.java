package PracticeQuestion2;

/**
 * The problem is to find factorial of a large number like 100 which cannot be stored in any
 * data type.
 * 
 * Solution- we are going to use array for the same
 * @author rocky.kumar
 *
 */

public class LargeNumberFactorial 
{
	public static void factorial(int n)
	{
		int[] res = new int[500];
		res[0] = 1;
		int resSize = 1;
		
		// array will store the result in reverse
		for(int i=2; i<=n; i++)
			resSize = multiply(res,i,resSize);
		
		for(int i=resSize-1; i>=0; i--)
		{
			System.out.print(res[i]);
		}
	}
	
	// multiply res[] with n and return resSize
	public static int multiply(int[] res, int n, int resSize)
	{
		int carry = 0;
		int temp = 1;
		for(int i=0; i<resSize; i++)
		{
			temp = res[i] * n + carry;
			res[i] = temp%10;
			carry = temp/10;
		}
		
		// if there is any carry left over - 
		while(carry != 0)
		{
			res[resSize] = carry%10;
			carry = carry/10;
			resSize++;
		}
		
		return resSize;
	}
	
	public static void main(String[] args) {
		//factorial(100);
		factorial(0);
	}
}
