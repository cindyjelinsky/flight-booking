package cindyhj.com.flight_booking.service;

import cindyhj.com.flight_booking.domain.model.User;

public interface UserService {

    User findById(Long id);
    User create(User userToCreate);

    User update( User userToUpdate);

    void delete(Long id);

}
