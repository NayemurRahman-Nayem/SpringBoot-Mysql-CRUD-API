package com.springrest.springrest.Dao;
import com.springrest.springrest.entities.Course ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import java.util.List;


public interface CourseDao extends JpaRepository<Course,Long> {


}
