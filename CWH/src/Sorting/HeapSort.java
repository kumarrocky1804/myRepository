package Sorting;

import DataStructures.Heap;

public class HeapSort 
{
	/* TIME COMPLEXITY - 
	 * Best Case - O(n log n)
	 * Average Case - O(n log n)
	 * Worst Case - O(n log n)
	 * Stable Algorithm - No
	 * In-Place Algorithm - Yes
	 * 
	 * It creates a heap and delete one by one
	 */
	
	// to make it inplace, heapify the array within same array.
	static void sort(int[] arr)
	{
		Heap heap = new Heap(arr.length);
		for(int i=0; i<arr.length; i++)
		{
			heap.insert(arr[i]);
		}
		for(int i=0; i<arr.length; i++)
		{
			arr[i] = heap.delete();
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
