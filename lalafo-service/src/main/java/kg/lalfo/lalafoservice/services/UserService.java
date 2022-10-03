package kg.lalfo.lalafoservice.services;

import kg.lalfo.lalafoservice.entities.Category;
import kg.lalfo.lalafoservice.entities.User;

import java.util.List;

public interface UserService {
    User create(User category);

    User update(Long userId, String name, String email);

    void delete(Long categoryId);
    User getById(Long id);

    List<User> getAll();
}
