package GraphPackage;
import ADTPackage.*;
import java.util.VertexInterface;
import java.util.vertex;
import javax.swing.text.html.HTMLDocument.Iterator;

public class Graph<T> implements GraphAlgorithmsInterface<T>, BasicGraphInterface<T>{

    public QueueInterface<T> getBreadthFirstTraversal(T origin) {
        resetVertices();
	    QueueInterface<T> traversalOrder = new LinkedQueue();
	    QueueInterface<VertexInterface<T>> vertex = new LinkedQueue<VertexInterface<T>>();

	    VertexInterface<T> originVertex = vertices.getValue(origin);
	    originVertex.visit();
	    traversalOrder.enqueue(originVertex);
	
	    while (!vertexQueue.isEmpty()) {
		    VertexInterface<T> frontVertex = vertexQueue.dequeue();

		    Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborsIterator();

		    while (neighbors.hasNext) {
			    VertexInterface<T> nextNeighbor = newNeighbors.next();
			    if  (!nextNeighbor.isVisited()) {
				    nextNeighbor.visit();
				    traversalOrder.enqueue(nextNeighbor.getLabel());
				    vertexQueue.enqueue(nextNeighbor);
			    }  //end if
		    } //end while
	    }  //end while
	    return traversalOrder;
    }
    public QueueInterface<T> getDepthFirstTraversal(T origin) {
    	//assumes graph is not empty
    	resetVertices();
    	QueueInterface<T> traversalOrder = new LinkedQueue<T>;
    	StackInterface<VertexInterface<T>> vertexStack = new LinkedStack<>();
    	
    	VertexInterface<T> originVertex = vertices.getValue(origin);
    	originVertex.visit();
    	traversalOrder.enqueue(origin);;
    	vertexStack.push(originVertex);
    	
    	while(!vertexStack.isEmpty()) {
    		vertexInterface<T> topVertex = vertexStack.peek();
    		vertexInterface<T> nextNeighbor = topVertex.getUnvisitedNeighbor();
    		
    		if (nextNeighbor != null) {
    			nextNeighbor.visit();
    			traversalOrder.enqueue(nextNeigbor.getLabel());
    			vertexStack.push(nextNeighbor);
    		}
    		else
    			vertexStack.pop();
    	}
    	return traversalOrder;
    	
    }
    public StackInterface<T> getTopologicalOrder() {

    }
    public int getShortestPath(T begin, T end, StackInterface<T> path) {

    }
    public double getCheapestPath(T begin, T end, StackInterface<T> path) {

    }
    public boolean addVertex(T vertexLabel) {
        VertexInterface<T> addOutcome = vertices.add(vertexLabel, new Vertex<>(vertexLabel));
        return addOutcome == null; // Was addition to dictionary successful?
    }
    public boolean addEdge(T begin, T end, double edgeWeight) {
        boolean result = false;
        VertexInterface<T> beginVertex = vertices.getValue(begin);
        VertexInterface<T> endVertex = vertices.getValue(end);
        if ( (beginVertex != null) && (endVertex != null) )
            result = beginVertex.connect(endVertex, edgeWeight);
        if (result)
            edgeCount++;
        return result;
    }
    public boolean addEdge(T begin, T end) {
        return addEdge(begin, end, 0);
    }
    public boolean hasEdge(T begin, T end) {
        boolean found = false;
        VertexInterface<T> beginVertex = vertices.getValue(begin);
        VertexInterface<T> endVertex = vertices.getValue(end);
        if ( (beginVertex != null) && (endVertex != null)) {
            Iterator<VertexInterface<T>> neighbors = beginVertex.getNeighborIterator();
            while (!found && neighbors.hasNext()) {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (endVertex.equals(nextNeighbor))
                    found = true;
            } // end while
        } // end if
        return found;
    }
    public boolean isEmpty() {
        return vertices.isEmpty();
    }
    public int getNumberOfVertices() {
        return vertices.getSize();
    }
    public int getNumberOfEdges() {
        return edgeCount;
    }
    public void clear() {
        vertices.clear();
        edgeCount = 0; 
    }
}
