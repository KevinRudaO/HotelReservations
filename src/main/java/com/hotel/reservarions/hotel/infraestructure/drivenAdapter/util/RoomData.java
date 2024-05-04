package com.hotel.reservarions.hotel.infraestructure.drivenAdapter.util;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomData {

    @DynamoDBHashKey(attributeName = "PK")
    private String pk;
    @DynamoDBRangeKey(attributeName = "id")
    private String id;

    @DynamoDBAttribute(attributeName = "pricePerNight")
    private float pricePerNight;
    @DynamoDBAttribute(attributeName = "roomType")
    private String roomType;
    @DynamoDBAttribute(attributeName = "numberPeople")
    private String numberPeople;
    @DynamoDBAttribute(attributeName = "status")
    private String status;
}
