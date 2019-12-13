package exception;

import exception.models.Student;
import exception.service.StudentsContainer;

import java.util.Arrays;
import java.util.List;

import static exception.models.Group.GroupName.*;
import static exception.models.Student.SubjectsName.*;
import static exception.models.Faculty.FacultyName.*;

public class Runner {
    public static void main(String[] args) {
        final String LAST_NAME_STUDENT = "Andrews";
        List<Student> students = Arrays.asList(
                new Student("Mills", MATHEMATICS, M1, COMPUTER_SCIENCE, 10),
                //1 new Student("Mills", MATHEMATICS, M1, COMPUTER_SCIENCE, 100),
                new Student("Mills",  MATHEMATICS, M1, COMPUTER_SCIENCE, 1),
                //1 new Student("Mills",  MATHEMATICS, M1, COMPUTER_SCIENCE, -1),
                new Student("Mills", MATHEMATICS, M1, HISTORY, 7),
                new Student("Mills", MATHEMATICS, M1, ECONOMICS, 7),
                new Student("Andrews", PHYSICS, P2, ASTRONOMY, 8),
                new Student("Andrews", PHYSICS, P2),
                new Student("Harris",  PHYSICS, P2, ASTRONOMY, 9),
                new Student("Harris", PHYSICS, P2, CHEMISTRY, 9),
                new Student("Benson",  BIOLOGY, B3, CHEMISTRY, 6),
                new Student("Wade", GEOLOGY, G1, GEOGRAPHY, 9),
                new Student("Wade",  GEOLOGY, G1, CHEMISTRY, 9),
                new Student("Lawson", MATHEMATICS, M4, ENGLISH, 5)
        );
        students.forEach(System.out::println);
        //средний по всем предметам студента
        System.out.print("\n Average mark of student " + LAST_NAME_STUDENT + " in all subject : ");
        System.out.println(StudentsContainer.averageMarkOfAllSubjects(students, LAST_NAME_STUDENT));

        //Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
        System.out.print("\n Average mark of subject " + ASTRONOMY + " in group " + P2 + " at faculty " + PHYSICS + " : ");
        System.out.println(StudentsContainer.averageMarkOfSpecificSubjectGroupFaculty(students, ASTRONOMY, P2, PHYSICS));

        //Посчитать средний балл по предмету для всего университета
        System.out.print("\n Average mark of subject " + CHEMISTRY + " in all university : ");
        System.out.println(StudentsContainer.averageMarkOfSubjectInUniversity(students, CHEMISTRY));

    }
}
