package com.eclipse.hotel.api.repository;

import com.eclipse.hotel.api.model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomsRepository extends JpaRepository<Rooms,Long> {
}
