package cindyhj.com.flight_booking.domain.repository;

import cindyhj.com.flight_booking.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
