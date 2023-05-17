package ru.hehnev.springbootcrud.converters;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.hehnev.springbootcrud.models.dto.UserDTO;
import ru.hehnev.springbootcrud.models.entities.User;

@Component
@RequiredArgsConstructor
public class UserConverter {

    private final ModelMapper mapper;

    public User dtoToEntity(UserDTO userDTO) {
        return mapper.map(userDTO, User.class);
    }

    public UserDTO entityToUserDTO(User user) {
        return mapper.map(user, UserDTO.class);
    }
}
