package chapter_03_StackAndQueue;

import java.util.Stack;

public class SortStackUsingExtraStack {

	public static void main(String[] args) {
		Stack<Integer> st1 = new Stack<Integer>();
		Stack<Integer> st2 = new Stack<Integer>();
		
		int[] arr = {8,4,9,7,1,2,45,78,4,89,-3,0};
		System.out.print("Before sorting: ");
		for(int i:arr){
			st1.push(i);
			System.out.print(i+",");
		}
		System.out.println();
		
		st2.push(st1.pop());
		while(!st1.isEmpty()){
			int element = st1.pop();
			if(st2.peek()>element){
				st2.push(element);
			}
			else{
				while(!st2.isEmpty() && st2.peek()<element)
					st1.push(st2.pop());
				st2.push(element);
			}
		}
		while(!st2.isEmpty())
			st1.push(st2.pop());
		
		System.out.print("After sorting: ");
		while(!st1.isEmpty())
			System.out.print(st1.pop()+",");
	}
}
