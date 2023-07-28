package uz.pdp;

import java.util.UUID;

public class ConstructorReferenceExample {
    public static void main(String[] args) {
        StudentDTO dto=new StudentDTO("A","P");

        StudentService service=studentDTO -> {
            Student student=new Student();
            student.setUuid(UUID.randomUUID());
            student.setUsername(studentDTO.username());
            student.setPassword(studentDTO.password());
            return student;
        };
        StudentService  studentService=Student::new;
    }
}
