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
	
	//In place heap-sort
	public static void sortInPlace(int[] arr)
	{
		//rearrange the array as heap, last parent and go upwards
		for(int i=(arr.length-2)/2;i>=0;i--)
		{
			// more like heapify_delete, top to bottom approach
			heapify(arr,arr.length-1,i);
		}
		// now array is rearranged as max heap
		// we will exchange the first element with last and apart from last element heapify everyone
		for(int i=arr.length-1; i>0; i--)
		{
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			heapify(arr,i-1,0);
		}
	}
	
	// we are creating max heap
	public static void heapify(int[] arr, int lastIndex, int index)
	{
		int leftChild = index*2+1;
		int rightChild = index*2+2;
		
		if(leftChild>lastIndex&&rightChild>lastIndex)
			return;
		
		int largest=index;
		
		if(leftChild<=lastIndex&&arr[leftChild]>arr[largest])
			largest = leftChild;
		
		if(rightChild<=lastIndex&&arr[rightChild]>arr[largest])
			largest = rightChild;
		
		if(largest!=index)
		{
			int temp = arr[largest];
			arr[largest] = arr[index];
			arr[index] = temp;
			
			heapify(arr,lastIndex,largest);
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
	
	/* Find k largest elements from array */
	public static void largest(int[] arr,int k)
	{
		//rearrange the array as heap, last parent and go upwards
		for(int i=(arr.length-2)/2;i>=0;i--)
		{
			// more like heapify_delete, top to bottom approach
			heapify(arr,arr.length-1,i);
		}
		// now array is rearranged as max heap
		// we will exchange the first element with last and apart from last element heapify everyone
		for(int i=arr.length-1; i>(arr.length-1)-k; i--)
		{
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			heapify(arr,i-1,0);
		}
		
		for(int i=arr.length-1;i>=(arr.length-1)-(k-1);i--)
		{
			System.out.println(arr[i] + ", ");
		}
	}
	
	public static void main(String[] args) {
		//int[] arr = {1,2,3,4,5,6};
		int[] arr = {6,5,4,3,2,1};
		
		display(arr);
		//sort(arr);
		//sortInPlace(arr);
		//display(arr);
		int k=3;
		System.out.println("The largest " + k + " elements ar - ");
		largest(arr, k);
	}
}
