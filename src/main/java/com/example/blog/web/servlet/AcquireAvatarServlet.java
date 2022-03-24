package com.example.blog.web.servlet;

import com.example.blog.dao.UserInformationGetDao;
import com.example.blog.domain.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
/**
 * @author wu
 */
@WebServlet("/acquireAvatarServlet")
public class AcquireAvatarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * 接收用户名返回图片路径
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        User user = null;
        try {
            user = new UserInformationGetDao().getAvatar(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().write("{\"avatar\":\""+user.getAvatar()+"\"}");
    }
}
