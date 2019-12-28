package exception.models;

public class Faculty{
    public enum FacultyName {
        MATHEMATICS, PHYSICS, BIOLOGY, GEOLOGY, LAW
    }
    private FacultyName facultyName;

    public Faculty() {
    }

    public Faculty(FacultyName facultyName) {
        this.facultyName = facultyName;
    }

    public FacultyName getFacultyName() {
        return facultyName;
    }
}
