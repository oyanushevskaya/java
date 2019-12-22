package error_exceptions.exceptions;

public class FacultyInUniversityException extends IllegalArgumentException {

  public FacultyInUniversityException() {
  }

  public FacultyInUniversityException(String s) {
    super(s);
  }

  public FacultyInUniversityException(String message, Throwable cause) {
    super(message, cause);
  }

  public FacultyInUniversityException(Throwable cause) {
    super(cause);
  }
}
