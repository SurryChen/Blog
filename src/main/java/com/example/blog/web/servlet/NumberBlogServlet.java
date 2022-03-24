package com.example.blog.web.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author wu
 */
@WebServlet("/numberBlogServlet")
public class NumberBlogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * 将文章编号写入cookie，用于将编号对应的文章数据导入到修改博客那里
     * 返回值没有意义
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numberBlog = request.getParameter("numberBlog");
        Cookie cookie = new Cookie("numberBlog",numberBlog);
        response.addCookie(cookie);
        response.getWriter().write("{\"flag\": \"1\"}");
    }

    //{"flag":"1"}
}
