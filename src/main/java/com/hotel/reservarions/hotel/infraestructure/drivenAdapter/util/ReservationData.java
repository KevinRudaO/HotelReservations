package com.hotel.reservarions.hotel.infraestructure.drivenAdapter.util;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ReservationData {
    @DynamoDBHashKey(attributeName = "PK")
    private String pk;
    @DynamoDBRangeKey(attributeName = "idUser")
    private String idUser;
    @DynamoDBRangeKey(attributeName = "nameUser")
    private String nameUser;
    @DynamoDBRangeKey(attributeName = "reservationDate")
    private Date reservationDate;
    @DynamoDBRangeKey(attributeName = "reservationDateExpiration")
    private Date reservationDateExpiration;
    @DynamoDBRangeKey(attributeName = "roomId")
    private String roomId;


}
