package chapter_03_StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class StackWithMaxUsingStackDS {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		Stack<Integer> max = new Stack<Integer>();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("Enter 1 to PUSH, 2 to POP, 3 to PEEK, 4 to MIN and 5 to EXIT.");
			int option = sc.nextInt();
			boolean breakFlag = false;
			int x;
			switch(option){
				case 1:
					System.out.println("Enter the element: ");
					int element = sc.nextInt();
					st.push(element);
					if(max.isEmpty())
						max.push(element);
					else if(element>=(int)max.peek())
						max.push(element);
					break;
				
				case 2:
					if(!st.isEmpty()){
						x=st.pop();
						if(x == max.peek())
							max.pop();
						System.out.println(x+" is removed from Stack.");
					}
					else
						System.out.println("Stack is empty.");	
					break;
					
				case 3:
					if(!st.isEmpty())
						System.out.println(st.peek()+" is in the top of Stack.");
					else
						System.out.println("Stack is empty.");
					break;
					
				case 4:
					if(!st.isEmpty())
						System.out.println(max.peek()+" is the max value in the Stack.");
					else
						System.out.println("Stack is empty.");
					break;
					
				case 5:
					breakFlag = true;
					break;
					
				default:
					System.out.println("Wrong option entered. Please between 1 and 5.");
			}
			//debugPrint(stackArray);
			if(breakFlag == true)
				break;
		}
	}

}
