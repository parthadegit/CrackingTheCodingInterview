package chapter_02_LinkedList;

public class LargeNumberSum {

	public static void main(String[] args) {
		int[] list1 = {9,1,9,3,4,1,6,2,9,7};
		LinkedList number1 = new LinkedList(list1);
		int[] list2 = {5,1,2,3,4,1,6,2,9,1,9,9,8,9};
		LinkedList number2 = new LinkedList(list2);
		int base = 10;
		Node head = calculateSumOfLargeNumbers(number1.getHead(),number2.getHead(), base);
		LinkedList sum = new LinkedList();
		sum.setHead(head);
		number1.displayLinkedList();
		number2.displayLinkedList();
		sum.displayLinkedList();			
	}

	private static Node calculateSumOfLargeNumbers(Node head1, Node head2, int base) {
		LinkedList sum = new LinkedList();
		Node temp1 = head1, temp2 = head2;
		int s = 0, c= 0;
		while(temp1.getNextPointer()!=null && temp2.getNextPointer()!=null){
			s = (c+temp1.getValue()+temp2.getValue())%base;
			c = (c+temp1.getValue()+temp2.getValue())/base;
			sum.addToEnd(s);
			temp1 = temp1.getNextPointer();
			temp2 = temp2.getNextPointer();
		}
		s = (c+temp1.getValue()+temp2.getValue())%base;
		c = (c+temp1.getValue()+temp2.getValue())/base;
		sum.addToEnd(s);
		
		Node temp;
		if(temp1.getNextPointer()!=null)
			temp = temp1;
		else
			temp = temp2;
		
		if(c==0){
			temp = temp.getNextPointer();
			Node sumHead = sum.getHead();
			while(sumHead.getNextPointer()!=null){
				sumHead=sumHead.getNextPointer();
			}
			sumHead.setNextPointer(temp);
		}
		else{
			temp = temp.getNextPointer();
			while(temp.getNextPointer()!=null){
				s = (c+temp.getValue())%base;
				c = (c+temp.getValue())/base;
				sum.addToEnd(s);
				temp = temp.getNextPointer();
			}
			s = (c+temp.getValue())%base;
			c = (c+temp.getValue())/base;
			sum.addToEnd(s);
			sum.addToEnd(c);
		}
		return sum.getHead();
	}

}
