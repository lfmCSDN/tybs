package com.ty.operatorservice.mapper;

import org.apache.ibatis.annotations.Param;
import req.AddUserReq;

import java.util.List;

/**
 * create by Lfm
 * on 2018-04-07 12:25
 */
public interface UserBaseInfoMapper {
    /*用户基本信息*/
    void addUserBaseInfo(@Param("addUserReq") AddUserReq addUserReq);

    /*查询账户*/
    List<AddUserReq> queryUserByIdCard(@Param("addUserReq") AddUserReq addUserReq);

    /*注销账户*/
    void deleteUserByIdCard(@Param("addUserReq") AddUserReq addUserReq);


}
