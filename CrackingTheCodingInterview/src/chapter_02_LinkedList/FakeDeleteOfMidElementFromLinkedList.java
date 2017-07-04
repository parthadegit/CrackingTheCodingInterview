package chapter_02_LinkedList;

public class FakeDeleteOfMidElementFromLinkedList {

	public static void main(String[] args) {
		LinkedList myList = new LinkedList(1);
		myList.displayLinkedList();
		Node midElement = getMidElementOfLinkedList(myList.getHead());
		System.out.println("\nMid element is: "+midElement.getValue());
		fakeRemoveMiddleElement(midElement);
		myList.displayLinkedList();
	}

	//Function to find the middle element of a linked list.
	//Slow pointer will be forwarded one step and fast pointer will be forwarded two step in each cycle.
	private static Node getMidElementOfLinkedList(Node head) {
		Node tempB, tempF;
		tempB = head;
		tempF = head;
		while(tempF.getNextPointer()!=null && tempF.getNextPointer().getNextPointer()!=null){
			tempB = tempB.getNextPointer();
			tempF = tempF.getNextPointer().getNextPointer();
		}
		return tempB;
	}

	//This is a fake delete as the actual node is not deleted, b
	private static void fakeRemoveMiddleElement(Node midElement) {
		if(midElement.getNextPointer()!=null){	
			midElement.setValue(midElement.getNextPointer().getValue());
			midElement.setNextPointer(midElement.getNextPointer().getNextPointer());
		}
	}

}
