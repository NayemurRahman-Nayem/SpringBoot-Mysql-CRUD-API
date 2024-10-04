package com.springrest.springrest.services;
import com.springrest.springrest.entities.Student;
import com.springrest.springrest.enums.Department;
import com.springrest.springrest.enums.Gender;
import com.sun.jdi.request.InvalidRequestStateException;
import jakarta.el.PropertyNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@AllArgsConstructor
//@NoArgsConstructor
@Data
@Service
public class StudentServiceImpl implements StudentService{
    Map<Long, Student> STUDENT_MAP = new HashMap<>();
    public StudentServiceImpl() {
        Student s1 = new Student(12L,Department.CSE, Gender.Male,"Nayem") ;
        Student s2 = new Student(234L,Department.EEE,Gender.Male,"ABC") ;
        STUDENT_MAP.put(12L, s1 ) ;
        STUDENT_MAP.put(234L,s2) ;
    }


    @Override
    public Student save(Student request) {
        if (STUDENT_MAP.get(request.getId()) != null) {
            throw new IllegalArgumentException("Student already exist with id: " + request.getId());
        }
        STUDENT_MAP.put(request.getId(), request);
        return STUDENT_MAP.get(request.getId());
    }


    @Override
    public Student get(Long id) {
        if(STUDENT_MAP.containsKey(id)) {
            return STUDENT_MAP.get(id);
        }
        else {
            System.out.println("Nayem");
            throw new PropertyNotFoundException("Student not found with id: " + id);
        }
    }


    @Override
    public List<Student> getList() {
        return STUDENT_MAP.values().stream().toList();
    }


    @Override
    public Student update(Long id, Student request) {
        if (id.compareTo(request.getId()) != 0) {
            throw new InvalidRequestStateException("Requested ID and Student ID mismatch");
        }
        if (STUDENT_MAP.get(id) == null) {
            throw new PropertyNotFoundException("Student not found with id: " + id);
        }
        STUDENT_MAP.put(id, request);
        return STUDENT_MAP.get(id);
    }


    @Override
    public void delete(Long id) {
        if (STUDENT_MAP.get(id) == null) {
            throw new PropertyNotFoundException("Student not found with id: " + id);
        }
        STUDENT_MAP.remove(id);
    }
}
