package error_exceptions.models;

import error_exceptions.exceptions.WrongMarkException;

public class Student {

    public enum SubjectsName {
        COMPUTER_SCIENCE, ANATOMY, CHEMISTRY, ECONOMICS, ENGLISH, GEOGRAPHY, HISTORY, ASTRONOMY
    }

    private String lastName;
    private String firstName;
    private SubjectsName subject;
    private int mark;

    public Student() {
        super();
    }

    public Student(String lastName, String firstName) {
        setLastName(lastName);
        setFirstName(firstName);
    }

    public Student(Student student, SubjectsName subject, int mark) {
        setLastName(student.getLastName());
        setFirstName(student.getFirstName());
        setSubject(subject);
        setMark(mark);
    }

    private void setLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("Last name is null");
        } else if ("".equals(lastName)) {
            throw new IllegalArgumentException("Last name is empty");
        } else {
            this.lastName = lastName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("First name is null");
        } else if ("".equals(firstName)) {
            throw new IllegalArgumentException("First name is empty");
        } else {
            this.firstName = firstName;
        }
    }

    private void setMark(int mark) {
        if (mark < 0 || mark > 10) {
            throw new WrongMarkException("Non correct mark: " + mark);
        } else {
            this.mark = mark;
        }
    }

    public int getMark() {
        return mark;
    }

    private void setSubject(SubjectsName subject) {
        if (subject == null) {
            throw new IllegalArgumentException("Subject is null");
        }
        this.subject = subject;
    }

    public SubjectsName getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return String.format("Student: %s %s, subject: %s, mark: %d ",
            getLastName(), getFirstName(), getSubject(), getMark());
    }
}