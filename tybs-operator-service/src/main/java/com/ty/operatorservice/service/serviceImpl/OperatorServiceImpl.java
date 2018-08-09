package com.ty.operatorservice.service.serviceImpl;

import com.ty.operatorservice.mapper.CardBaseInfoMapper;
import com.ty.operatorservice.mapper.OperatorMapper;
import com.ty.operatorservice.mapper.UserBaseInfoMapper;
import com.ty.operatorservice.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.CardBaseInfo;
import po.UserOperInfo;
import req.AddUserReq;
import req.ModifyPwdReq;


import java.util.Date;
import java.util.List;

/**
 * create by Lfm
 * on 2018-04-06 11:01
 */
@Service
public class OperatorServiceImpl implements OperatorService {
    @Autowired
    OperatorMapper operatorMapper;
    @Autowired
    CardBaseInfoMapper cardBaseInfoMapper;
    @Autowired
    UserBaseInfoMapper userBaseInfoMapper;

    /*操作员登录*/
    @Override
    public UserOperInfo login(String username, String password) {
        return operatorMapper.getOperator(username, password);
    }

    /**
     * 开通账户
     *
     * @param addUserReq
     */
    @Override
    public void addUser(AddUserReq addUserReq) {
        //给主键设置一个随机值
        String pk = new Date().getTime() + "";
        addUserReq.setCardBaseInfoId(pk);
        addUserReq.setUserBaseInfoId(pk);
        userBaseInfoMapper.addUserBaseInfo(addUserReq);
        cardBaseInfoMapper.addCardBaseInfo(addUserReq);
    }

    /**
     * 查询账户
     *
     * @param addUserReq
     * @return
     */
    @Override
    public List<AddUserReq> queryUser(AddUserReq addUserReq) {
        return userBaseInfoMapper.queryUserByIdCard(addUserReq);
    }

    /**
     * 注销账户
     *
     * @param addUserReq
     */
    @Override
    public void deleteUser(AddUserReq addUserReq) {
        CardBaseInfo cardBaseInfo = cardBaseInfoMapper.getObjectByForeignKey(addUserReq.getUserBaseInfoId());
        cardBaseInfoMapper.delCardById(cardBaseInfo.getCardBaseInfoId());
        userBaseInfoMapper.deleteUserByIdCard(addUserReq);
    }

    /**
     * 挂失账户
     *
     * @param addUserReq
     * @return
     */
    @Override
    public String lostUser(AddUserReq addUserReq) {
        CardBaseInfo cardBaseInfo = cardBaseInfoMapper.getObjectByForeignKey(addUserReq.getUserBaseInfoId());
        switch (cardBaseInfo.getStat()) {
            case "L":
                return "L";
            case "D":
                return "D";
            case "F":
                return "F";
        }
        cardBaseInfoMapper.lostUser(cardBaseInfo.getCardBaseInfoId());
        return "Y";
    }

    @Override
    public String freezeUser(AddUserReq addUserReq) {
        CardBaseInfo cardBaseInfo = cardBaseInfoMapper.getObjectByForeignKey(addUserReq.getUserBaseInfoId());
        switch (cardBaseInfo.getStat()) {
            case "L":
                return "L";
            case "D":
                return "D";
            case "F":
                return "F";
        }
        cardBaseInfoMapper.freezeUser(cardBaseInfo.getCardBaseInfoId());
        return "Y";
    }

    @Override
    public String upLostUser(AddUserReq addUserReq) {
        CardBaseInfo cardBaseInfo = cardBaseInfoMapper.getObjectByForeignKey(addUserReq.getUserBaseInfoId());
        switch (cardBaseInfo.getStat()) {
            case "Y":
            case "D":
                return "D";
            case "F":
                return "F";
        }
        cardBaseInfoMapper.upLostUser(cardBaseInfo.getCardBaseInfoId());
        return "L";
    }

    @Override
    public String upFreezeUser(AddUserReq addUserReq) {
        CardBaseInfo cardBaseInfo = cardBaseInfoMapper.getObjectByForeignKey(addUserReq.getUserBaseInfoId());
        switch (cardBaseInfo.getStat()) {
            case "Y":
                return "Y";
            case "D":
                return "D";
            case "L":
                return "L";
        }
        cardBaseInfoMapper.upFreezeUser(cardBaseInfo.getCardBaseInfoId());
        return "F";
    }

    @Override
    public String modifyPwd(ModifyPwdReq modifyPwdReq) {
        CardBaseInfo cardBaseInfo = cardBaseInfoMapper.getObjectByCardId(modifyPwdReq.getCardId());

        if (!modifyPwdReq.getTransPwd().equals(cardBaseInfo.getTransPwd())) {
            return "银行卡密码错误";
        } else {
            if (!modifyPwdReq.getTransPwd2().equals(modifyPwdReq.getTransPwd1())) {
                return "两次密码输入不相符,请重新输入!";
            } else {
                cardBaseInfoMapper.modifyPwd(modifyPwdReq.getTransPwd1(), modifyPwdReq.getCardId());
            }
        }
        return "密码修改成功";
    }
}
