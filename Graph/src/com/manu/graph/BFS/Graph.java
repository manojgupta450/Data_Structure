package com.manu.graph.BFS;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	int V =0;
	LinkedList<Integer> [] listArr;
	@SuppressWarnings("unchecked")
	public Graph(int v) {
		listArr =new LinkedList[v];
		V=v;
		for(int i=0;i<v;i++)
			listArr[i]=new LinkedList<Integer>();
	}

	public void addEdge(int v,int e) {
		listArr[v].add(e);
	}
	
	public void bsf(int v) {
		boolean visited [] =new boolean[V]; 
		LinkedList<Integer> queue=new LinkedList<Integer>();
		// Mark the current node as visited and enqueue it
        visited[v]=true;
        queue.add(v);
        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            v = queue.poll();
            System.out.println(v);
            Iterator<Integer> it=listArr[v].iterator();
            while(it.hasNext()) {
            	Integer i=it.next();
            	if (!visited[i])
                {
                    visited[i] = true;
                    queue.add(i);
                }

            }
            
        }

	}
	public static void main(String args[]) {
		Graph g=new Graph(5);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

		g.bsf(2);
		
	}
}

