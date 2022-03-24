package com.example.blog.web.servlet;

import com.example.blog.service.LoginService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.fasterxml.jackson.databind.util.BeanUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wu
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    /**
     * 登录处理
     * 接收账号和密码，返回一个数字
     * 1代表账号存在，但是密码不正确
     * 2代表账号存在，密码正确
     * 3代表账号不存在
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        request.getParameterMap();

        int flag = 0;
        /**
         * 说不能有魔法值，就这样设置了一下，没有太多意义
         */
        int i = 2;
        try {
            flag = new LoginService().login(account,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(flag == i) {
            Cookie accountCookie = new Cookie("account",""+account);
            response.addCookie(accountCookie);
        }
        response.setContentType("application/json");
        response.getWriter().write("{\"flag\":\""+flag+"\"}");
    }
}
