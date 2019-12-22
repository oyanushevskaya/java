package error_exceptions;

import error_exceptions.models.Faculty;
import error_exceptions.models.Group;
import error_exceptions.models.Student;
import error_exceptions.service.StudentsContainer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static error_exceptions.models.Group.GroupName.*;
import static error_exceptions.models.Student.SubjectsName.*;
import static error_exceptions.models.Faculty.FacultyName.*;
import static error_exceptions.service.StudentsContainer.*;

public class Runner {

    public static void main(String[] args) {
        final String LAST_NAME_STUDENT = "Mills";
        final String FIRST_NAME_STUDENT = "Vincent";
        List<Faculty> faculties = Arrays.asList(
            new Faculty(MATHEMATICS, M1, studentMillsSteven),
            new Faculty(MATHEMATICS, M1, studentMillsVincent),
            new Faculty(BIOLOGY, B2, studentAndrewsBetty),
            new Faculty(PHYSICS, P1, studentHarrisJulian),
            new Faculty(BIOLOGY, B1, studentBensonMary),
            new Faculty(MATHEMATICS, M3, studentWadeAnthony)
        );
        faculties.sort(Comparator.comparing(Group::getGroupName));
        faculties.forEach(System.out::println);

        System.out.println("\n");
        List<Student> studentsMarks = Arrays.asList(
            new Student(studentMillsSteven, COMPUTER_SCIENCE, 10),
            new Student(studentMillsSteven, ENGLISH, 7),
            new Student(studentMillsVincent, COMPUTER_SCIENCE, 9),
            new Student(studentMillsVincent, ENGLISH, 6),
            new Student(studentAndrewsBetty, ANATOMY, 5),
            new Student(studentHarrisJulian, ASTRONOMY, 8),
            new Student(studentBensonMary, ECONOMICS, 4),
            new Student(studentBensonMary, ANATOMY, 8)
        );
        studentsMarks.forEach(System.out::println);

        System.out.print(String
            .format("%nAverage mark of student %s %s in all subject : ", LAST_NAME_STUDENT,
                FIRST_NAME_STUDENT));
        System.out.println(StudentsContainer
            .averageMarkOfAllSubjects(studentsMarks, LAST_NAME_STUDENT, FIRST_NAME_STUDENT));

        System.out.print(String
            .format("%nAverage mark of subject - %s, in group - %s, at faculty - %s : ", ANATOMY,
                B1, BIOLOGY));
        System.out.println(StudentsContainer
            .averageMarkOfSpecificSubjectGroupFaculty(faculties, studentsMarks, ANATOMY, B1,
                BIOLOGY));

        System.out.print(
            String.format("%nAverage mark of subject %s in all university : ", COMPUTER_SCIENCE));
        System.out.println(
            StudentsContainer.averageMarkOfSubjectInUniversity(studentsMarks, COMPUTER_SCIENCE));
    }
}
