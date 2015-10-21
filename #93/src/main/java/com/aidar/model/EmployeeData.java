package com.aidar.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stuff_data")
public class EmployeeData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPeople")
    @SequenceGenerator(name = "seqPeople")
    @Column(name = "id")
    private long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "employment_date")
    private Date employmentDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "dismissal_date")
    private Date dismissalDate;

    @Column(name = "expected_time")
    private Integer expectedTime;

    @Column(name = "salary")
    private Integer salary;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public Date getDismissalDate() {
        return dismissalDate;
    }

    public void setDismissalDate(Date dismissalDate) {
        this.dismissalDate = dismissalDate;
    }

    public Integer getExpectedTime() {
        return expectedTime;
    }

    public void setExpectedTime(Integer expectedTime) {
        this.expectedTime = expectedTime;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
