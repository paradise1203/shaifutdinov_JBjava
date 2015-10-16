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
    @Qualifier("studentRepository")
    private StudentRepository studentRepository;

    @Autowired
    @Qualifier("scoreRepository")
    private ScoreRepository scoreRepository;

    private Student getStudent(Student student) {
        return studentRepository.findByFirstNameAndSurnameAndLastName(student.getFirstName(), student.getSurname(),
                student.getLastName());
    }

    @Override
    public BigDecimal getAverageScore(Student student) {
        student = getStudent(student);
        if (student != null) {
            return scoreRepository.getAverageScore(student.getId());
        } else {
            return null;
        }
    }

    @Override
    public Integer getTotalScore(Student student) {
        student = getStudent(student);
        if (student != null) {
            return scoreRepository.getTotalScore(student.getId());
        } else {
            return null;
        }
    }

    @Override
    public Integer getParticularScore(Student student, Integer subject) {
        student = getStudent(student);
        if (student != null) {
            return scoreRepository.getParticularScore(student.getId(), Subject.getSubject(subject));
        } else {
            return null;
        }
    }

}
