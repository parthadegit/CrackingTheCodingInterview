package chapter_03_StackAndQueue;

import java.util.ArrayList;

public class SetOfStacks {
	static int tos=-1;
	final static int sizeLimit = 6;

	public static void main(String[] args) {
		ArrayList<int[]> setOfStacks = new ArrayList<int[]>();
		ArrayList<Integer> noOfDelList = new ArrayList<Integer>();
		int element = 0;
		int x1=0,x2=0,x3=0,x4=0;
		x1=push(setOfStacks, element,noOfDelList);
		x2=pop(setOfStacks);
		x3=peek(setOfStacks);
		int subStackNumber = 2;
		x4=popAt(setOfStacks,subStackNumber,noOfDelList);
	}
	
	private static int popAt(ArrayList<int[]> setOfStacks, int subStackNumber, ArrayList<Integer> noOfDelList) {
		int forwad=0;
		for(int i=0;i<subStackNumber;i++){
			forwad+=noOfDelList.get(i);
		}
		int actualIndex = subStackNumber*sizeLimit-1+forwad;
		if(actualIndex>tos)
			return Integer.MAX_VALUE;
		else{
			int[] temp = setOfStacks.get(actualIndex/sizeLimit);
			int element = temp[actualIndex%sizeLimit];
			noOfDelList.add(subStackNumber, noOfDelList.get(subStackNumber)+1);
			return element;
		}
	}
	private static int peek(ArrayList<int[]> setOfStacks) {
		if(!stackIsEmpty()){
			int[] temp = setOfStacks.get(tos/sizeLimit);
			int element = temp[tos%sizeLimit];
			return element;
		}
		else
			return Integer.MAX_VALUE;
	}
	private static int pop(ArrayList<int[]> setOfStacks) {
		if(!stackIsEmpty()){
			int[] temp = setOfStacks.get(tos/sizeLimit);
			int element = temp[tos%sizeLimit];
			tos--;
			return element;
		}
		else
			return Integer.MAX_VALUE;
	}
	
	private static boolean stackIsEmpty() {
		if(tos==-1)
			return true;
		else
			return false;
	}
	
	private static int push(ArrayList<int[]> setOfStacks, int element, ArrayList<Integer> noOfDelList) {
		if(!subStackIsFull()){
			int[] temp = setOfStacks.get(tos/sizeLimit);
			temp[(++tos)%sizeLimit]=element;
		}
		else{
			int[] temp = new int[sizeLimit];
			temp[0]=element;
			setOfStacks.add(temp);
			noOfDelList.add(0);
			tos++;		
		}
		return element;		
	}
	private static boolean subStackIsFull() {
		if(tos%sizeLimit == sizeLimit-1)
			return true;
		else
			return false;
	}

}
