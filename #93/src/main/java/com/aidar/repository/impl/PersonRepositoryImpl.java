package com.aidar.repository.impl;

import com.aidar.model.Office;
import com.aidar.repository.PersonRepositoryCustom;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

@Transactional
public class PersonRepositoryImpl implements PersonRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    private double getAverageByQuery(List<Office> offices, Query query) {
        if (offices.isEmpty()) {
            return (double) 0;
        }
        double res = 0;
        int count = 0;
        boolean hasRes = false;
        Iterator<Office> it = offices.listIterator();
        while (it.hasNext()) {
            query.setParameter(1, it.next().getId());
            List resultList = query.getResultList();
            if (resultList.isEmpty()) {
                continue;
            }
            Object[] mas = (Object[]) resultList.get(0);
            res += ((BigInteger) mas[0]).doubleValue();
            count += ((BigInteger) mas[1]).intValueExact();
            hasRes = true;
        }
        return hasRes ? res / count : (double) 0;
    }

    @Override
    public double getAverageSalary(List<Office> offices) {
        return getAverageByQuery(offices, entityManager.createNativeQuery("SELECT SUM(salary*expected_time), COUNT(*) FROM stuff_data " +
                "JOIN people ON people.id=stuff_data.person_id " +
                "WHERE type=0 AND office_id=?"));
    }

    @Override
    public double getAverageCheck(List<Office> offices) {
        return getAverageByQuery(offices, entityManager.createNativeQuery("SELECT SUM(cost), COUNT(*) FROM patient_data " +
                "JOIN people ON people.id = patient_data.person_id " +
                "WHERE type=1 AND office_id=?"));
    }

}
