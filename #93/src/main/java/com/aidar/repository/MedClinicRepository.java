package com.aidar.repository;

import com.aidar.model.MedClinic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedClinicRepository extends CrudRepository<MedClinic, Integer> {

    public MedClinic findByName(String name);

}
