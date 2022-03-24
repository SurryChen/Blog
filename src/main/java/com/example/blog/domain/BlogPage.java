package com.example.blog.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author wu
 */
public class BlogPage {
    /**
     * 该信息的总信息中排名
     */
    private int informationNumber;
    /**
     * 总信息数
     */
    private int informationAllNumber;
    private int number;
    private int numberBlog;
    private String title;
    private String time;
    private String category;
    private String oneType;
    private String twoType;
    private String threeType;

    /**
     * 这里是封装我的博客分页显示的文章信息
     * 使用ResultSet结果集，获取一些信息
     * 还要获取该分页的第一条数据是总数据中第几条，还有总信息数
     * @param re
     * @param informationNumber
     * @param informationAllNumber
     * @throws SQLException
     */
    public void setBlogPage(ResultSet re,int informationNumber,int informationAllNumber) throws SQLException {
        this.informationNumber = informationNumber;
        this.informationAllNumber = informationAllNumber;
        number = informationNumber;
        numberBlog = re.getInt("Novel_number");
        title = re.getString("Novel_name");
        time = re.getString("Novel_revise_time");
        category = re.getString("Novel_category");
        oneType = re.getString("Novel_label_first");
        twoType = re.getString("Novel_label_second");
        threeType = re.getString("Novel_label_third");
    }


    public int getInformationNumber() {
        return informationNumber;
    }

    public int getInformationAllNumber() {
        return informationAllNumber;
    }

    public int getNumber() {
        return number;
    }

    public int getNumberBlog() {
        return numberBlog;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public String getCategory() {
        return category;
    }

    public String getOneType() {
        return oneType;
    }

    public String getTwoType() {
        return twoType;
    }

    public String getThreeType() {
        return threeType;
    }

}
