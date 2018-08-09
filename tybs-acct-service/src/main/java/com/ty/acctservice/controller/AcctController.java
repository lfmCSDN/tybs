package com.ty.acctservice.controller;

import com.ty.acctservice.service.AcctService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qo.TransListInfoQo;
import qo.UserOperInfoQo;
import req.BankSaveReq;
import req.DrawMoneyReq;
import req.TransferReq;
import vo.UserOperInfoVo;

import java.util.List;

/**
 * User:jiaw.j
 * Date:2018/4/4 0004
 */
@RestController
@RequestMapping("/acct")
public class AcctController {

    @Autowired
    AcctService acctService;

    @RequestMapping("/bankSaving")
    public String bankSaving(@RequestBody BankSaveReq bankSaveReq) {
        return acctService.bankSaving(bankSaveReq);
    }

    @RequestMapping("/transfer")
    public String transfer(@RequestBody TransferReq transferReq) {
        return acctService.transfer(transferReq);
    }

    @RequestMapping("/drawMoney")
    public String drawMoney(@RequestBody DrawMoneyReq drawMoneyReq) {
        return acctService.drawMoney(drawMoneyReq);
    }

    @RequestMapping("/transList")
    public List<UserOperInfoVo> queryTransList(@RequestBody TransListInfoQo transListInfoQo) {
        return acctService.queryTransList(transListInfoQo);
    }
}
