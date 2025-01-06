package dev.naimsulejmani.rentcarmanagementas.services.impls;

import dev.naimsulejmani.rentcarmanagementas.entities.CarEntity;
import dev.naimsulejmani.rentcarmanagementas.repositories.CarRepository;
import dev.naimsulejmani.rentcarmanagementas.services.CarService2;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl2 implements CarService2 {
    private final CarRepository repository;

    @Override
    public CarEntity add(CarEntity carEntity) {
        return repository.save(carEntity);
    }

    @Override
    public CarEntity modify(Long id, CarEntity carEntity) {
        var entityExists = repository.existsById(id);
        if (!entityExists) {
            throw new EntityNotFoundException("Car with id " + id + " not found");
        }

        return repository.save(carEntity);
    }

    @Override
    public void removeById(Long id) {
        var entityExists = repository.existsById(id);
        if (!entityExists) {
            throw new EntityNotFoundException("Car with id " + id + " not found");
        }
        repository.deleteById(id);

    }

    @Override
    public CarEntity findById(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Car with id " + id + " not found"));
    }

    @Override
    public List<CarEntity> findAll() {
        return repository.findAll();
    }
}
