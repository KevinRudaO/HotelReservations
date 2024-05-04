package com.hotel.reservarions.hotel.application.domain.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomInformation {

    private String id;
    private float pricePerNight;
    private String roomType;
    private String numberPeople;
    private String status;
}
