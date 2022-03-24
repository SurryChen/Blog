package com.example.blog.web.servlet;

import com.example.blog.domain.Page;
import com.example.blog.service.PageService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
/**
 * @author wu
 */
@WebServlet("/pageServlet")
public class PageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    /**
     * 首页分页页数传入
     * 如果存在该页数，则发送数据给客户端
     * 如果不存在返回number:0说明不存在该页
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String number = request.getParameter("page");
        int pageNumber = 5*(Integer.parseInt(number)-1);
        PageService ps = new PageService();
        try {
            List<Page> pageNovel = ps.getPage(pageNumber);
            ObjectMapper objectMapper = new ObjectMapper();
            String jdbc = objectMapper.writeValueAsString(pageNovel);
            String equal = "[]";
            if(equal.equals(jdbc)){
                response.getWriter().write("[{\"number\":\"0\"}]");
            } else {
                response.getWriter().write(jdbc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
