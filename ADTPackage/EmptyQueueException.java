package ADTPackage;

public class EmptyQueueException extends java.lang.Exception {
	
    public EmptyQueueException() {
        System.out.println("The queue was empty.");
    }
    
    public EmptyQueueException(java.lang.String msg) {
        System.out.println(msg);
    }   
}
