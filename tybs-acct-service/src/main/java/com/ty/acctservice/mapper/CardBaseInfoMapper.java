package com.ty.acctservice.mapper;

import org.apache.ibatis.annotations.Param;
import po.CardBaseInfo;

import java.math.BigDecimal;

/**
 * User:jiaw.j
 * Date:2018/4/4 0004
 */
public interface CardBaseInfoMapper {

    CardBaseInfo getObjectByCardId(String cardId);

    /*付款*/
    boolean payment(@Param("cardId") String cardId, @Param("amount") BigDecimal amount);

    /*收款*/
    boolean receipt(@Param("cardId") String cardId, @Param("amount") BigDecimal amount);

}
