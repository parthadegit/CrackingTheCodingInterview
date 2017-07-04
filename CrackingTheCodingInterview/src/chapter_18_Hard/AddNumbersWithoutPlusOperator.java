package chapter_18_Hard;

public class AddNumbersWithoutPlusOperator {

	public static void main(String[] args) {
		int x = 9234;
		int y = -19492;
		int z = getSumWithoutPlusOp(x,y);
		int z0 = x+y;
		if(z==z0){
			System.out.println("True");
		}
		System.out.println("Sum= " +z);
	}

	private static int getSumWithoutPlusOp(int x, int y) {
		return getSumWithoutPlusOpUtil(x,y);
	}

	private static int getSumWithoutPlusOpUtil(int x, int y) {
		if(y==0){
			return x;
		}
		else{
			int p = getSumWithoutPlusOpUtil(x^y,(x&y)<<1);
			return p;
		}
	}

}
