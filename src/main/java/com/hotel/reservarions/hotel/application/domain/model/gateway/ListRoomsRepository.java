package com.hotel.reservarions.hotel.application.domain.model.gateway;

import com.hotel.reservarions.hotel.application.domain.model.request.RoomInformation;

import java.util.List;

public interface ListRoomsRepository {

    List<RoomInformation> listRooms();
}
