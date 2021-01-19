package com.pratice.mybatispro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pratice.mybatispro.pojo.Department;
import com.pratice.mybatispro.pojo.Employee;

public interface EmployeeMapper extends BaseMapper<Employee> {
    Employee findEmployee(Long id);
}
