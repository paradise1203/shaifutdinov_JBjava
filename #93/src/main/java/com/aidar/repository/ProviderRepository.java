package com.aidar.repository;

import com.aidar.model.Office;
import com.aidar.model.Provider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends CrudRepository<Provider, Integer> {

    public Provider findByNameAndOffice(String name, Office office);

}
