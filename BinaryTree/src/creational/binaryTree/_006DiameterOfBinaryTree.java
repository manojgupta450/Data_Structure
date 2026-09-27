package creational.binaryTree;

public class _006DiameterOfBinaryTree
{
 Node root;

 int diameter(Node root)
 {
     if (root == null)
         return 0;

     /* get the height of left and right sub trees */
     int lheight = height(root.left);
     int rheight = height(root.right);

     /* get the diameter of left and right subtrees */
     int ldiameter = diameter(root.left);
     int rdiameter = diameter(root.right);

     /* Return max of following three
       1) Diameter of left subtree
      2) Diameter of right subtree
      3) Height of left subtree + height of right subtree + 1 */
     return Math.max(lheight + rheight + 1,
                     Math.max(ldiameter, rdiameter));

 }

 int diameter()
 {
     return diameter(root);
 }

 static int height(Node node)
 {
     if (node == null)
         return 0;
     return (1 + Math.max(height(node.left), height(node.right)));
 }

 public static void main(String args[])
 {
     _006DiameterOfBinaryTree tree = new _006DiameterOfBinaryTree();
     tree.root = new Node(1);
     tree.root.left = new Node(2);
     tree.root.right = new Node(3);
     tree.root.left.left = new Node(4);
     tree.root.left.right = new Node(5);

     System.out.println("The diameter of given binary tree is : "
                        + tree.diameter());
 }
}
