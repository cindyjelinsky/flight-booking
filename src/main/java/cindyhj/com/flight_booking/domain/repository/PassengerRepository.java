package cindyhj.com.flight_booking.domain.repository;

import cindyhj.com.flight_booking.domain.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Long> {
}
