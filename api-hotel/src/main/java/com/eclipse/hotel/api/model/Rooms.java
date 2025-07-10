package com.eclipse.hotel.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rooms")
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//faz com que o id ++
    private Long id;

    @Column
    private Integer roomNumber;

    @Column
    private String type;
    @Column
    private Double price;

}
