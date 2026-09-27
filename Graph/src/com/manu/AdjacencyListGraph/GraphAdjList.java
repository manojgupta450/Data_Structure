package com.manu.AdjacencyListGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.manu.adjacencyMatrixGraph.Graph;

public class GraphAdjList extends Graph {
private Map<Integer, ArrayList<Integer>> adjListsMap;

public void implementAddVertex(){
int v= getNumVertices();
ArrayList<Integer> neighbors = new ArrayList<Integer>();
adjListsMap.put(v,neighbors);
}

public void implementAddEdge(int v,int w){
 (adjListsMap.get(v)).add(w);
}

@Override
public List<Integer> getNeighbors(int v) {
	// TODO Auto-generated method stub
	return null;
}


}
