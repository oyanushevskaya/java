package error_exceptions.exceptions;

public class StudentInGroupException extends IllegalArgumentException {

  public StudentInGroupException() {
  }

  public StudentInGroupException(String s) {
    super(s);
  }

  public StudentInGroupException(String message, Throwable cause) {
    super(message, cause);
  }

  public StudentInGroupException(Throwable cause) {
    super(cause);
  }
}
