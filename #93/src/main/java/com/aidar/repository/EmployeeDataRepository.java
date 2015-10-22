package com.aidar.repository;

import com.aidar.model.EmployeeData;
import com.aidar.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDataRepository extends CrudRepository<EmployeeData, Integer> {

    EmployeeData findByPerson(Person person);

}
