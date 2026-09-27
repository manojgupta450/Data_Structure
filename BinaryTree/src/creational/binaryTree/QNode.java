package creational.binaryTree;

public class QNode
{
    public int data;
    public int hd; //horizontal distance of the node
    public QNode left, right;
    public QNode(int key)
    {
        data = key;
        left = right = null;
    }
}
