package exception.models;

public class Student extends Group {
    public enum NamesSubjects {
        COMPUTER_SCIENCE, ANATOMY, CHEMISTRY, ECONOMICS, ENGLISH, GEOGRAPHY, HISTORY, ASTRONOMY
    }
    private String lastName;
    private NamesSubjects subject;
    private int mark;

    public Student() {
        super();
    }

    public Student(String lastName, NameFaculty nameFaculty, NameGroup nameGroup, NamesSubjects subject, int mark) {
        super(nameFaculty, nameGroup);
        setLastName(lastName);
        setSubject(subject);
        setMark(mark);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }

    public NamesSubjects getSubject() {
        return subject;
    }

    public void setSubject(NamesSubjects subject) {
        this.subject = subject;
    }

    public NameGroup getGroup() {
        return super.getNameGroup();
    }

    public NameFaculty getFaculty() {
        return super.getNameFaculty();
    }

    @Override
    public String toString() {
        return lastName +  "   faculty - " + getFaculty() +
                "  group - " + getGroup() + " subject - " + subject + ", mark = " + mark;
    }
}
