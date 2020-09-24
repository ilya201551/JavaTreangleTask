package entities.exceptions;

public class TriangleLogicException extends Exception{
    public TriangleLogicException() {
    }
    public TriangleLogicException(String message, Throwable cause) {
        super(message, cause);
    }
    public TriangleLogicException(String message) {
        super(message);
    }
    public TriangleLogicException(Throwable cause) {
        super(cause);
    }
}
