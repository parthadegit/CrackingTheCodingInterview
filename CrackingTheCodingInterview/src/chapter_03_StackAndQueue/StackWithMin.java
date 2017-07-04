package chapter_03_StackAndQueue;

import java.util.ArrayList;
import java.util.Scanner;

public class StackWithMin {
	static int tos;
	static ArrayList<Integer> minHolder= new ArrayList<Integer>();
	public static void main(String[] args) {
		int size = 6;
		int[] stackArray=new int[size];
		tos = -1;
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
					x=push(stackArray,element);
					if(x!=Integer.MAX_VALUE)
						System.out.println(x+" is pushed into Stack.");
					else
						System.out.println("Stack is full.");
					break;
				
				case 2:
					x=pop(stackArray);
					if(x!=Integer.MAX_VALUE)
						System.out.println(x+" is popped from Stack.");
					else
						System.out.println("Stack is empty.");	
					break;
					
				case 3:
					x=peek(stackArray);
					if(x!=Integer.MAX_VALUE)
						System.out.println(x+" is in the top of Stack.");
					else
						System.out.println("Stack is empty.");
					break;
					
				case 4:
					x = getMin(stackArray);
					if(x!=Integer.MAX_VALUE)
						System.out.println(x+" is the min value in the Stack.");
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
		
	private static int getMin(int[] stackArray) {
		if(isEmpty(stackArray))
			return Integer.MAX_VALUE;
		else
			return minHolder.get(minHolder.size()-1);
	}
	private static int pop(int[] stackArray) {
		int x =0;
		if(isEmpty(stackArray))
			return Integer.MAX_VALUE;
		else{
			x = stackArray[tos];
			if(x == minHolder.get(minHolder.size()-1))
				minHolder.remove(minHolder.size()-1);
			tos--;
			return x;
		}
	}
	private static int peek(int[] stackArray) {
		if(isEmpty(stackArray))
			return Integer.MAX_VALUE;
		else
			return stackArray[tos];
	}
	
	private static int push(int[] stackArray, int element) {
		if(isFull(stackArray))
			return Integer.MAX_VALUE;
		else{
			if(isEmpty(stackArray)){
				stackArray[++tos]=element;
				minHolder.add(element);
			}
			else if(element<=minHolder.get(minHolder.size()-1)){
				stackArray[++tos]=element;
				minHolder.add(element);
			}
			else
				stackArray[++tos]=element;		
		}
		return stackArray[tos];
	}
	private static boolean isEmpty(int[] stackArray) {
		if(tos == -1)
			return true;
		else
			return false;
	}
	private static boolean isFull(int[] stackArray) {
		if(tos == stackArray.length-1)
			return true;
		else
			return false;
	}


}
