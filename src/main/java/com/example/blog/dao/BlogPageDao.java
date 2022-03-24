package com.example.blog.dao;

import com.example.blog.domain.BlogPage;
import com.example.blog.domain.User;
import com.example.blog.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 * @author wu
 */
public class BlogPageDao {

    /**
     * 查找的分页数和账号
     * 可以查找某一个用户的所有文章
     * 并按照分页数，返回该分页信息
     * @param blogNumber
     * @param account
     * @return 分页信息BlogPage对象全部放置在List存储，然后返回
     * @throws Exception
     */
    public List<BlogPage> getPages(int blogNumber, String account) throws Exception {
        List<BlogPage> pages = new ArrayList<>();
        UserInformationGetDao us = new UserInformationGetDao();
        User user = us.getUser(account);
        String name = user.getName();
        int i = blogNumber*3-2;
        String sql = "select * from novel where Novel_author = ? limit "+(i-1)+",3;";
        String sqlNumber = "SELECT COUNT(*) FROM novel WHERE Novel_author = ?;";

        Connection connection = ConnectionUtil.getConnection();
        Connection connectionTwo = ConnectionUtil.getConnection();

        PreparedStatement pre = connection.prepareStatement(sqlNumber);
        pre.setString(1,name);

        PreparedStatement stmt = connectionTwo.prepareStatement(sql);
        stmt.setString(1,name);

        ResultSet reOne = stmt.executeQuery();
        ResultSet reTwo = pre.executeQuery();

        String informationAllNumber = null;
        while (reTwo.next()){
            // 总信息数
            informationAllNumber = reTwo.getString("COUNT(*)");
            break;
        }
        while (reOne.next()){
            BlogPage blogPage = new BlogPage();
            blogPage.setBlogPage(reOne,i,Integer.parseInt(informationAllNumber));
            pages.add(blogPage);
            i++;
        }
        ConnectionUtil.close(reOne,pre,connection);
        connectionTwo.close();
        reTwo.close();
        stmt.close();
        return pages;
    }
}
