package com.manu.adjacencyMatrixGraph;

public class GraphAdjacencyMatrix {
	 protected int maxVertsNum;
	 protected int numVerts;
	 protected Vertex [] vertexList;
	 protected int [][] adjMatrix;
	 
	 public GraphAdjacencyMatrix(int maxVerts){
	  maxVertsNum = maxVerts;
	  numVerts = 0;
	  vertexList = new Vertex[maxVertsNum];
	  adjMatrix = new int[maxVertsNum][maxVertsNum];
	  //Initializing all entries to zero.
	  for (int i = 0; i < maxVertsNum; i++) {
	   for (int j = 0; j < maxVertsNum; j++) {
	    adjMatrix[i][j] = 0;
	   }
	  }
	 }
	 
	 public void addVertex(char label){
	  if(numVerts < maxVertsNum){
	   vertexList[numVerts++] = new Vertex(label);
	  }
	 }
	 
	 public void addEdge(int start, int end){
	  if(start < numVerts && end < numVerts){
	   adjMatrix[start][end] = 1;
	   adjMatrix[end][start] = 1;
	  }
	 }
	 
	 public boolean hasEdge(int src, int dest){
	  return adjMatrix[src][dest]==1;
	 }
	 
	 public boolean isVertexVisited(int vertex){
	  return vertexList[vertex].isVisited;
	 }
	 
	 public void display(int idx){
	  System.out.print(vertexList[idx].label);
	 }
	 
	 public void displayAllEdges(){
	  System.out.println("All edges are:");
	  for (int i = 0; i < numVerts; i++) {
	   for (int j = 0; j < numVerts; j++) {
	    if(adjMatrix[i][j]==1){
	     System.out.print(vertexList[i].label+""+vertexList[j].label);
	     System.out.print(" ");
	    }
	   }
	  }
	  System.out.println();
	 }

	 public static void main(String[] args) {
	  GraphAdjacencyMatrix graph = new GraphAdjacencyMatrix(5);
	  graph.addVertex('A'); //0
	  graph.addVertex('B'); //1
	  graph.addVertex('C'); //2
	  graph.addVertex('D'); //3
	  
	  graph.addEdge(0, 1);
	  graph.addEdge(0, 2);
	  graph.addEdge(1, 2);
	  graph.addEdge(2, 3);
	  
	  graph.displayAllEdges();
	  
	  System.out.println("Is there an edge between "+graph.vertexList[0].label+" and "+graph.vertexList[2].label+" = "+graph.hasEdge(0, 2));
	  System.out.println("Is there an edge between "+graph.vertexList[1].label+" and "+graph.vertexList[3].label+" = "+graph.hasEdge(1, 3));
	 }
	}


class Vertex{
	 public char label;
	 public boolean isVisited = false;
	 
	 public Vertex(char label){
	  this.label = label;
	 }
	}

