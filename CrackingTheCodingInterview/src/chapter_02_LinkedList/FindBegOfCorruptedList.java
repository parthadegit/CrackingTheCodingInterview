package chapter_02_LinkedList;

public class FindBegOfCorruptedList {

	public static void main(String[] args) {
		int[] list = {5,1,2,3,4,1,6,2,9,9};
		LinkedList myList = new LinkedList(list);
		corruptLinkedList(myList.getHead());
		//myList.displayLinkedList();
		Node start = null;
		start = findBegOfCorruptedList(myList.getHead());
		if(start!= null)
			System.out.println("The list is corrupted and the starting point is: "+start.getValue());
		else
			System.out.println("the list is not corrupted.");
	}

	private static void corruptLinkedList(Node head) {
		int size = 0;
		Node temp = head;
		while(temp.getNextPointer()!=null){
			size++;
			temp = temp.getNextPointer();
		}
		Node end = temp;
		int stitchLoc = (int)(Math.random()*100)%size;
		System.out.println("Location of stitching (Starts from \'0\'. Needed for result verification): "+stitchLoc);
		temp = head;
		for(int i=0;i<stitchLoc;i++){
			temp = temp.getNextPointer();
		}
		end.setNextPointer(temp);
		
	}

	private static Node findBegOfCorruptedList(Node head) {
		Node tempF = head, tempB = head;
		while(tempF.getNextPointer().getNextPointer()!=null){
			tempF = tempF.getNextPointer().getNextPointer();
			tempB = tempB.getNextPointer();
			if(tempF == tempB){
				/* If the point of collision is found we need to find the starting of the loop.
				 * The distance between the head of the list and the stating of the loop is 'k'.
				 * Again, the distance between the collision point and the stating of the loop is 'k'.
				 * 
				 *  Reset the forward pointer to head of the list. 
				 *   
				*/
				tempB = head;
				while(true){
					//Equality checking should be done before forwarding the next pointers as the whole list may be part of the cycle.
					if(tempF == tempB)
						return tempF;
					tempF = tempF.getNextPointer();
					tempB = tempB.getNextPointer();
				}
			}
		}
		return null;
	}

}
