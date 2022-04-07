package SpecialQuestions;

/**
 * The problem is to find the majority element if exist. Majority element is that 
 * element which occurs more than size/2 times
 * 
 * Can use hashmap but to save space we use Moore's algo.
 * LINK - https://www.geeksforgeeks.org/boyer-moore-majority-voting-algorithm/
 * @author rocky.kumar
 *
 */

public class MooreAlgorithmForMajorityElement 
{
	static int majorityElement(int a[], int size)
    {        
        int majIndex=0,count=0;
        
        // step -1 Find candidate for majority element by counting the elements roughly
        // majority element has more than n/2 occurences so, if any time count becomes 0
        // then half of the elements are not that element hence change candidate
        for(int i=0; i<size; i++)
        {
            if(a[majIndex]==a[i])
            {
                count++;
            }
            else
            {
                count--;
            }
            
            if(count==0)
            {
                majIndex = i;
                count=1;
            }
        }
        
        int candidate = a[majIndex];
        
        if(count > size/2)
        {
            return candidate;
        }
        
        // step-2 confirm if the candidate is actually majority element or no such element exist
        count = 0;
        for(int i=0; i<size; i++)
        {
            if(a[i] == candidate)
            {
                count++;
            }
            
            if(count>size/2)
                return candidate;
        }
        
        return -1;
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
		//int[] a = {2,2,1,0,1,2,2,2};
		int[] a = {2,2,1,0,1,2,2,2,3,4,5,6};
		System.out.println("Original array - ");
		display(a);
		
		System.out.println(" Majority element - " + majorityElement(a, a.length));
	}
}
