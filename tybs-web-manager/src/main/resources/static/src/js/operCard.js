layui.use(['table', 'form', 'jquery'], function () {
    var table = layui.table;
    var form = layui.form;
    var $ = layui.$;

    form.on('submit(formDemo)', function (data) {
        //第一个实例
        table.render({
            elem: '#freezeuser',
            height: 600,
            width: 1053,
            url: '/operator/queryUser', //数据接口,
            page: true, //开启分页
            where: data.field,
            cols: [[
                //表头
                {field: 'userName', title: '姓名', width: 130, edit: 'text'}
                , {field: 'userCardId', title: '身份证号', width: 130, edit: 'text'}
                , {field: 'cardId', title: '卡号', width: 130, edit: 'text'}
                , {field: 'userMobilePhone', title: '手机号', width: 130, edit: 'text'}
                , {field: 'userAddress', title: '家庭住址', width: 130, edit: 'text'}
                , {field: 'stat', title: '卡状态', width: 83, edit: 'text'}
                , {field: 'openDate', title: '开户日期', width: 120, edit: 'text'}
                , {fixed: 'right', width: 200, title: '操作', toolbar: '#freeze'}
            ]]
        });
        return false;
    });
    table.on('tool', function (obj) {
        var info = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值
        var tr = obj.tr; //获得当前行 tr 的DOM对象

        if (layEvent === 'edit1') {
            layer.confirm('确定冻结该银行卡？', function (index) {
                $.ajax({
                    url: "/operator/freezeUser",
                    type: "post",
                    data: info,
                    success: function (result) {
                        if (result.toString() == "true") {
                            layer.open({
                                title: '提示',
                                content: '该卡已经冻结，冻结成功！'
                            })
                        } else {
                            layer.open({
                                title: '提示',
                                content: '该卡不是正常状态不能冻结，操作失敗！'
                            })
                        }
                    },
                    error: function (result) {
                        layer.open({
                            title: '提示',
                            content: '操作失败'
                        })
                    }
                });
                return false;
                layer.close(index);
            })
        }
        else if (layEvent === 'edit2') {
            layer.confirm('确定激活该银行卡？', function (index) {
                $.ajax({
                    url: "/operator/upFreezeUser",
                    type: "post",
                    data: info,
                    success: function (result) {
                        if (result.toString() == "true") {
                            layer.open({
                                title: '提示',
                                content: '该卡已经正常，激活成功！'
                            })
                        } else {
                            layer.open({
                                title: '提示',
                                content: '该卡不是冻结状态不能激活，操作失敗！'
                            })
                        }
                    },
                    error: function (result) {
                        layer.open({
                            title: '提示',
                            content: '操作错误！'
                        })
                    }
                });
                return false;
                layer.close(index);
            })
        }
        else if (layEvent === 'edit3') {
            layer.confirm('确定挂失该银行卡？', function (index) {
                $.ajax({
                    url: "/operator/lostUser",
                    type: "post",
                    data: info,
                    success: function (result) {
                        if (result.toString() == "true") {
                            layer.open({
                                title: '提示',
                                content: '该卡已经挂失，挂失成功！'
                            })
                        } else {
                            layer.open({
                                title: '提示',
                                content: '该卡不是正常状态不能挂失，操作失敗！'
                            })
                        }
                    },
                    error: function (result) {
                        layer.open({
                            title: '提示',
                            content: '操作失败'
                        })
                    }
                });
                return false;
                layer.close(index);
            })
        }
        else if (layEvent === 'edit4') {
            layer.confirm('确定激活该银行卡？', function (index) {
                $.ajax({
                    url: "/operator/upLostUser",
                    type: "post",
                    data: info,
                    success: function (result) {
                        if (result.toString() == "true") {
                            layer.open({
                                title: '提示',
                                content: '该卡已经正常，激活成功！'
                            })
                        } else {
                            layer.open({
                                title: '提示',
                                content: '该卡不是挂失状态不能激活，操作失敗！'
                            })
                        }
                    },
                    error: function (result) {
                        layer.open({
                            title: '提示',
                            content: '操作错误！'
                        })
                    }
                });
                return false;
                layer.close(index);
            })
        }
    })
});
