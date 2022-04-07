package PracticeQuestion2;

/** 
 * The problem is to sort the array of 0,1, and 2.
 */
public class SortArrayOf012 
{
	// Easier method is to count the 0s, 1s and 2s
	public static void sort012(int[] a, int n)
	{
		int count0=0,count1=0;
        
        for(int i=0; i<n; i++)
        {
            if(a[i] == 0)
                count0++;
            else if(a[i] == 1)
                count1++;
        }
        
        int i=0;
        while(i<count0)
        {
            a[i] = 0;
            i++;
        }
        
        while(i<count0+count1)
        {
            a[i] = 1;
            i++;
        }
        
        while(i<n)
        {
            a[i] = 2;
            i++;
        }
	}
	
	public static void display(int[] a)
	{
		for(int i=0; i<a.length; i++)
		{
			System.out.print(a[i] + " , ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] a = {0,1,2,2,1,0,1,2,1,0};
		
		System.out.println("Original array - ");
		display(a);
		
		sort012(a, a.length);
		
		System.out.println("Sorted array - ");
		display(a);
	}
}
