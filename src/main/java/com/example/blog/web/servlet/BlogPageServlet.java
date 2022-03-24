package com.example.blog.web.servlet;

import com.example.blog.domain.BlogPage;
import com.example.blog.service.BlogPageServer;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
/**
 * @author wu
 */
@WebServlet("/blogPageServlet")
public class BlogPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    /**
     * 根据分页传递信息
     * 我的博客那里的分页查询，使用cookie来储存页数，很不好
     * 如果存在与分页有关的cookie，则在其上加一作为页数进行查询，如果没有，就新建并赋值为1，进行第一页的查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String account = "";
        int flag = 0;
        String blogPageNumber = null;
        for(Cookie cookie:cookies){
           if("account".equals(cookie.getName())) {
               account = cookie.getValue();
           }
           if("blogPageNumber".equals(cookie.getName())){
               flag = 1;
               blogPageNumber = cookie.getValue();
           }
        }
        BlogPageServer blogPageServer = new BlogPageServer();
        List<BlogPage> blogPages = null;
        if(flag == 1){
            int pageNumber = Integer.parseInt(blogPageNumber);
            try {
                blogPages = blogPageServer.getBlogPage(pageNumber,account);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                blogPages = blogPageServer.getBlogPage(1,account);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Cookie cookie = new Cookie("blogPageNumber","1");
            response.addCookie(cookie);
        }
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(blogPages);
        System.out.println(json);
        response.getWriter().write(json);
    }
}
