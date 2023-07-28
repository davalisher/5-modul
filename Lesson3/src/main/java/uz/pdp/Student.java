package uz.pdp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    UUID uuid;
    private String fullName;
    private String group;
    private String username;
    private String password;
    private int birthYear;


    public Student(StudentDTO studentDTO) {
        this.uuid=UUID.randomUUID();
        this.username=studentDTO.username();
        this.password=studentDTO.password();
    }
}
