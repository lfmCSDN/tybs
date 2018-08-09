//JavaScript代码区域
layui.use(["jquery","element"], function () {
    var element = layui.element;
    var $ = layui.$;

    element.on("nav(filter)", function (elem) {
        var text = elem.children("a").text();
        var href = elem.children("a").attr("name");
        var navItem = $(".layui-tab-title li");
        var totalText = "";
        for(var i = 0;i < navItem.length;i++){
            totalText = totalText + $(navItem[i]).text();
        }

        if(totalText.indexOf(text) == -1){
            element.tabAdd("new_tab",{
                title:text,
                content:"<iframe src='" + href + "' width='100%' height='800px'></iframe>",
                id:text
            });
            element.tabChange("new_tab",text);
        }else{
            element.tabChange("new_tab",text);
        }
    });
});
