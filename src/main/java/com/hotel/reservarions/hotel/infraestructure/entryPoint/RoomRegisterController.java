package com.hotel.reservarions.hotel.infraestructure.entryPoint;

import com.hotel.reservarions.hotel.application.domain.model.request.RoomInformation;
import com.hotel.reservarions.hotel.application.domain.useCase.CreateRoomUseCase;
import com.hotel.reservarions.hotel.application.domain.useCase.DeleteRoomUseCase;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@NoArgsConstructor
@RestController
public class RoomRegisterController {
    public CreateRoomUseCase createRoomUseCase;
    public DeleteRoomUseCase deleteRoomUseCase;

    @PostMapping("/api/hotel/createRoom")
    private ResponseEntity createRoom(@RequestBody RoomInformation roomInformation) {
        String response = createRoomUseCase.createRoom(roomInformation);

        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/api/hotel/deleteRoom")
    private ResponseEntity deleteRoom(@RequestParam String idRoom) {
        deleteRoomUseCase.deleteRoom(idRoom);
        return ResponseEntity.ok().body("Habitacion Eliminada");
    }


}
