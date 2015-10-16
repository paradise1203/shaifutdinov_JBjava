package com.aidar.repository.impl;

import com.aidar.repository.ScoreRepositoryCustom;
import com.aidar.util.Subject;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;

@Transactional
public class ScoreRepositoryImpl implements ScoreRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Integer getTotalScore(Integer id) {
        Query query = entityManager.createNativeQuery("SELECT SUM(score) FROM scores WHERE student_id=?");
        query.setParameter(1, id);
        return ((BigDecimal) query.getSingleResult()).intValueExact();
    }

    @Override
    public BigDecimal getAverageScore(Integer id) {
        Query query = entityManager.createNativeQuery("SELECT AVG(score) FROM scores WHERE student_id=?");
        query.setParameter(1, id);
        return (BigDecimal) query.getSingleResult();
    }

    @Override
    public Integer getParticularScore(Integer id, Subject subject) {
        Query query = entityManager.createNativeQuery("SELECT score FROM scores WHERE student_id=? AND subject_type=?");
        query.setParameter(1, id);
        query.setParameter(2, subject.ordinal());
        return (Integer) query.getSingleResult();
    }

}
