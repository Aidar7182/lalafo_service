package kg.lalfo.lalafoservice.services.impl;

import kg.lalfo.lalafoservice.entities.User;
import kg.lalfo.lalafoservice.repositories.UserRepository;
import kg.lalfo.lalafoservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User create(User category) {
        return userRepository.save(category);
    }

    @Override
    public User update(Long userId, String phoneNumber, String email) {
        User user = getById(userId);
        if (user != null) {
            user.setPhoneNumber(phoneNumber);
            user.setEmail(email);
        }
        return userRepository.save(user);
    }

    @Override
    public void delete(Long categoryId) {
       userRepository.deleteById(categoryId);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }


}
