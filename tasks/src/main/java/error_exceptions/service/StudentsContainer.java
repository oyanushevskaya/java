package error_exceptions.service;

import error_exceptions.exceptions.GroupsInFacultyException;
import error_exceptions.exceptions.StudentInGroupException;
import error_exceptions.exceptions.StudentSubjectsException;
import error_exceptions.models.Faculty;
import error_exceptions.models.Group;
import error_exceptions.models.Student;

import error_exceptions.exceptions.FacultyInUniversityException;
import java.util.List;

public class StudentsContainer {

    public static final Student studentMillsSteven = new Student("Mills", "Steven");
    public static final Student studentMillsVincent = new Student("Mills", "Vincent");
    public static final Student studentAndrewsBetty = new Student("Andrews", "Betty");
    public static final Student studentHarrisJulian = new Student("Harris", "Julian");
    public static final Student studentBensonMary = new Student("Benson", "Mary");
    public static final Student studentWadeAnthony = new Student("Wade", "Anthony");

    private static double averageMark = 0.0;
    private static int countSubjects = 0;
    private static double sumAllMarks = 0.0;

    private static double averageMark(Student student) {
        sumAllMarks += student.getMark();
        if (student.getSubject() != null) {
            countSubjects++;
        }
        return sumAllMarks / countSubjects;
    }

    public static double averageMarkOfAllSubjects(List<Student> students, String lastName,
        String firstName) {
        for (Student student : students) {
            if (student.getLastName().equals(lastName) && student.getFirstName()
                .equals(firstName)) {
                averageMark = averageMark(student);
            }
        }
        if (averageMark == 0.0) {
            throw new StudentSubjectsException("Student " + lastName + " " + firstName
                + " without marks or not study in this university");
        }
        return averageMark;
    }

    private static boolean hasStudentInGroup(List<Faculty> faculties, Group.GroupName group) {
        boolean hasStudent = false;
        for (Faculty faculty : faculties) {
            String groupNames = faculty.getGroupName().name();
            if (groupNames.contains(group.name())) {
                hasStudent = true;
                break;
            }
        }
        return hasStudent;
    }

    private static boolean hasGroupsInFaculty(List<Faculty> faculties, Group.GroupName group,
        Faculty.FacultyName facultyName) {
        boolean hasGroup = false;
        for (Faculty faculty : faculties) {
            if (faculty.getFacultyName().equals(facultyName) && faculty.getGroupName().equals(group)) {
                hasGroup = true;
                break;
            }
        }
        return hasGroup;
    }

    private static boolean facultyInUniversity(List<Faculty> faculties,
        Faculty.FacultyName facultyName) {
        boolean hasFaculty = false;
        for (Faculty faculty : faculties) {
            String facultyNames = faculty.getFacultyName().name();
            if (facultyNames.contains(facultyName.name())) {
                hasFaculty = true;
                break;
            }
        }
        return hasFaculty;
    }

    public static double averageMarkOfSpecificSubjectGroupFaculty(List<Faculty> faculties,
        List<Student> students, Student.SubjectsName subject,
        Group.GroupName group, Faculty.FacultyName facultyName) {
        sumAllMarks = 0;
        countSubjects = 0;
        averageMark = 0.0;

        if (!hasStudentInGroup(faculties, group)) {
            throw new StudentInGroupException("Group without student");
        }

        if (!hasGroupsInFaculty(faculties, group, facultyName)) {
            throw new GroupsInFacultyException("Faculty not contains this group");
        }

        if (!facultyInUniversity(faculties, facultyName)) {
            throw new FacultyInUniversityException("Faculty not exist");
        }

        for (Faculty faculty : faculties) {
            for (Student student : students) {
                if (faculty.getStudent().getLastName().equals(student.getLastName()) &&
                    faculty.getStudent().getFirstName().equals(student.getFirstName()) &&
                    faculty.getGroupName() == group && faculty.getFacultyName() == facultyName
                    && student.getSubject() == subject) {
                    averageMark = averageMark(student);
                }
            }
        }
        return averageMark;
    }

    public static double averageMarkOfSubjectInUniversity(List<Student> students,
        Student.SubjectsName subjects) {
        sumAllMarks = 0;
        countSubjects = 0;
        averageMark = 0.0;
        for (Student student : students) {
            if (student.getSubject() == subjects) {
                averageMark = averageMark(student);
            }
        }
        if (averageMark == 0.0) {
            throw new IllegalArgumentException("no marks");
        }
        return averageMark;
    }
}
