package chapter_03_StackAndQueue;

import java.util.Scanner;

public class ImplementThreeStacksInOneArray {
	static int tos1,tos2,tos3,base3;
	public static void main(String[] args) {
		int size = 6;
		int[] stackArray = new int[size];
		tos1 = -1;
		tos2 = stackArray.length;
		tos3 = stackArray.length/3-1;
		base3 = stackArray.length/3;
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("Enter 1 to PUSH, 2 to POP, 3 to PEEK and 4 to EXIT.");
			int option = sc.nextInt();
			int stackNumber=0;
			boolean breakFlag = false;
			int x;
			switch(option){
				case 1:
					System.out.println("Enter the stack number: ");
					stackNumber = sc.nextInt();
					System.out.println("Enter the element: ");
					int element = sc.nextInt();
					if(stackNumber == 1 ||stackNumber == 2||stackNumber == 3){
						x=insert(stackArray,stackNumber,element);
						if(x!=Integer.MAX_VALUE)
							System.out.println(x+" is pushed into Stack "+stackNumber);
						else
							System.out.println("All the stacks are full.");
					}
					else{
						System.out.println("Wrong stack number is entered.");
					}	
					break;
				
				case 2:
					System.out.println("Enter the stack number: ");
					stackNumber = sc.nextInt();
					if(stackNumber == 1 ||stackNumber == 2||stackNumber == 3){
						x=delete(stackArray,stackNumber);
						if(x!=Integer.MAX_VALUE)
							System.out.println(x+" is popped from Stack "+stackNumber);
						else
							System.out.println("Stack "+stackNumber+" is empty.");
					}
					else{
						System.out.println("Wrong stack number is entered.");
					}	
					break;
					
				case 3:
					System.out.println("Enter the stack number: ");
					stackNumber = sc.nextInt();
					if(stackNumber == 1 ||stackNumber == 2||stackNumber == 3){
						x=checkTopElement(stackArray,stackNumber);
						if(x!=Integer.MAX_VALUE)
							System.out.println(x+" is in the top of Stack "+stackNumber);
						else
							System.out.println("Stack "+stackNumber+" is empty.");
					}
					else{
						System.out.println("Wrong stack number is entered.");
					}	
					break;
					
				case 4:
					breakFlag = true;
					break;
					
				default:
					System.out.println("Wrong option entered. Please between 1 and 4.");
			}
			//debugPrint(stackArray);
			if(breakFlag == true)
				break;
		}
	}

	private static int checkTopElement(int[] stackArray, int stackNumber) {
		if(isEmpty(stackNumber,stackArray.length))
			return Integer.MAX_VALUE;
		else{
			if(stackNumber == 1)
				return stackArray[tos1];
			else if(stackNumber == 2)
				return stackArray[tos2];
			else
				return stackArray[tos3];
		}
	}

	private static int delete(int[] stackArray, int stackNumber) {
		int x=0;
		if(isEmpty(stackNumber,stackArray.length))
			return Integer.MAX_VALUE;
		else{
			if(stackNumber == 1){
				x = stackArray[tos1];
				tos1--;
			}
			else if(stackNumber == 2){
				x = stackArray[tos2];
				tos2++;
			}
			else{
				x = stackArray[tos3];
				tos3--;
			}
		}
		return x;
	}

	private static boolean isEmpty(int stackNumber, int size) {
		if(stackNumber == 1){
			if(tos1 == -1)
				return true;
			else
				return false;
		}
		else if(stackNumber == 3){
			if(tos3==base3-1)
				return true;
			else
				return false;
		}
		else{
			if(tos2==size)
				return true;
			else
				return false;
		}
	}

	private static int insert(int[] stackArray, int stackNumber,int element) {
		if(isFull(stackNumber)){
			if(tos2-tos3==1 && base3-tos1==1)
				return Integer.MAX_VALUE;
			else{
				if(base3-tos1==1)
					rearrangeStacks(stackArray,2);
				else if(tos2-tos3==1)
					rearrangeStacks(stackArray,1);
				
			}
		}
		if(stackNumber == 1){
			stackArray[++tos1]=element;
			return stackArray[tos1];
		}
		else if(stackNumber == 2){
			stackArray[--tos2]=element;
			return stackArray[tos2];
		}
		else{
			stackArray[++tos3]=element;	
			return stackArray[tos3];
		}
	}

	private static void rearrangeStacks(int[]stackArray,int sN) {
		int freeSpace = 0;
		if(sN == 1){
			freeSpace = base3-tos1;
			int tempBase = base3;
			base3 = base3 - freeSpace/2;
			int i = base3;
			for(;tempBase != tos2;i++,tempBase++){
				stackArray[i]=stackArray[tempBase];
			}
			tos3 = --i;
		}
		else{
			freeSpace = tos2-tos3;
			int tempTos = tos3;
			tos3 = tos3 + freeSpace/2;
			int i = tos3;
			for(;tempTos>=base3;i--,tempTos--){
				stackArray[i]=stackArray[tempTos];
			}
			base3 = ++i;
		}
	}

	private static boolean isFull(int stackNumber) {
		if(stackNumber == 1){
			if(tos1+1==base3)
				return true;
			else
				return false;
		}
		else if(stackNumber == 3){
			if(tos3+1==tos2)
				return true;
			else
				return false;
		}
		else{
			if(tos2-1==tos3)
				return true;
			else
				return false;
		}
	}
	
	private static void debugPrint(int[] stackArray){
		for(int i=0;i<stackArray.length;i++)
			System.out.print(stackArray[i]+",");
		System.out.println();
		System.out.println("tos1="+tos1+"\ntos2="+tos2+"\ntos3="+tos3);
	}

}
