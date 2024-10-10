package ky.smartgulan.lab1.controller;


import ky.smartgulan.lab1.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/localRepo")
public class localController {

    ArrayList<Student> students = students();

    public static ArrayList<Student> students(){
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Margulan", 20));
        students.add(new Student("Oli", 18));
        students.add(new Student("Toriel", 31));
        students.add(new Student("Assgore", 32));
        students.add(new Student("Augustgrad", 50));
        students.add(new Student("Aegis", 25));
        students.add(new Student("Dummy", 5));
        students.add(new Student("Tychus", 40));
        students.add(new Student("Cum", 10));
        students.add(new Student("Hitler", 54));
        return students;
    }

    @GetMapping("/readStudent")
    public ArrayList<Student> readStudent(){
        return students;
    }

    @PostMapping("/createStudent")
    public void createStudent(@RequestBody Student student){
        students.add(student);
    }

    @PutMapping("/updateStudent")
    public void updateStudent(@RequestParam (name = "name") String name,
                              @RequestParam (name = "new_name") String new_name,
                              @RequestParam (name = "new_age", required = false) int new_age){
        for (Student st : students) {
            if (st.getName().equals(name)) {
                st.setName(new_name);
                st.setAge(new_age);
                break;
            }
        }
    }

    @DeleteMapping("/deleteStudent")
    public void deleteStudent(@RequestParam (name = "name") String name){
        for (Student st : students) {
            if (st.getName().equals(name)) {
                students.remove(st);
                break;
            }
        }
    }
}
