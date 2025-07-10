package com.eclipse.hotel.api.repository;

import com.eclipse.hotel.api.model.Reservation;
import com.eclipse.hotel.api.model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
