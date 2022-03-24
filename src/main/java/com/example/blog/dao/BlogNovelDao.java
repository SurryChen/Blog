package com.example.blog.dao;

import com.example.blog.domain.BlogNovel;
import com.example.blog.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * @author wu
 */
public class BlogNovelDao {

    /**
     * 传入一个文章编号
     * 查询该文章信息，并封装到BlogNovel对象中
     * 和另外一个方法封装的信息内容不同
     * @param numberBlog
     * @return BlogNovel对象，封装了文章信息
     * @throws Exception
     */
    public BlogNovel getNovel(String numberBlog) throws Exception{
        String sql = "select * from novel where Novel_number = ?;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setString(1,numberBlog);
        ResultSet re = pre.executeQuery();
        BlogNovel blogNovel = new BlogNovel();
        if(re.next()){
            blogNovel.set(re);
        }
        ConnectionUtil.close(re,pre,connection);
        return blogNovel;
    }

    /**
     * 传入一个文章编号
     * 查询该文章信息，并封装到BlogNovel对象中
     * 和另外一个方法封装的信息内容不同
     * @param numberBlog
     * @return
     * @throws Exception
     */
    public BlogNovel novel(String numberBlog) throws Exception{
        String sql = "select * from novel where Novel_number = ?;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setString(1,numberBlog);
        ResultSet re = pre.executeQuery();
        BlogNovel blogNovel = new BlogNovel();
        if(re.next()){
            blogNovel.setNovel(re);
        }
        ConnectionUtil.close(re,pre,connection);
        return blogNovel;
    }
}
