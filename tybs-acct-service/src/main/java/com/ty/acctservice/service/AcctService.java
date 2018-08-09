package com.ty.acctservice.service;

import qo.TransListInfoQo;
import req.BankSaveReq;
import req.DrawMoneyReq;
import req.TransferReq;
import vo.UserOperInfoVo;

import java.util.List;

/**
 * User:jiaw.j
 * Date:2018/4/4 0004
 */
public interface AcctService {

    String bankSaving(BankSaveReq bankSaveReq);

    String transfer(TransferReq transferReq);

    String drawMoney(DrawMoneyReq drawMoneyReq);

    List<UserOperInfoVo> queryTransList(TransListInfoQo transListInfoQo);
}
