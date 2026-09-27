package com.manu.graph.DFS;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	LinkedList<Integer> arrList[];
	int V;
	@SuppressWarnings("unchecked")
	public Graph(int v) {
		arrList=new LinkedList[v];
		for(int i=0;i<v;i++) 
			arrList[i]=new LinkedList<Integer>();
		V=v;
	}

	public void addEdge(int v,int e) {
		arrList[v].add(e);
	}
	
	public void dfs(int v) {
		boolean [] visited=new boolean[V];
		dfsUtil(v,visited);
	}
	
	public void dfsUtil(int v,boolean [] visited) {
		visited[v] = true;
		System.out.println(v +" ");
		Iterator<Integer> it=arrList[v].iterator();
		while(it.hasNext())
		{
			Integer i=it.next();
			if(!visited[i])
			dfsUtil(i,visited);
		}
		
		
	}
	public static void main(String[] args) {
		Graph g=new Graph(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Depth First Traversal "+
                           "(starting from vertex 2)");
 
        g.dfs(2);

		
	}

}
