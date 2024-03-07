package com.ren.genshin_start;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ren.genshin_start.entity.Student;
import com.ren.genshin_start.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@SpringBootTest
class GenshinStartApplicationTests {

    @Autowired
    private StudentService studentService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    public void test1() {
        List<Student> list = studentService.list();
        list.forEach(System.out::println);
    }

    @Test
    public void test2() {
        boolean b = studentService.save(new Student(null, "haha", 12, "tst", null));
        log.info("保存结果为:{}",b?"保存成功":"保存失败");
    }

    @Test
    public void test3() {

        Page<Student> page = studentService.getPage(1, 3, "");
        log.info(page.toString());
    }

    @Test
    public void test4() {
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        opsForValue.set("B1","stupid LI");
        String b1 = opsForValue.get("B1");
        log.info("$$$$$ B1 = {} $$$$$$",b1);
    }

}
