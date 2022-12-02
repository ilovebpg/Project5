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
   private int  numberOfEntries;;

   public LinkedListWithIterator() {
      initializeDataFields();
   } // end default constructor

   public void clear() {
      initializeDataFields();
   } //end clear

   public void add(T newEntry) {
      Node newNode = new Node(newEntry);
      if (isEmpty())
         firstNode = newNode;
      else {
         Node lastNode = getNodeAt(numberOfEntries);
         lastNode.setNextNode(newNode);
      } //end if
      numberOfEntries++;
   } //end add

   public T remove(int givenPosition) {
      // Return value
      T result = null;         
      // Assertion: !isEmpty()                 
      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
         // Case 1: Remove first entry 
         if (givenPosition == 1) {   
            // Save entry to be removed            
            result = firstNode.getData(); 
            // Remove entry      
            firstNode = firstNode.getNextNode(); 
         }
         // Case 2: Not first entry
         else {                                 
            Node nodeBefore = getNodeAt(givenPosition - 1);
            Node nodeToRemove = nodeBefore.getNextNode();
            // Save entry to be removed
            result = nodeToRemove.getData();    
            Node nodeAfter = nodeToRemove.getNextNode();
            // Remove entry
            nodeBefore.setNextNode(nodeAfter);   
         } // end if
         // Update count
         numberOfEntries--;  
         // Return removed entry                    
         return result;                         
      }
      else
         throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
   } // end remove

   public T[] toArray() {
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfEntries];
      
      int index = 0;
      Node currentNode = firstNode;
      while ((index < numberOfEntries) && (currentNode != null)) {
         result[index] = currentNode.getData();
         currentNode = currentNode.getNextNode();
         index++;
      } // end while
      return result;
   } // end toArray
   
   public boolean contains(T anEntry) {
      boolean found = false;
      Node currentNode = firstNode;
      
      while (!found && (currentNode != null)) {
         if (anEntry.equals(currentNode.getData()))
            found = true;
         else
            currentNode = currentNode.getNextNode();
      } // end while
      return found;
   } // end contains

   public T getEntry(int givenPosition) {
      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
         // Assertion: !isEmpty()
         return getNodeAt(givenPosition).getData();
      }
      else
         throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
   } // end getEntry

   public T replace(int givenPosition, T newEntry) {
      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
         // Assertion: !isEmpty()
         Node desiredNode = getNodeAt(givenPosition);
         T originalEntry = desiredNode.getData();
         desiredNode.setData(newEntry);
         return originalEntry;
      }
      else
         throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
   } // end replace

   public Iterator<T> iterator() {
	   return new IteratorForLinkedList();
   } // end iterator

	public Iterator<T> getIterator() {
	   return iterator();
	} // end getIterator
   
	private class IteratorForLinkedList implements Iterator<T> {
      private Node nextNode;

		private IteratorForLinkedList()
		{
			nextNode = firstNode;
		} // end default constructor

      @Override
      public boolean hasNext() {
         return nextNode != null;
      }

      @Override
      public T next() {
         T result;
			if (hasNext()) {
				result = nextNode.getData();
				nextNode = nextNode.getNextNode();
			} 
         else
				throw new NoSuchElementException("Unavailable move");
			return result;
      }
	} // end IteratorForLinkedList
	
	private class Node 
   {
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
      
      private void setData(T newData)
      {
         data = newData;
      } // end setData
      
      private Node getNextNode()
      {
         return next;
      } // end getNextNode
      
      private void setNextNode(Node nextNode)
      {
         next = nextNode;
      } // end setNextNode
	} // end Node
} // end LinkedListWithIterator



