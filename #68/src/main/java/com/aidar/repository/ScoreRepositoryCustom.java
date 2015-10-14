package com.aidar.repository;

import com.aidar.util.Subject;

import java.math.BigDecimal;

public interface ScoreRepositoryCustom {

    public Integer getTotalScore(Integer id);

    public BigDecimal getAverageScore(Integer id);

    public Integer getParticularScore(Integer id, Subject subject);

}
