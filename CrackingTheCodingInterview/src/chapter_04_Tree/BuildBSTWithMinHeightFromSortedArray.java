package chapter_04_Tree;


public class BuildBSTWithMinHeightFromSortedArray {

	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 50, 53, 70, 72, 74, 85, 88, 91, 95, 115, 128, 134};
		TreeNode root = buildMinHeightBSTFromSortedArray(arr,0,arr.length-1);
		printTreeInOrderRec(root);
	}
	
	
	private static TreeNode buildMinHeightBSTFromSortedArray(int[] arr, int startIndex, int endIndex) {
		int mid = (startIndex+endIndex)/2;
		if(startIndex>endIndex)
			return null;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = buildMinHeightBSTFromSortedArray(arr,startIndex,mid-1);
		root.right = buildMinHeightBSTFromSortedArray(arr,mid+1,endIndex);
		return root;
	}
	

	private static void printTreeInOrderRec(TreeNode root) {
		if(root == null)
			return;
		else{
			printTreeInOrderRec(root.left);
			System.out.print(root.data+", ");
			printTreeInOrderRec(root.right);
		}
	}


}
