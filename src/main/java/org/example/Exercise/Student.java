package org.example.Exercise;

import java.util.ArrayList;
import java.util.List;

public record Student() {
    static String name;
    static int id;

}

class Department {
    String name;
    List<Student> list;

    public Department(String name) {
        this.name = name;
        list = new ArrayList<>();

    }

    public void addStudent(Student student) {
        list.add(student);

    }
}