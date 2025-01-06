package dev.naimsulejmani.rentcarmanagementas.mappers;


import dev.naimsulejmani.rentcarmanagementas.dtos.CarDto;
import dev.naimsulejmani.rentcarmanagementas.entities.CarEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper extends BasicMapper<CarDto, CarEntity> {

}
