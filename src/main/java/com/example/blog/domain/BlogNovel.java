package com.example.blog.domain;

import java.sql.ResultSet;
/**
 * @author wu
 */
public class BlogNovel {
    private String title;
    private String author;
    private String novel;
    private String category;
    private String oneType;
    private String twoType;
    private String threeType;
    private String novelPublishTime;
    private String novelReviseTime;

    /**
     * 传入结果集
     * 封装 文章修改 需要导入的信息
     * @param re
     * @throws Exception
     */
    public void set(ResultSet re) throws Exception{
        title = re.getString("Novel_name");
        novel = re.getString("Novel_content");
        category = re.getString("Novel_category");
        oneType = re.getString("Novel_label_first");
        twoType = re.getString("Novel_label_second");
        threeType = re.getString("Novel_label_third");
    }

    /**
     * 传入结果集
     * 封装 文章查看 需要的信息
     * @param re
     * @throws Exception
     */
    public void setNovel(ResultSet re) throws Exception{
        title = re.getString("Novel_name");
        author = re.getString("Novel_author");
        novel = re.getString("Novel_content");
        novelPublishTime = re.getString("Novel_publish_time");
        novelReviseTime = re.getString("Novel_revise_time");
        oneType = re.getString("Novel_label_first");
        twoType = re.getString("Novel_label_second");
        threeType = re.getString("Novel_label_third");
    }

    public String getTitle() {
        return title;
    }

    public String getNovel() {
        return novel;
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

    public String getAuthor() {
        return author;
    }

    public String getNovelPublishTime() {
        return novelPublishTime;
    }

    public String getNovelReviseTime() {
        return novelReviseTime;
    }
}
