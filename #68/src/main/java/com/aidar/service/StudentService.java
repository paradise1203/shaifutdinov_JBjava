package com.aidar.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface StudentService {

    public Integer getTotalScore(String fName, String sName, String lName);

    public BigDecimal getAverageScore(String fName, String sName, String lName);

    public Integer getParticularScore(String fName, String sName, String lName, Integer subject);

}
