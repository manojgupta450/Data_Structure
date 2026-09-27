package creational.binaryTree;

public class _027RemoveChild {
	Node root=null;
	public void removeChild(Node node ) {
		if(node == null || (node.left==null && node.right==null)) {
			return;
		}
		
		if(node.left!=null && node.right!=null) {
			
			while(node.left.left!=null && node.left.right==null) {
				node.left=node.left.left;
			}
			while(node.left.right!=null && node.left.left==null) {
				node.left=node.left.right;
			}
			removeChild(node.left);
			while(node.right.left==null && node.right.right!=null) {
				node.right=node.right.right;
			}
			while(node.right.left!=null && node.right.right==null) {
				node.right=node.right.left;
			}
			removeChild(node.right);
		}else {
			if(node.left!=null && node.right==null) {
				node=node.left;
				removeChild(node.left);
				if(node.left==null && node.right==null) {
					root=node;
				}
			}else if(node.left==null && node.right!=null) {
				node=node.right;
				removeChild(node.right);
				if(node.left==null && node.right==null) {
					root=node;
				}	
			}/*else {
				root=node;
			}*/
		}
	}
		
	public static void main(String[] args) {
		_027RemoveChild tree = new _027RemoveChild();
	     tree.root = new Node(1);
	     tree.root.left = new Node(2);
	     tree.root.left.left = new Node(3);
	     tree.root.left.left .left= new Node(4);
	     
	     
	     /*tree.root = new Node(1);
	     tree.root.left = new Node(5);
	     tree.root.left.right = new Node(7);
	     tree.root.right = new Node(2);
	     tree.root.right.left = new Node(6);
	     tree.root.right.right = new Node(3);
	     tree.root.right.right .right= new Node(4);*/
	     tree.removeChild(tree.root);
	     
	     
	     
	     System.out.println(tree.root);

	}

}
