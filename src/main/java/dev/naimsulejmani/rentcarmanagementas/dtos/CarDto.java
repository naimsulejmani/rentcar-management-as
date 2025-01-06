package dev.naimsulejmani.rentcarmanagementas.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {

    @PositiveOrZero
    private long id;

    @NotNull(message = "VIN should not be null")
    @NotBlank(message = "VIN should not be empty or blank")
    @Size(min = 17, max = 17, message = "VIN must be 17 characters long")
    private String vin;

    @NotNull(message = "Make should not be null")
    @NotBlank(message = "Make should not be empty or blank")
    private String make;
    private String model;

    private int year;
    private String color;
    private double price;
    private boolean available;
}
