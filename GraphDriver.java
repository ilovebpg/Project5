import ADTPackage.*;
import GraphPackage.Graph;

public class GraphDriver {
    @SuppressWarnings("unchecked")
	public static void main(String[] args) throws EmptyQueueException
    {
        //init graph
        @SuppressWarnings("rawtypes")
		Graph test = new Graph<>(9);

        //set labels
        test.setLabel(0, "A");
        test.setLabel(1, "B");
        test.setLabel(2, "C");
        test.setLabel(3, "D");
        test.setLabel(4, "E");
        test.setLabel(5, "F");
        test.setLabel(6, "G");
        test.setLabel(7, "H");
        test.setLabel(8, "I");

        //add edges
        //edges of A:
        test.addEdge(0, 1); //A to B
        test.addEdge(0, 3); //A to D
        test.addEdge(0, 4); //A to E
        //edges of B:
        test.addEdge(1, 4); //B to E
        //edges of C:
        test.addEdge(2, 1); //C to B
        //edges of D:
        test.addEdge(3, 6); //D to G
        //edges of E:
        test.addEdge(4, 5); //E to F
        test.addEdge(4, 7); //E to H
        //edges of F:
        test.addEdge(5, 2); //F to C
        test.addEdge(5, 7); //F to H
        //edges of G:
        test.addEdge(6, 7); //G to H
        //edges of H:
        test.addEdge(7, 8); //H to I
        //edges of I:
        test.addEdge(8, 5); // I to F

        System.out.println("Expected BFT: A B D E G F H C I");
        System.out.println("Actual BFT: " + test.getBreadthFirstTraversal(0));

        System.out.println();

        System.out.println("Expected DFT: A B E F C H I D G");
        System.out.println("Actual DFT: " + test.getDepthFirstTraversal(0));
        
    }//end main
}//end Driver