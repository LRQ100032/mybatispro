package com.pratice.mybatispro.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("emp")
public class Employee implements Serializable {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    private String ename;
    //@Column只能用来转驼峰
    //@Column(value = "job_id")
    private Integer jobId;
    private Integer mgr;
    private Date joindate;
    private Double salary;
    private Double bonus;
    //@Column(value = "dept_id")
    private Integer deptId;

    //使用mybatisplus查询表中没有的字段需要加下面的注解
    @TableField(exist = false)
    private Department department;


}
