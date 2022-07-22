package StriverSDESheet;

/**
 * Problem is to set all elements of the row and column to 0 if any one of the element in 
 * the row/column is 0
 * 
 * example - if a[2][2] -0, then set all 2nd row and 2nd column element as 0
 * @author rocky.kumar
 * Link - https://takeuforward.org/data-structure/set-matrix-zero/
 */
public class SetMatrixZeros 
{
	// approach is to set the first row and column as marker elements for the rest of the 
	// elements. hence, first row and column is treated as special case and for other 
	// elements, they are marker elements.
	public static void setElementZeroes(int[][] matrix)
	{
		int row = matrix.length;
		int col = matrix[0].length;
		
		boolean isFirstRowZero=false,isFirstColZero=false;
		
		// check if first row have to be set as 0
		for(int i=0; i<row; i++){
            if(matrix[i][0] == 0){
            	isFirstColZero = true;
                break;
            }
        }
        
		// check if first column have to be set as 0
        for(int i=0; i<col; i++){
            if(matrix[0][i] == 0){
            	isFirstRowZero = true;
                break;
            }
        }
		
		for(int i=1; i<row; i++)
		{			
			for(int j=1; j<col; j++)
			{
				if(matrix[i][j]==0)
				{
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		System.out.println("Marker Matrix - ");
		
		for(int i=0; i<matrix.length; i++)
		{
			for(int j=0; j<matrix[0].length; j++)
			{
				System.out.print(" " + matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		// Now based on marker matrix, set all other elements
		
		for(int i=1; i<row; i++)
		{
			for(int j=1; j<col; j++)
			{
				if(matrix[i][0] == 0 || matrix[0][j] == 0)
					matrix[i][j] = 0;
			}
		}
		
		if(isFirstColZero)
		{
			for(int i=0; i<row; i++) {
				matrix[i][0]=0;
	        }
		}
		
		if(isFirstRowZero)
		{
			for(int i=0; i<col; i++) {
				matrix[0][i]=0;
	        }
		}
	}

	public static void main(String[] args) 
	{
		//int[][] matrix= {{1,2,3},{2,0,4},{2,1,4}};
		
		int[][] matrix= {{1,1,1,1},{1,0,1,1},{1,1,0,0},{0,0,0,1}};
		
		System.out.println("Original Matrix is -");
		
		for(int i=0; i<matrix.length; i++)
		{
			for(int j=0; j<matrix[0].length; j++)
			{
				System.out.print(" " + matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		setElementZeroes(matrix);
		
		System.out.println("Revised Matrix is -");
		
		for(int i=0; i<matrix.length; i++)
		{
			for(int j=0; j<matrix[0].length; j++)
			{
				System.out.print(" " + matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
