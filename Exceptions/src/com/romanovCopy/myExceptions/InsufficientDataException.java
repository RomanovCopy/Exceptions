package src.com.romanovCopy.myExceptions;

public class InsufficientDataException extends RuntimeException{
    public InsufficientDataException() {
    }

    public InsufficientDataException(String message) {
        super(message);
    }

}
