package error_exceptions.models;

public class Faculty extends Group {

  public enum FacultyName {
    MATHEMATICS, PHYSICS, BIOLOGY, GEOLOGY, LAW
  }

  private FacultyName facultyName;

  public Faculty(FacultyName facultyName, GroupName groupName, Student student) {
    super(groupName, student);
    this.facultyName = facultyName;
  }

  public FacultyName getFacultyName() {
    return facultyName;
  }

  @Override
  public String toString() {
    return String.format("Faculty: %s  ", getFacultyName()) + super.toString();
  }
}
