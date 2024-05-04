package com.hotel.reservarions.hotel.application.domain.useCase;

import com.hotel.reservarions.hotel.application.domain.model.gateway.ListRoomsRepository;
import com.hotel.reservarions.hotel.application.domain.model.gateway.RegisterReservationRepository;
import com.hotel.reservarions.hotel.application.domain.model.request.ReservationInformation;
import com.hotel.reservarions.hotel.application.domain.model.request.RoomInformation;

import java.util.List;

public class ReservationRoomUseCase {
    private ListRoomsRepository listRoomsRepository;
    private RegisterReservationRepository registerReservationRepository;

    // list all rooms
    private List<RoomInformation> listRooms() {
        return listRoomsRepository.listRooms();
    }

    // validate if the room is available

    private boolean validateRoom(String roomId) {
        List<RoomInformation> rooms = listRooms();
        return rooms.stream().anyMatch(room -> room.getId().equals(roomId) && room.getStatus().equals("AVAILABLE"));

    }

    // register reservation

    private ReservationInformation registerReservation(ReservationInformation roomInformation) {
        if (validateRoom(roomInformation.getId())) {
            return registerReservationRepository.registerReservation(roomInformation);
        }
        return null;
    }






}
