package uz.pdp;

import com.github.javafaker.Faker;
import lombok.Cleanup;
import lombok.extern.java.Log;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.logging.Level;

@Log
public class Main {
    static final int count = 100;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
/*        List<Student> students = getStudents(count);
        writeStudentsTofile(students);*/
//        List<Student> list = getStudentsStartsWith("A");
//        list.forEach(System.out::println);
//        System.out.println("Test");
        Student student=new Student("A","G","p","e",1);
//        student.setAddress(new Address("A","B"));
        System.out.println("===========================");
        System.out.println(student);
        Student.abc()
                .phone("z")
                .fullName("sdfsd")
                .cba();
        log.log(Level.INFO,"sdfsdfsfsdfs");
        List<Integer> integers=new ArrayList<>();
        UnaryOperator
    }

    private static List<Student> getStudentsStartsWith(String start) throws IOException, ClassNotFoundException {
        List<Student> students = new ArrayList<>();
        @Cleanup ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/main/java/students.txt"));

        Student student;
        for (int i = 0; i < count; i++) {
            student = (Student) objectInputStream.readObject();
            if (student.getFullName().startsWith(start)) {
                students.add(student);
            }

        }
        return students;
    }

   /* private static void writeStudentsTofile(List<Student> students) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/main/resources/students.txt"));
        for (Student student : students) {
            objectOutputStream.writeObject(student);
        }
    }

    private static List<Student> getStudents(int count) {
        Faker faker = new Faker();

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            students.add(
                    new Student(
                            faker.name().fullName(),
                            faker.educator().university(),
                            faker.phoneNumber().phoneNumber(),
                            faker.internet().emailAddress(),
                            faker.date().birthday().getYear())
            );
        }
        return students;
    }*/
}