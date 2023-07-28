package uz.pdp.evos.backend.entity;


import lombok.*;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Food extends BaseEntity<UUID> {
//    private UUID id;
    private String name;
    private String description;
    private Double price;
    private Category category;
}
