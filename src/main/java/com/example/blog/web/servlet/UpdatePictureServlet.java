package com.example.blog.web.servlet;

import com.example.blog.service.UpdateInformationServer;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.List;

/**
 * @author wu
 */
@WebServlet("/updatePictureServlet")
public class UpdatePictureServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * 接收图片数据，返回一个图片在服务器中的储存路径
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 基本思路：
         * 设置传输大小，由工厂来设置
         * 解析  通过工厂解析建立一个解析器
         * 建立流  通过解析器建立流
         */
        // 配置环境，设置传输大小
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(1024*1024*40);
        // 设置工厂的解析器，设置传输大小
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(1024*1024);
        // 开始解析网页请求
        List<FileItem> fileItems = null;
        try {
            fileItems = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        // 获取FileItem对象，每一个对象都是一个input数据，这里只有一个文件选择框input
        for(FileItem fileItem: fileItems){
            // 建立输入流
            InputStream in = fileItem.getInputStream();
            // 建立输出流，需要文件输出路径
            // 获取名字配合路径，去创建一个指定文件
            String fileName = fileItem.getName();
            String filePath = "D:\\Blog\\src\\main\\webapp\\picture\\"+fileName;
            OutputStream out = new FileOutputStream(filePath);
            byte[] b = new byte[in.available()];
            in.read(b);
            out.write(b);
            in.close();
            out.close();
            Cookie[] cookies = request.getCookies();
            String account = null;
            for(Cookie cookie: cookies){
                if("account".equals(cookie.getName())){
                    account = cookie.getValue();
                    break;
                }
            }
            try {
                new UpdateInformationServer(account).updateAvatar("../picture/"+fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
            response.setContentType("application/json");
            response.getWriter().write("{\"path\": \"../picture/"+fileName+"\"}");
        }
    }
}
