package cindyhj.com.flight_booking.service;

import cindyhj.com.flight_booking.domain.model.FlightTicket;

import java.util.List;

public interface FlightTicketService {
    FlightTicket findById(Long id);

    List<FlightTicket> findAllByPassenger(Long id);
    FlightTicket create(FlightTicket ticketToIssue);

    FlightTicket update(FlightTicket ticketToUpdate);

    void delete(Long id);


}
