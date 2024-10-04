package com.springrest.springrest.controller;
import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Scanner;


@RestController
@RequestMapping(value="/api/v1/course")
public class MyController {
    Scanner scanner = new Scanner(System.in)  ;

    // get the courses
    @Autowired                   // Dependency Injection
    private CourseServiceImpl courseService ;

    // Get all the course
    @RequestMapping(path="/courses",method=RequestMethod.GET)
    public List<Course> getCourses() {
        return courseService.getCourses() ;
    }

    // Get the course where id = courseid ;
    @GetMapping("/{courseId}")
    public Course getCourse(@PathVariable(value = "courseId") String courseId) {
        long cid = Long.parseLong(courseId) ;
        return this.courseService.getCourse(cid) ;
    }

    @RequestMapping(path="/courses",method=RequestMethod.POST)
    public Course AddCourse(@RequestBody Course course) {
        return this.courseService.addCourse(course) ;
    }

    //update the title of the couse having id = id ;
    @RequestMapping(path="/update",method=RequestMethod.PUT)
    public Course UpdateCourse(@RequestBody Course course ) {
        return this.courseService.updateCourse(course) ;
    }

    // Delete the couse having id = id ;
    @RequestMapping(path="/{id}",method=RequestMethod.DELETE)
    public void DeleteCouse(@PathVariable(value="id") String id) {
        long cid = Long.parseLong(id) ;
        this.courseService.deleteCouse(cid) ;
    }
}
