package com.springrest.springrest.Dao;
import com.springrest.springrest.entities.Course ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface CourseDao extends JpaRepository<Course,Long> {

}
