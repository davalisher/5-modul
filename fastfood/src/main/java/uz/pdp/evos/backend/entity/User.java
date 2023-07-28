package uz.pdp.evos.backend.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class User {
    private String fullName;
    private String phone;
}
