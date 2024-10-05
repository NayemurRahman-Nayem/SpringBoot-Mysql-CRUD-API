package com.springrest.springrest.services;
import com.springrest.springrest.Dao.CourseDao;
import com.springrest.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao ;

    @Autowired
    private Course course ;


    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {
        return courseDao.getOne(courseId) ;
    }

    @Override
    public Course addCourse(Course course) {
        courseDao.save(course) ;
        return course ;
    }

    @Override
    public Course updateCourse(Course course) {
        courseDao.save(course) ;
        return course ;
    }

    @Override
    public void deleteCouse(long id) {
        Course course = courseDao.getOne(id) ;
        courseDao.delete(course);
    }
}