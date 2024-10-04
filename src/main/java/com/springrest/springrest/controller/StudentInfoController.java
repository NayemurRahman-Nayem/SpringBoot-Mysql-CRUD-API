package com.springrest.springrest.controller;
import com.springrest.springrest.entities.Student;
import com.springrest.springrest.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.concurrent.ExecutionException;


@RestController
@RequestMapping(value="/api/v1/student")
public class StudentInfoController {

    @Autowired
    private StudentService studentService;

    //Add a student
    @RequestMapping(path="/add",method=RequestMethod.POST)
    public Student saveStudent(@RequestBody @Validated Student request) {
        return studentService.save(request);
    }

    // Get all the students
    @RequestMapping(path="/get",method=RequestMethod.GET)
    public List<Student> getStudents() {
        return studentService.getList();
    }

    // Get the student with id
    @GetMapping("get/{Id}")
    public Student getStudent(@PathVariable(value="Id") Long id) {
        return studentService.get(id) ;
    }

    // Update the student info with id
    @PutMapping(value = "/{id}")
    public Student updateStudent(@PathVariable(value="id") String id, @RequestBody @Validated Student request) {
        Long sid = Long.parseLong(id) ;
        return studentService.update(sid, request);
    }

    // Delete the student with id
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable(value ="id") Long id) {
        try {
            studentService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK) ;
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
    }
}
