/*
 * Youlema.com Inc.
 * Copyright (c) 2011-2013 All Rights Reserved
 */

/**
 * Created by Administrator on 2018/3/4 0004.
 */

layui.use(["jquery","util","laypage","form"],function () {
    var $ = layui.$;
    var util = layui.util;
    var laypage = layui.laypage;
    var form = layui.form;

    //页面初始化（人物列与祝福列同高、逐个下滑显示块、分页总数样式）
    function init() {
        var col1 = $(".complaint-col1");
        var col2 = $(".complaint-col2");
        var row = $(".complaint-row");

        for(var i = 0;i < col1.length;i++){
            if($(col1[i]).height() >= $(col2[i]).height()){
                $(col2[i]).height($(col1[i]).height());
            }else{
                $(col1[i]).height($(col2[i]).height());
            }
            $(row[i]).css("animation","slide 1s " + (i - 0.7 * i) + "s forwards");
        }

        var laypageCount = $(".layui-laypage-count");
        laypageCount.html("共<span style='color: #ff762f;background-color: #f2f2f2;border-width: 0px;padding: 3px 6px 0px 4px'>" + $(":input[name='pageNum']").val() + "</span>条");
    }


    //分页
    laypage.render({
        elem:"page",
        count:$(":input[name='pageNum']").val(),
        layout:["prev","page","next","count"],
        groups:4,
        jump:function (obj,first) {
            if(!first){
                //ajax请求对应页数的数据

                //重新渲染
                var show = $("#complaint-show");
                show.empty();
                for(var i = 0;i < 3;i++){
                    show.append("<div class='layui-row complaint-row'>"+
                        "<div class='layui-col-md3 complaint-col1'>"+
                        "<div class='complaint-person'>"+
                        "<img src='/src/images/headPortrait/default/man.jpg' class='layui-circle' width='85px' />"+
                        "<div class='complaint-person-name'>蒋嘉维</div>"+
                        "</div>"+
                        "</div>"+
                        "<div class='layui-col-md9 complaint-col2'>"+
                        "<div class='layui-row complaint-other'>"+
                        "<div class='layui-col-md8 complaint-time'>2018-02-27 10:15</div>"+
                        "<div class='layui-col-md2'><i class='layui-icon complaint-praise-unselected'>&#xe6c6;</i></div>"+
                        "<div class='layui-col-md2 complaint-praise-num-unselected'>12580</div>"+
                        "</div>"+
                        "<div class='complaint-content'>小雨和渣一粑小雨和渣一粑小雨和渣一粑小雨和渣一粑</div>"+
                        "</div>"+
                        "</div>");
                }
                init();
            }
        }
    });

    //页面初始化
    $(function () {
        init();
    });
});
