package com.springrest.springrest.Dao;
import com.springrest.springrest.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface BookDao extends JpaRepository<BookEntity,Long> {

}
