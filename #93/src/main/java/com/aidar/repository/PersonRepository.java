package com.aidar.repository;

import com.aidar.model.Office;
import com.aidar.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer>, PersonRepositoryCustom {

    public Person findByFioAndType(String fio, Integer type);

    public List<Person> findByTypeAndOffice(Integer type, Office office);

}
