package chapter_05_BitManipulation;

public class FindDuplicate {

	public static void main(String[] args) {
		int[] arr = {5,1023,963222,4,3,67,68,1023,963222,10241024,67}; // All positive numbers
		int range = 10241025;
		int duplicate = findduplicate(arr, range);
		if(duplicate!=-1){
			System.out.println(duplicate);
		}
		else{
			System.out.println("No such element exists.");
		}
	}

	private static int findduplicate(int[] arr, int range) {
		/*One integer can hold up to 32 integers.
		 *If the range is x, we need (x-1)/32 + 1 integers to track the whole range.
		 *If the value of (x-1)/32 + 1 can exceed the range of Integer, then first we have to break them into ranges like, 0 - 9999, 10000 - 19999, etc.
		 *We can optimize it by load balancing.
		*/
		int[] tracker = new int[(range-1)/32 + 1];
		for(int i=0;i<arr.length;i++){
			int numCount = arr[i]/32;
			int bitCount = arr[i]%32;
			if(isSet(tracker[numCount],bitCount)){
				return arr[i];
			}
			else{
				tracker[numCount] |= (1<<bitCount);
			}
		}
		return -1;
	}

	private static boolean isSet(int num, int bitCount) {
		if((num | (1<<bitCount)) == num){
			return true;
		}
		else{
			return false;
		}
	}

}
