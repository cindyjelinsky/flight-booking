package cindyhj.com.flight_booking.service;

import cindyhj.com.flight_booking.domain.model.User;

public interface UserService {

    User findByiId(Long id);
    User create(User userToCreate);
    User update(User userToUpdate);
    User delete(Long id);

}
