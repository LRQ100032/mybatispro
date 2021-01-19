package com.pratice.mybatispro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pratice.mybatispro.mapper.EmployeeMapper;
import com.pratice.mybatispro.pojo.Employee;
import com.pratice.mybatispro.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee findEmployee(Long id) {
        Employee employee = employeeMapper.findEmployee(id);
        return employee;
    }
}
