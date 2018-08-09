package com.ty.tybs.web.controller;

import com.ty.tybs.web.feignclient.OperatorFeign;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import po.CardBaseInfo;
import po.UserOperInfo;
import qo.CardBaseInfoQo;
import qo.UserBaseInfoQo;
import qo.UserOperInfoQo;
import req.AddUserReq;
import req.ModifyPwdReq;
import vo.TableVo;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * create by Lfm
 * on 2018-03-19 22:11
 * 账户管理
 */

@Controller
@RequestMapping("/operator")
public class OperatorController {

    private static Logger log = LoggerFactory.getLogger(OperatorController.class);
    @Autowired
    OperatorFeign operatorFeign;

    /**
     * 登录
     *
     * @param userOperInfoQo
     * @param model
     * @return
     */
    @RequestMapping("/login")
    public String OperatorLogin(UserOperInfoQo userOperInfoQo, Model model) {
        UserOperInfo operator = operatorFeign.login(userOperInfoQo);
        String loginName = userOperInfoQo.getOperName();
        String loginTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        model.addAttribute("loginTime", loginTime);
        model.addAttribute("loginName", loginName);
        if (operator == null) {
            return "login";
        } else {
            return "operatorMain";
        }
    }

    /*
    跳转开通账户
    */
    @RequestMapping("/addUserVm")
    public String addUserVm(AddUserReq addUserReq, Model model) {
        return "addUser";
    }

    /*
    开通账户
     */
    @RequestMapping("/addUser")
    public String addOperator(AddUserReq addUserReq, Model model) {
        operatorFeign.addUser(addUserReq);
        return "addUser";
    }

    /**
     * 跳转删除账户
     *
     * @param addUserReq
     * @param model
     * @return
     */
    @RequestMapping("/deleteUserVm")
    public String deleteUserVm(AddUserReq addUserReq, Model model) {
        return "deleteUser";
    }

    /*删除账户*/
    @RequestMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(AddUserReq addUserReq, Model model) {
        operatorFeign.deleteUser(addUserReq);
        return "";
    }

    /**
     * 跳转查找账户
     *
     * @param addUserReq
     * @param model
     * @return
     */
    @RequestMapping("/queryUserVm")
    public String queryUserVm(AddUserReq addUserReq, Model model) {
        return "queryUser";
    }

    /* 查询账户*/
    @RequestMapping("/queryUser")
    @ResponseBody
    public TableVo<AddUserReq> queryUser(AddUserReq addUserReq, Model model) {
        List<AddUserReq> list = operatorFeign.queryUser(addUserReq);

        TableVo<AddUserReq> tableVo = new TableVo<>();
        tableVo.setCode(0);
        tableVo.setMsg("成功");
        tableVo.setCount(list.size());
        tableVo.setData(list);
        return tableVo;
    }

    /**
     * 跳转冻结账户
     *
     * @param addUserReq
     * @param model
     * @return
     */
    @RequestMapping("/freezeUserVm")
    public String freezeUserVm(AddUserReq addUserReq, Model model) {
        return "operCard";
    }

    /*冻结账户*/
    @RequestMapping("/freezeUser")
    @ResponseBody
    public String freezeUser(AddUserReq addUserReq, Model model) {
        String stat = operatorFeign.freezeUser(addUserReq);
        if ("Y".equals(stat)) {
            return "true";
        }
        return "false";
    }

    /*解冻账户*/
    @RequestMapping("/upFreezeUser")
    @ResponseBody
    public String upFreezeUser(AddUserReq addUserReq, Model model) {
        String stat = operatorFeign.upFreezeUser(addUserReq);
        if ("F".equals(stat)) {
            return "true";
        }
        return "false";

    }

    /* 跳转挂失账户*/
    @RequestMapping("/lostUserVm")
    public String lostUserVm(AddUserReq addUserReq, Model model) {
        return "lostUser";
    }

    /*挂失账户*/
    @RequestMapping("/lostUser")
    @ResponseBody
    public String lostUser(AddUserReq addUserReq, Model model) {
        String stat = operatorFeign.lostUser(addUserReq);
        if ("Y".equals(stat)) {
            return "true";
        }
        return "false";
    }

    /*解挂账户*/
    @RequestMapping("/upLostUser")
    @ResponseBody
    public String upLostUser(AddUserReq addUserReq, Model model) {
        String stat = operatorFeign.upLostUser(addUserReq);
        if ("L".equals(stat)) {
            return "true";
        }
        return "false";
    }

    /*修改密码*/
    @RequestMapping("/toModifyPwd")
    public String toModifyPwd(ModifyPwdReq modifyPwdReq, Model model) {
        return "modifyPwd";
    }

    @RequestMapping("/modifyPwd")
    @ResponseBody
    public String modifyPwd(ModifyPwdReq modifyPwdReq, Model model) {
        return operatorFeign.modifyPwd(modifyPwdReq);
    }

    /*退出*/
    @RequestMapping("/exit")
    public String exit(HttpSession session, SessionStatus sessionStatus) {
        log.info("退出......");
        session.removeAttribute("useroper");
        sessionStatus.setComplete();
        return "redirect:login";
    }
}


