package com.hotel.reservarions.hotel.infraestructure.drivenAdapter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.hotel.reservarions.hotel.application.domain.businessException.BusinessException;
import com.hotel.reservarions.hotel.application.domain.model.request.RoomInformation;
import com.hotel.reservarions.hotel.application.domain.model.gateway.CreateRoomRepository;
import com.hotel.reservarions.hotel.infraestructure.drivenAdapter.util.RoomData;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@NoArgsConstructor
@Repository
public class DynamoDbDrivenAdapter implements CreateRoomRepository {
    private DynamoDBMapper dynamoDBMapper;
    private DynamoDBMapperConfig dynamoDBMapperConfig;

    public DynamoDbDrivenAdapter(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
        this.dynamoDBMapperConfig = DynamoDBMapperConfig.builder().withTableNameOverride(
                new DynamoDBMapperConfig.TableNameOverride("Room")).build();

    }

    @Override
    public String createRoom(RoomInformation roomInformation) {
        try {
            RoomData data = RoomData.builder()
                    .pk("Room")
                    .id(roomInformation.getId())
                    .pricePerNight(roomInformation.getPricePerNight())
                    .roomType(roomInformation.getRoomType())
                    .numberPeople(roomInformation.getNumberPeople())
                    .build();
            dynamoDBMapper.save(data, dynamoDBMapperConfig);
            return "Room created";
        }catch (Exception e){
            throw new BusinessException("Error creating room");
        }

    }
}
