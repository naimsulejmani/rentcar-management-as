package dev.naimsulejmani.rentcarmanagementas.services.impls;

import dev.naimsulejmani.rentcarmanagementas.dtos.CarDto;
import dev.naimsulejmani.rentcarmanagementas.mappers.CarMapper;
import dev.naimsulejmani.rentcarmanagementas.repositories.CarRepository;
import dev.naimsulejmani.rentcarmanagementas.services.CarService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository repository;
    private final CarMapper mapper;


    @Override
    public CarDto add(CarDto carDto) {
        var entity = mapper.toEntity(carDto);
        repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public CarDto modify(Long id, CarDto carDto) {
        var entityExists = repository.existsById(id);

        if (!entityExists) {
            throw new EntityNotFoundException("Car with id " + id + " not found");
        }

        var entity = mapper.toEntity(carDto);
        repository.save(entity);

        return mapper.toDto(entity);
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
    public CarDto findById(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Car with id " + id + " not found"));
        return mapper.toDto(entity);
    }

    @Override
    public List<CarDto> findAll() {
        var entities = repository.findAll();
        return mapper.toDtoList(entities);
    }
}
