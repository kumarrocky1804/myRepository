package PracticeQuestion2;

/**
 * A celebrity is the person that is known by everyone but he/she does not know anyone. we
 * have to find if there is any such person in the matrix of knowns.
 * 
 * know[i][j] = 1 means i knows j
 * know[i][j] = 0 means i does not know j
 * know[i][i] is always 0
 * 
 * ex - [ 0 1 0
 * 		  0 0 0   Answer is 1 as person 1 is known to everyone but he does not know anyone
 *        0 1 0]
 *        
 * LINK - https://www.geeksforgeeks.org/the-celebrity-problem/
 * @author rocky.kumar
 *
 */

public class CelebrityFinder 
{
	// Method we are using is to check a potential candidate in matrix and then 
	// confirming the same in second step as there is only one or 0 celebrities in the matrix
	
	public static int checkCelebrity(int[][] know, int numOfPeople)
	{
		int i = 0, j = numOfPeople-1;
		
		// check the matrix values and keep reducing search area
		// This can be done with stack but we are saving space
		while(i<j)
		{
			// if j knows i eliminate j else, eliminate i
			if(know[j][i]==1)
				j--;
			else
				i++;
		}
		
		int potentialCandidate = i;
		
		// reconfirming 
		for(int temp=0; temp<numOfPeople; temp++)
		{
			if(temp != potentialCandidate)
			{
				if(know[temp][potentialCandidate] != 1 || 
						know[potentialCandidate][temp] != 0)
					return -1;
			}
		}
		
		return potentialCandidate;
	}
	
	public static void main(String[] args) {
		int[][] know = {{0,1,0},{0,0,0},{0,1,0}};
		
		System.out.println(checkCelebrity(know, 3));
	}
}
