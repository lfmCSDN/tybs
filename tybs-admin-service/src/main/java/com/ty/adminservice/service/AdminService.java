package com.ty.adminservice.service;


import po.UserAdminInfo;
import po.UserOperInfo;
import qo.UserOperInfoQo;
import vo.UserOperInfoVo;

import java.util.List;

/**
 * create by Lfm
 * on 2018-03-18 12:04
 */
public interface AdminService {
    //管理员登录
    UserAdminInfo login(String username, String password);

    //增加操作员
    void add(UserOperInfoQo userOperInfoQo);

    //查询操作员
    List<UserOperInfoVo> query(UserOperInfoQo userOperInfoQo);

    //删除操作员
    void del(UserOperInfoQo userOperInfoQo);

    //修改操作员
    void update(UserOperInfoQo userOperInfoQo);
}
