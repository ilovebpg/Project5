package GraphPackage;
import ADTPackage.*;
import java.util.EmptyStackException;
import java.util.Iterator;


public class Graph<E> implements GraphInterface<E> {
    private boolean[][] edges; //edges[i][j]is true if there is a vertex from i to j
    private E[] labels; //labels[i] contains the label for vertex i
	private Object vertices;

    public QueueInterface<E> getBreadthFirstTraversal(E origin) {
		resetVertices();
		QueueInterface<E> traversalOrder = new LinkedQueue<E>();
		QueueInterface<VertexInterface<E>> vertexQueue = new LinkedQueue<VertexInterface<E>>();

		VertexInterface<E> originVertex = vertices.getValue(origin);
		originVertex.visit();
		traversalOrder.enqueue(origin);
		vertexQueue.enqueue(originVertex);
		
		while (!vertexQueue.isEmpty()) {
		    VertexInterface<E> frontVertex = vertexQueue.dequeue();

		    Iterator<VertexInterface<E>> neighbors = frontVertex.getNeighborIterator();

		    while (neighbors.hasNext()) {
			    VertexInterface<E> nextNeighbor = neighbors.next();
			    if  (!nextNeighbor.isVisited()) {
				    nextNeighbor.visit();
				    traversalOrder.enqueue(nextNeighbor.getLabel());
				    vertexQueue.enqueue(nextNeighbor);
			    }  //end if
		    } //end while
	    }  //end while
	    return traversalOrder;
    } //end getBreadthFirstTraversal

	public QueueInterface<E> getDepthFirstTraversal(E origin) {
		resetVertices();
    	QueueInterface<E> traversalOrder = new LinkedQueue<E>();
    	StackInterface<VertexInterface<E>> vertexStack = new LinkedStack<>();
    	
    	VertexInterface<E> originVertex = vertices.getValue(origin);
    	originVertex.visit();
    	traversalOrder.enqueue(origin);;
    	vertexStack.push(originVertex);
    	
    	while(!vertexStack.isEmpty()) {
    		VertexInterface<E> topVertex = vertexStack.peek();
    		VertexInterface<E> nextNeighbor = topVertex.getUnvisitedNeighbor();
    		
    		if (nextNeighbor != null) {
    			nextNeighbor.visit();
				traversalOrder.enqueue(nextNeighbor.getLabel());
    			vertexStack.push(nextNeighbor);
    		}
    		else
    			vertexStack.pop();
    	}
    	return traversalOrder;
	} //end getDepthFirstTraversal
    
    //constructors
    public Graph (int n)
    {
        edges = new boolean[n][n];
        labels = (E[]) new Object[n]; //unchecked cast safe because entries are null
    }//end Constructor

    /**
     * Sees if something is an edge or not.
     * @param source Source of edge to be checked.
     * @param target Target of edge to be checked.
     * @return
     */
    public boolean isEdge(int source, int target)
    {
        return edges[source][target];
    }//end isEdge

    /**
     * Adds an edge to the graph.
     * @param source The source of the edge.
     * @param target The target of the edge.
     */
    public void addEdge(int source, int target)
    {
        edges[source][target] = true;
    }//end addEdge

    /**
     * Gets the label of a vertex.
     * @param vertex The input vertex.
     * @return The label of the input vertex.
     */
    public E getLabel(int vertex)
    {
        return labels[vertex];
    }//end getLabel

    /**
     * Finds neighbors of input vertex.
     * @param vertex The input vertex.
     * @return An int array of the indices of neighboring vertices.
     */
    public int[] neighbors (int vertex)
    {
        int i;
        int count = 0;
        int[] answer;

        for (i = 0; i < labels.length; i++)
        {
            if (edges[vertex][i])
            {
                count++;
            }
        }

        answer = new int[count];
        count = 0;
        for (i = 0; i < labels.length; i++)
        {
            if (edges[vertex][i])
            {
                answer[count++] = i;
            }
        }
        return answer;
    }//end neighbors

    /**
     * Removes an edge from a graph.
     * @param source Source of the edge to be removed.
     * @param target Target of the edge to be removed.
     */
    public void removeEdge(int source, int target)
    {
        edges[source][target] = false;
    }//end removeEdge

    /**
     * Sets the label of a vertex in the graph.
     * @param vertex The vertex to be set.
     * @param newLabel The label to be given.
     */
    public void setLabel(int vertex, E newLabel)
    {
        labels[vertex] = newLabel;
    }//end setLabel

    /**
     * Gives the size of the Graph.
     * @return The length of the labels array.
     */
    public int size()
    {
        return labels.length;
    }//end size

	private void resetVertices() {
		Iterator<VertexInterface<E>> vertexIterator = vertices.getValueIterator();
		while (vertexIterator.hasNext()) {
			VertexInterface<E> nextVertex = vertexIterator.next();
			nextVertex.unvisit();
		}
	}

}//end Graph
