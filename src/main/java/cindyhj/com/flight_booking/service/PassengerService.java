package cindyhj.com.flight_booking.service;

import cindyhj.com.flight_booking.domain.model.Passenger;

public interface PassengerService {

    Passenger findById(Long id);
    Passenger create(Passenger userToCreate);

    Passenger update(Passenger userToUpdate);

    void delete(Long id);

}
