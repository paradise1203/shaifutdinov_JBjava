package com.aidar.service;

import com.aidar.model.Office;

public interface MedClinicService {

    public Integer getParticularSalary(String fio, Integer type);

    public Long getWorkingExperience(String fio, Integer type);

    public Double getAverageSalary(String name);

    public String getMostProfitableClinic();

    public Double getAverageClinicCheck(String name);

    public String getMostProfitableOffice();

    public Double getAverageOfficeCheck(String city, String street);

    public Office getOffice(String city, String street);

}
