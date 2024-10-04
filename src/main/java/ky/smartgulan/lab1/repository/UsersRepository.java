package ky.smartgulan.lab1.repository;

import ky.smartgulan.lab1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Integer> {
    Optional<User> findByLoginAndPassword(String login, String password);
}
