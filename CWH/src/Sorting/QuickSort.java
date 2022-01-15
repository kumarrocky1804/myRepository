package Sorting;

public class QuickSort 
{
	/* TIME COMPLEXITY - 
	 * Best Case - O(n log n)
	 * Average Case - O(n log n)
	 * Worst Case - O(n^2)
	 * Stable Algorithm - No
	 * In-Place Algorithm - Yes
	 * 
	 * It uses recursion approach and (divide and conquer) algorithm.
	 */
	
	// we have to find the position for pivot only and return its index
	static int partition(int[] arr, int low, int high)
	{
		/* In this implementation we are assuming the pivot is last element
		 * Other way can be to assume that pivot is the first element always.
		 * Better implementation can be to use median as pivot to reduce swapping
		 * Java - Arrays.sort() uses dual pivot Quick sort algorithm that has complexity - O(n log n)
		 */
		int pivot = arr[high];
		
		int indexPivot = low-1; // current assumed best position for pivot
		
		/* Finding best position for pivot in array from low to high-1
		 * because high is pivot right now
		 */
		for(int i=low; i<=high-1; i++)
		{
			//lower values should be in left
			if(arr[i] < pivot)
			{
				indexPivot++;
				//swap indexPivot and current index values
				int temp = arr[indexPivot];
				arr[indexPivot] = arr[i];
				arr[i] = temp;
			}
		}
		
		//swap indexPivot+1 and pivot index values to put pivot at right position
		indexPivot++;
		int temp = arr[indexPivot];
		arr[indexPivot] = arr[high];
		arr[high] = temp;
		
		return indexPivot;
	}
	
	static void sort(int[] arr, int low, int high)
	{
		if(low<high)
		{
			// after each iteration the pivot will contain the element at correct position
			int pivot = partition(arr,low,high);
			
			// Rest of the left and right arrays will be then sorted
			sort(arr,low,pivot-1);
			sort(arr,pivot+1, high);
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
		sort(arr,0,arr.length-1);
		display(arr);
	}
}
