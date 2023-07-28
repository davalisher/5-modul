package uz.pdp.evos.backend.repository;

import uz.pdp.evos.backend.dtos.UserDTO;
import uz.pdp.evos.backend.entity.BaseEntity;
import uz.pdp.evos.backend.entity.User;

import java.util.ArrayList;
import java.util.List;

public abstract class Repository<Entity extends BaseEntity, Id> implements BaseRepository<Entity , Id> {
    private  final List<Entity> ENTITIES=new ArrayList<>();

    @Override
    public User getById(Id id) {
        return null; //todo
    }

    @Override
    public void add(UserDTO userDTO) {
//todo
    }

    @Override
    public Entity delete(Id id) {
        return null;////todo
    }

    @Override
    public List<Entity> getAll() {
        return ENTITIES;//todo
    }
}
