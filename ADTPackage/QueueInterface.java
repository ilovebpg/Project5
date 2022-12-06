package ADTPackage;
/**
   An interface for the ADT queue.   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public interface QueueInterface<T> {
    /**Adds a new entry to the back of the queue
     * @param newEntry The object to be added.
     */
    public void enqueue (T newEntry);

    /**Removes and returns the entry at the front of the queue.
     * @return The first object in the queue
     * @throws EmptyQueueException if the queue is empty before the operation.
     */
    public T dequeue() throws EmptyQueueException;

    /**Retrieves the entry at the front of the queue
     * @return The first object in the queue
     * @throws EmptyQueueException if the queue is empty.
     */
    public T getFront() throws EmptyQueueException;

    /**Detects if queue is empty
     * @return True if queue is empty, false otherwise
     */
    public boolean isEmpty();

    /** Removes all entries from queue */
    public void clear();
}//end QueueInterface