package com.hotel.reservarions.hotel.infraestructure.drivenAdapter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.hotel.reservarions.hotel.application.domain.model.gateway.DeleteRoomRepository;
import com.hotel.reservarions.hotel.infraestructure.drivenAdapter.util.RoomData;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@NoArgsConstructor
@AllArgsConstructor
public class DynamoDbDeleteRoom implements DeleteRoomRepository {
    private DynamoDBMapper dynamoDBMapper;
    private DynamoDBMapperConfig dynamoDBMapperConfig;

    public DynamoDbDeleteRoom(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
        this.dynamoDBMapperConfig = DynamoDBMapperConfig.builder().withTableNameOverride(
                new DynamoDBMapperConfig.TableNameOverride("Room")).build();

    }
    @Override
    public void deleteRoom(String id) {

        DynamoDBDeleteExpression deleteExpression = new DynamoDBDeleteExpression();
        deleteExpression.withConditionExpression("PK = :Room");
        deleteExpression.withConditionExpression("id = :id");

        dynamoDBMapper.delete(RoomData.class,deleteExpression,dynamoDBMapperConfig);
    }
}
