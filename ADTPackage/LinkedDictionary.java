package ADTPackage;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedDictionary<K extends Comparable<? super K>, V> implements DictionaryInterface<K, V> {

	private Node firstNode;
	private int numberOfEntries;
	
	public LinkedDictionary() {
		firstNode = null;
		numberOfEntries = 0;
	}
	
	public V add(K key, V value) {
		V result = null;
		if((key == null) || (value ==null))
			throw new IllegalArgumentException("Does not except null");
		else {
			Node currentNode = firstNode;
			Node nodeBefore = null;
			while ((currentNode != null) && key.compareTo(currentNode.getKey()) > 0) {
				nodeBefore = currentNode;
				currentNode = currentNode.getNextNode();
			}
			
			if ((currentNode != null) && (key.equals(currentNode.getKey()))) {
				result = currentNode.getValue();
				
				currentNode.setValue(value);
			}
			else {
				Node newNode = new Node(key , value);
				
				if(nodeBefore == null) {
					newNode.setNextNode(firstNode);
					firstNode = newNode;
				}
				else {
					newNode.setNextNode(currentNode);
					nodeBefore.setNextNode(newNode);
				}
				
				numberOfEntries++;
			}
		}
		return result;
	}

	public V remove(K key) {
		
	}

	public V getValue(K key) {
	
		return getValue(key);
	}

	public boolean contains(K key) {
		
		return false;
	}

	public Iterator<K> getKeyIterator() {
		  
	}

	public Iterator<V> getValueIterator() {
	
		return null;
	}

	public boolean isEmpty() {

		return false;
	}

	public int getSize() {
		return numberOfEntries;
	}

	public void clear() {
		firstNode = null;
	}
	private class Node 
	   {
	      private Node next; // Link to next node
	      private Node value;
	      
	      private Node(T dataPortion)
	      {
	         next = null;
	      } // end constructor
	      
	      private Node(T dataPortion, Node nextNode)
	      {
	         next = nextNode;
	      } // end constructor
	      
	      private Node getNextNode()
	      {
	         return next;
	      } // end getNextNode
	      
	      private void setNextNode(Node nextNode)
	      {
	         next = nextNode;
	      } // end setNextNode
	      private Node getValue() {
	    	  return value;
	      }
		} // end Node

}
