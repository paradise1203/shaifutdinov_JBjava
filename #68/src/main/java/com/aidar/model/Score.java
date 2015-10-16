package com.aidar.model;

import com.aidar.util.Subject;

import javax.persistence.*;

@Entity
@Table(name = "scores")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqScore")
    @SequenceGenerator(name = "seqScore")
    @Column(name = "id")
    private Integer id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "subject_type")
    private Subject subjectType;

    @Column(name = "score")
    private Integer score;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Subject getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(Subject subjectType) {
        this.subjectType = subjectType;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
