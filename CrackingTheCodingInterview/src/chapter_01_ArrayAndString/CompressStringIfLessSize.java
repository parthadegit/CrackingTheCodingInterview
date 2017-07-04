package chapter_01_ArrayAndString;

import java.util.ArrayList;

public class CompressStringIfLessSize {

	public static void main(String[] args) {
		String s = "aaaaadddsscceeseaass";
		System.out.print("Before Compression: ");
		System.out.println(s);
		StringBuilder strBldr = new StringBuilder();
		if (s.length() > 0) {
			int charCount = 1;
			strBldr.append(s.charAt(0));
			for (int i = 1; i < s.length(); i++) {
				if (s.charAt(i) == s.charAt(i - 1))
					charCount++;
				else {
					strBldr.append(charCount);
					strBldr.append(s.charAt(i));
					charCount = 1;
				}
			}
			strBldr.append(charCount);
			System.out.print("After Compression: ");
			if (s.length() <= strBldr.length())
				System.out.println(s);
			else
				System.out.println(strBldr);
		}
	}
}

		/*
		 * If String builder is not allowed then,
		 * We need to use character array list and convert the count to character set.
		 * Here we need to be careful as the integer can be more than one digit.
		 * Therefore, recursively we need to take each digit, convert it into character by adding '0'
		 * and put that in the character array list.
		 * Or, we can convert the integer to a string by adding "".
		 * After that using charAt() function we can add each of the characters.
		*/