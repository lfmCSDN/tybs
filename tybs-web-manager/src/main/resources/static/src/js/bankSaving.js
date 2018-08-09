layui.use(["jquery","form","layer"],function () {
    var $ = layui.$;
    var form = layui.form;
    var layer = layui.layer;

    form.on("submit",function (data) {
        $.post("/acct/bankSaving",data.field,function (resp) {
            layer.msg(resp,{
                offset:["120px","430px"],
                time:3000
            });
        });

        return false;
    });
});