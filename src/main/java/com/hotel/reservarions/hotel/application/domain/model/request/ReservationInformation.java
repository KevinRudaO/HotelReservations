package com.hotel.reservarions.hotel.application.domain.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationInformation {

    private String idUser;
    private String nameUser;
    private Date reservationDate;
    private Date reservationDateExpiration;
    private String roomId;
}
