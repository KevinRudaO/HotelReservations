package com.hotel.reservarions.hotel.infraestructure.drivenAdapter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.hotel.reservarions.hotel.application.domain.businessException.BusinessException;
import com.hotel.reservarions.hotel.application.domain.model.gateway.RegisterReservationRepository;
import com.hotel.reservarions.hotel.application.domain.model.request.ReservationInformation;
import com.hotel.reservarions.hotel.infraestructure.drivenAdapter.util.ReservationData;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterReservation implements RegisterReservationRepository {

    private DynamoDBMapper dynamoDBMapper;
    private DynamoDBMapperConfig dynamoDBMapperConfig;

    public RegisterReservation(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
        this.dynamoDBMapperConfig = DynamoDBMapperConfig.builder().withTableNameOverride(
                new DynamoDBMapperConfig.TableNameOverride("Reservation")).build();

    }
    @Override
    public ReservationInformation registerReservation(ReservationInformation roomInformation) {
        try {
            ReservationData reservationData = ReservationData.builder()
                    .pk("Reservation")
                    .idUser(roomInformation.getIdUser())
                    .nameUser(roomInformation.getNameUser())
                    .reservationDate(roomInformation.getReservationDate())
                    .reservationDateExpiration(roomInformation.getReservationDateExpiration())
                    .roomId(roomInformation.getRoomId())
                    .build();


            dynamoDBMapper.save(reservationData, dynamoDBMapperConfig);
            return roomInformation;
    }catch (Exception e){
        throw new BusinessException("Error creating reservation");
    }

    }
}
