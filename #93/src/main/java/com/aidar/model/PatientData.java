package com.aidar.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "patient_data")
public class PatientData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPatient")
    @SequenceGenerator(name = "seqPatient")
    @Column(name = "id")
    private long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "visit_date")
    private Date visitDate;

    @Column(name = "cost")
    private Integer cost;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
