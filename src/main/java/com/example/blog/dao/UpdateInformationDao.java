package com.example.blog.dao;

import com.example.blog.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 * @author wu
 */
public class UpdateInformationDao {

    String account;

    /**
     * 传入账号来初始化该类的对象
     * @param account
     */
    public UpdateInformationDao(String account){
        this.account = account;
    }

    /**
     * 更新账号的用户信息
     * @param name
     * @param birthday
     * @param sex
     * @throws Exception
     */
    public void updateAccount(String name,String birthday,String sex) throws Exception {
        String sql = "update user set name = ? , birthday = ? , sex = ? where account = ?;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,birthday);
        preparedStatement.setString(3,sex);
        preparedStatement.setString(4,account);
        preparedStatement.executeUpdate();
        ConnectionUtil.close(null,preparedStatement,connection);
    }

    /**
     * 更换账号的密码
     * @param password
     * @throws Exception
     */
    public void updatePassword(String password) throws Exception {
        String sql = "update user set password = ? where account = ?;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,password);
        preparedStatement.setString(2,account);
        preparedStatement.executeUpdate();
        ConnectionUtil.close(null,preparedStatement,connection);
    }

    /**
     * 更换账号的头像存储路径
     * @param avatar
     * @throws Exception
     */
    public void updateAvatar(String avatar) throws Exception{
        String sql = "update user set avatar = ? where account = ?;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,avatar);
        preparedStatement.setString(2,account);
        preparedStatement.executeUpdate();
        ConnectionUtil.close(null,preparedStatement,connection);
    }
}
