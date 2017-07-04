package chapter_04_Tree;

public class CheckIfBinaryTreeIsBST {
	
	/*
	 * This code is using three parameters in the function call.
	 * This one does not have the custom return type with boolean flag and upper and range.
	 * The rang is indirectly passed through as function parameter.
	*/
	
	public static void main(String[] args) {
		int[] arr2 = {10, -20, 30, -50, 13, 17, 32, -60, 28, 5, 51, 15, 75, 14, 78};
		int[] arr = {11, 11, 30, -50, 9, 17, 35, -60, -28, 5, 10, 15, 25, 31, 78};
		TreeNode root = new TreeNode();
		root=root.buildFullBinaryTree(arr);
		printTreeInOrderRec(root);
		boolean status = isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
		System.out.println();
		if(status)
			System.out.println("BST");
		else
			System.out.println("Not BST");

	}
	private static boolean isBST(TreeNode root, int minValue, int maxValue) {
		if(root==null)
			return true;
		if(!(root.data>minValue) || !(root.data<=maxValue)) // right sub tree> Root value >= left sub tree
			return false;
		else{
			return isBST(root.left, minValue, root.data)&& isBST(root.right, minValue,maxValue);
		}
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
