package chapter_02_LinkedList;

public class LargeNumberSumRecursive {

	public static void main(String[] args) {
		int[] list1 = {9,1,9,3,4,1,6,2,9,7};
		LinkedList number1 = new LinkedList(list1);
		int[] list2 = {9,9,9,9,5,1,2,3,4,1,6,2,9,1};
		LinkedList number2 = new LinkedList(list2);
		int base = 10;
		LinkedList sum = new LinkedList();
		padSmallerList(number1,number2);
		
		int carry = calculateSumOfLargeNumbersRecursive(sum,number1.getHead(),number2.getHead(), base);
		if(carry>0)
			sum.addToBeg(new Node(carry));
		//sum.setHead(head);
		number1.displayLinkedList();
		number2.displayLinkedList();
		sum.displayLinkedList();			
	}

	private static void padSmallerList(LinkedList number1, LinkedList number2) {
		int length1 = getLength(number1.getHead());
		int length2 = getLength(number2.getHead());
		int x = 0;
		if(length1>length2){
			x=length1-length2;
			for(int i=0;i<x;i++)
				number2.addToBeg(new Node(0));
		}
		else{
			x=length2-length1;
			for(int i=0;i<x;i++)
				number1.addToBeg(new Node(0));
		}
		
	}

	private static int getLength(Node item) {
		if(item.getNextPointer() == null)
			return 0;
		else
			return 1+getLength(item.getNextPointer());
	}

	private static int calculateSumOfLargeNumbersRecursive(LinkedList sum, Node head1, Node head2, int b) {
		//Here, we are assuming the number 539 is represented as 5->3->9
		int base = b;
		int c = 0, x = 0;
		if(head1.getNextPointer() == null){
			x = (head1.getValue()+head2.getValue())%b;
			c = (head1.getValue()+head2.getValue())/b;
			sum.addToBeg(new Node(x));
		}
		else{
			c = calculateSumOfLargeNumbersRecursive(sum,head1.getNextPointer(),head2.getNextPointer(),base);
			x = (c + head1.getValue() + head2.getValue())%b;
			c = (c + head1.getValue() + head2.getValue())/b;
			sum.addToBeg(new Node(x));
		}
		return c;
		
	}

}
