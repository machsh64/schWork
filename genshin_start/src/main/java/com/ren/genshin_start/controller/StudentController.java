package com.ren.genshin_start.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ren.genshin_start.entity.R;
import com.ren.genshin_start.entity.Student;
import com.ren.genshin_start.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: easc
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-07-16 10:20
 * @description:
 **/
@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/page")
    public R<Page<Student>> getPage(Integer page,Integer pageSize, String name){
        Page<Student> studentPage = studentService.getPage(page, pageSize, name);
        return R.success(studentPage);
    }
}
