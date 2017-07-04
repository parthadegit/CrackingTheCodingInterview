package chapter_04_Tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListForAllNodesInALevelOfATree {

	public static void main(String[] args) {
		int[] arr = {10, -20, 30, 50, 13, 70, 32, -40, 28, 55, 51, 45, 75, 78, 14};
		TreeNode root = new TreeNode();
		root=root.buildFullBinaryTree(arr);
		printTreeInOrderRec(root);
		ArrayList<LinkedList<TreeNode>> treeList = getAllLists(root);
		printAllLists(treeList);
	}

	private static void printAllLists(ArrayList<LinkedList<TreeNode>> treeList) {
		for(int i=0;i<treeList.size();i++){
			System.out.println();
			for(int j=0;j<treeList.get(i).size();j++){
				if(treeList.get(i).get(j)!=null)
					System.out.print(treeList.get(i).get(j).data+"->");
			}
		}
		
	}

	private static ArrayList<LinkedList<TreeNode>> getAllLists(TreeNode root) {
		int level =0;
		ArrayList<LinkedList<TreeNode>> treeList = new ArrayList<LinkedList<TreeNode>>();
		ArrayList<TreeNode> bFSOutput = BFS(root);
		LinkedList<TreeNode> x = new LinkedList<TreeNode>();
		x.add(bFSOutput.get(0));
		treeList.add(x);
		for(int i=1;i<bFSOutput.size();i++){
			treeList.get(level).add(bFSOutput.get(i));
			if(bFSOutput.get(i)==null){
				if(i==bFSOutput.size()-1)
					break;
				x = new LinkedList<TreeNode>();
				i++;
				x.add(bFSOutput.get(i));
				treeList.add(x);
				level++;
			}
		}
		return treeList;
	}

	private static ArrayList<TreeNode> BFS(TreeNode root) {
		ArrayList<TreeNode> bFSOutput = new ArrayList<TreeNode>();
		bFSOutput.add(root);
		bFSOutput.add(null);
		for(int i=0;i<bFSOutput.size();i++){
			if(bFSOutput.get(i)==null){
				if(i!=bFSOutput.size()-1)
					bFSOutput.add(null);
			}
			else{
				if(bFSOutput.get(i).left!=null)
					bFSOutput.add(bFSOutput.get(i).left);
				if(bFSOutput.get(i).right!=null)
					bFSOutput.add(bFSOutput.get(i).right);
			}	
		}
		return bFSOutput;
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
