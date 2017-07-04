package chapter_01_ArrayAndString;

public class InPlaceMatrixRotation {
	public static void main(String[] args) {

		int size = 5;
		char direction = 'L';// 'R';
		// int[][] matrix=new int[size][size];
		int[][] matrix = { { 11, 12, 13, 14, 15 }, { 21, 22, 23, 24, 25 }, { 31, 32, 33, 34, 35 }, { 41, 42, 43, 44, 45 },
				{ 51, 52, 53, 54, 55 } };
		System.out.println("Matrix before rotation:");
		printMatrix(matrix, size);
		String dir;
		if (direction == 'R') {
			dir = "right";
			matrix = rightRotate(matrix);
		} else {
			dir = "left";
			matrix = leftRotate(matrix);
		}
		System.out.println("\nMatrix after "+dir+" rotation:");
		printMatrix(matrix, size);

	}

	private static int[][] leftRotate(int[][] matrix) {
		int size = matrix.length;
		for (int i = 0; i < size / 2; i++) {
			for (int j = i; j < size - i - 1; j++) {
				int x = matrix[i][j];
				matrix[i][j] = matrix[j][size - 1 - i];
				matrix[j][size - 1 - i] = matrix[size - 1 - i][size - 1 - j];
				matrix[size - 1 - i][size - 1 - j] = matrix[size - 1 - j][i];
				matrix[size - 1 - j][i] = x;
			}
		}
		return matrix;
	}

	private static int[][] rightRotate(int[][] matrix) {
		int size = matrix.length;
		for (int i = 0; i < size / 2; i++) {
			for (int j = i; j < size - i - 1; j++) {
				int x = matrix[i][j];
				matrix[i][j] = matrix[size - 1 - j][i];
				matrix[size - 1 - j][i] = matrix[size - 1 - i][size - 1 - j];
				matrix[size - 1 - i][size - 1 - j] = matrix[j][size - 1 - i];
				matrix[j][size - 1 - i] = x;
			}
		}
		return matrix;
	}

	private static void printMatrix(int[][] matrix, int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}
}
