package com.ty.operatorservice.controller;

import com.ty.operatorservice.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import po.UserOperInfo;
import qo.UserBaseInfoQo;
import qo.UserOperInfoQo;
import req.AddUserReq;
import req.ModifyPwdReq;
import vo.UserOperInfoVo;

import java.security.PublicKey;
import java.util.List;

/**
 * create by Lfm
 * on 2018-04-06 10:59
 */
@RestController
@RequestMapping("/operator")
public class OperatorController {
    @Autowired
    OperatorService operatorService;

    //操作员登录
    @RequestMapping("/login")
    public UserOperInfo login(@RequestBody UserOperInfoQo oper) {
        String name = oper.getOperName();
        String password = oper.getLoginPwd();
        UserOperInfo operator = operatorService.login(name, password);
        return operator;
    }

    //账户开通
    @RequestMapping("/addUser")
    public void addUser(@RequestBody AddUserReq addUserReq) {
        operatorService.addUser(addUserReq);
    }

    //注销账户
    @RequestMapping("/deleteUser")
    public void deleteUser(@RequestBody AddUserReq addUserReq) {
        operatorService.deleteUser(addUserReq);
    }

    // 查询账户
    @RequestMapping("/queryUser")
    public List<AddUserReq> queryUser(@RequestBody AddUserReq addUserReq) {
        return operatorService.queryUser(addUserReq);
    }

    // 冻结账户
    @RequestMapping("/freezeUser")
    public String freezeUser(@RequestBody AddUserReq addUserReq) {
        return operatorService.freezeUser(addUserReq);
    }

    //挂失账户
    @RequestMapping("/lostUser")
    public String lostUser(@RequestBody AddUserReq addUserReq) {
        return operatorService.lostUser(addUserReq);
    }

    //解挂账户
    @RequestMapping("/upLostUser")
    public String upLostUser(@RequestBody AddUserReq addUserReq) {
        return operatorService.upLostUser(addUserReq);
    }

    //解冻账户
    @RequestMapping("/upFreezeUser")
    public String upFreezeUser(@RequestBody AddUserReq addUserReq) {
        return operatorService.upFreezeUser(addUserReq);
    }

    //修改密码
    @RequestMapping("/modifyPwd")
    String modifyPwd(@RequestBody ModifyPwdReq modifyPwdReq) {
        return operatorService.modifyPwd(modifyPwdReq);
    }
}
