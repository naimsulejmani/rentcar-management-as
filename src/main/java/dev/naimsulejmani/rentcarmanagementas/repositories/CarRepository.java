package dev.naimsulejmani.rentcarmanagementas.repositories;

import dev.naimsulejmani.rentcarmanagementas.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

}
