package com.example.blog.web.servlet;

import com.example.blog.dao.BlogNovelDao;
import com.example.blog.domain.BlogNovel;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author wu
 */
@WebServlet("/novelServlet")
public class NovelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * 接收文章编号，返回文章信息
     * 代码与BlogNovelServlet类似，但是封装的数据不一样
     * 这里封装查看文章的所有数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numberBlog = request.getParameter("numberBlog");
        BlogNovelDao novel = new BlogNovelDao();
        BlogNovel blogNovel = null;
        try {
            blogNovel = novel.novel(numberBlog);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(blogNovel);
        response.getWriter().write(json);
    }
}
