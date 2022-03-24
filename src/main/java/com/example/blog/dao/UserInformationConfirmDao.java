package com.example.blog.dao;

import com.example.blog.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author wu
 */
public class UserInformationConfirmDao {
    /**
     * @param name
     * @throws Exception
     * @return 返回true说明存在该用户名的用户，返回false说明不存在该用户名的用户
     */
    public boolean nameConfirm(String name) throws Exception {
        String sql = "select account from user where name = ?;";
        Connection conn = ConnectionUtil.getConnection();
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setString(1,name);
        ResultSet resultSet = pre.executeQuery();
        if(resultSet.next()){
            ConnectionUtil.close(resultSet,pre,conn);
            return true;
        } else{
            ConnectionUtil.close(resultSet,pre,conn);
            return false;
        }
    }

    /**
     * @param account
     * @return 返回true说明存在该账号的用户，返回false说明不存在该账号的用户
     * @throws Exception
     */
    public boolean accountConfirm(String account) throws Exception {
        String sql = "select name from user where account = ?;";
        Connection conn = ConnectionUtil.getConnection();
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setString(1,account);
        ResultSet resultSet = pre.executeQuery();
        if(resultSet.next()) {
            ConnectionUtil.close(resultSet,pre,conn);
            return true;
        } else{
            ConnectionUtil.close(resultSet,pre,conn);
            return false;
        }
    }

    /**
     * @param account
     * @param password
     * @return 密码正确就返回true，密码错误就返回false,能进入方法中必然是存在该账号
     * @throws Exception
     */
    public boolean passwordConfirm(String account,String password) throws Exception{
        String sql = "select password from user where account = ?";
        Connection conn = ConnectionUtil.getConnection();
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setString(1,account);
        ResultSet resultSet = pre.executeQuery();
        if(resultSet.next()) {
            String confirm = resultSet.getString("password");
            if (confirm.equals(password)) {
                ConnectionUtil.close(resultSet,pre,conn);
                return true;
            } else {
                ConnectionUtil.close(resultSet,pre,conn);
                return false;
            }
        } else {
            ConnectionUtil.close(resultSet,pre,conn);
            return false;
        }
    }
}
