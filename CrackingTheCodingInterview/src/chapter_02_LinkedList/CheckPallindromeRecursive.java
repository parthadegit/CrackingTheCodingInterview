package chapter_02_LinkedList;

public class CheckPallindromeRecursive {

	public static void main(String[] args) {
		int[] list = {9,1,9,3,4,1,1,6,2,9,7};
		//int[] list = {9,1,2,3,4,1,4,3,2,1,9};
		//int[] list = {9,1,2,3,4,4,3,2,1,9};
		LinkedList listPallindrome = new LinkedList(list);
		int len =findLength(listPallindrome.getHead());
		Node isPallindrome = checkPallindromeRec(listPallindrome.getHead(),len);
		if(isPallindrome!=null)
			System.out.println("The list is a pallindrome.");
		else
			System.out.println("The list is NOT a pallindrome.");
	}

	private static Node checkPallindromeRec(Node head, int len) {
		if(head==null||len==1)
			return head;
		if(len == 2){
			if(head.getValue()==head.getNextPointer().getValue())
				return head.getNextPointer();
			else
				return null;
		}
		else{
			Node x = checkPallindromeRec(head.getNextPointer(),len-2);
			if(x==null)
				return null;
			else{
				if(head.getValue()==x.getNextPointer().getValue())
					return x.getNextPointer();
				else
					return null;
			}
				
		}
	}

	private static int findLength(Node head) {
		int count=0;
		Node temp = head;
		while(temp!=null){
			count++;
			temp=temp.getNextPointer();
		}
		return count;
	}

}
