package com.manu.graph.adjacencyMatrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacencyMatrixGraph extends Graph{
	int adjMatrix [] []=new int [5][5];
	int size=5;
	
	public boolean inEdgeExists(int v, int w) throws VertexOutOfBoundsException {
		     return outEdgeExists(w,v);
		 }
		 
	public boolean outEdgeExists(int v, int w)  throws VertexOutOfBoundsException {
		   int numV = getNumVertices();
		   if (v >= numV || w >= numV) {
		     throw new VertexOutOfBoundsException();
		   }
		     return adjMatrix[w][v] != 0;
		 }

	public void addVertex() {
	    // If the number of vertices is more than half the size of our matrix, 
	    // double the size of our matrix
	    int numV = getNumVertices();
	    if (numV > 0.5 * size) {
	        size = 2*size;
	        int[][] newAdjMatrix = new int[size][size];
	        for (int i = 0; i < adjMatrix.length; i++) {
	            for (int j = 0; j < adjMatrix[0].length; j++) {
	                newAdjMatrix[i][j] = adjMatrix[i][j];
	            }
	        }
	        adjMatrix = newAdjMatrix;
	    }
	    setNumVertices(numV+1);
	}
	@Override
	public void addEdge(int v, int w) throws VertexOutOfBoundsException {
		 int numV = getNumVertices();
		    if (v >= numV || w >= numV) {
		      throw new VertexOutOfBoundsException();
		    }
		    adjMatrix[v][w] = 1;
		    setNumEdges(getNumEdges()+1);
	}

	@Override
	public void removeVertex() throws VertexOutOfBoundsException {
		// TODO Auto-generated method stub
		    int numV = getNumVertices();
		    if (numV == 0) {
		      throw new VertexOutOfBoundsException();
		    }
		    if (size < 0.5 * numV) {
		        size = (int) 0.5*size;
		        int[][] newAdjMatrix = new int[size][size];
		        for (int i = 0; i < size; i++) {
		            for (int j = 0; j < size; j++) {
		                newAdjMatrix[i][j] = adjMatrix[i][j];
		            }
		        }
		        adjMatrix = newAdjMatrix;
		    }
		    setNumVertices(numV-1);
	}

	@Override
	public void removeEdge(int v, int w) throws VertexOutOfBoundsException {
		  int numV = getNumVertices();
		    if (v >= numV || w >= numV) {
		      throw new VertexOutOfBoundsException();
		    }
		    adjMatrix[v][w] = 0;
		    setNumEdges(getNumEdges()-1);
	}

	public int getInDegree(int v) throws VertexOutOfBoundsException {
		  int numV = getNumVertices();
		  if (v >= numV) {
		    throw new VertexOutOfBoundsException();
		  }
		    // Count the number of in-degrees
		    int count = 0;
		    for (int i = 0; i < getNumVertices(); i++) {
		        if (adjMatrix[i][v] != 0) {
		            count++;
		        }
		    }
		    return count;
		}
		 
		public int getOutDegree(int v) throws VertexOutOfBoundsException {
		  int numV = getNumVertices();
		  if (v >= numV) {
		    throw new VertexOutOfBoundsException();
		  }
		    // Count the number of in-degrees
		    int count = 0;
		    for (int i = 0; i < getNumVertices(); i++) {
		        if (adjMatrix[v][i] != 0) {
		            count++;
		        }
		    }
		    return count;
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
			  if (v >= numV) {
			    throw new VertexOutOfBoundsException();
			  }
			    List<Integer> neighbors = new ArrayList<Integer>();
			    for (int i = 0; i < getNumVertices(); i++) {
			        if (adjMatrix[v][i] != 0) {
			            neighbors.add(i);
			        }
			    }
			    return neighbors;
			}

		public List<Integer> getNeighborsTwoApart(int v) throws VertexOutOfBoundsException {
			  int numV = getNumVertices();
			  if (v >= numV) {
			    throw new VertexOutOfBoundsException();
			  }
			    List<Integer> neighbors = new ArrayList<Integer>();
			    int[][] sqMatrix = new int[size][size];
			    for (int i = 0; i < numV; i++)
			        for (int j = 0; j < numV; j++)
			            for (int k = 0; k < numV; k++)
			                sqMatrix[i][j] += adjMatrix[i][k] * adjMatrix[k][j];
			    for (int i = 0; i < numV; i++) {
			        if (sqMatrix[i][v] != 0 || sqMatrix[v][i] != 0) {
			            neighbors.add(i);
			        }
			    }
			    return neighbors; 
			}

}
