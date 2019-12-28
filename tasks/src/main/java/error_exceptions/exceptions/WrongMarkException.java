package error_exceptions.exceptions;

public class WrongMarkException extends IllegalArgumentException {

  public WrongMarkException() {
  }

  public WrongMarkException(String message, Throwable cause) {
    super(message, cause);
  }

  public WrongMarkException(Throwable cause) {
    super(cause);
  }

  public WrongMarkException(String s) {
    super(s);
  }
}
