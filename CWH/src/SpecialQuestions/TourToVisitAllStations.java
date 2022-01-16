package SpecialQuestions;

class Node
{
	int petrol;
	int distanceNextStation;
	
	public Node(int petrol,int distanceNextStation)
	{
		this.petrol = petrol;
		this.distanceNextStation = distanceNextStation;
	}
}

public class TourToVisitAllStations 
{
	/*  Suppose there is a circle. 
	 * 	There are n petrol pumps on that circle. 
	 * 	You are given two sets of data.
	 *	1. The amount of petrol that every petrol pump has.
	 *	2. Distance from that petrol pump to the next petrol pump.
	 *
	 *	Calculate the first point from where a truck will be able to complete the circle
	 *	(The truck will stop at each petrol pump and it has infinite capacity). 
	 *	Assume for 1-litre petrol, the truck can go 1 unit of distance.
	 *	For example, let there be 4 petrol pumps with amount of petrol and 
	 *	distance to next petrol pump value pairs as {4, 6}, {6, 5}, {7, 3} and {4, 5}. 
	 *	The first point from where the truck can make a circular tour is 2nd petrol pump. 
	 *	Output should be “start = 1” (index of 2nd petrol pump). 
	 */
	
	/* Solution - 
	 *  1. We can easily do it in O(n^2) complexity by visiting each node twice.
	 *  2. For O(n) - we can visit each node once only. We can store the deficit if the current
	 *     petrol becomes negative so that we know how much distance is still to cover if we
	 *     change our start point.
	 */
	
	public static int FindTourStart(Node[] arr)
	{
		int currentPetrol = 0;
		int deficit = 0;
		int start = 0;
		
		for(int i=0; i<arr.length; i++)
		{
			// As i unit petrol = 1 unit distance, so currentPetrol will result of difference 
			currentPetrol = currentPetrol + (arr[i].petrol - arr[i].distanceNextStation);
			// If less than zero, then there is no point of starting from any station till this
			// So, just store the deficit till now, so that value can be used later without 
			// visiting them again 
			if(currentPetrol<0)
			{
				deficit = deficit+currentPetrol;
				// reset current petrol
				currentPetrol = 0;
				// update start 
				start = i+1;
			}
		}
		
		// if current start can tour till end and remaining stations' deficit then it is the 
		// correct node, otherwise no correct node exists.
		if(currentPetrol + deficit >= 0)
			return start;
		return -1;
	}
	
	public static void main(String[] args)
	{
		//Node[] arr = {new Node(4,6), new Node(6,5), new Node(7,3), new Node(4,5)};
		Node[] arr = {new Node(4,6), new Node(6,5), new Node(7,9), new Node(4,1)};
		int start = FindTourStart(arr);
		if(start == -1)
		{
			System.out.println("No such station exist.");
		}
		else
		{
			System.out.println("Station to start tour is - " + (start+1));
		}
	}
}
