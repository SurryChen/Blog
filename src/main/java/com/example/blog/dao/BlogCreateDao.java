package com.example.blog.dao;

import com.example.blog.domain.NovelPage;
import com.example.blog.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * @author wu
 */
public class BlogCreateDao {
    /**
     * 传入一个封装了一篇文章所有信息的对象Novelpage
     * 将所有信息写进数据库
     * @param novel
     * @throws Exception
     */
    public void create(NovelPage novel) throws Exception {
        String sql = "insert into novel (`Novel_author`,`Novel_name`,`Novel_content`,`Novel_publish_time`," +
                "`Novel_revise_time`,`Novel_category`,`Novel_label_first`,`Novel_label_second`," +
                "`Novel_label_third`) " +
                "value(?,?,?,?,?,?,?,?,?);";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,novel.getNovelAuthor());
        preparedStatement.setString(2, novel.getNovelName());
        preparedStatement.setString(3,novel.getNovelContent());
        preparedStatement.setString(4, novel.getNovelPublishTime());
        preparedStatement.setString(5, novel.getNovelReviseTime());
        preparedStatement.setString(6, novel.getNovelCategory());
        preparedStatement.setString(7, novel.getNovelLabelFirst());
        preparedStatement.setString(8,novel.getNovelLabelSecond());
        preparedStatement.setString(9, novel.getNovelLabelThird());
        preparedStatement.executeUpdate();
        ConnectionUtil.close(null,preparedStatement,connection);
    }

    /**
     * 传入需要更新的文章信息和文章编号
     * 通过文章编号找到需要更新文章信息的文章，然后写入信息
     * @param novel
     * @param numberBlog
     * @throws Exception
     */
    public void update(NovelPage novel,String numberBlog) throws Exception {
        String sql = "update novel set Novel_name = ? , Novel_content = ? , Novel_revise_time = ? ," +
                " Novel_category = ? , Novel_label_first = ? , Novel_label_second = ? , " +
                "Novel_label_third = ? where Novel_number = ?;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, novel.getNovelName());
        preparedStatement.setString(2,novel.getNovelContent());
        preparedStatement.setString(3, novel.getNovelReviseTime());
        preparedStatement.setString(4, novel.getNovelCategory());
        preparedStatement.setString(5, novel.getNovelLabelFirst());
        preparedStatement.setString(6,novel.getNovelLabelSecond());
        preparedStatement.setString(7, novel.getNovelLabelThird());
        preparedStatement.setString(8,numberBlog);
        preparedStatement.executeUpdate();
        ConnectionUtil.close(null,preparedStatement,connection);
    }

    /**
     * 判断是否存在这个用户名
     * @param name
     * @return 返回true说明存在这个用户名，返回false说明不存在这个用户名
     * @throws Exception
     */
    public boolean existNovel(String name) throws Exception{
        String sql = "select Novel_name from novel where Novel_name = ?;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setString(1,name);
        ResultSet resultSet = pre.executeQuery();
        if(resultSet.next()){
            ConnectionUtil.close(resultSet,pre,connection);
            return true;
        } else {
            ConnectionUtil.close(resultSet,pre,connection);
            return false;
        }
    }

    /**
     * 传入文章名和文章编号
     * 判断是否有重名
     * 如果是和自己原来的名字相同，不算重名
     * @param numberBlog
     * @param novelName
     * @return 返回false，表示不存在同名账号，返回true，表示存在同名账号
     * @throws Exception
     */
    public boolean existNovelName(String novelName,String numberBlog) throws Exception{
        String sql = "select Novel_name from novel where Novel_number = ?;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setString(1,numberBlog);
        ResultSet resultSet = pre.executeQuery();
        if(resultSet.next()){
            String name = resultSet.getString("Novel_name");
            if(novelName.equals(name)){
                ConnectionUtil.close(resultSet,pre,connection);
                return false;
            } else {
                ConnectionUtil.close(resultSet,pre,connection);
                return true;
            }
        } else {
            ConnectionUtil.close(resultSet,pre,connection);
            return false;
        }
    }
}
