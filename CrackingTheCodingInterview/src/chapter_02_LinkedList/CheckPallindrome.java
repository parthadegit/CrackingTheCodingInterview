package chapter_02_LinkedList;

public class CheckPallindrome {

	public static void main(String[] args) {
		//int[] list = {9,1,9,3,4,1,1,6,2,9,7};
		//int[] list = {9,1,2,3,4,1,4,3,2,1,9};
		int[] list = {9,1,2,3,4,4,3,2,1,9};
		LinkedList listPallindrome = new LinkedList(list);
		LinkedList rev = getMidElementOfLinkedList(listPallindrome.getHead());
		listPallindrome.displayLinkedList();
		rev.displayLinkedList();			
		boolean isPallindrome = checkPallindrome(listPallindrome.getHead(),rev.getHead());
		if(isPallindrome)
			System.out.println("The list is a pallindrome.");
		else
			System.out.println("The list is NOT a pallindrome.");
	}
	
	private static boolean checkPallindrome(Node lpHead, Node revHead) {
		while(lpHead.getNextPointer()!=null && revHead.getNextPointer()!=null){
			if(lpHead.getValue()!=revHead.getValue())
				return false;
			lpHead = lpHead.getNextPointer();
			revHead = revHead.getNextPointer();
		}
		return true;
	}

	private static LinkedList getMidElementOfLinkedList(Node head) {
		Node tempB, tempF;
		tempB = head;
		tempF = head;
		while(tempF.getNextPointer()!=null && tempF.getNextPointer().getNextPointer()!=null){
			tempB = tempB.getNextPointer();
			tempF = tempF.getNextPointer().getNextPointer();
		}
		//System.out.println(tempB.getValue());
		LinkedList reversedHalfList = new LinkedList(); 
		while(tempB.getNextPointer()!=null){
			/*Alternate solution where the node is removed from the actual linked list. So no extra space is used. 
			  Node nodeToRemove = tempB.getNextPointer();
			  if(tempB.getNextPointer().getNextPointer()==null)
			  	tempB.setNextPointer(null);
			  else
			  	tempB.setNextPointer(tempB.getNextPointer().getNextPointer());
			  nodeToRemove.setNextPointer(null);
			  reversedHalfList.addToBeg(nodeToRemove);*/
			
			Node temp = new Node(tempB.getValue());
			reversedHalfList.addToBeg(temp);
			tempB = tempB.getNextPointer();
		}
		reversedHalfList.addToBeg(new Node(tempB.getValue()));
		return reversedHalfList;
	}

}
