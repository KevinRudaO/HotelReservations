package com.hotel.reservarions.hotel.infraestructure.drivenAdapter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.hotel.reservarions.hotel.application.domain.model.request.RoomInformation;
import com.hotel.reservarions.hotel.application.domain.model.gateway.ListRoomsRepository;
import com.hotel.reservarions.hotel.infraestructure.drivenAdapter.util.RoomData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DynamoListRooms implements ListRoomsRepository {

    private DynamoDBMapper dynamoDBMapper;
    private DynamoDBMapperConfig dynamoDBMapperConfig;

    public DynamoListRooms(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
        this.dynamoDBMapperConfig = DynamoDBMapperConfig.builder().withTableNameOverride(
                new DynamoDBMapperConfig.TableNameOverride("Room")).build();

    }

    @Override
    public List<RoomInformation> listRooms() {
        List<RoomData> responseData = new ArrayList<>();
        List<RoomInformation> roomInformationList = new ArrayList<>();
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
        .withFilterExpression("PK = :Room");

        responseData = dynamoDBMapper.scan(RoomData.class, scanExpression, dynamoDBMapperConfig);

        roomInformationList.add(responseData.stream().map(roomData -> RoomInformation.builder()
                .id(roomData.getId())
                .pricePerNight(roomData.getPricePerNight())
                .roomType(roomData.getRoomType())
                .numberPeople(roomData.getNumberPeople())
                .status(roomData.getStatus())
                .build()).findFirst().get());


        return roomInformationList;
    }
}
