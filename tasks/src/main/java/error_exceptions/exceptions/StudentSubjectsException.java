package error_exceptions.exceptions;

public class StudentSubjectsException extends IllegalArgumentException {

  public StudentSubjectsException() {
  }

  public StudentSubjectsException(String s) {
    super(s);
  }

  public StudentSubjectsException(String message, Throwable cause) {
    super(message, cause);
  }

  public StudentSubjectsException(Throwable cause) {
    super(cause);
  }
}
