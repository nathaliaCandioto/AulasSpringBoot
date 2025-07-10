package com.eclipse.hotel.api.service;

import com.eclipse.hotel.api.model.Customers;
import com.eclipse.hotel.api.model.Reservation;
import com.eclipse.hotel.api.model.Rooms;
import com.eclipse.hotel.api.model.StatusEnums;
import com.eclipse.hotel.api.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation create(Reservation reservation){
        return reservationRepository.save(reservation);

    }

    public List<Reservation> listAll(){
        return reservationRepository.findAll();
    }

    public   Reservation findById(Long id){
         return reservationRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id){
        reservationRepository.deleteById(id);

    }
}
