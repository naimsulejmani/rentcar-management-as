package dev.naimsulejmani.rentcarmanagementas.services;

import java.util.List;

public interface BaseService<ENTITY, ID> {
    ENTITY add(ENTITY entity);

    ENTITY modify(ID id, ENTITY entity);

    void removeById(ID id);

    ENTITY findById(ID id);

    List<ENTITY> findAll(); // Pageable pageable
}
