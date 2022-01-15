package Searching;

public class BinarySearchArray 
{
	/* Linear search has linear complexity
	 * Binary search has complexity - O(log n)
	 * Condition for this logic to work is
	 * the array should be sorted in increasing order
	 */
	static int BinarySearch(int[] arr,int ele)
	{
		int lowIndex = 0;
		int highIndex = arr.length-1;
		int midIndex;
		int foundIndex=-1;
		
		while(lowIndex <= highIndex)
		{
			midIndex = (lowIndex + highIndex)/2;
			if(ele == arr[midIndex])
			{
				foundIndex = midIndex;
				break;
			}
			else if(ele > arr[midIndex])
			{
				lowIndex = midIndex + 1;
			}
			else
			{
				highIndex = midIndex - 1;
			}
		}
		
		return foundIndex;
	}
	
	static int BinarySearch(int[] arr, int ele, int lower, int upper)
	{
		int mid = (lower + upper)/2;
		int foundIndex=-1;
		
		if(arr[mid] == ele)
		{
			foundIndex = mid;
			return foundIndex;
		}
		else if(lower > upper)
		{
			return foundIndex;
		}
		else if(ele > arr[mid])
		{
			return BinarySearch(arr,ele,mid+1,upper);
		}
		else
		{
			return BinarySearch(arr,ele,lower,mid-1);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		//System.out.println(BinarySearch(arr,2));
		System.out.println(BinarySearch(arr,11,0,arr.length - 1));
	}
}
