package cindyhj.com.flight_booking.domain.repository;

import cindyhj.com.flight_booking.domain.model.FlightTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightTicketRepository extends JpaRepository<FlightTicket,Long> {

    List<FlightTicket> findByPassenger_Id(Long id);
}
