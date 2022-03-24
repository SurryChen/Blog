package com.example.blog.domain;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author wu
 */
public class NovelPage {
    private String novelAuthor;
    private String novelName;
    private String novelContent;
    private String novelPublishTime;
    private String novelReviseTime;
    private String novelCategory;
    private String novelLabelFirst;
    private String novelLabelSecond;
    private String novelLabelThird;

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

    /**
     * 根据HttpServletRequest请求和用户名，获取一个文章信息对象
     * 其实可以放在Page类中
     * @param request
     * @param name
     * @return
     */
    public NovelPage setNovel(HttpServletRequest request, String name) {
        novelAuthor = name;
        novelName = request.getParameter("name");
        novelContent = request.getParameter("novel");
        novelCategory = request.getParameter("type");
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        novelPublishTime = format.format(date);
        novelReviseTime = format.format(date);
        novelLabelFirst = request.getParameter("labelOne");
        novelLabelSecond = request.getParameter("labelTwo");
        novelLabelThird = request.getParameter("labelThree");
        return this;
    }

    /**
     * 传入HttpServletRequest，获取修改编辑后的文章信息和用户名，并new一个最终修改时间
     * 获得修改编辑后的文章信息
     * @param request
     * @param name
     */
    public void updateNovel(HttpServletRequest request, String name) {
        novelAuthor = name;
        novelName = request.getParameter("name");
        novelContent = request.getParameter("novel");
        novelCategory = request.getParameter("type");
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        novelReviseTime = format.format(date);
        novelLabelFirst = request.getParameter("labelOne");
        novelLabelSecond = request.getParameter("labelTwo");
        novelLabelThird = request.getParameter("labelThree");
    }
}
