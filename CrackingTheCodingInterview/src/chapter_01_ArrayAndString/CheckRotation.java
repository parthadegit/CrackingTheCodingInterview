package chapter_01_ArrayAndString;

public class CheckRotation {

	public static void main(String[] args) {
		String s1 = "waterbottle", s2 = "botllewater";
		if (s1.length() == s2.length() && s1.length() > 0) {
			String s = s1 + s1;
			if (isSubString(s, s2))
				System.out.println("True");
			else
				System.out.println("False");
		} 
		else
			System.out.println("False");
	}

	private static boolean isSubString(String s, String s2) {
		if (s.contains(s2))
			return true;
		else
			return false;
	}

}
