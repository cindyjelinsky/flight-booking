package cindyhj.com.flight_booking.service.impl;

import cindyhj.com.flight_booking.domain.dto.PassengerDTO;
import cindyhj.com.flight_booking.domain.dto.PassengerResponse;
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
        return passenger.orElseThrow(() -> new ResourceNotFoundException("Passenger Not Found"));

    }

    @Override
    @Transactional
    public Passenger create(Passenger passenger) {
        passengerRepository.save(passenger);
        return passenger;


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

    @Override
    public Passenger fromDTO(PassengerDTO passengerDTO) {
        return new Passenger(passengerDTO.getId(),
                passengerDTO.getName(),
                passengerDTO.getCpf());
    }

    @Override
    public PassengerResponse toDTO(Passenger passenger) {
        return new PassengerResponse(
                passenger.getId(),
                passenger.getName()
        );
    }

}