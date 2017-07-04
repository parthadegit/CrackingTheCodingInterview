package chapter_03_StackAndQueue;

import java.util.Stack;

public class TowerOfHanoi {

	public static void main(String[] args) {
		Stack<Integer> source = new Stack<Integer>();
		Stack<Integer> dest = new Stack<Integer>();
		Stack<Integer> aux = new Stack<Integer>();
		int height = 5;
		for(int i=0;i<height;i++)
			source.push(height-i); // We can access only 0-th location. i.e. the top of the stack;
		System.out.println("Before:");
		printTOH(source,height);
		printTOH(aux,height);
		printTOH(dest,height);
		dest = toh(source,dest,aux,height);
		System.out.println("After:");
		printTOH(source,height);
		printTOH(aux,height);
		printTOH(dest,height);
	}
	
	private static void printTOH(Stack<Integer> toh, int height) {
		for(int i=0;i<toh.size();i++)
			System.out.println("  "+toh.get(toh.size()-i-1)+"  ");
		if(toh.size()==0){
			for(int i=0;i<height;i++)
				System.out.println("  |  ");
		}
		System.out.println("-----");

	}

	public static Stack<Integer> toh(Stack<Integer> source, Stack<Integer> dest, Stack<Integer> aux, int height){
		if(height==1){
			int x = source.pop();
			dest.push(x);
		}
		else{
			aux = toh(source,aux, dest,height-1);
			int x = source.pop();
			dest.push(x);
			dest = toh(aux,dest,source,height-1);
		}
		return dest;
	}

}
