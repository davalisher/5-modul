package uz.pdp.evos.backend.repository;

import uz.pdp.evos.backend.dtos.UserDTO;
import uz.pdp.evos.backend.entity.BaseEntity;
import uz.pdp.evos.backend.entity.User;

import java.util.List;
import java.util.UUID;

public interface BaseRepository<Entity extends BaseEntity, Id> {
    User getById(Id id);
    void add(UserDTO userDTO);
    Entity delete(Id id);
    List<Entity> getAll();


}
