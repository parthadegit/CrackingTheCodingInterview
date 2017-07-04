package chapter_01_ArrayAndString;

public class CheckPermutationOfString {
	/*
	 * Without extra space and without string destruction best time is O(n^2)
	 * Without extra space and with string destruction: sort the strings after
	 * converting to char arrays. time O(n log n) The following code is with
	 * extra space. time is O(n)
	 */
	public static void main(String[] args) {
		String s1 = "abbcf12Adkugi";
		String s2 = "bf12cAadkbugi";
		boolean isPermutation = checkIfPermutation(s1, s2);
		if (isPermutation)
			System.out.println("True");
		else
			System.out.println("False");
	}

	private static boolean checkIfPermutation(String s1, String s2) {
		int[] countArray = new int[256];
		if (s1.length() != s2.length())
			return false;
		for (int i = 0; i < s1.length(); i++) // Pass 1
			countArray[s1.charAt(i)]++;
		for (int i = 0; i < s2.length(); i++) // Pass 2
			countArray[s2.charAt(i)]--;
		for (int i = 0; i < countArray.length; i++) { // Pass 3
			if (countArray[i] != 0)
				return false;
		}
		return true;

		/*
		 * Pass 3 can be avoided by modifying the Pass 2 
		 * for(int i=0;i<s2.length();i++){ //Modified Pass 2
		 * 		if(--countArray[s2.charAt(i)]<0) return false; 
		 * } 
		 * This logic works on
		 * the fact, if the length of the two strings are same and if they are
		 * not permutation of each other, Then, there must be at least one
		 * character whose count is more in the second string.
		 * In other words, we can say,
		 * for(int i=0;i<s2.length();i++){ //Modified Pass 2
		 * 		if(countArray[s2.charAt(i)]==0) return false; 
		 * } 
		 */
	}

}
