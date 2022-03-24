package com.example.blog.web.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
/**
 * @author wu
 */
@WebServlet("/blogPageChangeServlet")
public class BlogPageChangeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * 通过修改cookie来修改管理博客那里的页数设置，是一个比较失败的处理
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String numberFlag = null;
        for(Cookie cookie: cookies) {
            if("blogPageNumber".equals(cookie.getName())) {
                numberFlag = cookie.getValue();
            }
        }
        String flag = request.getParameter("flag");
        String value = null;
        String one = "1";
        String zone = "0";
        if(one.equals(flag)) {
            value = (Integer.parseInt(numberFlag)+1)+"";
        } else if(zone.equals(flag)) {
            value = (Integer.parseInt(numberFlag)-1)+"";
        }
        Cookie cookieNow = new Cookie("blogPageNumber",value);
        response.addCookie(cookieNow);
        response.getWriter().write("{\"flag\":\"1\"}");
    }
}
