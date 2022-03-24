package com.example.blog.domain;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 该类是为了封装用户信息
 * @author wu
 */
public class User {
    private String name;
    private String account;
    private String password;
    private String birthday;
    private String sex;
    private String avatar;

    public String getName() {
        return name;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getSex() {
        return sex;
    }

    public String getAvatar() { return  avatar; }

    /**
     * 使用HttpServletRequest请求获取User对象
     * @param httpServletRequest
     * @return
     */
    public User acquireUser(HttpServletRequest httpServletRequest){
        name = httpServletRequest.getParameter("name");
        account = httpServletRequest.getParameter("account");
        password = httpServletRequest.getParameter("password");
        birthday = httpServletRequest.getParameter("birthday");
        sex = httpServletRequest.getParameter("sex");
        return this;
    }

    /**
     * 使用结果集ResultSet获取User对象
     * @param rs
     * @return
     * @throws SQLException
     */
    public User acquireUser(ResultSet rs) throws SQLException {
        name = rs.getString("name");
        account = rs.getString("account");
        password = rs.getString("password");
        birthday = rs.getString("birthday");
        sex = rs.getString("sex");
        avatar = rs.getString("avatar");
        return this;
    }
}
