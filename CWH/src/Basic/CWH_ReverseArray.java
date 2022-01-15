package Basic;

import java.util.Scanner;

public class CWH_ReverseArray {

	// Reverse an array without using another array
	// Optimize it to use less memory
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		int length;
		System.out.println("Enter the length of an array:");
		length = sc.nextInt();
		int[] arr = new int[length];
		System.out.println("Enter the elements of the array:");
		for(int i=0; i<length; i++)
		{
			arr[i] = sc.nextInt();
		}
		
		System.out.println("The array you entered is :");
		for(int ele: arr)
		{
			System.out.println(ele);
		}
		
		// MAIN LOGIC
		for(int i=0; i<Math.floorDiv(length, 2); i++)
		{
			// SWAP THE ELEMENTS
			/*temp = arr[i];
			arr[i] = arr[length-i-1];
			arr[length-i-1] = temp;*/
			
			arr[i] = arr[i] + arr[length-i-1];
			arr[length-i-1] = arr[i] - arr[length-i-1];
			arr[i] = arr[i] - arr[length-i-1];
		}
		
		System.out.println("THE ELEMENTS IN REVERSE ORDER IS :");
		for(int ele: arr)
		{
			System.out.println(ele);
		}
		sc.close();
	}
}
