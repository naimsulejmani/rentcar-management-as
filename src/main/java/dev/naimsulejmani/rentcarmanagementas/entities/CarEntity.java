package dev.naimsulejmani.rentcarmanagementas.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "cars")
@Getter
@Setter
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // atributes for vin, make, model, year, color, price, available
    @Column(unique = true, nullable = false, length = 17)
    private String vin;
    @Column(nullable = false, length = 50)
    private String make;
    private String model;
    private int year;
    private String color;
    private double price;
    private boolean available;
    // here to be add at least 5 logging columns such as created_at, updated_at, created_by, updated_by, updated_count;
}
