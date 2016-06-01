
public class Matrix 
{
	private int numRow;
	private int numCol;
	private int[][] matrix;

	public Matrix (int numRows, int numColumns)
	{
		numRow = numRows;
		numCol = numColumns;
		matrix = new int[numRows][numColumns];
	}

	/**
	 * gets value of the given space in the matrix
	 * @param row index of row
	 * @param col indes of column
	 * @return value
	 */
	private int getValue(int row, int col)
	{
		int value = matrix[row][col];
		return value;
	}
	
	/**
	 * changes the value of the given space in the matrix
	 * @param row index of the row 
	 * @param col index of the column
	 * @param value value to be written in the matrix
	 */
	public void changeValueAt(int row, int col, int value)
	{
		if (row < 0 || row >= numRow || col < 0 || col >= numCol)
			System.out.println("Nicht moeglich!");
		else
			matrix[row][col] = value;
	}
	
	/**
	 * checks if the matrix is symmetric 
	 * @return true if symmetric, false if not
	 */
	public boolean checkSymmetry()
	{
		for (int row = 0; row < numRow; row++)
		{
			for (int col = 0; col < numCol; col++)
			{
				if ( matrix[row][col] != matrix[col][row])
					return false;
			}
		}
		return true;
	}
	
	/**
	 * creates a new Matrix object which is the transposed version of the given Matrix
	 * @return transposed matrix
	 */
	public Matrix transposeMatrix()
	{
		Matrix transMat = new Matrix(numCol, numRow);
		for (int row = 0; row < numRow; row++)
		{
			for (int col = 0; col < numCol; col++)
			{
				transMat.changeValueAt(col, row, matrix[row][col]);
			}
		}
		return transMat;
	}
	
	/**
	 * multiplies the Matrix with the given Matrix and returns the multiplied Matrix
	 * @param mat second Matrix
	 * @return multiplied Matrix
	 */
	public Matrix multiplyWith(Matrix mat)
	{
		Matrix multMat = new Matrix(numRow, numCol);
		
		if (mat.numRow != this.numRow || mat.numCol != this.numCol)
		{
			System.out.println("Matrizen koennen nicht multipliziert werden!");
			return null;
		}
		else
		{
			for (int row = 0; row < numRow; row++)
			{
				for (int col = 0; col < numCol; col++)
				{
					int product = matrix[row][col]* mat.getValue(row, col);
					multMat.changeValueAt(row, col, product);
				}
			}
		}
		return multMat;
	}
	
	public String toString()
	{
		String mat = "";
		for (int row = 0; row < numRow; row++)
		{
			String s1 = "";
			for (int col = 0; col < numCol; col++)
			{
				s1 = s1 + String.valueOf(matrix[row][col]) + "  ";
			}
			mat = mat + "\n" + s1;
		}
		return mat;
	}
	
	/**
	 * creates an object of the class Matrix  with values between min and max
	 * @param numRows number of rows
	 * @param numColumns number of columns
	 * @param min minimal value
	 * @param max maximal value
	 * @return object of the class Matrix
	 */
	public static Matrix createRandomMatrix(int numRows, int numColumns, int min, int max)
	{
		if (numRows < 0 || numColumns < 0)
			return null;
		else if (min > max)
			return null;
		else
		{
			Matrix matrix = new Matrix(numRows, numColumns);
			//int[][] matrix = new int[numRows][numColumns];
			for (int row = 0; row < numRows; row++)
			{
				for (int col = 0; col < numColumns; col++)
				{
					int byChance = min + (int)(Math.random()* (max+1-min));
					matrix.changeValueAt(row, col, byChance);
				}
			}
			return matrix;
		}
	}
	public static void main(String[] args) 
	{
		Matrix test = createRandomMatrix(4, 4, 1, 2);
		System.out.println(test.toString());
		//test.changeMatrixAt(0, 3, 10);
		
		if (test.checkSymmetry())
			System.out.println("Symmetrisch!");
		else
			System.out.println("Nicht symmetrisch!");
		
		Matrix transMatrix = test.transposeMatrix();
		System.out.println(transMatrix.toString());
		
		Matrix test2 = createRandomMatrix(4, 4, -2, 6);
		System.out.println(test2.toString());
		Matrix multiplied = test.multiplyWith(test2);
		
		String matrix = multiplied.toString();
		System.out.println(matrix);
	}

}
