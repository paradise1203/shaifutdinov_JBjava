package com.aidar.repository;

import com.aidar.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    public Student findByFirstNameAndSurnameAndLastName(String firstName, String surname, String lastName);

}
