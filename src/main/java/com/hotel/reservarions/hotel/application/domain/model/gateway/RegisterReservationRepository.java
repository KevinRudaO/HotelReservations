package com.hotel.reservarions.hotel.application.domain.model.gateway;

import com.hotel.reservarions.hotel.application.domain.model.request.ReservationInformation;
import com.hotel.reservarions.hotel.application.domain.model.request.RoomInformation;

public interface RegisterReservationRepository {

    ReservationInformation registerReservation(ReservationInformation reservationInformation);
}
