package chapter_01_ArrayAndString;

public class CheckUniqueCharacterInString {

	public static void main(String[] args) {
		// boolean idAlphabetOnlyIgnoreCase = true;
		String s = "abcf12Adkugi";
		boolean isBroken = false;
		// if(!idAlphabetOnlyIgnoreCase){
		boolean[] flagArray = new boolean[256];
		for (int i = 0; i < s.length(); i++) {
			if (flagArray[s.charAt(i)]) {
				isBroken = true;
				System.out.println(
						"Duplicate exists. The first duplicate character encountered is \'" + s.charAt(i) + "\'.");
				break;
			} else {
				flagArray[s.charAt(i)] = true;
			}
		}
		if (!isBroken)
			System.out.println("No duplicate exists.");
		// }
	}

}
