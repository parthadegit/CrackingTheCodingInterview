package chapter_01_ArrayAndString;

public class ReplaceSpaceByMultipleCharacters {

	public static void main(String[] args) {
		String s = "My name is Partha De.";
		System.out.println(s);
		String replacementString = "%&20";
		int noOfSpace = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ')
				noOfSpace++;
		}
		char[] sArray = new char[s.length() + (replacementString.length() - 1) * noOfSpace];
		for (int j = 0, i = 0; j < s.length(); j++) {
			if (s.charAt(j) == ' ') {
				for (int p = 0; p < replacementString.length(); p++) {
					sArray[i] = replacementString.charAt(p);
					i++;
				}
			} else {
				sArray[i] = s.charAt(j);
				i++;
			}
		}
		s = String.valueOf(sArray);
		System.out.println(s);
	}

}
