package cindyhj.com.flight_booking.service.impl;

import cindyhj.com.flight_booking.domain.model.User;
import cindyhj.com.flight_booking.domain.repository.UserRepository;
import cindyhj.com.flight_booking.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
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
    public void update(Long id, User userToUpdate) {
        Optional<User> userUp = userRepository.findById(id);
        if(userUp.isPresent()){
            userRepository.save(userToUpdate);
        }
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
