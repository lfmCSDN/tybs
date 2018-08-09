package com.ty.tybs.web.feignclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import po.UserOperInfo;
import qo.CardBaseInfoQo;
import qo.UserBaseInfoQo;
import qo.UserOperInfoQo;
import req.AddUserReq;
import req.ModifyPwdReq;

import java.util.List;

/**
 * create by Lfm
 * on 2018-04-06 10:45
 */
@FeignClient("zuul-server")
//@Service
public interface OperatorFeign {
    //登录操作员
    @RequestMapping("/operator/operator/login")
    UserOperInfo login(@RequestBody UserOperInfoQo operator);

    //账户开通
    @RequestMapping("/operator/operator/addUser")
    void addUser(@RequestBody AddUserReq addUserReq);

    // 删除账户
    @RequestMapping("/operator/operator/deleteUser")
    void deleteUser(@RequestBody AddUserReq addUserReq);

    //查询账户
    @RequestMapping("/operator/operator/queryUser")
    List<AddUserReq> queryUser(@RequestBody AddUserReq addUserReq);

    //冻结账户
    @RequestMapping("/operator/operator/freezeUser")
    String freezeUser(@RequestBody AddUserReq addUserReq);

    // 挂失账户
    @RequestMapping("/operator/operator/lostUser")
    String lostUser(@RequestBody AddUserReq addUserReq);

    //解挂账户
    @RequestMapping("/operator/operator/upLostUser")
    String upLostUser(@RequestBody AddUserReq addUserReq);

    //解冻账户
    @RequestMapping("/operator/operator/upFreezeUser")
    String upFreezeUser(@RequestBody AddUserReq addUserReq);

    //修改密码
    @RequestMapping("/operator/operator/modifyPwd")
    String modifyPwd(@RequestBody ModifyPwdReq modifyPwdReq);
}
