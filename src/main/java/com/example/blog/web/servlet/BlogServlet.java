package com.example.blog.web.servlet;

import com.example.blog.dao.UserInformationGetDao;
import com.example.blog.domain.NovelPage;
import com.example.blog.domain.User;
import com.example.blog.service.BlogServer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
/**
 * @author wu
 */
@WebServlet("/blogServlet")
public class BlogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    /**
     * 接收表单信息，返回“1”是创建成功，返回“2”是创建失败，文章名字重复
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String account = null;
        for(Cookie cookie: cookies){
            if("account".equals(cookie.getName())){
                account = cookie.getValue();
            }
        }
        User user = null;
        try {
            user = new UserInformationGetDao().getUser(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        NovelPage novel = new NovelPage().setNovel(request,user.getName());
        BlogServer blogServer = new BlogServer();
        String flag = null;
        try {
            flag = blogServer.createBlog(novel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().write("{\"flag\": \""+flag+"\"}");
    }
}
