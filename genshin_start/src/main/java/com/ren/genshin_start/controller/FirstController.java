package com.ren.genshin_start.controller;

import com.ren.genshin_start.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @program: easc
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-07-12 09:16
 * @description:
 **/
@Slf4j
@RequestMapping("/first")
@RestController
public class FirstController {

    @RequestMapping("/a")
    public String a() {
        log.info("genshin_Start");
        return "abc";
    }

    @RequestMapping("/b/{name}")
    public String b(@PathVariable String name) {
        log.info("NAme:{}", name);
        return name;
    }

    @PostMapping("/stu")
    public String c(Student student) {
        log.info("Stu:{}",student);
        return ("success: "+student.toString());
    }
}
