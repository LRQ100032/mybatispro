package com.pratice.mybatispro.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@TableName("user")
//@KeySequence
@AllArgsConstructor
@NoArgsConstructor
//KeySequence是自定义ID生成器用
public class User implements Serializable {
    //IdType.AUTO自增主键,表中主键要求自增,IdType.INPUT由后台输入ID
    //IdType.ASSIGN_ID自动雪花算法生成ID
    //@TableId(value = "id", type = IdType.INPUT)
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;


}
