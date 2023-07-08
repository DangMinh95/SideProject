package com.example.sideproject.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @Min(0)
    @Max(100)
    private Double price;

    private Long category_id;

    private String factory;

    @Nullable
    private String created_at;

    @Nullable
    private String updated_at;
}
