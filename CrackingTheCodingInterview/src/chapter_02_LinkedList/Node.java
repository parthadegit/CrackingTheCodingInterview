package chapter_02_LinkedList;

public class Node{
		private int value;
		private Node nextPointer;
		
		
		public Node() {
			super();
		}

		public Node(int value) {
			this.value = value;
			nextPointer = null;
		}
		
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public Node getNextPointer() {
			return nextPointer;
		}
		public void setNextPointer(Node nextPointer) {
			this.nextPointer = nextPointer;
		}
		
		
	}
	
