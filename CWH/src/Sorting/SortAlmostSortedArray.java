package Sorting;

import DataStructures.Heap;

public class SortAlmostSortedArray {
	/* The problem is that the elements in array is atmost k elements away from their actual
	 * position in sorted array.
	 * 
	 * Example - Input : arr[] = {6, 5, 3, 2, 8, 10, 9}
     *       	 k = 3 
	 *			 Output : arr[] = {2, 3, 5, 6, 8, 9, 10}
	 */
	
	/* we can use insertion sort for this but most efficient is if we use heap of size k+1
	 * and extract min one by one.
	 */
	
	public static void sort(int[] arr, int k)
	{
		Heap heap = new Heap(k+1);
		
		// put first k+1 elements in heap
		int i=0;
		for(; i<k+1; i++)
			heap.insert(arr[i]);
		
		// for rest of elements, extract min, place it in array and add next element
		int index=0;
		for(;i<arr.length;i++)
		{
			arr[index] = heap.delete();
			index++;
			heap.insert(arr[i]);
		}
		
		// extract remaining element from heap
		for(;index<arr.length;index++)
			arr[index] = heap.delete();
	}
	
	public static void display(int[] arr)
	{
		System.out.println();
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i] + " -> ");
		}
	}
	
	
	public static void main(String[] args) {
		//int[] arr = {6, 5, 3, 2, 8, 10, 9};
		//int k=3;
		
		int[] arr = {10, 9, 8, 7, 4, 70, 60, 50};
		int k=4;
		
		display(arr);
		sort(arr,k);
		display(arr);
	}

}
