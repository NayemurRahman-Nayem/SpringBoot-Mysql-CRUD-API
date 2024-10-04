package com.springrest.springrest.entities;
import com.springrest.springrest.enums.Gender ;
import com.springrest.springrest.enums.Department ;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
public class Student {

    @NotNull(message = "Student ID can't ne null.")
    private Long id;

    @NotNull(message = "Student name can't be null.")
    @NotEmpty(message = "Student name can't be empty.")
    private String name;

    @NotNull
    private Gender gender;

    @NotNull
    private Department department;

    public Student(Long id, Department department, Gender gender, String name) {
        this.id = id;
        this.department = department;
        this.gender = gender;
        this.name = name;
    }
}
