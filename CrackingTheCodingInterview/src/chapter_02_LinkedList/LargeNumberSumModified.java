package chapter_02_LinkedList;

public class LargeNumberSumModified {

	public static void main(String[] args) {
		int[] list1 = {9,1,9,3,4,1,6,2,9,9,9,9,9,9,9,9,9,9};
		LinkedList number1 = new LinkedList(list1);
		int[] list2 = {5,1,2,3,4,1,6,2,9,1,9,9,9,9};
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
		
		//Here is the difference in the Modified version. Temp1!=null is used instead of temp1.next!=null
		
		while(temp1!=null && temp2!=null){
			s = (c+temp1.getValue()+temp2.getValue())%base;
			c = (c+temp1.getValue()+temp2.getValue())/base;
			sum.addToEnd(s);
			temp1 = temp1.getNextPointer();
			temp2 = temp2.getNextPointer();
		}
		
		Node temp;
		if(temp1!=null)
			temp = temp1;
		else
			temp = temp2;
		
		if(c==0){
			Node sumHead = sum.getHead();
			while(sumHead.getNextPointer()!=null){
				sumHead=sumHead.getNextPointer();
			}
			sumHead.setNextPointer(temp);
		}
		else{
			while(temp!=null){
				s = (c+temp.getValue())%base;
				c = (c+temp.getValue())/base;
				sum.addToEnd(s);
				temp = temp.getNextPointer();
			}
			if(c!=0)
				sum.addToEnd(c);
		}
		return sum.getHead();
	}

}
