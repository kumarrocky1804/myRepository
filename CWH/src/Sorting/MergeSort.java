package Sorting;

public class MergeSort 
{
	/* TIME COMPLEXITY - 
	 * Best Case - O(n log n)
	 * Average Case - O(n log n)
	 * Worst Case - O(n log n)
	 * Stable Algorithm - Yes
	 * In-Place Algorithm - No (Takes extra space)
	 * 
	 * It uses recursion approach and (divide and conquer) algorithm.
	 */
	
	/* we have to merge 2 already sorted arrays -
	 * arr[left] to arr[mid]
	 * arr[mid+1] to arr[right]
	 */
	static void merge(int[] arr, int left, int mid, int right)
	{
		int[] leftArray = new int[mid-left+1];
		int[] rightArray = new int[right-mid];
		
		int leftLength = mid-left+1;
		int rightLength = right-mid;
		
		// fill leftArray
		for (int i=0; i<leftLength; i++)
		{
			leftArray[i] = arr[left+i];
		}
		
		// fill right array
		for (int j=0; j<rightLength; j++)
		{
			rightArray[j] = arr[mid+1+j];
		}
		
		//index of 2 temp arrays
		int i=0,j=0;
		// index of main array
		int k = left;
		
		// if both have the element we need to compare
		while(i<leftLength && j<rightLength)
		{
			if(leftArray[i] <= rightArray[j])
			{
				arr[k] = leftArray[i];
				i++;
			}
			else
			{
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}
		
		//now check extra elements of left and right arraya
		while(i<leftLength)
		{
			arr[k] = leftArray[i];
			i++;k++;
		}
		
		while(j<rightLength)
		{
			arr[k] = rightArray[j];
			j++;k++;
		}
	}
	
	static void sort(int[] arr, int left, int right)
	{
		if(left < right)
		{
			int mid = left + (right-left)/2;
			
			// divide the array further from middle till only one element is left
			sort(arr,left,mid);
			sort(arr,mid+1,right);
			
			// start merging the divided arrays
			merge(arr,left,mid,right);
			
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
