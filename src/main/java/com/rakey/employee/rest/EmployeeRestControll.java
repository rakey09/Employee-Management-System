package com.rakey.employee.rest;

import com.rakey.employee.entity.Employee;
import com.rakey.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestControll {
    private EmployeeService employeeService;
@Autowired
    public EmployeeRestControll(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/employees")
    public List<Employee> findAll(Employee employee){
    return employeeService.findAll();
    }
    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id){
    Employee employee = employeeService.findById(id);
    if(employee == null){
        throw new RuntimeException("Employee not Found: "+id);

    }
    return employee;
    }
   @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee){
    employee.setId(0);
       return employeeService.saveAll(employee);
    }
    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee){
        return employeeService.saveAll(employee);
    }

    @DeleteMapping("/employees/{id}")
    public String delete(@PathVariable int id){
    Employee tempEmployee = employeeService.findById(id);
    if (tempEmployee == null){
        throw new RuntimeException("Employee not found with id : "+id);

    }
    employeeService.deleteById(id);
    return "employee deleted :"+id;
    }


}
