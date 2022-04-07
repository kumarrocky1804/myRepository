package PracticeQuestions;

import java.util.HashMap;

/** The problem is to check whether the subarray exists with sum = 0
 * Example -1 [1,-1,2,-1,1,3] - YES
 * Example -2 [1,2,3,-5,3,4] - Yes (2,3,-5)
 */

/** The implemented solution is to create a array with sum until that element
 * For example - 1 [1,0,2,1,2,5]
 * example -2 [1,3,6,1,4,8]
 * 
 * Observation is that if the elements in this array repeats or it is 0,
 * then the subarray exists with sum = 0;
 */

public class IfArrayHasSubArrayWithSum0 
{	
	static boolean checkSubArray(int[] arr)
	{
		// we are using hashmap due to its O(1) complexity to search elements
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int sum = 0;
		
		for(int i=0; i<arr.length; i++)
		{
			sum = sum + arr[i];
			// if sum is 0 or the element is repeating itself
			if(sum == 0 || map.containsKey(sum))
			{
				return true;
			}
			map.put(sum, 1);
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		//int[] arr = {1,2,4,23};
		//int[] arr = {1,-1,2,-1,1,3};
		int[] arr = {1,2,3,-5,3,4};
		
		System.out.println(checkSubArray(arr));
	}
}
