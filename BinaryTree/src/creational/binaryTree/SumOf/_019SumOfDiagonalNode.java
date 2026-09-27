package creational.binaryTree.SumOf;

import java.util.*;
import java.util.Map.Entry;

class TreeNode
{
 int data; 
 int vd; //vertical distance diagonally
 TreeNode left, right;

 public TreeNode(int data)
 {
     this.data = data;
     vd = Integer.MAX_VALUE;
     left = right = null;
 }
}

class _019SumOfDiagonalNode
{
 TreeNode root;

 public _019SumOfDiagonalNode(TreeNode root)  {  this.root = root;  }

 public void diagonalSum()
 {
     Queue<TreeNode> queue = new LinkedList<TreeNode>();
     Map<Integer, Integer> map = new TreeMap<>();
     root.vd = 0;

     queue.add(root);

     while (!queue.isEmpty())
     {
         TreeNode curr = queue.remove();

         // Get the vertical distance of the dequeued node.
         int vd = curr.vd;

         // Sum over this node's right-child, right-of-right-child
         // and so on
         while (curr != null)
         {
             int prevSum = (map.get(vd) == null)? 0: map.get(vd);
             map.put(vd, prevSum + curr.data);

             // If for any node the left child is not null add
             // it to the queue for future processing.
             if (curr.left != null)
             {
                 curr.left.vd = vd+1;
                 queue.add(curr.left);
             }
             curr = curr.right;
         }
     }
     Set<Entry<Integer, Integer>> set = map.entrySet();

     Iterator<Entry<Integer, Integer>> iterator = set.iterator();
     System.out.print("Diagonal sum in a binary tree is - ");
     while (iterator.hasNext())
     {
         Map.Entry<Integer, Integer> me = iterator.next();

         System.out.print(me.getValue()+" ");
     }
 }
 
 public static void main(String[] args)
 {
     TreeNode root = new TreeNode(1);
     root.left = new TreeNode(2);
     root.right = new TreeNode(3);
     root.left.left = new TreeNode(9);
     root.left.right = new TreeNode(6);
     root.right.left = new TreeNode(4);
     root.right.right = new TreeNode(5);
     root.right.left.left = new TreeNode(12);
     root.right.left.right = new TreeNode(7);
     root.left.right.left = new TreeNode(11);
     root.left.left.right = new TreeNode(10);
     _019SumOfDiagonalNode tree = new _019SumOfDiagonalNode(root);
     tree.diagonalSum();
 }
}
