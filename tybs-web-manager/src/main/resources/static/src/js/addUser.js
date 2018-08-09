layui.use(["jquery","element","table","layer","form","laydate"],function () {
    var $ = layui.$;
    var element = layui.element
    var table = layui.table;
    var layer = layui.layer;
    var form = layui.form;
    var laydate=layui.laydate;

    //时间插件
    laydate.render({
        elem: '#open'
        ,type:'date'
    });


    //监听提交
    form.on('submit(formDemo)', function (data) {
        $.ajax({
            url: "/operator/addUser",
            type: "post",
            data: data.field,
            success: function (mgs) {
                // layer.msg("成功了")
                layer.open({
                    title: '提示',
                    content: '开户成功'
                })
            },
            error: function (mgs) {
                layer.open({
                    title: '提示',
                    content: '开户失败'
                })
            }
        });
        return false;
    });
});