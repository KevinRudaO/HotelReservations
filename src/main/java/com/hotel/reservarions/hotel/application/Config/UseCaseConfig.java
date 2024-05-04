package com.hotel.reservarions.hotel.application.Config;

import com.hotel.reservarions.hotel.application.domain.useCase.CreateRoomUseCase;
import com.hotel.reservarions.hotel.application.domain.useCase.DeleteRoomUseCase;
import com.hotel.reservarions.hotel.infraestructure.drivenAdapter.DynamoDbDeleteRoom;
import com.hotel.reservarions.hotel.infraestructure.drivenAdapter.DynamoDbDrivenAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public CreateRoomUseCase createRoomUseCase(DynamoDbDrivenAdapter createRoomRepository) {
        return new CreateRoomUseCase(createRoomRepository);
    }

    @Bean
    public DeleteRoomUseCase deleteRoomUseCase(DynamoDbDeleteRoom deleteRoomRepository) {
        return new DeleteRoomUseCase(deleteRoomRepository);
    }
}
