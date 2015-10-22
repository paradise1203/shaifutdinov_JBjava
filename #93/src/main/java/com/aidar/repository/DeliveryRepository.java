package com.aidar.repository;

import com.aidar.model.Delivery;
import com.aidar.model.Office;
import com.aidar.model.Provider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends CrudRepository<Delivery, Integer> {

    List<Delivery> findByOfficeAndProvider(Office office, Provider provider);

}
