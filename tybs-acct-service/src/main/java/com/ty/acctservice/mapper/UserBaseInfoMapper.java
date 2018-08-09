package com.ty.acctservice.mapper;

import po.UserBaseInfo;

/**
 * User:jiaw.j
 * Date:2018/4/4 0004
 */
public interface UserBaseInfoMapper {

    UserBaseInfo getObjectByForeignKey(String cardBaseInfoId);

}
