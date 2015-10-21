package com.aidar.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "med_clinic")
public class MedClinic {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMedClinic")
    @SequenceGenerator(name = "seqMedClinic")
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "licence_number")
    private Integer licenseNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(Integer licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

}
