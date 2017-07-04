package chapter_04_Tree;

public class ValidateBalancedTree {

	public static void main(String[] args) {
		int[] arr = {10, -20, 30, 50, 13, 70, 32, -40, 28, 55, 51, 45, 75, 78, 14};
		TreeNode root = new TreeNode();
		root=root.buildFullBinaryTree(arr);
		printTreeInOrderRec(root);
		System.out.println();
		unBalanceATree(2,root);
		printTreeInOrderRec(root);
		System.out.println();

		boolean status = isBalancedTree(root);
		if(status)
			System.out.println("Balanced");
		else
			System.out.println("Not Balanced");
		
	}

	static class RetType{
		boolean flag;
		int height;
		
		public RetType(boolean flag, int height) {
			super();
			this.flag = flag;
			this.height = height;
		}
		
	}
	
	private static boolean isBalancedTree(TreeNode root) {
		RetType ret = isBalancedTreeAux(root);
		return ret.flag;
	}

	private static RetType isBalancedTreeAux(TreeNode root) {
		if(root == null)
			return new RetType(true,0);
		RetType left=null,right=null;
		if(root!=null){
			left = isBalancedTreeAux(root.left);
			right = isBalancedTreeAux(root.right);
		}
		if(left.flag&&right.flag == true && Math.abs(left.height-right.height)<2)
			return new RetType(true,Math.max(left.height, right.height)+1);
		else
			return new RetType(false,Integer.MIN_VALUE);
	}
	
				//*******Auxiliary Function******//
	
	public static void unBalanceATree(int additionalLevel, TreeNode root){
			TreeNode temp= root;
			while(temp.left!= null)
				temp = temp.left;
			for(int i=0;i<additionalLevel;i++){
				temp.left = new TreeNode(i+50);
				temp = temp.left;
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
