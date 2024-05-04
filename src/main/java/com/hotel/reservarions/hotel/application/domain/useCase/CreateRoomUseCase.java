package com.hotel.reservarions.hotel.application.domain.useCase;

import com.hotel.reservarions.hotel.application.domain.model.request.RoomInformation;
import com.hotel.reservarions.hotel.application.domain.model.gateway.CreateRoomRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CreateRoomUseCase {

    public CreateRoomRepository createRoomRepository;

    public String createRoom(RoomInformation roomInformation) {

    return createRoomRepository.createRoom(roomInformation);
    }
}
