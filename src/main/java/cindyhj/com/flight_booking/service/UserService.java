package cindyhj.com.flight_booking.service;

import cindyhj.com.flight_booking.domain.model.User;

public interface UserService {

    User findByiId(Long id);
    User create(User userToCreate);

    void update(Long id, User userToUpdate);

    void delete(Long id);

}
