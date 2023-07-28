package uz.pdp.evos.backend.entity;

import lombok.*;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Category extends BaseEntity<UUID> {
    private String name;
}
