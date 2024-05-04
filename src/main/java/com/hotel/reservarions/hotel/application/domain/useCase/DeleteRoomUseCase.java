package com.hotel.reservarions.hotel.application.domain.useCase;

import com.hotel.reservarions.hotel.application.domain.model.gateway.DeleteRoomRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class DeleteRoomUseCase {

    private DeleteRoomRepository deleteRoomRepository;

    public void deleteRoom(String id) {
        deleteRoomRepository.deleteRoom(id);
    }

}
