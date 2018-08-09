package com.ty.operatorservice.mapper;

import org.apache.ibatis.annotations.Param;
import po.CardBaseInfo;
import req.AddUserReq;

/**
 * create by Lfm
 * on 2018-04-07 12:19
 */
public interface CardBaseInfoMapper {
    /*根据用户外键查询卡对象*/
    CardBaseInfo getObjectByForeignKey(String userBaseInfoId);

    CardBaseInfo getObjectByCardId(String cardId);

    void addCardBaseInfo(@Param("addUserReq") AddUserReq addUserReq);

    void lostUser(@Param("userCardId") String userCardId);

    void freezeUser(@Param("userCardId") String userCardId);

    void delCardById(@Param("cardBaseInfoId") String cardBaseInfoId);

    void upLostUser(@Param("userCardId") String userCardId);

    void upFreezeUser(@Param("userCardId") String userCardId);

    void modifyPwd(@Param("transPwd1") String transPwd1, @Param("cardId") String cardId);
}
