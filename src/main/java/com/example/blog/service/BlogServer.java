package com.example.blog.service;

import com.example.blog.dao.BlogCreateDao;
import com.example.blog.domain.NovelPage;
/**
 * @author wu
 */
public class BlogServer {
    /**
     * 传入一个封装文章信息的NovelPage对象
     * 先判断文章名字是否已被占用
     * 然后在进行写入数据库的操作
     * @param novel
     * @return
     * @throws Exception
     */
    public String createBlog(NovelPage novel) throws Exception{
        String flag;
        BlogCreateDao blogCreateDao = new BlogCreateDao();
        boolean result = blogCreateDao.existNovel(novel.getNovelName());
        if(result == true) {
            flag = "0";
        } else {
            blogCreateDao.create(novel);
            flag = "1";
        }
        return flag;
    }

    /**
     * 用于更新文章信息
     * 需要传入一个封装文章信息的NovelPage对象和文章编号
     * 文章编号是为了知道要把数据写进哪一篇文章
     * @param novel
     * @param numberBlog
     * @return
     * @throws Exception
     */
    public String updateBlog(NovelPage novel,String numberBlog) throws Exception{
        String flag;
        BlogCreateDao blogCreateDao = new BlogCreateDao();
        boolean result = blogCreateDao.existNovelName(novel.getNovelName(),numberBlog);
        if(result == true) {
            flag = "0";
        } else {
            blogCreateDao.update(novel,numberBlog);
            flag = "1";
        }
        return flag;
    }
}
