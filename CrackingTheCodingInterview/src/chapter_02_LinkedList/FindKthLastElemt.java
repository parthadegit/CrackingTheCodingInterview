package chapter_02_LinkedList;

public class FindKthLastElemt {

	public static void main(String[] args) {
		LinkedList myList = new LinkedList(10);
		myList.displayLinkedList();
		System.out.println();
		int k=3;
		Node res = getKthLast(myList.getHead(),k);
		if(res!=null)
			System.out.println("The "+k+"-th last elementin the list is: "+res.getValue());
		else
			System.out.println("The list may have less that kelements."); 
	}

	private static Node getKthLast(Node head, int k) {
		Node tempB = head, tempF = head;
		for(int i=0;i<k-1;i++){
			tempF = tempF.getNextPointer();
			if(tempF == null)
				return null;
		}
		while(tempF.getNextPointer()!=null){
			tempF = tempF.getNextPointer();
			tempB = tempB.getNextPointer();
		}
		return tempB;
	}

}
