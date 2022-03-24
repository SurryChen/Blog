package com.example.blog.dao;

import com.example.blog.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author wu
 */
public class DeleteBlogDao {
    /**
     * 传入编号
     * 然后删除该编号文章
     * @param numberBlog
     */
    public void deleteBlog(String numberBlog) throws Exception{
        String sql = "delete from novel where Novel_number = '"+numberBlog+"';";
        Connection conn = ConnectionUtil.getConnection();
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.execute(sql);
        ConnectionUtil.close(null,pre,conn);
    }
}
