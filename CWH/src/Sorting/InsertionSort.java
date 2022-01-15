package Sorting;

public class InsertionSort 
{
	/* TIME COMPLEXITY - 
	 * Best Case - O(n)
	 * Average Case - O(n^2)
	 * Worst Case - O(n^2)
	 * Stable Algorithm - Yes
	 * In-Place Algorithm - Yes
	 * 
	 */
	
	static void sort(int[] arr)
	{
		int currNum,start;
		
		for(int i=0; i<arr.length; i++)
		{
			currNum = arr[i];
			start = i;
			
			// array until start is already sorted, so find the place for currNum
			// and put the number there
			while(start > 0 && arr[start-1]>currNum)
			{
				arr[start] = arr[start-1];
				start--;
			}
			arr[start] = currNum;
		}
	}
	
	static void display(int[] arr)
	{
		System.out.println();
		for(int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i] + " -> ");
		}
	}
	
	public static void main(String[] args) {
		//int[] arr = {1,2,3,4,5,6};
		int[] arr = {6,5,4,3,2,1};
		
		display(arr);
		sort(arr);
		display(arr);
		
	}
}
