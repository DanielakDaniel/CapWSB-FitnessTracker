package pl.wsb.fitnesstracker.user.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.wsb.fitnesstracker.user.api.User;
import pl.wsb.fitnesstracker.user.api.UserProvider;
import pl.wsb.fitnesstracker.user.api.UserService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
class UserServiceImpl implements UserService, UserProvider {

    private final UserRepository userRepository;

    @Override
    public User createUser(final User user) {
        log.info("Creating User {}", user);
        if (user.getId() != null) {
            throw new IllegalArgumentException("User has already DB ID, update is not permitted!");
        }
        return userRepository.save(user);
    }

    @Override
    public User updateUser(final User user) {
        log.info("Updating User {}", user);
        if (user.getId() == null) {
            throw new IllegalArgumentException("User ID cannot be empty!");
        }
        getUser(user.getId()).orElseThrow(() -> new IllegalArgumentException("User does not exist!"));
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(final Long id) {
        log.info("Deleting User {}", id);
        if (id == null) {
            throw new IllegalArgumentException("User ID cannot be empty!");
        }
        getUser(id).orElseThrow(() -> new IllegalArgumentException("User does not exist!"));
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getUser(final Long userId) {return userRepository.findById(userId);}

    @Override
    public Optional<User> getUserByEmail(final String email) {return userRepository.findByEmail(email);}

    @Override
    public List<User> findAllUsers() {return userRepository.findAll();}

    @Override
    public List<User> getUsersByEmail(String email) { return userRepository.findMultipleByEmail(email);}

    @Override
    public List<User> getUsersOlderThan(LocalDate date) { return userRepository.findOlderThan(date);}

}