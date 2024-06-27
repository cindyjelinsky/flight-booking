package cindyhj.com.flight_booking.service.impl;

import cindyhj.com.flight_booking.domain.model.Passenger;
import cindyhj.com.flight_booking.domain.repository.PassengerRepository;
import cindyhj.com.flight_booking.service.PassengerService;
import cindyhj.com.flight_booking.service.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;

    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public Passenger findById(Long id) {
        Optional<Passenger> passenger = passengerRepository.findById(id);
        return passenger.orElseThrow(() -> new ResourceNotFoundException(id));

    }

    @Override
    @Transactional
    public Passenger create(Passenger passengerToCreate) {
        return passengerRepository.save(passengerToCreate);

    }

    @Override
    @Transactional
    public Passenger update(Passenger passengerToUpdate) {
      Passenger passenger = findById(passengerToUpdate.getId());
      passenger.setName(passengerToUpdate.getName());
      return passengerRepository.save(passenger);
    }


    @Override
    public void delete(Long id) {
        passengerRepository.deleteById(id);
    }
}

