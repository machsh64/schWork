package com.ren.genshin_start.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ren.genshin_start.entity.R;
import com.ren.genshin_start.entity.Student;

/**
 * @program: easc
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-07-13 15:57
 * @description:
 **/
public interface StudentService extends IService<Student> {

    Page<Student> getPage(Integer pageNum, Integer pageSize, String name);


}
