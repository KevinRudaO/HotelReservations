package com.hotel.reservarions.hotel.infraestructure.entryPoint;

import com.hotel.reservarions.hotel.application.domain.model.request.RoomInformation;
import com.hotel.reservarions.hotel.application.domain.useCase.CreateRoomUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureWebMvc
@AutoConfigureMockMvc
@SpringBootTest(classes = RoomRegisterController.class)
class RoomRegisterControllerTest {

    @MockBean
    private CreateRoomUseCase createRoomUseCase;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createRoom() throws Exception {
    // Given
        String response = "Creacion exitosa";
        RequestBuilder requestBuilder = createRequest();

     // When
     when(createRoomUseCase.createRoom(any(RoomInformation.class))).thenReturn(response);

     // Then

        mockMvc.perform(requestBuilder)
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string("Creacion exitosa"))
                .andExpect(status().isCreated());

        verify(createRoomUseCase).createRoom(any(RoomInformation.class));

    }

    private RequestBuilder createRequest(){
        return MockMvcRequestBuilders.post("/api/hotel/createRoom")
                .content("{\"id\":\"1\",\"pricePerNight\":100}")
                .contentType("application/json");
    }

}