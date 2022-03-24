package com.example.blog.web.servlet;

import com.example.blog.dao.UserInformationGetDao;
import com.example.blog.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
/**
 * @author wu
 */
@WebServlet("/checkLoginServlet")
public class CheckLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    /**
     * 如果登录了可以返回账号的用户信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        User user = null;
        int flag = 1;
        if(cookies != null) {
            for(Cookie cookie: cookies){
                if("account".equals(cookie.getName())){
                    String account = cookie.getValue()+"";
                    if(account.equals("0")){
                        flag = 0;
                        response.getWriter().write("{\"account\":\"0\"}");
                        break;
                    } else {
                        flag = 0;
                        try {
                            user = new UserInformationGetDao().getUser(account);
                            ObjectMapper mapper = new ObjectMapper();
                            String json = mapper.writeValueAsString(user);
                            response.setContentType("application/json");
                            response.getWriter().write(json);
                            break;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }
            }
        }
        if(flag == 1){
            Cookie cookie = new Cookie("account","0");
            response.addCookie(cookie);
            response.getWriter().write("{\"account\":\"0\"}");
        }
    }
}
