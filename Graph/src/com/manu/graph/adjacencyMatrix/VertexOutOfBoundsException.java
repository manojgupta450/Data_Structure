package com.manu.graph.adjacencyMatrix;

import java.lang.Exception;

public class VertexOutOfBoundsException extends Exception {
private static final long serialVersionUID = 3888015753201347385L;

public VertexOutOfBoundsException() {
    super();
  }
  public VertexOutOfBoundsException(String message) {
    super(message);
  }
}