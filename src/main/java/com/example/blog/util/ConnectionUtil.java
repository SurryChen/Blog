package com.example.blog.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC连接数据库的工具类
 * 思路参考B站视频：黑马程序员JavaWeb全套教程 第258和259个视频 邓旒案例_代码实现
 * 下面代码与视频基本一致
 * @author wu
 */
public class ConnectionUtil {

    /**
     * 创建数据库连接池对象
     */
    private static DataSource ds;

    /**
     * 使用静态代码，表示只加载一次配置文件
     * 将配置文件加载进这个类中
     */
    static {
        try {
            Properties pro = new Properties();
            InputStream is = ConnectionUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接池对象方法
     * @return 返回一个连接池DataSource对象
     */
    public static DataSource getDatasource(){
        return ds;
    }

    /**
     * 获取连接对象方法
     * @return 返回一个Connection对象
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 关闭连接
     * @param rs
     * @param pre
     * @param conn
     * @throws Exception
     */
    public static void close(ResultSet rs, PreparedStatement pre, Connection conn) throws Exception{
        if(rs != null){
            rs.close();
        }
        if(pre != null){
            pre.close();
        }
        if(conn != null){
            conn.close();
        }
    }
}
