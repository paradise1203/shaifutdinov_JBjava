package com.aidar.service.impl;

import com.aidar.model.EmployeeData;
import com.aidar.model.MedClinic;
import com.aidar.model.Office;
import com.aidar.model.Person;
import com.aidar.repository.EmployeeDataRepository;
import com.aidar.repository.MedClinicRepository;
import com.aidar.repository.OfficeRepository;
import com.aidar.repository.PersonRepository;
import com.aidar.service.MedClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class MedClinicServiceImpl implements MedClinicService {

    @Autowired
    @Qualifier("medClinicRepository")
    private MedClinicRepository medClinicRepository;

    @Autowired
    @Qualifier("officeRepository")
    private OfficeRepository officeRepository;

    @Qualifier("personRepository")
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    @Qualifier("employeeDataRepository")
    private EmployeeDataRepository employeeDataRepository;

    private Long getDateDiff(Date date1, Date date2) {
        long diffInMill = date2.getTime() - date1.getTime();
        return TimeUnit.DAYS.convert(diffInMill, TimeUnit.MILLISECONDS);
    }

    @Override
    public Long getWorkingExperience(String fio, Integer type) {
        Person person = personRepository.findByFioAndType(fio, type);
        if (person == null) {
            return null;
        }
        EmployeeData employeeData = employeeDataRepository.findByPerson(person);
        if (employeeData.getDismissalDate() == null) {
            return getDateDiff(employeeData.getEmploymentDate(), new Date());
        } else {
            return getDateDiff(employeeData.getEmploymentDate(), employeeData.getDismissalDate());
        }
    }

    @Override
    public Integer getParticularSalary(String fio, Integer type) {
        Person person = personRepository.findByFioAndType(fio, type);
        if (person == null) {
            return null;
        }
        EmployeeData employeeData = employeeDataRepository.findByPerson(person);
        return employeeData.getExpectedTime() * employeeData.getSalary();
    }

    @Override
    public Double getAverageSalary(String name) {
        List<Office> offices = officeRepository.findByMedClinic(medClinicRepository.findByName(name));
        if (offices.isEmpty()) {
            return null;
        }
        double res = personRepository.getAverageSalary(offices);
        return res != 0 ? res : null;
    }

    @Override
    public String getMostProfitableClinic() {
        List<MedClinic> medClinics = (List<MedClinic>) medClinicRepository.findAll();
        if (medClinics.isEmpty()) {
            return null;
        }
        double resCheck = 0;
        String res = null;
        Iterator<MedClinic> it = medClinics.listIterator();
        while (it.hasNext()) {
            MedClinic medClinic = it.next();
            double temp = personRepository.getAverageCheck(officeRepository.findByMedClinic(medClinic));
            if (temp > resCheck) {
                resCheck = temp;
                res = medClinic.getName();
            }
        }
        return res;
    }

    @Override
    public Double getAverageClinicCheck(String name) {
        List<Office> offices = officeRepository.findByMedClinic(medClinicRepository.findByName(name));
        if (offices.isEmpty()) {
            return null;
        }
        double res = personRepository.getAverageCheck(offices);
        return res != 0 ? res : null;
    }

    @Override
    public String getMostProfitableOffice() {
        double resCheck = 0;
        String res = null;
        List<Office> offices = (List<Office>) officeRepository.findAll();
        if (offices.isEmpty()) {
            return null;
        }
        Iterator<Office> it = offices.listIterator();
        while (it.hasNext()) {
            List<Office> office = new ArrayList<>();
            office.add(it.next());
            double temp = personRepository.getAverageCheck(office);
            if (temp > resCheck) {
                resCheck = temp;
                res = office.get(0).getCity() + office.get(0).getStreet();
            }
        }
        return res;
    }

    @Override
    public Double getAverageOfficeCheck(String city, String street) {
        List<Office> offices = officeRepository.findByCityAndStreet(city, street);
        if (offices.isEmpty()) {
            return null;
        }
        double res = personRepository.getAverageCheck(offices);
        return res != 0 ? res : null;
    }

    @Override
    public Office getOffice(String city, String street) {
        List<Office> offices = officeRepository.findByCityAndStreet(city, street);
        return offices.isEmpty() ? null : offices.get(0);
    }

}
