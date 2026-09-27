package FlattenList;

public class FlattenLinkedList{
 Node head;
 
 Node merge(Node a, Node b){
	 Node result=null;
	 if (a == null)     
    	 return b;
     if (b == null)      
    	 return a;

     if (a.data < b.data){
         result = a;
         result.down =  merge(a.down, b);
     }else{
         result = b;
         result.down = merge(a, b.down);
     }
     return result;
 }

 Node flatten(Node root){
     if (root == null || root.right == null)
         return root;
     root.right = flatten(root.right);
     root = merge(root, root.right);
     return root;
 }
 
 void printlistist(){
     Node temp = head;
     while (temp != null){
         System.out.print(temp.data + " ");
         temp = temp.down;
     }
     System.out.println();
 }
 
 Node push(Node head_ref, int data){
     Node new_node = new Node(data);
     new_node.down = head_ref;

     head_ref = new_node;
     return head_ref;
 }

 public static void main(String args[])
 {
	 FlattenLinkedList list = new FlattenLinkedList();

     /* Let us create the following linked list
         5 -> 10 -> 19 -> 28
         |    |     |     |
         V    V     V     V
         7    20    22    35
         |          |     |
         V          V     V
         8          50    40
         |                |
         V                V
         30               45
     */

     list.head = list.push(list.head, 30);
     list.head = list.push(list.head, 8);
     list.head = list.push(list.head, 7);
     list.head = list.push(list.head, 5);

     list.head.right = list.push(list.head.right, 20);
     list.head.right = list.push(list.head.right, 10);

     list.head.right.right = list.push(list.head.right.right, 50);
     list.head.right.right = list.push(list.head.right.right, 22);
     list.head.right.right = list.push(list.head.right.right, 19);

     list.head.right.right.right = list.push(list.head.right.right.right, 45);
     list.head.right.right.right = list.push(list.head.right.right.right, 40);
     list.head.right.right.right = list.push(list.head.right.right.right, 35);
     list.head.right.right.right = list.push(list.head.right.right.right, 28);

     list.head = list.flatten(list.head);

     list.printlistist();
 }
} 

class Node
{
    int data;
    Node right, down;
    Node(int data)
    {
        this.data = data;
        right = null;
        down = null;
    }
}
