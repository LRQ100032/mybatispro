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

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("dept")
public class Department implements Serializable {
    @TableId(value = "id",type = IdType.INPUT)
    private Integer id;
    private String dname;
    //@Column(value = "loc")
    //下面的注解是mybatisplus解决表字段名和成员变量名不一样
    @TableField(value = "loc")
    private String location;
}
