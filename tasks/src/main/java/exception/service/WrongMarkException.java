package exception.service;

public class WrongMarkException extends IllegalArgumentException {
    private String message;

    public WrongMarkException() {
        super();
    }

    public WrongMarkException(Exception exception, String message) {
        super(exception);
        this.message = message;
    }

    public WrongMarkException(int value, String message) {
        System.out.println("Wrong value: " + value);
        this.message = message;
    }

    public String toString() {
        return message;
    }
}
