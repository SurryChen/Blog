package com.example.blog.web.servlet;

import com.example.blog.service.UpdateInformationServer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
/**
 * @author wu
 */
@WebServlet("/updatePasswordServlet")
public class UpdatePasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * 用于修改密码
     * 接收原密码和修改后密码
     * 返回1，代表成功
     * 返回0，代表原密码错误
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
            if(account.equals(cookie.getName())){
                account = cookie.getValue();
                break;
            }
        }
        UpdateInformationServer up = new UpdateInformationServer(account);
        String startPassword = request.getParameter("startPassword");
        String endPassword = request.getParameter("endPassword");
        try {
            boolean flag = up.updatePassword(startPassword,endPassword);
            // 设置返回内容
            int returnFlag;
            if(flag == true){
                returnFlag = 1;
            } else {
                returnFlag = 0;
            }
            response.getWriter().write("{\"flag\":\""+returnFlag+"\"}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
