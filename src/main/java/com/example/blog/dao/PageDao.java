package com.example.blog.dao;

import com.example.blog.domain.Page;
import com.example.blog.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * @author wu
 */
public class PageDao {
    /**
     * 传入一个数字
     * 查找首页某一页的所有信息
     * 因为页数并不是从表单获取的数据，所以没有使用PreparedStatement，同时因为?默认携带单引号''，所以就直接使用Statement了
     * @param number 查找首页信息
     * @return
     * @throws Exception
     */
    public List<Page> pageAll(int number) throws Exception {
        String sqlPage = "select * from novel limit "+number+",5;";
        String sqlNumber = "SELECT COUNT(*) AS number FROM novel;";
        Connection conn = ConnectionUtil.getConnection();
        Connection connTwo = ConnectionUtil.getConnection();

        Statement pre = conn.createStatement();
        ResultSet re = pre.executeQuery(sqlPage);

        Statement preTwo = connTwo.createStatement();
        ResultSet res = preTwo.executeQuery(sqlNumber);
        List<Page> pageNovel = new ArrayList<Page>();
        res.next();

        while(re.next()){
            Page page = new Page();
            page.set(re,res);
            pageNovel.add(page);
        }
        ConnectionUtil.close(re,null,conn);
        pre.close();
        conn.close();
        res.close();
        preTwo.close();
        return pageNovel;
    }
}
