package creational.binaryTree;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=Jg4E4KZstFE&index=7&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu
public class _003RootToLeafSumBinaryTree {
	Node root;
	
	public _003RootToLeafSumBinaryTree() {
		this.root = null;
	}

	public boolean rootToLeafSum(Node node,int sum,List<Integer> results){
		if(node == null)
			return false;
		if(node.left ==  null && node.right == null) {
			if(node.data == sum) {
				results.add(node.data);
				return true;
			}
			else {
				return false;
			}	
		}
		
		if(rootToLeafSum(node.left,sum-node.data,results)) {
			results.add(node.data);
			return true;
		}
		if(rootToLeafSum(node.right,sum-node.data,results)) {
			results.add(node.data);
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		List<Integer> results = new ArrayList<Integer>();
		_003RootToLeafSumBinaryTree bt=new _003RootToLeafSumBinaryTree();
		bt.root=new Node(10);
		bt.root.left=new Node(16);
		bt.root.left.right=new Node(-3);
		bt.root.right=new Node(5);
		bt.root.right.left=new Node(6);
		bt.root.right.right=new Node(11);
		System.out.println("Sum is :" +bt.rootToLeafSum(bt.root, 26, results));
		System.out.println(results);
	}

}
