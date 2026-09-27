package com.manu.graph.adjacencyMatrix;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
 
public abstract class Graph {
    private int numVertices;
    private int numEdges;
 
    public Graph() {
        numVertices = 0;
        numEdges = 0;
    }
 
    public int getNumVertices() {
        return numVertices;
    }
 
    public int getNumEdges() {
        return numEdges;
    }
 
 
    public void setNumVertices(int v) {
        numVertices = v;
    }
 
    public void setNumEdges(int e) {
        numEdges = e;
    }
 
    public abstract boolean inEdgeExists(int v, int w) throws VertexOutOfBoundsException;
    public abstract boolean outEdgeExists(int v, int w) throws VertexOutOfBoundsException;
    public abstract void addVertex();
    public abstract void addEdge(int v, int w) throws VertexOutOfBoundsException;
    public abstract void removeVertex() throws VertexOutOfBoundsException;
    public abstract void removeEdge(int v, int w) throws VertexOutOfBoundsException;
    public abstract int getInDegree(int v) throws VertexOutOfBoundsException;
    public abstract int getOutDegree(int v) throws VertexOutOfBoundsException;
    public abstract List<Integer> getNeighbors(int v) throws VertexOutOfBoundsException;
    public abstract List<Integer> getNeighborsTwoApart(int v) throws VertexOutOfBoundsException;
    
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
 
}