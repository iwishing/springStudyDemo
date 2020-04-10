package com.cbw.utils;

import java.sql.SQLException;

/**
 * 和事务相关的工具类，它包含了开启事务，提交事务，回滚事务，释放连接
 */
public class TransactionManager {

    private ConnectionUtils connectionUtils;

    /**
     * 开始事务
     */
    public void beginTranscation(){
        try {
            System.out.println("开始事务--前置");
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commit(){
        try {
            System.out.println("提交事务--后置");
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollback(){
        try {
            System.out.println("回滚事务--异常");
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放连接
     */
    public void release(){
        try {
            System.out.println("释放连接--最终");
            connectionUtils.getThreadConnection().close();//并不是真的关闭，是将conn连接还回连接池中
            connectionUtils.removeConnection();//解绑
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }
}
