package uz.pdp.evos.backend.entity;

import lombok.*;

import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Basket extends BaseEntity<UUID> {
    private User user;
    private Map<Food,Integer> products;


}
