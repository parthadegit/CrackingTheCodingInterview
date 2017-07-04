package chapter_17_Moderate;

public class SwapNumbersWithoutExtraVariable {

	public static void main(String[] args) {
		int[] x1 = {35, 49};
		if(x1.length!=2){
			return;
		}
		System.out.println("Before swapping: ");
		printArray(x1);
		System.out.println("After swapping: ");
		swapUsingXOR(x1);
		printArray(x1);
		
		int[] x2 = {Integer.MIN_VALUE, 44};
		if(x2.length!=2){
			return;
		}
		System.out.println("Before swapping: ");
		printArray(x2);
		System.out.println("After swapping: ");
		swapUsingAddSub(x2);
		printArray(x2);
	}
	public static void swapUsingXOR(int[]  x){
		x[0] ^= x[1];
		x[1] ^= x[0];
		x[0] ^= x[1];
	}
	public static void swapUsingAddSub(int[]  x){
		x[0] = x[0]+x[1];
		x[1] = x[0]-x[1];
		x[0] = x[0]-x[1];
	}
	public static void printArray(int[]  x){
		System.out.println("a="+x[0]+" b="+x[1]);
	}
}
