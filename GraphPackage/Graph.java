package GraphPackage;
import java.util.Iterator;
import ADTPackage.*;

public class Graph<T> implements GraphAlgorithmsInterface<T>, BasicGraphInterface<T> {
	//declare private fields
	private DictionaryInterface<T, VertexInterface<T>> vertices;
	private int edgeCount;

	public QueueInterface<T> getBreadthFirstTraversal(T origin) {
		resetVertices();
		QueueInterface<T> traversalOrder = new LinkedQueue<T>();
		QueueInterface<VertexInterface<T>> vertexQueue = new LinkedQueue<VertexInterface<T>>();

		VertexInterface<T> originVertex = vertices.getValue(origin);
		originVertex.visit();
		traversalOrder.enqueue(origin);
		vertexQueue.enqueue(originVertex);
		
		while (!vertexQueue.isEmpty()) {
		    VertexInterface<T> frontVertex = vertexQueue.dequeue();

		    Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();

		    while (neighbors.hasNext()) {
			    VertexInterface<T> nextNeighbor = neighbors.next();
			    if  (!nextNeighbor.isVisited()) {
				    nextNeighbor.visit();
				    traversalOrder.enqueue(nextNeighbor.getLabel());
				    vertexQueue.enqueue(nextNeighbor);
			    }  //end if
		    } //end while
	    }  //end while
	    return traversalOrder;
    } //end getBreadthFirstTraversal

	public QueueInterface<T> getDepthFirstTraversal(T origin) {
		resetVertices();
    	QueueInterface<T> traversalOrder = new LinkedQueue<T>();
    	StackInterface<VertexInterface<T>> vertexStack = new LinkedStack<>();
    	
    	VertexInterface<T> originVertex = vertices.getValue(origin);
    	originVertex.visit();
    	traversalOrder.enqueue(origin);;
    	vertexStack.push(originVertex);
    	
    	while(!vertexStack.isEmpty()) {
    		VertexInterface<T> topVertex = vertexStack.peek();
    		VertexInterface<T> nextNeighbor = topVertex.getUnvisitedNeighbor();
    		
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

	public boolean addEdge(T begin, T end) {
	    return addEdge(begin, end);
	} //end AddEdge

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
    } //end hasEdge

	public boolean isEmpty() {
		return vertices.isEmpty();
	} //end isEmpty

	public int getNumberOfVertices() {
        return vertices.getSize();
    } //end getNumberOfVertices

	public int getNumberOfEdges() {
	       return edgeCount;
	} //end getNumberOfEdges
	
	public void clear() {
	        vertices.clear();
	        edgeCount = 0; 
	} //end clear
	
	public void resetVertices() {
		Iterator<VertexInterface<T>> vertexIterator = vertices.getValueIterator();
		while (vertexIterator.hasNext()) {
			VertexInterface<T> nextVertex = vertexIterator.next();
			nextVertex.unvisit();
			nextVertex.setCost(0);
			nextVertex.setPredecessor(null);
		} 
	} //end resetVertices

	public DictionaryInterface<T, VertexInterface<T>> getVertices() {
		return vertices;
	} //end getVertices

	public void setVertices(DictionaryInterface<T, VertexInterface<T>> vertices) {
		this.vertices = vertices;
	} //end setVertices

	public int getEdgeCount() {
		return edgeCount;
	} //end getEdgeCount

	public void setEdgeCount(int edgeCount) {
		this.edgeCount = edgeCount;
	} //end setEdgeCount
} //end Graph

