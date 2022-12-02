package ADTPackage;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
   A class that implements the ADT list by using a chain of linked nodes.
   The list has an iterator. The class is similar to LList.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class LinkedListWithIterator<T> {
   private Node firstNode;
   
   private void initializeDataFields() {
		firstNode = null;

	}
   
   public LinkedListWithIterator()
   {
      initializeDataFields();
   } // end default constructor


/*	< Implementations of the methods of the ADT list go here;
     you can see them in Chapter 12, beginning at Segment 12.7 >
   . . . */
   
   public Iterator<T> iterator()
   {
	   return new IteratorForLinkedList();
   } // end iterator

	public Iterator<T> getIterator()
	{
	   return iterator();
	} // end getIterator
   
	private class IteratorForLinkedList implements Iterator<T> {
      private Node nextNode;

		private IteratorForLinkedList()
		{
			nextNode = firstNode;
		} // end default constructor
		
      // Implementations of the methods in the interface Iterator go here.
		public boolean hasNext() {
			return nextNode != null;
		}
		
		public T next() {
			T result;
			if(hasNext()) {
				result = nextNode.getData();
				nextNode = nextNode.getNextNode();
			} else
				throw new NoSuchElementException("Unavailable move");
			return result;
		}
	}

	private class Node {
      private T    data; // Entry in list
      private Node next; // Link to next node
      
      private Node(T dataPortion)
      {
         data = dataPortion;
         next = null;
      } // end constructor
      
      private Node(T dataPortion, Node nextNode)
      {
         data = dataPortion;
         next = nextNode;
      } // end constructor
      
      private T getData()
      {
         return data;
      } // end getData
      
      private Node getNextNode()
      {
         return next;
      } // end getNextNode
	} // end Node
} // end LinkedListWithIterator



