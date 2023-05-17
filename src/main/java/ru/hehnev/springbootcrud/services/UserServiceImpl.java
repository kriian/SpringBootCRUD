package ru.hehnev.springbootcrud.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hehnev.springbootcrud.converters.UserConverter;
import ru.hehnev.springbootcrud.exceptions.ResourceNotFoundException;
import ru.hehnev.springbootcrud.models.dto.UserDTO;
import ru.hehnev.springbootcrud.models.entities.User;
import ru.hehnev.springbootcrud.repositories.UserRepository;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Override
    public void saveUser(UserDTO user) {
        userRepository.save(userConverter.dtoToEntity(user));
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(userConverter::entityToUserDTO)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateUser(Long id, UserDTO userDTO) {
        User user = userConverter.dtoToEntity(getUserById(id));
        user.setName(userDTO.getName());
        user.setMail(userDTO.getMail());
        userRepository.save(user);
    }

    @Override
    public Iterable<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userConverter::entityToUserDTO)
                .collect(Collectors.toList());
    }
}
