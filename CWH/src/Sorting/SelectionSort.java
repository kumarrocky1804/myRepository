package Sorting;

public class SelectionSort 
{
	/* TIME COMPLEXITY - 
	 * Best Case - O(n^2)
	 * Average Case - O(n^2)
	 * Worst Case - O(n^2)
	 * Stable Algorithm - NO
	 * In-Place Algorithm - Yes
	 * 
	 */
	
	static void sort(int[] arr)
	{
		int minIndex;
		for(int i=0; i<arr.length-1; i++)
		{
			//currently lets say min is ith number
			minIndex = i;
			//find new min and if found replace it
			
			for(int j = i+1; j<arr.length; j++)
			{
				if(arr[j] < arr[minIndex])
				{
					minIndex = j;
				}
			}
			
			// if minIndex is changed, swap the numbers
			if(minIndex != i)
			{
				int temp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i] = temp;
			}
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
		int[] arr = {1,2,3,4,5,6};
		//int[] arr = {6,5,4,3,2,1};
		
		display(arr);
		sort(arr);
		display(arr);
		
	}
}
