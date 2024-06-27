package cindyhj.com.flight_booking.service.impl;

import cindyhj.com.flight_booking.domain.model.FlightTicket;
import cindyhj.com.flight_booking.domain.model.Passenger;
import cindyhj.com.flight_booking.domain.repository.FlightTicketRepository;
import cindyhj.com.flight_booking.service.FlightTicketService;
import cindyhj.com.flight_booking.service.PassengerService;
import cindyhj.com.flight_booking.service.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightTicketServiceImpl implements FlightTicketService {

    private final FlightTicketRepository flightTicketRepository;

    private PassengerService passengerService;

    public FlightTicketServiceImpl(FlightTicketRepository flightTicketRepository, PassengerService passengerService) {
        this.flightTicketRepository = flightTicketRepository;
        this.passengerService = passengerService;
    }


    @Override
    public FlightTicket findById(Long id) {
        Optional<FlightTicket> flightTicket = flightTicketRepository.findById(id);
        return flightTicket.orElseThrow(()-> new ResourceNotFoundException(id));
    }

    @Override
    public FlightTicket create(FlightTicket ticketToIssue) {
        Passenger passenger = this.passengerService.findById(ticketToIssue.getPassenger().getId());
        passenger.setName(passenger.getName());
        ticketToIssue.setId(null);
        ticketToIssue.setPassenger(passenger);
        return flightTicketRepository.save(ticketToIssue);
    }

    public List<FlightTicket> findAllByPassenger(Long userId) {
        Passenger passenger = passengerService.findById(userId);
        List<FlightTicket> tickets = this.flightTicketRepository.findByPassenger_Id(passenger.getId());
        return tickets;
    }

    @Override
    public FlightTicket update(FlightTicket ticketToUpdate) {
        return null;

    }

    @Override
    public void delete(Long id) {
            flightTicketRepository.deleteById(id);
    }
}
