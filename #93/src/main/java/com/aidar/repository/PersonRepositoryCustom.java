package com.aidar.repository;

import com.aidar.model.Office;

import java.util.List;

public interface PersonRepositoryCustom {

    public double getAverageSalary(List<Office> offices);

    public double getAverageCheck(List<Office> offices);

}
