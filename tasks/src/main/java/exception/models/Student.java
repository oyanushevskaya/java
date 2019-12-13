package exception.models;

import exception.service.WrongMarkException;

public class Student extends Group {
    public enum SubjectsName {
        COMPUTER_SCIENCE, ANATOMY, CHEMISTRY, ECONOMICS, ENGLISH, GEOGRAPHY, HISTORY, ASTRONOMY
    }
    private String lastName;
    private SubjectsName subject;
    private int mark;

    public Student() {
        super();
    }

    public Student(String lastName, FacultyName facultyName, GroupName groupName) {
        super(facultyName, groupName);
        setLastName(lastName);
    }

    public Student(String lastName, FacultyName facultyName, GroupName groupName, SubjectsName subject, int mark) {
        super(facultyName, groupName);
        setLastName(lastName);
        setSubject(subject);
        setMark(mark);
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("Name is null");
        } else if ("".equals(lastName)) {
            throw new IllegalArgumentException("Name is empty");
        } else {
            this.lastName = lastName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setMark(int mark) {
        if (mark < 0 || mark > 10) {
            throw new WrongMarkException(mark, "Non correct mark");
        } else {
            this.mark = mark;
        }
    }

    public int getMark() {
        return mark;
    }

    public void setSubject(SubjectsName subject) {
        if (subject == null) {
            throw new IllegalArgumentException("Subject is null");
        }
        this.subject = subject;
    }

    public SubjectsName getSubject() {
        return subject;
    }

    public GroupName getGroup() {
        return super.getGroupName();
    }

    public FacultyName getFaculty() {
        return super.getFacultyName();
    }

    @Override
    public String toString() {
        return lastName +  "   faculty - " + getFaculty() +
                "  group - " + getGroup() + " subject - " + subject + ", mark = " + mark;
    }
}
