package com.ren.genshin_start.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ren.genshin_start.entity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: easc
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-07-13 15:56
 * @description:
 **/
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
