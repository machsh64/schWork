package com.ren.genshin_start.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: easc
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-07-12 10:05
 * @description:
 **/
@Data
@AllArgsConstructor
@TableName("student_dev")
public class Student implements Serializable {
    
    @TableId
    private Integer id;

    private String name;

    private Integer age;

    private String password;

    @TableLogic(value="1",delval = "0")
    private Integer isDelete;
}
