package com.example.blog.service;

import com.example.blog.dao.UpdateInformationDao;
import com.example.blog.dao.UserInformationConfirmDao;
import com.example.blog.dao.UserInformationGetDao;
import com.example.blog.domain.User;

import java.sql.SQLException;
/**
 * @author wu
 */
public class UpdateInformationServer {

    /**
     * 保存账号
     */
    private String account;
    /**
     * 该类有直接操作数据的方法
     */
    private UpdateInformationDao up;

    /**
     * 传入账号，修改账号，但是因为后面设置账号不能修改，所以没用了
     * @param account
     */
    public UpdateInformationServer(String account) {
        this.account = account;
        up = new UpdateInformationDao(this.account);
    }

    /**
     * 获取账号和密码，判断密码是否正确，而后修改值
     * 返回true是修改成功
     * 返回false是密码错误
     * @param startPassword
     * @param endPassword
     * @return
     * @throws Exception
     */
    public boolean updatePassword(String startPassword, String endPassword) throws Exception {
        UserInformationConfirmDao us = new UserInformationConfirmDao();
        boolean flag = us.passwordConfirm(account,startPassword);
        if(flag == true){
            up.updatePassword(endPassword);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改用户名，生日，性别，有进行用户名是否重复判断
     * 返回true是修改成功
     * 返回false是用户名已被占用
     * 如果名字是原来的，要返回true
     * @param name
     * @param birthday
     * @param sex
     * @return
     * @throws SQLException
     */
    public boolean updateAccount(String name, String birthday, String sex) throws Exception {
        User user = new UserInformationGetDao().getUser(account);
        if(user.getName().equals(name)){
            up.updateAccount(name,birthday,sex);
            return true;
        } else {
            UserInformationConfirmDao us = new UserInformationConfirmDao();
            boolean flag = us.nameConfirm(name);
            if(flag == true){
                return false;
            } else {
                up.updateAccount(name,birthday,sex);
                return true;
            }
        }
    }

    /**
     * 传送回去储存路径，也要将路径保存到数据库中
     * @param avatar
     * @throws Exception
     */
    public void updateAvatar(String avatar) throws Exception {
        up.updateAvatar(avatar);
    }
}
