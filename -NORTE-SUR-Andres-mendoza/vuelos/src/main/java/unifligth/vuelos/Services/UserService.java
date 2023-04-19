package unifligth.vuelos.Services;

import java.util.List;

import unifligth.vuelos.entidades.User;
public interface UserService {
    User getUserById(Long id);
    List<User> getAllUsers();
    User saveUser(User user);
    void deleteUserById(Long id);
}