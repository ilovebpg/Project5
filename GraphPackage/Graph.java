package GraphPackage;
import java.util.Stack;
import java.util.Queue;

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
