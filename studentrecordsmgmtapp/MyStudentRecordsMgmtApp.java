package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MyStudentRecordsMgmtApp {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        try {
            Date date1 = dateFormat.parse("11/18/1951");
            Date date2 = dateFormat.parse("12/07/1990");
            Date date3 = dateFormat.parse("01/31/1974");
            Date date4 = dateFormat.parse("08/22/2009");
            Date date5 = dateFormat.parse("03/05/1990");

            Student[] students = {
                    new Student(110001, "Dave", date1),
                    new Student(110002, "Anna", date2),
                    new Student(110003, "Erica", date3),
                    new Student(110004, "Carlos", date4),
                    new Student(110005, "Bob", date5)
            };

            // Call the printListOfStudents method to print student data in ascending order of names
            printListOfStudents(students);

            // Call the getListOfPlatinumAlumniStudents method to get the list of platinum-alumni students
            List<Student> platinumAlumniStudents = getListOfPlatinumAlumniStudents(students);

            // Sort the list of platinum-alumni students by date of admission in descending order
            platinumAlumniStudents.sort(Comparator.comparing(Student::getDateOfAdmission).reversed());

            // Print the list of platinum-alumni students
            System.out.println("\nList of Platinum Alumni Students:");
            for (Student student : platinumAlumniStudents) {
                System.out.println(student);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void printListOfStudents(Student[] students) {
        // Sort the array of students by name in ascending order
        Arrays.sort(students, Comparator.comparing(Student::getName));

        // Print student details
        System.out.println("List of Students (Sorted by Name):");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static List<Student> getListOfPlatinumAlumniStudents(Student[] students) {
        List<Student> platinumAlumniStudents = new ArrayList<>();
        Date currentDate = new Date();

        for (Student student : students) {
            long yearsSinceAdmission = (currentDate.getTime() - student.getDateOfAdmission().getTime()) / (1000L * 60 * 60 * 24 * 365);
            if (yearsSinceAdmission >= 30) {
                platinumAlumniStudents.add(student);
            }
        }

        return platinumAlumniStudents;
    }
}
