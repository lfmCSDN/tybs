package com.ty.acctservice.service.impl;

import com.ty.acctservice.mapper.CardBaseInfoMapper;
import com.ty.acctservice.mapper.TransListMapper;
import com.ty.acctservice.mapper.UserBaseInfoMapper;
import com.ty.acctservice.service.AcctService;
import com.ty.acctservice.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import po.CardBaseInfo;
import po.UserBaseInfo;
import qo.TransListInfoQo;
import qo.UserOperInfoQo;
import req.BankSaveReq;
import req.DrawMoneyReq;
import req.TransferReq;
import vo.UserOperInfoVo;

import java.util.Date;
import java.util.List;

/**
 * User:jiaw.j
 * Date:2018/4/4 0004
 */
@Service
@Transactional
public class AcctServiceImpl implements AcctService {

    @Autowired
    CardBaseInfoMapper cardBaseInfoMapper;

    @Autowired
    UserBaseInfoMapper userBaseInfoMapper;

    @Autowired
    TransListMapper transListMapper;

    /*存款*/
    @Override
    public String bankSaving(BankSaveReq bankSaveReq) {

        CardBaseInfo cardBaseInfo = cardBaseInfoMapper.getObjectByCardId(bankSaveReq.getCardId());

        if (cardBaseInfo == null) {
            return "银行卡号错误";
        } else {
            UserBaseInfo userBaseInfo = userBaseInfoMapper.getObjectByForeignKey(cardBaseInfo.getCardBaseInfoId());
            if (!bankSaveReq.getAcctName().equals(userBaseInfo.getUserName())) {
                return "银行卡号与持卡人不符合";
            }
        }

        switch (cardBaseInfo.getStat()) {
            case "L":
                return "存款失败，该银行卡处于挂失状态";
            case "D":
                return "存款失败，该银行卡处于删除状态";
            case "F":
                return "存款失败，该银行卡处于冻结状态";
        }
        cardBaseInfoMapper.receipt(bankSaveReq.getCardId(), bankSaveReq.getAmount());

        String test = new Date().getTime() + "";
        String openDate = DateUtils.dataToStr1(new Date());
        transListMapper.addTransList(test, bankSaveReq.getAcctName(), bankSaveReq.getCardId(), bankSaveReq.getAmount(), "存款", openDate);

        return "存款成功";
    }

    /*转账*/
    @Override
    public String transfer(TransferReq transferReq) {

        CardBaseInfo payCard = cardBaseInfoMapper.getObjectByCardId(transferReq.getPayCardId());
        UserBaseInfo payMan = userBaseInfoMapper.getObjectByForeignKey(payCard.getCardBaseInfoId());
        if (payCard == null) {
            return "付款账号不存在，请重新输入";
        }

        CardBaseInfo receiptCard = cardBaseInfoMapper.getObjectByCardId(transferReq.getReceiptCardId());
        if (receiptCard == null) {
            return "收款账号不存在，请重新输入";
        } else {
            UserBaseInfo receiptMan = userBaseInfoMapper.getObjectByForeignKey(receiptCard.getCardBaseInfoId());
            if (!transferReq.getReceiptName().equals(receiptMan.getUserName()))
                return "收款账号与收款人不匹配，请再次确认";
        }

        if (!transferReq.getTransPwd().equals(payCard.getTransPwd())) {
            return "银行卡密码错误";
        }

        switch (payCard.getStat()) {
            case "L":
                return "转账失败，付款账号处于挂失状态";
            case "D":
                return "转账失败，付款账号处于删除状态";
            case "F":
                return "转账失败，付款账号处于冻结状态";
        }

        switch (receiptCard.getStat()) {
            case "L":
                return "转账失败，收款账号处于挂失状态";
            case "D":
                return "转账失败，收款账号处于删除状态";
            case "F":
                return "转账失败，收款账号处于冻结状态";
        }

        if (payCard.getOveage().compareTo(transferReq.getAmount()) == -1) {
            return "付款账号余额不足";
        }

        cardBaseInfoMapper.payment(payCard.getCardId(), transferReq.getAmount());
        cardBaseInfoMapper.receipt(receiptCard.getCardId(), transferReq.getAmount());

        String test = new Date().getTime() + "";
        String openDate = DateUtils.dataToStr1(new Date());
        transListMapper.addTransList(test, payMan.getUserName(), payCard.getCardId(), transferReq.getAmount(), "转账", openDate);


        return "转账成功";
    }


    @Override
    public String drawMoney(DrawMoneyReq drawMoneyReq) {
        CardBaseInfo payCard = cardBaseInfoMapper.getObjectByCardId(drawMoneyReq.getCardId());
        UserBaseInfo payMan = userBaseInfoMapper.getObjectByForeignKey(payCard.getCardBaseInfoId());
        if (payCard == null) {
            return "银行卡号不存在，请重新输入";
        }

        if (!drawMoneyReq.getTransPwd().equals(payCard.getTransPwd())) {
            return "银行卡密码错误，请重新输入！";
        }

        switch (payCard.getStat()) {
            case "L":
                return "取款失败，付款账号处于挂失状态";
            case "D":
                return "取款失败，付款账号处于注销状态";
            case "F":
                return "取款失败，付款账号处于冻结状态";
        }

        if (payCard.getOveage().compareTo(drawMoneyReq.getAmount()) == -1) {
            return "账号余额不足,不能取款！";
        }

        cardBaseInfoMapper.payment(payCard.getCardId(), drawMoneyReq.getAmount());

        String test = new Date().getTime() + "";
        String openDate = DateUtils.dataToStr1(new Date());
        transListMapper.addTransList(test, payMan.getUserName(), payCard.getCardId(), drawMoneyReq.getAmount(), "取款", openDate);


        return "取款成功";
    }

    @Override
    public List<UserOperInfoVo> queryTransList(TransListInfoQo transListInfoQo) {
        return transListMapper.queryTransList(transListInfoQo);
    }

}
