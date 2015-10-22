package com.aidar.service;

import com.aidar.model.Office;

public interface MedClinicService {

    Integer getParticularSalary(String fio, Integer type);

    Long getWorkingExperience(String fio, Integer type);

    Double getAverageSalary(String name);

    String getMostProfitableClinic();

    Double getAverageClinicCheck(String name);

    String getMostProfitableOffice();

    Double getAverageOfficeCheck(String city, String street);

    Office getOffice(String city, String street);

}
