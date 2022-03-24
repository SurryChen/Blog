package com.example.blog.service;

import com.example.blog.dao.PageDao;
import com.example.blog.domain.Page;

import java.util.List;

/**
 * @author wu
 */
public class PageService {
    /**
     * 这个方法和这个类比较多余，可以直接在Servlet中完成
     * 传入一个数字，也就是首页页数
     * 然后查询该页的数据返回
     * @param number
     * @return
     * @throws Exception
     */
    public List<Page> getPage(int number) throws Exception {
        PageDao pageDao = new PageDao();
        List<Page> pageNovel = pageDao.pageAll(number);
        return pageNovel;
    }
}
