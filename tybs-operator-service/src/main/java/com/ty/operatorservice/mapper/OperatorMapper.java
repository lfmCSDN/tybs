package com.ty.operatorservice.mapper;

import org.apache.ibatis.annotations.Param;
import po.UserOperInfo;

/**
 * create by Lfm
 * on 2018-04-06 11:00
 */
public interface OperatorMapper {
    UserOperInfo getOperator(@Param("operName") String operName, @Param("loginPwd") String loginPwd);
}
