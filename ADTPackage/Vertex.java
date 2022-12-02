package ADTPackage;
import java.util.Iterator;
import java.util.NoSuchElementException;
import ADTPackage.*; // Classes that implement various ADTs
/**
 A class of vertices for a graph.
 @author Frank M. Carrano
 @author Timothy M. Henry
 @version 5.0
 */
class Vertex<T> implements VertexInterface<T>
{
   private T label;
   private ListWithIteratorInterface<Edge> edgeList; // Edges to neighbors
   private boolean visited;                          // True if visited
   private VertexInterface<T> previousVertex;        // On path to this vertex
   private double cost;                              // Of path to this vertex
   
   public Vertex(T vertexLabel)
   {
      label = vertexLabel;
      edgeList = new LinkedListWithIterator<>();
      visited = false;
      previousVertex = null;
      cost = 0;
   } // end constructor

/* Implementations of the vertex operations go here.
   . . . */

   protected class Edge
   {
      private VertexInterface<T> vertex; // Vertex at end of edge
      private double weight;
      
      protected Edge(VertexInterface<T> endVertex, double edgeWeight)
      {
         vertex = endVertex;
         weight = edgeWeight;
      } // end constructor
      
      protected Edge(VertexInterface<T> endVertex)
      {
         vertex = endVertex;
         weight = 0;
      } // end constructor

      protected VertexInterface<T> getEndVertex()
      {
         return vertex;
      } // end getEndVertex
      
      protected double getWeight()
      {
         return weight; 
      } // end getWeight
   } // end Edge

@Override
public T getLabel() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void visit() {
	// TODO Auto-generated method stub
	
}

@Override
public void unvisit() {
	// TODO Auto-generated method stub
	
}

@Override
public boolean isVisited() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public Iterator<VertexInterface<T>> getNeighborIterator() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean hasNeighbor() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public VertexInterface<T> getUnvisitedNeighbor() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public VertexInterface<T> getPredecessor() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void setCost(double newCost) {
	// TODO Auto-generated method stub
	
}

@Override
public void setPredecessor(VertexInterface<T> predecessor) {
	// TODO Auto-generated method stub
	
}
} // end Vertex
