package com.example.blog.web.servlet;

import com.example.blog.dao.BlogNovelDao;
import com.example.blog.domain.BlogNovel;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
/**
 * @author wu
 */
@WebServlet("/blogNovelServlet")
public class BlogNovelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * 接收文章编号，返回文章信息
     * 与NovelServlet中代码类似
     * 但是封装的数据不一样，这里是只封装博客可以修改的数据
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
            blogNovel = novel.getNovel(numberBlog);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(blogNovel);
        response.getWriter().write(json);
    }
}
