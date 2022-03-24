package com.example.blog.service;

import com.example.blog.dao.BlogPageDao;
import com.example.blog.domain.BlogPage;

import java.util.List;
/**
 * @author wu
 */
public class BlogPageServer {
    /**
     * 多余的一个类，可以直接在Servlet完成
     * 用于我的博客管理文章的分页展示
     * 传入分页页数和账号
     * 页数用于查询
     * 账号用于查询账号的用户名，根据文章的作者来查询文章
     * @param pageNumber
     * @param account
     * @return
     * @throws Exception
     */
    public List<BlogPage> getBlogPage(int pageNumber, String account) throws Exception{
        BlogPageDao blogPageDao = new BlogPageDao();
        List<BlogPage> pages = blogPageDao.getPages(pageNumber,account);
        return pages;
    }
}
