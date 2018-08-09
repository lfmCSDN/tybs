package com.ty.adminservice.mapper;


import org.apache.ibatis.annotations.Param;
import po.UserAdminInfo;
import po.UserOperInfo;
import qo.UserOperInfoQo;
import vo.UserOperInfoVo;

import java.util.List;


/**
 * create by Lfm
 * on 2018-03-18 12:00
 */

public interface AdminMapper {
    UserAdminInfo getUser(@Param("adminName") String adminName, @Param("adminPwd") String adminPwd);

    void addOper(@Param("UsrOperInfoQo") UserOperInfoQo userOperInfoQo);

    List<UserOperInfoVo> queryOper(@Param("userOperInfoQo") UserOperInfoQo userOperInfoQo);

    void delOper(@Param("userOperInfoQo") UserOperInfoQo userOperInfoQo);

    void updateOper(@Param("userOperInfoQo") UserOperInfoQo userOperInfoQo);
}
