package exception.service;

import exception.models.Faculty;
import exception.models.Group;
import exception.models.Student;

import java.util.List;

public class StudentsContainer {
    private static double averageMark = 0.0;
    private static int countSubjects = 0;
    private static double sum = 0.0;

    private static double averageMark(Student student) {
        if (student.getSubject() != null) {
            countSubjects++;
        }
        sum += student.getMark();
        if (countSubjects == 0) {
            throw new IllegalArgumentException("Count subject is null at " + student.getLastName());
        }
        return sum / countSubjects;
    }

    public static double averageMarkOfAllSubjects(List<Student> students, String lastName) {
        for (Student student : students) {
            if (student.getLastName().equals(lastName)) {
                averageMark = averageMark(student);
            }
        }
        if (averageMark == 0.0) {
            throw new IllegalArgumentException("Student not exist!");
        }
        return averageMark;
    }

    public static double averageMarkOfSpecificSubjectGroupFaculty(List<Student> students, Student.SubjectsName subject,
                                                                  Group.GroupName group, Faculty.FacultyName faculty){
        sum = 0; countSubjects = 0;
        for (Student student: students) {
            if (student.getSubject() == subject && student.getGroup() == group && student.getFaculty() == faculty) {
                averageMark = averageMark(student);
            }
        }
        return averageMark;
    }

    public static double averageMarkOfSubjectInUniversity(List<Student> students, Student.SubjectsName subjects){
        sum = 0; countSubjects = 0;
        for (Student student: students) {
            if (student.getSubject() == subjects) {
                averageMark = averageMark(student);
            }
        }
        return averageMark;
    }
}
