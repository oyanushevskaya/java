package error_exceptions.models;

public class Group {

    public enum GroupName {
        M1, M2, M3, M4, P1, P2, P3, P4, B1, B2, B3, B4, G1, G2, G3, G4
    }

    private GroupName groupName;
    private Student student;

    public Group(GroupName groupName) {
        this.groupName = groupName;
    }

    Group(GroupName groupName, Student student) {
        setGroupName(groupName);
        setStudent(student);
    }

    private void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public Student.SubjectsName getSubject() {
        return student.getSubject();
    }

    private void setGroupName(GroupName groupName) {
        this.groupName = groupName;
    }

    public GroupName getGroupName() {
        return groupName;
    }

    @Override
    public String toString() {
        return String.format(" Group - %s  Student: %s %s ",
            getGroupName(), student.getLastName(), student.getFirstName());
    }
}
