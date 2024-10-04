package com.springrest.springrest.services;
import com.springrest.springrest.entities.Student;

import java.util.List;

public interface StudentService {
    Student save(Student request);
    Student get(Long id);
    List<Student> getList();
    Student update(Long id, Student request);
    void delete(Long id);
}
