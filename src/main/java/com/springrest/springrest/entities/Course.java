package com.springrest.springrest.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Entity
@Service
public class Course {
    @Id
    private long id ;
    private String title ;
    private String description ;
}
