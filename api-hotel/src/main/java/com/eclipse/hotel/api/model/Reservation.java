package com.eclipse.hotel.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Reservation")
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column
    private LocalDate checkin;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column
    private LocalDate checkout;

    private StatusEnums status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customers;

    @OneToOne
    @JoinColumn(name = "room_id")
    private Rooms room;
}
