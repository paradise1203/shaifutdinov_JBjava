package com.aidar.repository;

import com.aidar.model.MedClinic;
import com.aidar.model.Office;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficeRepository extends CrudRepository<Office, Integer> {

    public List<Office> findByMedClinic(MedClinic medClinic);

    public List<Office> findByCityAndStreet(String city, String street);

}
