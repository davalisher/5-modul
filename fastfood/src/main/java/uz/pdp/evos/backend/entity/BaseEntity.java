package uz.pdp.evos.backend.entity;

import java.time.LocalDateTime;

public class BaseEntity<Id> {
    Id id;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    User createdBy;
    User updatedBy;


}
