package com.ty.adminservice.controller;

import com.ty.adminservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import po.UserAdminInfo;
import qo.UserAdminInfoQo;
import qo.UserOperInfoQo;
import vo.UserOperInfoVo;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    //登录
    @RequestMapping("/login")
    public UserAdminInfo login(@RequestBody UserAdminInfoQo adm) {
        String name = adm.getAdminName();
        String password = adm.getAdminPwd();
        UserAdminInfo admin = adminService.login(name, password);
        return admin;
    }

    /*
    添加操作员
    */
    @RequestMapping("/addOperator")
    public void addOperator(@RequestBody UserOperInfoQo userOperInfoQo) {
        adminService.add(userOperInfoQo);
    }

    /*
    删除操作员
     */
    @RequestMapping("/delOperator")
    public void deleteOperator(@RequestBody UserOperInfoQo userOperInfoQo) {
        adminService.del(userOperInfoQo);
    }

    /*
    查询操作员
     */
    @RequestMapping("/queryOperator")
    public List<UserOperInfoVo> queryOperator(@RequestBody UserOperInfoQo userOperInfoQo) {
        return adminService.query(userOperInfoQo);
    }

    /*
    修改操作员
     */
    @RequestMapping("/updateOperator")
    public void updateOperator(@RequestBody UserOperInfoQo userOperInfoQo) {
        adminService.update(userOperInfoQo);
    }
}
