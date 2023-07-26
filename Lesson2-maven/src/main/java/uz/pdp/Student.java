package uz.pdp;

import lombok.*;

import java.io.Serializable;
import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Builder(builderMethodName = "abc", buildMethodName = "cba")
public class Student extends Person implements Serializable  {
    private String fullName;
    @NonNull
    private String group;
    private String phone;
    private String email;
//    @Getter(lazy = true)
    private  int birthYear=randomBirthYear();
//    private Address address;



    private int randomBirthYear(){
        System.out.println("Generating birth year");
        return new Random().nextInt(2000,2010);
    }


}
