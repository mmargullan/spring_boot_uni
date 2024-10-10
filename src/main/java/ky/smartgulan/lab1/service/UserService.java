package ky.smartgulan.lab1.service;

import java.util.*;
import ky.smartgulan.lab1.model.Student;
import ky.smartgulan.lab1.model.User;
import ky.smartgulan.lab1.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

//    ArrayList<Student> students = students();
//
//    public static ArrayList<Student> students(){
//        ArrayList<Student> students = new ArrayList<>();
//        students.add(new Student("Margulan", 20));
//        students.add(new Student("Oli", 18));
//        students.add(new Student("Toriel", 31));
//        students.add(new Student("Assgore", 32));
//        students.add(new Student("Augustgrad", 50));
//        students.add(new Student("Aegis", 25));
//        students.add(new Student("Dummy", 5));
//        students.add(new Student("Tychus", 40));
//        students.add(new Student("Cum", 10));
//        students.add(new Student("Hitler", 54));
//        return students;
//    }

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
