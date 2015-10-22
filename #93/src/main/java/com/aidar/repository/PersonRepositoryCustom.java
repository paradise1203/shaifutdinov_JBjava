package com.aidar.repository;

import com.aidar.model.Office;

import java.util.List;

public interface PersonRepositoryCustom {

    double getAverageSalary(List<Office> offices);

    double getAverageCheck(List<Office> offices);

}
