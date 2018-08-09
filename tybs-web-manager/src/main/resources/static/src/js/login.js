/*
 * Youlema.com Inc.
 * Copyright (c) 2011-2013 All Rights Reserved
 */

/**
 * Created by Administrator on 2018/2/17 0017.
 */

layui.use(["jquery","form","element"],function () {
    var $ = layui.$;
    var form = layui.form;
    var element = layui.element;

    //登录按钮悬停事件
    $("form button").hover(function () {
        $(this).addClass("layui-anim layui-anim-scaleSpring");
    },function () {
        $(this).removeClass("layui-anim layui-anim-scaleSpring");
    });
});
