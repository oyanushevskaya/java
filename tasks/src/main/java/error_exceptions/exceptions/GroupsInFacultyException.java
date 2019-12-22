package error_exceptions.exceptions;

public class GroupsInFacultyException extends IllegalArgumentException {

  public GroupsInFacultyException() {
  }

  public GroupsInFacultyException(String s) {
    super(s);
  }

  public GroupsInFacultyException(String message, Throwable cause) {
    super(message, cause);
  }

  public GroupsInFacultyException(Throwable cause) {
    super(cause);
  }
}
