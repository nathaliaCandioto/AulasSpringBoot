package com.eclipse.hotel.api.service;

import com.eclipse.hotel.api.model.Rooms;
import com.eclipse.hotel.api.repository.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomsService {
    @Autowired //injeta instancia de RoomsRepository

    //chamada para o repository
    private RoomsRepository roomsRepository;

    public Rooms cadastraQuarto(Rooms rooms) {
        return roomsRepository.save(rooms);

    }

    public List<Rooms> listarQuarto() {
        return roomsRepository.findAll();
    }

    public Rooms buscarQuartoPeloId(Long idQuarto) {
        Optional<Rooms> room = roomsRepository.findById(idQuarto);

        return room.orElse(null); //existe objeto? sim retorna. nao , retorna null
    }

    public Rooms atualizaRooms(Long idQuarto, Rooms room) {
        Optional<Rooms> roomToUpdate = roomsRepository.findById(idQuarto);
        if (roomToUpdate.isPresent()) {
            roomToUpdate.get().setRoomNumber(room.getRoomNumber());
            roomToUpdate.get().setPrice(room.getPrice());
            roomToUpdate.get().setType(room.getType());
            return roomsRepository.save(room);
        }
        return null;
    }

    public boolean desativaQuarto(Long idQuarto) {
        Optional<Rooms> roomToDelete = roomsRepository.findById(idQuarto);
        if (roomToDelete.isPresent()) {
            roomsRepository.deleteById(idQuarto);
            return true;
        }

        return false;
    }

    public void deletebyid(Long id){
        roomsRepository.deleteById(id);

    }


}


