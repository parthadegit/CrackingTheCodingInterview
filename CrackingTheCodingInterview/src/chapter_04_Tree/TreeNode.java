package chapter_04_Tree;

public class TreeNode {
	//Ideally these variables should not be public
	public int data;
	public TreeNode left;
	public TreeNode right;	

	public TreeNode() {
		super();
	}

	public TreeNode(int data) {
		super();
		this.data = data;
	}

	public TreeNode buildFullBinaryTree(int[] arr) {
		TreeNode[] arrNodes = new TreeNode[arr.length];
		for(int i=0;i<arr.length;i++){
			TreeNode tn = new TreeNode();
			tn.data = arr[i];
			tn.left  =  null;
			tn.right = null;
			arrNodes[i] = tn;
		}
		TreeNode root = arrNodes[0];
		for(int i=0;i<arrNodes.length/2;i++){
			arrNodes[i].left = arrNodes[2*i+1];
			if(2*i+2<=arr.length-1)
				arrNodes[i].right = arrNodes[2*i+2];
		}
		return root;
	}
	
	
}
