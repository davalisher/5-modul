package uz.pdp.evos.backend.entity;

import lombok.*;
import uz.pdp.evos.backend.enums.Status;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Order extends BaseEntity<UUID> {
    private List<Food> foods;
    private User user;
    private Status status;
    private String location;
    private double totalPrice;
    boolean isDelivery;
    private double deliveryPrice;


}
