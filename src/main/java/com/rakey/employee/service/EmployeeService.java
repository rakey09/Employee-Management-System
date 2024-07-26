package com.rakey.employee.service;

import com.rakey.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee saveAll(Employee theEmployee);

    void deleteById(int id);
}
