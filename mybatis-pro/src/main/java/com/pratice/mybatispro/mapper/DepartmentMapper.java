package com.pratice.mybatispro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pratice.mybatispro.pojo.Department;

public interface DepartmentMapper extends BaseMapper<Department> {
    Department findDepartment(Integer id);
}
