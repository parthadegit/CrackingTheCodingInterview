package chapter_01_ArrayAndString;

public class SetRowColToZero {

	public static void main(String[] args) {
		int rowSize = 5, colSize = 4;
		int[][] matrix = { { 1, 2, 3, 4 }, { 6, 7, 0, 9 }, { 11, 12, 13, 14 }, { 0, 17, 18, 19 }, { 21, 22, 23, 24 } };
		boolean[] rowFlag = new boolean[rowSize];
		boolean[] colFlag = new boolean[colSize];

		System.out.println("Matrix before setting values to zeroes:");
		printMatrix(matrix);

		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				if (matrix[i][j] == 0) {
					rowFlag[i] = true;
					colFlag[j] = true;
				}
			}
		}
		for (int i = 0; i < rowFlag.length; i++) {
			if (rowFlag[i]) {
				for (int j = 0; j < matrix[i].length; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < colFlag.length; i++) {
			if (colFlag[i]) {
				for (int j = 0; j < matrix.length; j++) {
					matrix[j][i] = 0;
				}
			}
		}
		System.out.println("\nMatrix after setting values to zeroes:");
		printMatrix(matrix);
	}

	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

}
