package SpecialQuestions;

public class MinimalCashFlow 
{
	/* Given a matrix that represent how much money the row element person has to pay the coloumn
	 * element person. We have to find the way in which the money is settled with minimum number
	 * of transactions.
	 * Example - if matrix[0][1] = 1000, then person 0 have to pay 1000 to person 1.
	 * 
	 * Solution algo - 
	 * 	- Make an array amount for all persons involved and put the net amount they have to 
	 * 	  credit or debit
	 *  - Find the max credit and max debit guy. (will be max and min of the array)
	 *  - Find the minimum absolute value for the two and update amount array after their transaction.
	 *  - Do the above steps until max credit and max debit is 0. 
	 */

	static int getMin(int arr[])
	{
		int minInd = 0;
		for (int i = 1; i < arr.length; i++)
			if (arr[i] < arr[minInd])
				minInd = i;
		return minInd;
	}

	static int getMax(int arr[])
	{
		int maxInd = 0;
		for (int i = 1; i < arr.length; i++)
			if (arr[i] > arr[maxInd])
				maxInd = i;
		return maxInd;
	}

	static int minOf2(int x, int y)
	{
		return (x < y) ? x: y;
	}

	static void minCashFlowRec(int[] amount)
	{
		// Now I have net amount for all persons
		int maxMoneyGetter = getMax(amount); // will be positive value
		int maxMoneyPayer = getMin(amount); // will be negative value

		// if both persons have to net amount 0, then everyone else is also settled
		if(amount[maxMoneyGetter]==0&&amount[maxMoneyPayer]==0)
			return;

		// transactionAmount as minimum of two absolute values
		int tranAmount = minOf2(amount[maxMoneyGetter], -amount[maxMoneyPayer]);
		// DO the transaction and update the net amount
		amount[maxMoneyGetter] = amount[maxMoneyGetter] - tranAmount;
		amount[maxMoneyPayer] = amount[maxMoneyPayer] + tranAmount;

		System.out.println("Person - " + maxMoneyPayer + " should pay " + tranAmount + 
				" to Person - " + maxMoneyGetter);

		minCashFlowRec(amount);
	}

	static void minCashFlow(int[][] matrix, int N)
	{
		int[] amount = new int[N];

		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				// Net amount - it will be negative if i have to pay more than get
				// positive if i have to get more than pay
				amount[i] = amount[i] + (matrix[j][i]-matrix[i][j]);
			}
		}

		// recursively call this function
		minCashFlowRec(amount);
	}

	public static void main(String[] args) {
		int n=3;

		int[][] matrix = {{0,1000,2000},
				{500,0,5000},
				{100,200,0},};
		
		minCashFlow(matrix, n);
	}
}
