package myExceptions;

public class InvalidDataFormatException extends RuntimeException{
    public InvalidDataFormatException() {
    }

    public InvalidDataFormatException(String message) {
        super(message);
    }

}
