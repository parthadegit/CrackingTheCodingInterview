package chapter_04_Tree;

import java.util.Random;

public class SuccessorAndPredeccessorOfBinaryTreeWithParentPointer {

	public static void main(String[] args) {
		int[] arr = {10, -20, 30, 50, 13, 70, 32, -40, 28, 55, 51, 45, 75, 78, 14};
		TreeNodeWithParentPointer root = new TreeNodeWithParentPointer();
		root=root.buildFullBinaryTree(arr);
		printTreeInOrderRec(root);
		TreeNodeWithParentPointer node = root;//getArbitraryNode(root);
		TreeNodeWithParentPointer succ = findSuccessor(node);
		TreeNodeWithParentPointer pred = findPredecessor(node);
		System.out.println();
		System.out.println("root "+root.data+" succ "+succ.data+", pred "+pred.data);
		//check for the other cases
	}
	
	private static TreeNodeWithParentPointer findPredecessor(TreeNodeWithParentPointer node) {
		if(node == null)
			return null;
		if(node.left!=null)
			return findMostRightOnLeft(node.left);
		TreeNodeWithParentPointer cur = node;
		TreeNodeWithParentPointer parent = cur.parent;
		while(parent!=null && parent.right!=cur){
			cur = parent;
			parent = cur.parent;
		}
		return parent;
	}
	private static TreeNodeWithParentPointer findMostRightOnLeft(TreeNodeWithParentPointer node) {
		while(node.right!=null)
			node = node.right;
		return node;
	}
	private static TreeNodeWithParentPointer findSuccessor(TreeNodeWithParentPointer node) {
		if(node==null)
			return null;
		if(node.right!=null)
			return findMostLeftOnRight(node.right);
		TreeNodeWithParentPointer cur = node;
		TreeNodeWithParentPointer parent = cur.parent;
		while(parent!=null && parent.left!=cur){
			cur = parent;
			parent = cur.parent;
		}
		return parent;
	}
	private static TreeNodeWithParentPointer findMostLeftOnRight(TreeNodeWithParentPointer node) {
		while(node.left!=null)
			node = node.left;
		return node;
	}
	
	private static TreeNodeWithParentPointer getArbitraryNode(TreeNodeWithParentPointer root) {
		int r =Math.abs((new Random()).nextInt());
		TreeNodeWithParentPointer t = null;
		return t;
	}
	
	private static void printTreeInOrderRec(TreeNodeWithParentPointer root) {
		if(root == null)
			return;
		else{
			printTreeInOrderRec(root.left);
			System.out.print(root.data+", ");
			printTreeInOrderRec(root.right);
		}
	}

}
