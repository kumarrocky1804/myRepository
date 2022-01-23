package DataStructures;

public class Heap 
{
	/* Heap is a special case for complete binary tree.
	 * Here we implemented min heap using arrays.
	 * min heap means that the parent node will always have data <= child nodes
	 *  - it can be used to sort data in non increasing order (Heap sort)
	 *  Linked list are not preferred to implement Heap as its implementation is only less 
	 *  time consuming when random access is available.
	 */
	
	int[] arr;
	int currSize;
	
	public Heap(int maxSize)
	{
		arr = new int[maxSize];
		currSize = 0;
	}
	
	public void insert(int data)
	{
		// IF heap empty
		if(currSize == 0)
		{
			currSize++;
			arr[0] = data;
			return;
		}
		
		currSize++;
		arr[currSize-1] = data;
		// check whether heap principle is followed or not
		heapify_insert(arr,currSize-1);
	}
	
	// heapify in bottom-top approach
	private void heapify_insert(int[] arr, int index)
	{
		// calculate parent
		int parent = (index-1)/2;
		
		// if root node
		if(parent < 0)
			return;
		
		// if heap principle is followed for immediate parent, it will be fine for all
		if(arr[parent] <= arr[index])
			return;
		
		// swap values with parent and heapify parent
		int temp = arr[parent];
		arr[parent] = arr[index];
		arr[index] = temp;
		
		heapify_insert(arr, parent);
	}
	
	// always root node is deleted and returned
	public int delete()
	{
		// if heap is empty
		if(currSize == 0)
		{
			return -1;
		}
		
		// return root element
		int retElement = arr[0];
		currSize--;
		//replace root element with last element
		arr[0] = arr[currSize];
		// make sure the heap principle is followed
		heapify_delete(arr, 0);
		return retElement;
	}
	
	private void heapify_delete(int[] arr, int startIndex)
	{
		// find the child node indices
		int leftChildIndex = (2*startIndex) + 1;
		int rightChildIndex = (2*startIndex) + 2;
		
		// if last node then return
		if(leftChildIndex > currSize || rightChildIndex > currSize)
			return;
		
		// if heap principle followed for this, then ok for all
		if(arr[startIndex] <= arr[leftChildIndex] && arr[startIndex] <= arr[rightChildIndex])
			return;
		
		int indexToSwap;
		
		// find least element between left and right child. that's the one to swap
		if(arr[startIndex]>arr[leftChildIndex] && arr[leftChildIndex] <= arr[rightChildIndex])
			indexToSwap = leftChildIndex;
		else
			indexToSwap = rightChildIndex;
		
		// further heapify that child node
		int temp = arr[startIndex];
		arr[startIndex] = arr[indexToSwap];
		arr[indexToSwap] = temp;
		
		heapify_delete(arr,indexToSwap);		
	}
	
	public void display()
	{
		System.out.println();
		for(int i=0;i<currSize;i++)
		{
			System.out.print(arr[i] + " -> ");
		}
	}
	
	public static void main(String[] args) {
		Heap heap = new Heap(100);
		
		heap.insert(10);
		heap.insert(20);
		heap.insert(30);
		heap.insert(40);
		heap.insert(50);
		heap.insert(60);
		
		heap.display();
		
		heap.insert(5);
		heap.display();   
		heap.insert(4);
		heap.display(); 
		
		System.out.println(heap.delete());
		heap.display();
		
		System.out.println(heap.delete());
		heap.display();
		System.out.println(heap.delete());
		heap.display();
		System.out.println(heap.delete());
		heap.display();
		System.out.println(heap.delete());
		heap.display();
		System.out.println(heap.delete());
		heap.display();
		System.out.println(heap.delete());
		heap.display();
		System.out.println(heap.delete());
		heap.display();
		System.out.println(heap.delete());
		heap.display();
		
	}
}
