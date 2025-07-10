package com.eclipse.hotel.api.controller;

import com.eclipse.hotel.api.model.Reservation;
import com.eclipse.hotel.api.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/createReservation")
    @ResponseStatus(HttpStatus.CREATED)

    public Reservation createReservation(@RequestBody Reservation reservation){
        return reservationService.create(reservation);
    }

    @GetMapping("/listReservation")
    @ResponseStatus(HttpStatus.OK)
    public List<Reservation> listReservation(){
        return reservationService.listAll();

    }

    @DeleteMapping("/deleteReservation/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReservation(@PathVariable(value="id") Long id){
        reservationService.deleteById(id);
    }
    @GetMapping("/listReservation/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Reservation reservation(Long id){
        return reservationService.findById(id);
    }


}
