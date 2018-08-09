package com.ty.tybs.web.feignclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import qo.TransListInfoQo;
import req.BankSaveReq;
import req.DrawMoneyReq;
import req.TransferReq;
import vo.TransListInfoVo;

import java.util.List;

/**
 * User:jiaw.j
 * Date:2018/4/4 0004
 */
@FeignClient("zuul-server")
@Service
public interface AcctFeign {

    @RequestMapping("/acct/acct/transfer")
    String transfer(@RequestBody TransferReq transferReq);

    @RequestMapping("/acct/acct/bankSaving")
    String bankSaving(@RequestBody BankSaveReq bankSaveReq);

    @RequestMapping("/acct/acct/drawMoney")
    String drawMoney(@RequestBody DrawMoneyReq drawMoneyReq);

    @RequestMapping("/acct/acct/transList")
    List<TransListInfoVo> queryTransList(@RequestBody TransListInfoQo transListInfoQo);
}
