package Basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class KMostFrequent {
	
	static class object
	{
		int number;
		int count;
	}

	public static void kmostFreq(int[] arr, int k)
	{
		HashMap<Integer,Integer> map = new HashMap<>();
		
		for(int i=0; i<arr.length; i++)
		{
			if(map.get(arr[i]) == null)
			{
				map.put(arr[i], 1);
			}
			else
			{
				map.put(arr[i], map.get(arr[i])+1);
			}
		}
		
		object[] arrObject = new object[map.size()];
		int i=0;
		
		for(Map.Entry<Integer, Integer> entry: map.entrySet())
		{
			arrObject[i].number = entry.getKey();
			arrObject[i].count = entry.getValue();
			i++;
		}
		
		Arrays.sort(arrObject, (object A, object B) -> {
			return B.count-A.count;
		});
		
		for(int j=0; j<k; j++)
		{
			System.out.print(arrObject[i].number);
		}
		
	}
	
	public static void main(String[] args) 
	{
		int[] arr = new int[] {4,7,1,6,6,4,9,1,2};
		kmostFreq(arr,2);
	}

}
