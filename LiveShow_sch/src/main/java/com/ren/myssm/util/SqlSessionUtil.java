package com.ren.myssm.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-12 15:44
 * @description:
 **/
public class SqlSessionUtil {

    private static final ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();;

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = threadLocal.get();
        // 获取核心配置文件的输入流
        InputStream is = null;
        if (sqlSession == null) {
            try {
                is = Resources.getResourceAsStream("mybatis-config.xml");
                // 获取SqlSessionFactoryBuilder
                SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
                // 获取sqlSessionFactory
                SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
                // 由sqlSessionFactory获取sqlSession
                sqlSession = sqlSessionFactory.openSession(true);  //此处出现bug，在测试中事务管理提交正常，但是网页中无法提交到数据库
                System.out.println("sqlSession build true...");
                threadLocal.set(sqlSession);
            } catch (IOException e) {
                System.out.println("sqlSession build false...");
                e.printStackTrace();
            }
        }
        return threadLocal.get();
    }

    public static void closeQuietly(){
        SqlSession sqlSession = threadLocal.get();
        sqlSession.close();
        threadLocal.set(null);
        System.out.println("sqlSession close...\n");
    }
}
