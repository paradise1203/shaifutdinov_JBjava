package com.aidar.service.impl;

import com.aidar.model.Student;
import com.aidar.repository.ScoreRepository;
import com.aidar.repository.StudentRepository;
import com.aidar.service.StudentService;
import com.aidar.util.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    @Qualifier("scoreRepository")
    private ScoreRepository scoreRepository;

    private Student getStudent(String fName, String sName, String lName) {
        return studentRepository.findByFirstNameAndSurnameAndLastName(fName, sName, lName);
    }

    @Override
    public Integer getParticularScore(String fName, String sName, String lName, Integer subject) {
        Student student = getStudent(fName, sName, lName);
        if (student != null) {
            return scoreRepository.getParticularScore(student.getId(), Subject.getSubject(subject));
        } else {
            return null;
        }
    }

    @Override
    public BigDecimal getAverageScore(String fName, String sName, String lName) {
        Student student = getStudent(fName, sName, lName);
        if (student != null) {
            return scoreRepository.getAverageScore(student.getId());
        } else {
            return null;
        }
    }

    @Override
    public Integer getTotalScore(String fName, String sName, String lName) {
        Student student = getStudent(fName, sName, lName);
        if (student != null) {
            return scoreRepository.getTotalScore(student.getId());
        } else {
            return null;
        }
    }

}
