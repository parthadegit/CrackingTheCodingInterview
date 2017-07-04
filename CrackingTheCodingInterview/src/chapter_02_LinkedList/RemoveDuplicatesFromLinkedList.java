package chapter_02_LinkedList;

import java.util.Hashtable;
/*
 * This code uses hash table of type Hashtable<Integer,boolean>. Time complexity is O(n) with extra space O(n).
 * If extra space is not allowed the best possible algorithm is of O(n^2).
 */
public class RemoveDuplicatesFromLinkedList {

	public static void main(String args[]){
		int[] list = {1,1,2,3,4,1,6,2,9,9};
		LinkedList myList = new LinkedList(list);
		myList.displayLinkedList();
		removeDuplicate(myList, myList.getHead());
		myList.displayLinkedList();
	}

	private static void removeDuplicate(LinkedList myList, Node head) {
		Hashtable<Integer,Boolean> ht =new Hashtable<Integer, Boolean>();
		Node tempB = head;
		ht.put(tempB.getValue(),true);
		Node temp = head.getNextPointer();//Assuming that the list has at least two nodes.
		while(temp.getNextPointer()!=null){
			if(ht.containsKey(temp.getValue())){
				temp = temp.getNextPointer();
				tempB.getNextPointer().setNextPointer(null);
				tempB.setNextPointer(temp);
			}
			else{
				ht.put(temp.getValue(),true);
				temp = temp.getNextPointer();
				tempB = tempB.getNextPointer();
			}
		}
		if(ht.containsKey(temp.getValue())){
			tempB.getNextPointer().setNextPointer(null);
			tempB.setNextPointer(null);
		}
	}


}
