package com.hotel.reservarions.hotel.application.domain.model.gateway;

import com.hotel.reservarions.hotel.application.domain.model.request.RoomInformation;

public interface CreateRoomRepository {

    String createRoom(RoomInformation roomInformation);
}
