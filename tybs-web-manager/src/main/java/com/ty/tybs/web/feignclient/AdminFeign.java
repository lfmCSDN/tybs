package com.ty.tybs.web.feignclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import po.UserOperInfo;
import qo.UserAdminInfoQo;
import qo.UserOperInfoQo;
import qo.UserBaseInfoQo;
import vo.UserOperInfoVo;

import java.util.List;

@FeignClient("zuul-server")
public interface AdminFeign {
    //登录操作员
    @RequestMapping("/admin/admin/login")
    UserOperInfo login(@RequestBody UserAdminInfoQo admin);

    //添加操作员
    @RequestMapping("/admin/admin/addOperator")
    void addOper(@RequestBody UserOperInfoQo userOperInfoQo);

    //查询操作员
    @RequestMapping("/admin/admin/queryOperator")
    List<UserOperInfoVo> queryOper(@RequestBody UserOperInfoQo userOperInfoQo);

    //删除操作员
    @RequestMapping("/admin/admin/delOperator")
    void delOper(@RequestBody UserOperInfoQo userOperInfoQo);

    //修改操作员
    @RequestMapping("/admin/admin/updateOperator")
    void updateOper(@RequestBody UserOperInfoQo userOperInfoQo);

}
