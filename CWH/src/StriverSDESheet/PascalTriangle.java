package StriverSDESheet;

import java.util.Scanner;

/**
 * Generate pascal triangle with n rows - 
 * In Pascal’s triangle, each number is the sum of the two numbers directly above it
 * @author rocky.kumar
 * Link - https://takeuforward.org/data-structure/program-to-generate-pascals-triangle/
 */

public class PascalTriangle {
	
	public static void generatePascalTriangle(int[][] a)
	{
		int row = a.length;
		
		if(row >= 1)
		{
			a[0][0] = 1;
		}
		
		for(int i=1; i<row; i++)
		{
			// first column is always 1
			a[i][0] = 1;
			for(int j=1; j<row; j++)
			{
				if(i==j)
				{
					a[i][j]=1;
					break;
				}
				
				a[i][j] = a[i-1][j-1] + a[i-1][j];
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of rows of triangle's matrix - ");
		
		int n = sc.nextInt();
		
		sc.close();
		
		int matrix[][] = new int[n][n];
		
		generatePascalTriangle(matrix);
		
		System.out.println("Pascal Triangle Matrix is -");
		
		for(int i=0; i<matrix.length; i++)
		{
			for(int j=0; j<matrix[0].length; j++)
			{
				System.out.print(" " + matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
	}

}
