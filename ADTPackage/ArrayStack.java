package ADTPackage;
import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> implements StackInterface<T> {
    private T[] stack;
    private int topIndex;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_CAPACITY = 10000;
    private boolean integrityOK = false;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    } //end ArrayStack

    public ArrayStack(int initialCapacity) {
        integrityOK = false;
        checkCapacity(initialCapacity);
        
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[initialCapacity]; // Unchecked cast
        stack = tempStack;
        topIndex = -1;
        integrityOK = true;
	} //end ArrayStack

    public ArrayStack(T[] contents) {
        checkCapacity(contents.length);
        stack = Arrays.copyOf(contents, contents.length);
        topIndex= 0;
        integrityOK = true;
    } //end ArrayStack

    public void push(T newEntry) {
        checkintegrity();
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    }//end push

    public T pop() throws EmptyStackException {
        checkintegrity();
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        else{
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        } //end if
    } //end pop

    public T peek() throws EmptyStackException {
        checkintegrity();
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stack[topIndex];
        }
    }//end peek

    public boolean isEmpty() {
        return topIndex < 0;
    }

    public void clear() {
        checkintegrity();
        while(topIndex > -1) {
            stack[topIndex] = null;
            topIndex--;
        }//end while
    }//end clear

    private void checkintegrity() {
        if (!integrityOK)
            throw new SecurityException ("ArrayBag object is corrupt.");
    } //end checkIntegrity

    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds allowed maximum of " + MAX_CAPACITY);
    } // end checkCapacity

    private void ensureCapacity() {
        if (topIndex >= stack.length -1) {
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        }//end if
    }//end ensureCapacity
    
}//end ResizeableArrayStack
