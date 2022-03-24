package com.example.blog.dao;

import com.example.blog.domain.User;
import com.example.blog.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * @author wu
 */
public class UserInformationGetDao {
    /**
     * 根据账号获取用户所有信息
     * @param account
     * @return
     * @throws Exception
     */
    public User getUser(String account) throws Exception {
        String sql = "select * from user where account = ?";
        Connection conn = ConnectionUtil.getConnection();
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setString(1,account);
        ResultSet rs = pre.executeQuery();
        User user = null;
        while(rs.next()){
            user = new User().acquireUser(rs);
        }
        ConnectionUtil.close(rs,pre,conn);
        return user;
    }

    /**
     * 根据用户名获取账号所有信息
     * @param name
     * @return
     * @throws Exception
     */
    public User getAvatar(String name) throws Exception {
        String sql = "select * from user where name = ?";
        Connection conn = ConnectionUtil.getConnection();
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setString(1,name);
        ResultSet rs = pre.executeQuery();
        User user = null;
        while(rs.next()){
            user = new User().acquireUser(rs);
        }
        ConnectionUtil.close(rs,pre,conn);
        return user;
    }
}
