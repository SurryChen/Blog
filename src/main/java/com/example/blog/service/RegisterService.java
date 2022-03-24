package com.example.blog.service;

import com.example.blog.dao.UserInformationConfirmDao;
import com.example.blog.dao.RegisterDao;
import com.example.blog.domain.User;

/**
 * 该类是调用dao包中的类完成注册
 * 有判断用户名，账号是否有被占用的
 * 然后才会将数据写到数据库
 * 返回数字1，说明名字已被使用
 * 返回数字2，说明账号已被使用
 * 返回数字3，说明名字和账号都被使用
 * 返回数字4，说明注册成功
 * @author wu
 */
public class RegisterService {
    public int register(User user) throws Exception {
        UserInformationConfirmDao us = new UserInformationConfirmDao();
        boolean nameResult = us.nameConfirm(user.getName());
        boolean accountResult = us.accountConfirm(user.getAccount());
        if(nameResult == true && accountResult == false){
            return 1;
        } else if(nameResult == false && accountResult == true) {
            return 2;
        } else if(nameResult == true && accountResult == true) {
            return 3;
        } else {
            new RegisterDao().register(user);
            return 4;
        }
    }

}
