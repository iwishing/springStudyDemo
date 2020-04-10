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
