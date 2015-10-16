package com.aidar.service;

import com.aidar.model.Student;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface StudentService {

    public Integer getTotalScore(Student student);

    public BigDecimal getAverageScore(Student student);

    public Integer getParticularScore(Student student, Integer subject);

}
