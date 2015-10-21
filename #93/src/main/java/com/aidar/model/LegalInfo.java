package com.aidar.model;

import javax.persistence.*;

@Entity
@Table(name = "legal_info")
public class LegalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPeople")
    @SequenceGenerator(name = "seqPeople")
    @Column(name = "id")
    private long id;

    @Column(name = "series")
    private String series;

    @Column(name = "number")
    private String number;

    @Column(name = "number_uuid")
    private String uuid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

}
