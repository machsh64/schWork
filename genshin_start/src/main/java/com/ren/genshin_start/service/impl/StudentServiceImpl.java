package com.ren.genshin_start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ren.genshin_start.entity.Student;
import com.ren.genshin_start.mapper.StudentMapper;
import com.ren.genshin_start.service.StudentService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @program: easc
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-07-13 15:58
 * @description:
 **/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Cacheable(cacheNames = "getPage", key = "#pageNum")
    @Override
    public Page<Student> getPage(Integer pageNum, Integer pageSize, String name) {
        // 构造分页构造器
        Page<Student> studentPage = new Page<>(pageNum, pageSize);
        // 构造条件构造器
        LambdaQueryWrapper<Student> studentLambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 添加过滤条件
        studentLambdaQueryWrapper.like(StringUtils.hasText(name),Student::getName,name);  // 有则加入,没有则过滤
        // 执行查询
        Page<Student> page = this.page(studentPage, studentLambdaQueryWrapper);
        return page;
    }


}
