package com.example.blog.service;

import com.example.blog.dao.UserInformationConfirmDao;
/**
 * @author wu
 */
public class LoginService {
    /**
     * 传入账号和密码
     * 先判断账号是否存在
     * 再判断密码是否正确
     * 1代表账号存在，但是密码不正确
     * 2代表账号存在，密码正确
     * 3代表账号不存在
     * @param account
     * @param password
     * @return 返回一个int数值
     * @throws Exception
     */
    public int login(String account,String password) throws Exception{
        UserInformationConfirmDao us = new UserInformationConfirmDao();
        boolean flag = us.accountConfirm(account);
        if(flag){
            boolean flagTwo = new UserInformationConfirmDao().passwordConfirm(account,password);
            if(flagTwo) {
                return 2;
            } else {
                return 1;
            }
        } else {
            return 3;
        }
    }
}
