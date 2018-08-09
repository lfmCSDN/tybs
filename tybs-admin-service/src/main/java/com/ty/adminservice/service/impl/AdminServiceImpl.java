package com.ty.adminservice.service.impl;


import com.ty.adminservice.mapper.AdminMapper;
import com.ty.adminservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.UserAdminInfo;
import qo.UserOperInfoQo;
import vo.UserOperInfoVo;

import java.util.List;

/**
 * create by Lfm
 * on 2018-03-18 12:05
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public UserAdminInfo login(String username, String password) {
        return adminMapper.getUser(username, password);
    }

    @Override
    public void add(UserOperInfoQo userOperInfoQo) {
        adminMapper.addOper(userOperInfoQo);
    }

    @Override
    public List<UserOperInfoVo> query(UserOperInfoQo userOperInfoQo) {
        return adminMapper.queryOper(userOperInfoQo);
    }

    @Override
    public void del(UserOperInfoQo userOperInfoQo) {
        adminMapper.delOper(userOperInfoQo);
    }

    @Override
    public void update(UserOperInfoQo userOperInfoQo) {
        adminMapper.updateOper(userOperInfoQo);
    }
}
