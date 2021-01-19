package com.pratice.mybatispro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pratice.mybatispro.mapper.DepartmentMapper;
import com.pratice.mybatispro.pojo.Department;
import com.pratice.mybatispro.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {
}
