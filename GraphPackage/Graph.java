package GraphPackage;
import ADTPackage.*;
import java.util.EmptyStackException;
import java.util.Arrays;

public class Graph<E> {
    private boolean[][] edges; //edges[i][j]is true if there is a vertex from i to j
    private E[] labels; //labels[i] contains the label for vertex i

    //constructors
    @SuppressWarnings("unchecked")
	public Graph (int n) {
        edges = new boolean[n][n];
        labels = (E[]) new Object[n]; //unchecked cast safe because entries are null
    }//end Constructor

 
    public boolean isEdge(int source, int target) {
        return edges[source][target];
    }//end isEdge

    public void addEdge(int source, int target) {
        edges[source][target] = true;
    }//end addEdge

    public E getLabel(int vertex){
        return labels[vertex];
    }//end getLabel

    public int[] neighbors (int vertex){
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

    public String getBreadthFirstTraversal(int vertex) throws EmptyQueueException {
        String result = "";

        //make array to hold visited vertices, make all entries false
        boolean[] visited = new boolean[labels.length];
        
        //make queue of vertices to visit
        ArrayQueue<Integer> vertexQueue = new ArrayQueue<Integer>();

        //go through array starting from input index
        vertexQueue.enqueue(vertex);
        while (!vertexQueue.isEmpty()) {
            //add current to visited and result string
            result += labels[vertexQueue.getFront()] + " ";
            visited[vertexQueue.getFront()] = true;

            //add neighbors to queue in alpha order if not in visited
            int[] neighbors = neighbors(vertexQueue.dequeue());//put neighbors in array, remove front entry

            //put neighbors in alphabetical order(assumes index of A is 0, B is 1,etc)
            Arrays.sort(neighbors);

            //iterate through each neighbor
            for (int i = 0; i < neighbors.length; i++) {
                //search visited, enqueue if doesn't contain
                if (!visited[neighbors[i]]) {
                    visited[neighbors[i]] = true;
                    vertexQueue.enqueue(neighbors[i]);
                }
            }//end for
        }//end while

        return result;
    }//end getBreadthFirstTraversal

    public String getDepthFirstTraversal (int vertex) throws EmptyQueueException,EmptyStackException {
        String result = "";

        //initialize stack to track path
        ArrayStack<Integer> vertexStack = new ArrayStack<Integer>();

        //initialize array of booleans to keep track of visited status
        boolean[] visited = new boolean[labels.length]; 

        //push input vertex, mark as visited
        vertexStack.push(vertex);
        visited[vertex] = true;

        //add input vertex to result
        result += getLabel(vertex) + " ";

        while (!vertexStack.isEmpty()) {
            //make array of neighbors
            int[] neighbors = neighbors(vertexStack.peek());
            
            //if no neighbors, pop
            if (neighbors.length == 0) {
                vertexStack.pop();
            }
            Arrays.sort(neighbors);

            //iterate through each neighbor and push only the first unvisited neighbor,
            //if all neighbors are visited go back a step
            for (int i = 0; i < neighbors.length; i++) {
                if (!visited[neighbors[i]]) {
                    visited[neighbors[i]] = true;
                    vertexStack.push(neighbors[i]);
                    result += getLabel(neighbors[i]) + " ";
                    break;
                } else if (i == neighbors.length - 1) {
                    vertexStack.pop();
                }
            }
        }

        return result;
    }//end getDepthFirstTraversal
}//end Graph