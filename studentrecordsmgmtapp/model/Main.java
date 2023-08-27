package edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        try {
            Date date1 = dateFormat.parse("11/18/1951");
            Date date2 = dateFormat.parse("12/07/1990");
            Date date3 = dateFormat.parse("01/31/1974");
            Date date4 = dateFormat.parse("08/22/2009");
            Date date5 = dateFormat.parse("03/05/1990");

            Student student1 = new Student(110001, "Dave", date1);
            Student student2 = new Student(110002, "Anna", date2);
            Student student3 = new Student(110003, "Erica", date3);
            Student student4 = new Student(110004, "Carlos", date4);
            Student student5 = new Student(110005, "Bob", date5);

            System.out.println(student1);
            System.out.println(student2);
            System.out.println(student3);
            System.out.println(student4);
            System.out.println(student5);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
