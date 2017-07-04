package chapter_04_Tree;

public class TreeNodeWithParentPointer {
	//Ideally these variables should not be public
		public int data;
		public TreeNodeWithParentPointer left;
		public TreeNodeWithParentPointer right;
		public TreeNodeWithParentPointer parent;

		public TreeNodeWithParentPointer() {
			super();
		}

		public TreeNodeWithParentPointer(int data) {
			super();
			this.data = data;
		}

		public TreeNodeWithParentPointer buildFullBinaryTree(int[] arr) {
			TreeNodeWithParentPointer[] arrNodes = new TreeNodeWithParentPointer[arr.length];
			for(int i=0;i<arr.length;i++){
				TreeNodeWithParentPointer tn = new TreeNodeWithParentPointer();
				tn.data = arr[i];
				tn.left  =  null;
				tn.right = null;
				arrNodes[i] = tn;
			}
			TreeNodeWithParentPointer root = arrNodes[0];
			for(int i=0;i<arrNodes.length/2;i++){
				arrNodes[i].left = arrNodes[2*i+1];
				if(2*i+2<=arr.length-1)
					arrNodes[i].right = arrNodes[2*i+2];
			}
			for(int i=arrNodes.length-1;i>0;i--)
				arrNodes[i].parent = arrNodes[(i-1)/2];
			return root;
		}
}
