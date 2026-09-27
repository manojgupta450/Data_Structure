package com.test;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
 
public class BottomViewOfBinaryTree {

    Node root;
    
    class MapEntry
    {
        int nodeValue;
        int nodeLevel;
        public MapEntry (int value, int level)
        {
            nodeValue = value;
            nodeLevel = level;
        }
    }
    
    private void fillUpViewMap(Node currentNode, int currLevel, int horizontalDistFromRoot, Map<Integer, MapEntry> viewMap)
    {
        if (currentNode == null) return;
        MapEntry mapEntry = (MapEntry) viewMap.get(new Integer(horizontalDistFromRoot));
        if (mapEntry != null)  
        {             
            if (currLevel >= mapEntry.nodeLevel)
            {
                MapEntry nodeEntry = new MapEntry(currentNode.data, currLevel);
                viewMap.put(horizontalDistFromRoot, nodeEntry);
            }
        }
        else  
        {
            MapEntry nodeEntry = new MapEntry(currentNode.data, currLevel);
            viewMap.put(horizontalDistFromRoot, nodeEntry);
        }
  
        fillUpViewMap(currentNode.left, currLevel + 1, horizontalDistFromRoot - 1, viewMap); 
        fillUpViewMap(currentNode.right, currLevel + 1, horizontalDistFromRoot + 1, viewMap);
    }    

    private void printBottomView()
    {
        Map<Integer, MapEntry> viewMap = new TreeMap<Integer, MapEntry>();
        fillUpViewMap(root, 0, 0, viewMap); 
        Iterator<Entry<Integer, MapEntry>> iterator = viewMap.entrySet().iterator();
        while (iterator.hasNext())
        {
            Entry<Integer, MapEntry> nodeEntry = iterator.next();
            System.out.print("  "  + nodeEntry.getValue().nodeValue);
        }
    }
    
    public static void main(String[] args)
    {
    	BottomViewOfBinaryTree tree = new BottomViewOfBinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(3);
        tree.root.right.right = new Node(25);
        //tree.root.right.left = new Node(4);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.printBottomView();
    }
}

