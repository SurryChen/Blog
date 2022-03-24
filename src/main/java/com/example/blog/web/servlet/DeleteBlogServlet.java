package com.example.blog.web.servlet;

import com.example.blog.dao.DeleteBlogDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
/**
 * @author wu
 */
@WebServlet("/deleteBlogServlet")
public class DeleteBlogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * 删除博客
     * 删除必然成功，返回的数据没有用处，只是习惯这么一写
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numberBlog = request.getParameter("numberBlog");
        DeleteBlogDao delete = new DeleteBlogDao();
        try {
            delete.deleteBlog(numberBlog);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().write("{\"flag\": \"1\"}");
    }
}
