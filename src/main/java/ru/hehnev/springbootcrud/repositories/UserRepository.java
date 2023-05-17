package ru.hehnev.springbootcrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hehnev.springbootcrud.models.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
