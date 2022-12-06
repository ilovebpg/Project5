package GraphPackage;
import ADTPackage.*;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;


public class Graph<E> implements GraphInterface<E> {
    private boolean[][] edges; //edges[i][j]is true if there is a vertex from i to j
    private E[] labels; //labels[i] contains the label for vertex i
	private int vertices = 9;

    /*public QueueInterface<E> getBreadthFirstTraversal(E origin) {
		QueueInterface<E> traversalOrder = new ArrayQueue<E>();
		QueueInterface<E> vertexQueue = new ArrayQueue<E>();

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
    } //end getBreadthFirstTraversal*/

    public String getBreadthFirstTraversal (int origin) throws EmptyQueueException {
        QueueInterface<Integer> traversalOrder = new ArrayQueue<Integer>();
        QueueInterface<Integer> vertexQueue = new ArrayQueue<Integer>();
        boolean visited[] = new boolean[vertices];
        String result = "";

        visited[origin] = true;
        traversalOrder.enqueue(origin);
        vertexQueue.enqueue(origin);

        while (!vertexQueue.isEmpty()) {
            int nextNeighbor = vertexQueue.dequeue();
            result += nextNeighbor + " ";
            
            vertexQueue.dequeue();
            neighbors(nextNeighbor);
            visited[nextNeighbor] = true;
            
        }
        return result;
    }

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
    
	/*public void BFS(int s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[vertices];
 
        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);
 
        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");
 
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = labels[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }*/

    public Graph (int n) {
        edges = new boolean[n][n];
        //unchecked cast safe because entries are null
        labels = (E[]) new Object[n];
    }//end Constructor

    public boolean isEdge(int source, int target) {
        return edges[source][target];
    }//end isEdge

    public void addEdge(int source, int target) {
        edges[source][target] = true;
    }//end addEdge

    public E getLabel(int vertex) {
        return labels[vertex];
    }//end getLabel

    public int[] neighbors (int vertex) {
        int i;
        int count = 0;
        int[] answer;

        for (i = 0; i < labels.length; i++) {
            if (edges[vertex][i]) {
                count++;
            }
        }
        answer = new int[count];
        count = 0;
        for (i = 0; i < labels.length; i++) {
            if (edges[vertex][i]) {
                answer[count++] = i;
            }
        }
        return answer;
    }//end neighbors

    public void removeEdge(int source, int target) {
        edges[source][target] = false;
    }//end removeEdge

    public void setLabel(int vertex, E newLabel) {
        labels[vertex] = newLabel;
    }//end setLabel

    public int size() {
        return labels.length;
    }//end size

}//end Graph
