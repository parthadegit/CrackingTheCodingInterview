package chapter_04_Tree;

public class LCAForNodesInBSTWithParentPointer {

	public static void main(String[] args) {
		int[] arr2 = {10, -20, 30, -50, 13, 17, 32, -60, 28, 5, 51, 15, 75, 14, 78};
		int[] arr = {11, 9, 30, -50, 10, 17, 35, -60, -28, 10, 11, 15, 25, 31, 78};
		TreeNode root = new TreeNode();
		root=root.buildFullBinaryTree(arr);
		printTreeInOrderRec(root);
		System.out.println();
		int n1 = -60, n2 = 35;
		TreeNode res = getLCAForNodesInBST(root, n1, n2);
		if(res!=null)
			System.out.println("LCA in BST for node "+n1+" and "+n2+" is "+res.data);
		else
			System.out.println("One or more elements are not present in the BST");
	}

	private static TreeNode getLCAForNodesInBST(TreeNode root, int n1, int n2) {
		if(root==null)
			return null;
		if(root.data==n1 || root.data == n2){
			if(isChildInBST(root,root.data==n1?n2:n1)) //Case where one node is parent of other node
				return root;
			else
				return null;
		}
		if(root.data>n1 && root.data>n2)
			return getLCAForNodesInBST(root.left,n1,n2);
		else if(root.data<n1 && root.data<n2)
			return getLCAForNodesInBST(root.right,n1,n2);
		else
			return root;
	}

	private static boolean isChildInBST(TreeNode root, int val) {
		if(root==null)
			return false;
		if(root.data==val)
			return true;
		else{
			if(val<root.data)
				return isChildInBST(root.left,val);
			else 
				return isChildInBST(root.right,val);
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
