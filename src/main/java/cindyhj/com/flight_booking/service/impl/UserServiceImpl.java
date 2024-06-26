package cindyhj.com.flight_booking.service.impl;

import cindyhj.com.flight_booking.domain.model.User;
import cindyhj.com.flight_booking.domain.repository.UserRepository;
import cindyhj.com.flight_booking.service.UserService;
import cindyhj.com.flight_booking.service.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));

    }

    @Override
    @Transactional
    public User create(User userToCreate) {
        return userRepository.save(userToCreate);

    }

    @Override
    @Transactional
    public User update(User userToUpdate) {
      User user = findById(userToUpdate.getId());
      user.setName(userToUpdate.getName());
      return userRepository.save(user);
    }


    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}

