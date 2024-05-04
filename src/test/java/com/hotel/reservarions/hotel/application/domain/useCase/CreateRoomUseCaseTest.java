package com.hotel.reservarions.hotel.application.domain.useCase;

import com.hotel.reservarions.hotel.application.domain.model.gateway.CreateRoomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class CreateRoomUseCaseTest {

    @Mock
    private CreateRoomRepository createRoomRepository;

    @Mock
    private CreateRoomUseCase createRoomUseCase;

    @BeforeEach
    void setUp() {
        openMocks(this);
        createRoomUseCase = new CreateRoomUseCase(createRoomRepository);
    }

    @Test
    void createRoomTest(){
        //Arrange
        String response = "Creacion exitosa";

        // Act
        when(createRoomUseCase.createRoom(any())).thenReturn(response);

        // Assert
        assertNotNull(createRoomUseCase.createRoom(any()));

    }



}