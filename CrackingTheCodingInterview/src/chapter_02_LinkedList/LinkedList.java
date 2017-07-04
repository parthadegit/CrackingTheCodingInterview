package chapter_02_LinkedList;

public class LinkedList {
	//A linkedList is defined by its head 
	//Its length is an optional  member that can be maintained
	private Node head;
	
	public LinkedList() {
		super();
	}
	
	public LinkedList(int nodeCount) {
		for(int i=0; i<nodeCount;i++){
			addToEnd(i);
		}
	}
	
	public LinkedList(int[] nodeValueList) {
		for(int i=0; i<nodeValueList.length;i++){
			addToEnd(nodeValueList[i]);
		}
	}

	public void addToEnd(int value) {
		Node item=new Node(value);
		if(head == null)
			head = item;
		else{
			Node temp = head;
			while(temp.getNextPointer()!=null){
				temp = temp.getNextPointer();
			}
			temp.setNextPointer(item);
		}
	}
	
	private void addToBeg(int value){
		Node item = new Node(value);
		if(head == null)
			head=item;
		else{
			item.setNextPointer(head);
			head=item;
		}
	}
	
	public void addToBeg(Node item){
		if(head == null)
			head=item;
		else{
			item.setNextPointer(head);
			head=item;
		}
	}
	
	public void displayLinkedList(){
		if(head == null)
			System.out.println("No item is presentin the linkedlist");
		else{
			Node temp = head;
			while(temp.getNextPointer()!=null){
				System.out.print(temp.getValue()+"-->");
				temp = temp.getNextPointer();
			}
			System.out.print(temp.getValue()+"~~\n");
		}
	}
	

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

}
