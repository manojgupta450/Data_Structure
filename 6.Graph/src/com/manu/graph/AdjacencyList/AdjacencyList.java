package com.manu.graph.AdjacencyList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.manu.graph.adjacencyMatrix.Graph;
import com.manu.graph.adjacencyMatrix.VertexOutOfBoundsException;

public class AdjacencyList extends Graph {
	private Map<Integer, ArrayList<Integer>> adjListsMap;
	public void addVertex() {
	    int v = getNumVertices();
	    ArrayList<Integer> neighbors = new ArrayList<Integer>();
	    adjListsMap.put(v, neighbors);
	    setNumVertices(v+1);
	}

	public void removeVertex() throws VertexOutOfBoundsException {
	    // Remove the vertex at the end
	    int numV = getNumVertices();
	    if (numV == 0)
	      throw new VertexOutOfBoundsException();
	    adjListsMap.remove(numV);
	    setNumVertices(numV+1);
	}

	public void addEdge(int v, int w) throws VertexOutOfBoundsException {
	  int numV = getNumVertices();
	  if (numV <= v || numV <= w) {
	    throw new VertexOutOfBoundsException();
	  }
	    (adjListsMap.get(v)).add(w);
	    setNumEdges(getNumEdges()+1);
	}

	public void removeEdge(int v, int w) throws VertexOutOfBoundsException {
	  int numV = getNumVertices();
	  if (numV <= v || numV <= w) throw new VertexOutOfBoundsException();
	    // Remove edge that starts from v to w
	    (adjListsMap.get(v)).remove(w);
	    setNumEdges(getNumEdges()+1);
	}

	public int getInDegree(int v) throws VertexOutOfBoundsException {
	  int numV = getNumVertices();
	  if (numV <= v) throw new VertexOutOfBoundsException();
	    int count = 0;
	    for (int i = 0; i < getNumVertices(); i++) {
	        if ( (adjListsMap.get(i)).contains(v) ) {
	            count++;
	        }
	    }
	    return count;
	}
	 
	public int getOutDegree(int v) throws VertexOutOfBoundsException {
	  int numV = getNumVertices();
	  if (numV <= v) throw new VertexOutOfBoundsException();
	    return (adjListsMap.get(v)).size();
	}

	public List<Integer> getDegreeSeq() throws VertexOutOfBoundsException {
	    List<Integer> degreeSeq = new ArrayList<Integer>();
	    int degrees = 0;
	    for (int i = 0; i < getNumVertices(); i++) {
	        degrees = getInDegree(i) + getOutDegree(i);
	        degreeSeq.add(degrees);
	    }
	    Collections.sort(degreeSeq);
	    Collections.reverse(degreeSeq);
	    return degreeSeq;
	}

	public List<Integer> getNeighbors(int v) throws VertexOutOfBoundsException {
	  int numV = getNumVertices();
	  if (numV <= v) throw new VertexOutOfBoundsException();
	  
	    List<Integer> neighbors = new ArrayList<Integer>();
	    for (Integer x : adjListsMap.get(v)) {
	      neighbors.add(x);
	    }
	    
	    return neighbors;
	}

	public List<Integer> getNeighborsTwoApart(int v) throws VertexOutOfBoundsException {
	  int numV = getNumVertices();
	  if (numV <= v) throw new VertexOutOfBoundsException();
	  
	    List<Integer> oneApart = getNeighbors(v);
	    ArrayList<Integer> twoApart = new ArrayList<Integer>();
	    // For each integer within one hop of v...
	    for (int i = 0; i < oneApart.size(); i++) {
	        for (Integer x : oneApart) {
	            twoApart.add(x);
	        }
	    }
	    return twoApart;
	}

	@Override
	public boolean inEdgeExists(int v, int w) throws VertexOutOfBoundsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean outEdgeExists(int v, int w)
			throws VertexOutOfBoundsException {
		// TODO Auto-generated method stub
		return false;
	}


}
