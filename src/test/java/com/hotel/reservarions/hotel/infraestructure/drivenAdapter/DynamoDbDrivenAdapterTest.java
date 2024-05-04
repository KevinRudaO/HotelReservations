package com.hotel.reservarions.hotel.infraestructure.drivenAdapter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.hotel.reservarions.hotel.application.domain.model.request.RoomInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

class DynamoDbDrivenAdapterTest {

    @Mock
    private DynamoDBMapper dynamoDBMapper;
    @Mock
    private DynamoDBMapperConfig dynamoDBMapperConfig;

    private DynamoDbDrivenAdapter dynamoDbDrivenAdapter;

    @BeforeEach
    void setUp() {
        openMocks(this);
        dynamoDbDrivenAdapter = new DynamoDbDrivenAdapter(dynamoDBMapper);
        doNothing().when(dynamoDBMapper).save(any(), any(DynamoDBMapperConfig.class));
    }

    @Test
    void createRoom() {
        //Arrange
        RoomInformation roomInformation = RoomInformation.builder()
                .id("1")
                .pricePerNight(100)
                .roomType("Single")
                .numberPeople("2")
                .build();

        //Act
        String response = dynamoDbDrivenAdapter.createRoom(roomInformation);

        //Assert

        assertNotNull(response);
        verify(dynamoDBMapper).save(any(), any(DynamoDBMapperConfig.class));


    }

}