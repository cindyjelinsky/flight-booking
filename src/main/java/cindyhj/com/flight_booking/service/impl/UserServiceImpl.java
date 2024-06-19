package cindyhj.com.flight_booking.service.impl;

import cindyhj.com.flight_booking.domain.model.User;
import cindyhj.com.flight_booking.domain.repository.UserRepository;
import cindyhj.com.flight_booking.service.UserService;

import java.util.NoSuchElementException;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByiId(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);


    }

    @Override
    public User create(User userToCreate) {
        return userRepository.save(userToCreate);

    }

    @Override
    public User update(User userToUpdate) {
        return null;
    }

    @Override
    public User delete(Long id) {
        return null;
    }
}
