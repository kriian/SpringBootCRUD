package ru.hehnev.springbootcrud.services;

import ru.hehnev.springbootcrud.models.dto.UserDTO;

public interface UserService {
    UserDTO getUserById(Long id);
    void deleteUser(Long id);
    void updateUser(Long id, UserDTO user);
    Iterable<UserDTO> getAllUsers();
    void saveUser(UserDTO user);
}
