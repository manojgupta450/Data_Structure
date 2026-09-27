package com.BT_Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BTTest_VerticalTraversal{
	Node root;
	Map<Integer,List<Integer>> map=new TreeMap<Integer,List<Integer>>();
	
	public static void main(String args[]) {
		BTTest_VerticalTraversal bt=new BTTest_VerticalTraversal();
		bt.root= new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		bt.root.right.left = new Node(6);
		bt.root.right.right = new Node(7);
		bt.root.right.left.right = new Node(8);
		bt.root.right.right.right = new Node(9);
	     
	     bt.verticalTraversal(bt.root);
	}

	private void verticalTraversal(Node root) {
		
		verticalTraversal(root,0,map);
		Iterator<Integer> it=map.keySet().iterator();
		
		while (it.hasNext()) {
			Integer hd = (Integer) it.next();
			List<Integer> list=map.get(hd);
			for(Integer i:list) {
				System.out.print(i+" ");
			}
			System.out.println();
			
		}
		
	}

	private void verticalTraversal(Node root2, int hd,Map<Integer,List<Integer>> map) {
		
		if(root2==null)
			return;
		List<Integer> li=map.get(hd);
		if(li==null) {
			li=new ArrayList<Integer>();
			li.add(root2.data);
		}else {
			li.add(root2.data);
		}
		map.put(hd,li);
		
		verticalTraversal(root2.left, hd-1, map);
		verticalTraversal(root2.right, hd+1, map);
		
	}
	
}



