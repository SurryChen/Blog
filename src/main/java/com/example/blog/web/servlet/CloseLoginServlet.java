package com.example.blog.web.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
/**
 * @author wu
 */
@WebServlet("/closeLoginServlet")
public class CloseLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    /**
     * 退出账号处理
     * 将cookie的account的值设置为“0”，代表客户端没有注册账号
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("account","0");
        response.addCookie(cookie);
        Cookie cookieTwo = new Cookie("blogPageNumber","1");
        response.addCookie(cookieTwo);
        String json = "{\"account\":\"0\"}";
        response.getWriter().write(json);
    }
}
