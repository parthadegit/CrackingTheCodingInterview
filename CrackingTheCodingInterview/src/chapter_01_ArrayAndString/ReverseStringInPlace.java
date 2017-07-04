package chapter_01_ArrayAndString;

public class ReverseStringInPlace {

	public static void main(String[] args) {
		String s = "abcf12Adkugi";
		System.out.print("Before string reversing: ");
		System.out.println(s);
		char[] sArray = s.toCharArray();
		for (int i = 0, j = sArray.length - 1; i < j; i++, j--) {
			swap(sArray, i, j);
		}
		//s = String.valueOf(sArray);
		s = new String(sArray);
		System.out.print("After string reversing: ");
		System.out.println(s);
	}

	private static void swap(char[] sArray, int i, int j) {
		char temp = sArray[i];
		sArray[i] = sArray[j];
		sArray[j] = temp;
	}

}
