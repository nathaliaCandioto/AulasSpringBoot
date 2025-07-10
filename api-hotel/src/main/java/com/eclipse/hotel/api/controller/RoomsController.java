package com.eclipse.hotel.api.controller;

import com.eclipse.hotel.api.model.Customers;
import com.eclipse.hotel.api.model.Rooms;
import com.eclipse.hotel.api.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomsController {

    @Autowired
    private RoomsService roomsService;

    @PostMapping ("/cadastro")
    @ResponseStatus(HttpStatus.CREATED)
    public Rooms cadastraQuarto(@RequestBody Rooms room) {
        return roomsService.cadastraQuarto(room);
    }
    @GetMapping ("/listarRoom")
    @ResponseStatus(HttpStatus.OK)
    public List <Rooms> cadastraQuarto() {
        return roomsService.listarQuarto();
    }

    @GetMapping ("/listaRoomId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Rooms> buscaQuartoPeloId(@PathVariable(value="id")Long id ) {
        Rooms body = roomsService.buscarQuartoPeloId(id);
        return ResponseEntity.ok(body);
    }
    @DeleteMapping("deleteroomid/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletebyid(@PathVariable(value = "id")Long id){
        roomsService.deletebyid(id);
    }


}
