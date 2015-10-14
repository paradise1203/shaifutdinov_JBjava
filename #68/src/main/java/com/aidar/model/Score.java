package com.aidar.model;

import javax.persistence.*;

@Entity
@Table(name = "scores")
public class Score {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "subject_type")
    private Enum subjectType;

    @Column(name = "score")
    private Integer score;

    @Column(name = "student_id")
    private Integer studentId;

    public Score() {
    }

    public Score(Integer id, Enum subjectType, Integer score, Integer studentId) {
        this.id = id;
        this.subjectType = subjectType;
        this.score = score;
        this.studentId = studentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Enum getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(Enum subjectType) {
        this.subjectType = subjectType;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

}
