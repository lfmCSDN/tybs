package com.ty.operatorservice.service;

import po.UserOperInfo;
import req.AddUserReq;
import req.ModifyPwdReq;

import java.util.List;

/**
 * create by Lfm
 * on 2018-04-06 11:01
 */
public interface OperatorService {
    //操作员登录
    UserOperInfo login(String username, String password);

    //开通账户
    void addUser(AddUserReq addUserReq);

    // 查询账户
    List<AddUserReq> queryUser(AddUserReq addUserReq);

    // 删除账户
    void deleteUser(AddUserReq addUserReq);

    //挂失账户
    String lostUser(AddUserReq addUserReq);

    //冻结账户
    String freezeUser(AddUserReq addUserReq);

    //解挂账户
    String upLostUser(AddUserReq addUserReq);

    //解冻账户
    String upFreezeUser(AddUserReq addUserReq);

    //修改密码
    String modifyPwd(ModifyPwdReq modifyPwdReq);
}
