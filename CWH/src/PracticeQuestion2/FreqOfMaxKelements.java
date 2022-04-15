package PracticeQuestion2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * The problem is to give the first k elements with max frequency from an array . 
 * If frequency is same, then higher element is given priority.
 * @author rocky.kumar
 *
 */

public class FreqOfMaxKelements 
{
	static class freq
    {
        int num;
        int count;
    }
    
    public static void topK(int[] nums, int k) {
        // Code here
        
    	// First create map to store num and frequency
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for(int i=0; i<nums.length; i++)
        {
            if(map.get(nums[i])!=null)
            {
                map.put(nums[i], map.get(nums[i])+1);
            }
            else
                map.put(nums[i],1);
        }
        
        // put the map entries into array of objects
        freq[] fArr = new freq[map.size()];
        int i=0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet())
        {
        	fArr[i] = new freq();
            fArr[i].num = entry.getKey();
            fArr[i].count = entry.getValue();
            i++;
        }
        
        // sort array according to question
        Arrays.sort(fArr, (A, B) -> {
            if(A.count != B.count)
            {
            	return B.count - A.count;
            }
            else
            {
            	return B.num - A.num;
            }
            });
            
        
        // display first k elements
        for(i=0; i<k; i++)
        {
            System.out.println(fArr[i].num + " occured " + fArr[i].count + " times.");
        }
    }
    
    public static void main(String[] args) 
    {
    	int[] arr = new int[] {1,1,2,2,3,3,3,4};
    	
    	topK(arr, 2);
	}
}
