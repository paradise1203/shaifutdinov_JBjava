package com.aidar.repository;

import com.aidar.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

    public Student findByFirstNameAndSurnameAndLastName(String firstName, String surname, String lastName);

}
