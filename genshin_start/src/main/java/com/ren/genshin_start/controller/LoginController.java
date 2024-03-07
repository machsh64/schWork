package com.ren.genshin_start.controller;

import com.ren.genshin_start.entity.R;
import com.ren.genshin_start.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: easc
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-07-12 14:34
 * @description:
 **/
@Slf4j
@RequestMapping("/login")
@RestController
public class LoginController {

    @PostMapping("/login")
    public R<Student> login (Student student){
        if (student.getPassword().equals("123456")){
            return R.success(student);
        }

        return R.error("登录失败");
    }
}
