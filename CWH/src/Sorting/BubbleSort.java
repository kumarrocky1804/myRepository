package Sorting;

public class BubbleSort {
	/* TIME COMPLEXITY - 
	 * Best Case - O(n)
	 * Average Case - O(n^2)
	 * Worst Case - O(n^2)
	 * Stable Algorithm - Yes
	 * In-Place Algorithm - Yes
	 * 
	 * Used Where - Very rarely used as it has high time complexity but can be very useful
	 * 				in detecting small errors like swap of two elements in computer graphics.
	 */
	
	int[] arr;
	
	public BubbleSort()
	{
		arr = new int[]{6,5,4,3,2,1};
	}
	
	public void display()
	{
		System.out.println();
		System.out.println("current array is - ");
		for(int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i] + " -> ");
		}
	}
	
	public void sort()
	{
		boolean swap;
		// This is the max number of passes needed which is (length-1)
		for(int i=0; i<arr.length-1	; i++)
		{
			swap = false;
			// i no. of elements from end will always be sorted already
			for(int j=0; j<arr.length-1-i; j++)
			{
				if(arr[j] > arr[j+1])
				{
					System.out.println("swapping - " + arr[j] + "and" + arr[j+1]);
					//swap
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swap=true;
				}
			}
			
			display();
			// if no swap occurred in this pass, the array is now sorted
			if(!swap)
			{
				System.out.println("NOthing swapped in last pass");
				return;
			}
		}
	}

	public static void main(String[] args) 
	{
		BubbleSort sort = new BubbleSort();
		sort.display();
		sort.sort();
	}

}
