package creational.binaryTree;

public class _025LowestCommonAncestorOfBinaryTree
{
 Node root;
 static boolean v1 = false;
 static boolean v2 = false;
  
 Node findLCAUtil(Node root, int n1, int n2)
 {
     if (root == null)
         return null;

     // If either n1 or n2 matches with root's key, report the presence
     // by setting v1 or v2 as true and return root (Note that if a key
     // is ancestor of other, then the ancestor key becomes LCA)
     if (root.data == n1)
     {
         v1 = true;
         return root;
     }
     if (root.data == n2)
     {
         v2 = true;
         return root;
     }
     Node left_lca = findLCAUtil(root.left, n1, n2);
     Node right_lca = findLCAUtil(root.right, n1, n2);

     if (left_lca != null && right_lca != null)
         return root;

     return (left_lca != null) ? left_lca : right_lca;
 }
  
boolean find(Node root, int k)
{
 
 if (root == null)
     return false;

 if (root.data == k || find(root.left, k) ||  find(root.right, k))
     return true;

 return false;
}

 // Finds lca of n1 and n2 under the subtree rooted with 'node'
 Node findLCA(int n1, int n2)
 {

     // Find lca of n1 and n2 using the technique discussed above
     Node lca = findLCAUtil(root, n1, n2);

     // Return LCA only if both n1 and n2 are present in tree
     if (v1 && v2 || v1 && find(lca, n2) || v2 && find(lca, n1))
         return lca;

     // Else return NULL
     return null;
 }

 /* Driver program to test above functions */
 public static void main(String args[])
 {
     _025LowestCommonAncestorOfBinaryTree tree = new _025LowestCommonAncestorOfBinaryTree();
     tree.root = new Node(1);
     tree.root.left = new Node(2);
     tree.root.right = new Node(3);
     tree.root.left.left = new Node(4);
     tree.root.left.right = new Node(5);
     tree.root.right.left = new Node(6);
     tree.root.right.right = new Node(7);

     Node lca = tree.findLCA(4, 5);
     if (lca != null)
         System.out.println("LCA(4, 5) = " + lca.data);
     else
         System.out.println("Keys are not present");
      
     v1 = false; v2 = false;

     lca = tree.findLCA(4, 10);
     if (lca != null)
         System.out.println("LCA(4, 10) = " + lca.data);
     else
         System.out.println("Keys are not present");
 }
}
