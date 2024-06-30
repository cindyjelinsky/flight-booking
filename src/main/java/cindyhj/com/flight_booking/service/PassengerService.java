package cindyhj.com.flight_booking.service;

import cindyhj.com.flight_booking.domain.dto.PassengerDTO;
import cindyhj.com.flight_booking.domain.dto.PassengerResponse;
import cindyhj.com.flight_booking.domain.model.Passenger;

public interface PassengerService {

    Passenger findById(Long id);
    Passenger  create(Passenger passenger);

    Passenger update(Passenger userToUpdate);

    void delete(Long id);

    Passenger fromDTO(PassengerDTO passengerDTO);

    PassengerResponse toDTO(Passenger passenger);


}
