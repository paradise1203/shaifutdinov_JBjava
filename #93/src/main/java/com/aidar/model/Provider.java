package com.aidar.model;

import javax.persistence.*;

@Entity
@Table(name = "provider")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPeople")
    @SequenceGenerator(name = "seqPeople")
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "legal_info_id")
    private LegalInfo legalInfo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "office_id")
    private Office office;

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

    public LegalInfo getLegalInfo() {
        return legalInfo;
    }

    public void setLegalInfo(LegalInfo legalInfo) {
        this.legalInfo = legalInfo;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

}
