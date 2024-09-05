package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

/**
 *
 * @author Syed Dawood
 */
public class MyStudentRecordsMgmtApp {
    
    public static void main(String[] args) {
        
        Student[] students = {
            new Student("110001", "Dave", Student.parseDate("11/18/1951")),
            new Student("110002", "Anna", Student.parseDate("12/07/1990")),
            new Student("110003", "Erica", Student.parseDate("01/31/1974")),
            new Student("110004", "Carlos", Student.parseDate("08/22/2009")),
            new Student("110005", "Bob", Student.parseDate("03/05/1990"))
        };

        
        printListOfStudents(students);
        
        
        List<Student> platinumAlumni = getListOfPlatinumAlumniStudents(students);
        System.out.println("\nPlatinum Alumni Students (Descending Order of Admission Date):");
        platinumAlumni.forEach(student -> 
            System.out.println(student.getStudentId() + ", " + student.getName() + ", " + student.getDateOfAdmission())
        );

        int[] numbersForHelloWorld = {10, 35, 14, 70, 22};
        printHelloWorld(numbersForHelloWorld);

        int[] numbers = {19, 9, 11, 0, 12};
        int secondBiggest = findSecondBiggest(numbers);
        System.out.println("The second biggest number is: " + secondBiggest);
    }

    public static void printListOfStudents(Student[] students) {
        Arrays.sort(students, Comparator.comparing(Student::getName));
        System.out.println("List of Students in Ascending Order of Names:");
        for (Student student : students) {
            System.out.println(student.getStudentId() + ", " + student.getName() + ", " + student.getDateOfAdmission());
        }
    }

    public static List<Student> getListOfPlatinumAlumniStudents(Student[] students) {
        List<Student> platinumAlumni = new ArrayList<>();
        LocalDate thirtyYearsAgo = LocalDate.now().minusYears(30);

        for (Student student : students) {
            if (student.getDateOfAdmission().isBefore(thirtyYearsAgo)) {
                platinumAlumni.add(student);
            }
        }

        platinumAlumni.sort(Comparator.comparing(Student::getDateOfAdmission).reversed());
        return platinumAlumni;
    }

    public static void printHelloWorld(int[] numbers) {
        for (int number : numbers) {
            if (number % 5 == 0 && number % 7 == 0) {
                System.out.println("HelloWorld");
            } else if (number % 5 == 0) {
                System.out.println("Hello");
            } else if (number % 7 == 0) {
                System.out.println("World");
            }
        }
    }

    public static int findSecondBiggest(int[] numbers) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        
        for (int number : numbers) {
            if (number > max) {
                secondMax = max;
                max = number;
            } else if (number > secondMax && number != max) {
                secondMax = number;
            }
        }
        
        return secondMax;
    }

}
