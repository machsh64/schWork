package com.ren.myssm.trans;

import com.ren.myssm.util.SqlSessionUtil;

import java.sql.SQLException;

public class TransactionManager {

    //开启事务
    public static void beginTrans() throws SQLException {

        System.out.println("beginTrans true...");
    }

    //提交事务
    public static void commit() throws SQLException {

        SqlSessionUtil.getSqlSession();
        System.out.println("commit true...");
        SqlSessionUtil.closeQuietly();
    }

    //回滚事务
    public static void rollback() throws SQLException {

        SqlSessionUtil.getSqlSession().rollback();
        System.out.println("commit false, rollback...");
        SqlSessionUtil.closeQuietly();
    }
}
