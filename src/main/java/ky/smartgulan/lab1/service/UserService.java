package ky.smartgulan.lab1.service;

import ky.smartgulan.lab1.model.User;
import ky.smartgulan.lab1.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;
    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User registerUser(String login, String password, String email) {
        User user = new User(login, password, email);
        return usersRepository.save(user);
    }

    public String loginUser(String login, String password) {
        User user = usersRepository.findByLoginAndPassword(login, password).orElseThrow(
                () -> new RuntimeException("User is not found")
        );

        return "Molodec";
    }
}
