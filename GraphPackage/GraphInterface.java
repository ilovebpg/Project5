package GraphPackage;
import ADTPackage.*;
/**
   An interface of methods that create, manipulate, and process a graph.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public interface GraphInterface<E> {
   /** Performs a breadth-first traversal of this graph.
       @param origin  An object that labels the origin vertex of the traversal.
       @return  A queue of labels of the vertices in the traversal, with
                the label of the origin vertex at the queue's front. */
      public String getBreadthFirstTraversal(E origin);

      /** Performs a depth-first traversal of this graph.
      @param origin  An object that labels the origin vertex of the traversal.
      @return  A queue of labels of the vertices in the traversal, with
               the label of the origin vertex at the queue's front. */
      public QueueInterface<E> getDepthFirstTraversal(E origin);
      /**
       * Sees if something is an edge or not.
       * @param source Source of edge to be checked.
       * @param target Target of edge to be checked.
       * @return
       */
      public boolean isEdge(int source, int target);
      /**
     * Adds an edge to the graph.
     * @param source The source of the edge.
     * @param target The target of the edge.
     */
    public void addEdge(int source, int target);
    /**
     * Gets the label of a vertex.
     * @param vertex The input vertex.
     * @return The label of the input vertex.
     */
    public E getLabel(int vertex);
    /**
     * Finds neighbors of input vertex.
     * @param vertex The input vertex.
     * @return An int array of the indices of neighboring vertices.
     */
    public int[] neighbors (int vertex);
    /**
     * Removes an edge from a graph.
     * @param source Source of the edge to be removed.
     * @param target Target of the edge to be removed.
     */
    public void removeEdge(int source, int target);
    /**
     * Sets the label of a vertex in the graph.
     * @param vertex The vertex to be set.
     * @param newLabel The label to be given.
     */
    public void setLabel(int vertex, E newLabel);
    /**
     * Gives the size of the Graph.
     * @return The length of the labels array.
     */
    public int size();
} // end GraphInterface
