package com.example.blog.dao;

import com.example.blog.domain.User;
import com.example.blog.util.ConnectionUtil;

import java.sql.*;

/**
 * @author wu
 */
public class RegisterDao {
    /**
     * 传入一个user对象，对象里面封装了所有用户信息
     * 实现注册
     * @param user
     * @throws SQLException
     */
    public void register(User user) throws Exception {
        String sql = "INSERT INTO USER(Name,account,Password,birthday,sex,avatar) " +
                "VALUE(?,?,?,?,?,?);";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setString(1,user.getName());
        pre.setString(2, user.getAccount());
        pre.setString(3,user.getPassword());
        pre.setString(4,user.getBirthday());
        pre.setString(5,user.getSex());
        pre.setString(6,"../picture/start_picture.jpg");
        pre.executeUpdate();
        ConnectionUtil.close(null,pre,connection);
    }
}
