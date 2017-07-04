package chapter_02_LinkedList;

public class PartitionLinkedListAroundValue {

	public static void main(String[] args) {
		int[] list = {5,5,5,1,4,2,2,1,1,3,3,2,6};
		LinkedList myList = new LinkedList(list);
		myList.displayLinkedList();
		//System.out.println("Enter the value around which the list needs to be partitioned: ");
		Node head = null; 
		int pivot = 3;
		if(myList.getHead().getNextPointer()!=null){
			head = partitionListAroundPivot(myList.getHead(),pivot);
			myList.setHead(head);
		}
		myList.displayLinkedList();
	}

	private static Node partitionListAroundPivot(Node head, int pivot) {
		LinkedList largerValueList = new LinkedList();
		Node tempF = head.getNextPointer(), tempB = head;
		
		while(tempF.getNextPointer()!=null){
			if(tempF.getValue()>=pivot){
				Node nodeToRemove = tempF;
				tempF=tempF.getNextPointer();
				tempB.setNextPointer(tempF);
				nodeToRemove.setNextPointer(null);
				largerValueList.addToBeg(nodeToRemove);
			}
			else{
				tempF = tempF.getNextPointer();
				tempB = tempB.getNextPointer();
			}
		}
		//For the last node
		if(tempF.getValue()>=pivot){
			Node nodeToRemove = tempF;
			tempB.setNextPointer(null);
			largerValueList.addToBeg(nodeToRemove);
		}
		//For the first node
		if(head.getValue()>=pivot){
			Node nodeToRemove = head;
			head=head.getNextPointer();
			nodeToRemove.setNextPointer(null);
			largerValueList.addToBeg(nodeToRemove);
		}
		
		//Merging the two lists
		tempF = head;
		while(tempF.getNextPointer()!=null)
			tempF = tempF.getNextPointer();
		tempF.setNextPointer(largerValueList.getHead());
		return head;
	}

}
