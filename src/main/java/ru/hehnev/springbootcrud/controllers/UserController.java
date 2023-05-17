package ru.hehnev.springbootcrud.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.hehnev.springbootcrud.models.dto.UserDTO;
import ru.hehnev.springbootcrud.services.UserService;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public Iterable<UserDTO> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id,
                           @Valid @RequestBody UserDTO user) {
        userService.updateUser(id, user);
    }

    @PostMapping
    public void saveUser(@Valid @RequestBody UserDTO user) {
        userService.saveUser(user);
    }
}
