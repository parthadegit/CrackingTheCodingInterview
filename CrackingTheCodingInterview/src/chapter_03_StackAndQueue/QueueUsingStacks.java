package chapter_03_StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingStacks {

	public static void main(String[] args) {
		Stack<Integer> st1 = new Stack<Integer> ();
		Stack<Integer> st2 = new Stack<Integer> ();
		
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("Enter 1 to ENQUEUE, 2 to DEQUEUE, 3 to EXIT.");
			int option = sc.nextInt();
			int element = 0;
			boolean breakFlag = false;
			int x;
			switch(option){
				case 1:
					System.out.println("Enter the element: ");
					element = sc.nextInt();
					enqueue(st1,st2,element);
					break;
				case 2:
					x = dequeue(st1,st2);
					if(x!=Integer.MAX_VALUE)
						System.out.println(x+" is removed from the queue.");
					else
						System.out.println("Queue is empty.");
					break;

				case 3:
					breakFlag = true;
					break;
					
				default:
					System.out.println("Wrong option entered. Press between 1 and 3.");
			}
			if(breakFlag == true)
				break;
		}	
	}

	private static int dequeue(Stack<Integer> st1, Stack<Integer> st2) {
		if(st1.isEmpty() && st2.isEmpty())
			return Integer.MAX_VALUE;
		if(st2.isEmpty())
			while(!st1.isEmpty())
				st2.push(st1.pop());
		return st2.pop();
		
	}

	private static void enqueue(Stack<Integer> st1,Stack<Integer> st2, int element) {
		st1.push(element);
	}

}
