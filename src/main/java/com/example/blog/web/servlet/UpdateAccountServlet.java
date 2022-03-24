package com.example.blog.web.servlet;

import com.example.blog.service.UpdateInformationServer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
/**
 * @author wu
 */
@WebServlet("/updateAccountServlet")
public class UpdateAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    /**
     * 更新用户信息
     * 返回1是修改成功
     * 返回0是用户名已被占用
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
                break;
            }
        }
        UpdateInformationServer up = new UpdateInformationServer(account);
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String sex = request.getParameter("sex");
        try {
            boolean flag = up.updateAccount(name,birthday,sex);
            // 设置返回内容
            int returnFlag;
            if(flag == true){
                returnFlag = 1;
            } else {
                returnFlag = 0;
            }
            response.getWriter().write("{\"flag\":\""+returnFlag+"\"}");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
