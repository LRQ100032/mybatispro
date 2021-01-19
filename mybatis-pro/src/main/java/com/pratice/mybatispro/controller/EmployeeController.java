package com.pratice.mybatispro.controller;

import com.pratice.mybatispro.pojo.Department;
import com.pratice.mybatispro.pojo.Employee;
import com.pratice.mybatispro.service.EmployeeService;
import com.pratice.mybatispro.service.impl.DepartmentServiceImpl;
import com.pratice.mybatispro.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private DepartmentServiceImpl departmentService;

    //mybatis找雇员
    @GetMapping(value = "/findById/{id}")
    public Employee findById(@PathVariable Long id) {
        Employee employee = employeeService.findEmployee(id);
        return employee;
    }

    //mybatis-plus找雇员
    @GetMapping(value = "/findByIdPlus/{id}")
    public Employee findByIdPlus(@PathVariable Long id) {
        Employee employee = employeeService.getById(id);
        Integer deptId = employee.getDeptId();
        Department department = departmentService.getById(deptId);
        employee.setDepartment(department);
        return employee;
    }
}
