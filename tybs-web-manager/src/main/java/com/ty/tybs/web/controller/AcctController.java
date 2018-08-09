package com.ty.tybs.web.controller;

import com.ty.tybs.web.feignclient.AcctFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qo.TransListInfoQo;
import qo.UserOperInfoQo;
import req.BankSaveReq;
import req.DrawMoneyReq;
import req.TransferReq;
import vo.TableVo;
import vo.TransListInfoVo;
import vo.UserOperInfoVo;

import java.util.List;

/**
 * create by Lfm
 * on 2018-03-24 14:32
 * 交易管理
 */
@Controller
@RequestMapping("/acct")
public class AcctController {

    @Autowired
    AcctFeign acctFeign;

    /*存款*/
    @RequestMapping("/toBankSaving")
    public String toBankSaving() {
        return "bankSaving";
    }

    @RequestMapping("/bankSaving")
    @ResponseBody
    public String bankSaving(BankSaveReq bankSaveReq) {
        return acctFeign.bankSaving(bankSaveReq);
    }

    /*取款*/
    @RequestMapping("/toDrawMoney")
    public String toDrawMoney() { return "drawMoney"; }

    @RequestMapping("/drawMoney")
    @ResponseBody
    public String drawMoney(DrawMoneyReq drawMoneyReq) { return acctFeign.drawMoney(drawMoneyReq); }

    /*转账*/
    @RequestMapping("/toTransfer")
    public String toTransfer() {
        return "transfer";
    }

    @RequestMapping("/transfer")
    @ResponseBody
    public String transfer(TransferReq transferReq) {
        return acctFeign.transfer(transferReq);
    }

    /*交易明细*/
    @RequestMapping("/toTransList")
    public String toTransList() {
        return "transList";
    }

    @RequestMapping("/transList")
    @ResponseBody
    public TableVo<TransListInfoVo> queryTransList(TransListInfoQo transListInfoQo, Model model) {
        List<TransListInfoVo> list = acctFeign.queryTransList(transListInfoQo);
        TableVo<TransListInfoVo> tableVo = new TableVo<>();
        tableVo.setCode(0);
        tableVo.setMsg("成功");
        tableVo.setCount(list.size());
        tableVo.setData(list);
        return tableVo;
    }

}
