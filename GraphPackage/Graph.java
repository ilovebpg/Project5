package GraphPackage;
import java.util.Stack;

import ADTPackage.QueueInterface;

import java.util.Queue;

public class Graph<T> implements GraphAlgorithmsInterface<T>, BasicGraphInterface<T>{

    public QueueInterface<T> getBreadthFirstTraversal(T origin) {
        
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

    }
    public boolean addEdge(T begin, T end, double edgeWeight) {

    }
    public boolean addEdge(T begin, T end) {

    }
    public boolean hasEdge(T begin, T end) {

    }
    public boolean isEmpty() {

    }
    public int getNumberOfVertices() {

    }
    public int getNumberOfEdges() {

    }
    public void clear() {
        
    }
}
