package com.ty.acctservice.mapper;

import org.apache.ibatis.annotations.Param;
import po.TransListInfo;
import qo.TransListInfoQo;
import vo.UserOperInfoVo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * create by Lfm
 * on 2018-04-12 20:29
 */
public interface TransListMapper {
    /*增加交易信息*/
    void addTransList(@Param("transListInfoId") String transListInfoId, @Param("transName") String transName, @Param("transId") String transId, @Param("transAmount") BigDecimal transAmount, @Param("transType") String transType, @Param("openDate") String openDate);

    List<UserOperInfoVo> queryTransList(@Param("transListInfoQo") TransListInfoQo transListInfoQo);
}
