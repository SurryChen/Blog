package com.example.blog.web.servlet;

import com.example.blog.domain.User;
import com.example.blog.service.RegisterService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author wu
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            this.doPost(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 用于注册账号
     * 返回数字1，说明名字已被使用
     * 返回数字2，说明账号已被使用
     * 返回数字3，说明名字和账号都被使用
     * 返回数字4，说明注册成功
     * @param request
     * @param response
     * @throws ServletException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        User user = new User().acquireUser(request);
        RegisterService re = new RegisterService();
        try {
            int flag = re.register(user);
            String json = "{\"flag\":\""+flag+"\"}";
            response.setContentType("application/json");
            response.getWriter().write(json);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
