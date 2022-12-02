package GraphPackage;
import ADTPackage.*;

public class Graph<T> implements GraphInterface<T> {

	public QueueInterface<T> getBreadthFirstTraversal(T origin) {
	
		return null;
	}

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
    			VertexInterface<T> nextNeigbor;
				traversalOrder.enqueue(nextNeigbor.getLabel());
    			vertexStack.push(nextNeighbor);
    		}
    		else
    			vertexStack.pop();
    	}
    	return traversalOrder;
	}

	public boolean addEdge(T begin, T end) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean hasEdge(T begin, T end) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getNumberOfVertices() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getNumberOfEdges() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
