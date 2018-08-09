layui.use(["jquery","element","table","layer","form"],function () {
    var $ = layui.$;
    var element = layui.element
    var table = layui.table;
    var layer = layui.layer;
    var form = layui.form;

    //监听提交
    form.on('submit(formDemo)', function (data) {
        $.ajax({
            url: "/admin/queryOperator",
            type: "post",
            data: data.field,
            success: function (a) {
                layer.msg("成功了")
            },
            error: function (a) {
                layer.open({
                    title: '提示',
                    content: '添加成功'
                })
            }
        });
        return false;
    });
});
