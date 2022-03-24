package com.example.blog.web.servlet;

import com.example.blog.dao.UserInformationGetDao;
import com.example.blog.domain.NovelPage;
import com.example.blog.domain.User;
import com.example.blog.service.BlogServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author wu
 */
@WebServlet("/updateBlogServlet")
public class UpdateBlogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    /**
     * 用于修改博客信息功能
     * 接收表单数据
     * 返回1是成功
     * 返回0是失败，文章名重复
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String numberBlog = null;
        String account = null;
        for(Cookie cookie: cookies){
            if(account.equals(cookie.getName())){
                account = cookie.getValue();
            }
            if("numberBlog".equals(cookie.getName())){
                numberBlog = cookie.getValue();
            }
        }
        User user = null;
        try {
            user = new UserInformationGetDao().getUser(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        NovelPage novel = new NovelPage();
        novel.updateNovel(request,user.getName());
        BlogServer blogServer = new BlogServer();
        String flag = null;
        try {
            flag = blogServer.updateBlog(novel,numberBlog);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().write("{\"flag\": \""+flag+"\"}");
    }
}

