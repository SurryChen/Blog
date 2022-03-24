package com.example.blog.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author wu
 */
public class Page {

    private int novelNumber;
    private String novelAuthor;
    private String novelName;
    private String novelContent;
    private String novelPublishTime;
    private String novelReviseTime;
    private String novelCategory;
    private String novelLabelFirst;
    private String novelLabelSecond;
    private String novelLabelThird;
    private int number;

    /**
     * 使用结果集储存文章内容
     * re是查询文章信息的结果集
     * res是查询有多少篇文章的结果集
     * @param re
     */
    public void set(ResultSet re,ResultSet res) throws SQLException {
        novelNumber = re.getInt("Novel_number");
        novelAuthor = re.getString("Novel_author");
        novelName = re.getString("Novel_name");
        novelContent = re.getString("Novel_content");
        novelPublishTime = re.getString("Novel_publish_time");
        novelReviseTime = re.getString("Novel_revise_time");
        novelCategory = re.getString("Novel_category");
        novelLabelFirst = re.getString("Novel_label_first");
        novelLabelSecond = re.getString("Novel_label_second");
        novelLabelThird = re.getString("Novel_label_third");
        number = res.getInt("number");
    }

    public int getNovelNumber() {
        return novelNumber;
    }

    public String getNovelAuthor() {
        return novelAuthor;
    }

    public String getNovelName() {
        return novelName;
    }

    public String getNovelContent() {
        return novelContent;
    }

    public String getNovelPublishTime() {
        return novelPublishTime;
    }

    public String getNovelReviseTime() {
        return novelReviseTime;
    }

    public String getNovelCategory() {
        return novelCategory;
    }

    public String getNovelLabelFirst() {
        return novelLabelFirst;
    }

    public String getNovelLabelSecond() {
        return novelLabelSecond;
    }

    public String getNovelLabelThird() {
        return novelLabelThird;
    }

    public int getNumber() {
        return number;
    }
}
