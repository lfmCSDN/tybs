layui.use(['table','form','jquery'], function () {
    var table = layui.table;
    var form = layui.form;
    var $ = layui.$;

    form.on('submit(formDemo)',function (data) {
    //第一个实例
    table.render({
        elem: '#queryUser',
        height: 600,
        width:1000,
        url: '/admin/queryOperator', //数据接口,
        page: true, //开启分页
        where:data.field,
        cols: [[ //表头
            {field: 'userOperInfoId', title: '操作员号', width: 120}
            , {field: 'operName', title: '姓名', width: 120, edit:'text'}
            , {field: 'operCardId', title: '身份证号', width: 120, edit:'text'}
            , {field: 'operMobilPhone', title: '手机号', width: 120, edit:'text'}
            , {field: 'operEmail', title: '邮箱', width: 120, edit:'text'}
            , {field: 'operTel', title: '电话号码',width:120, edit:'text'}
            , {field: 'operStatu', title: '状态',width:120, edit:'text'}
            , {fixed: 'right', width:160, title:'操作', toolbar: '#oper'}
        ]]
    });
    return false;
    });
    table.on('tool',function (obj) {
        var info = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值
        var tr = obj.tr; //获得当前行 tr 的DOM对象

        if (layEvent ==='del'){
            layer.confirm('确定删除？',function (index) {
                obj.del();
                $.ajax({
                    url:"/admin/deleteOperator",
                    type:"post",
                    data:info,
                    success:function (a) {
                        layer.open({
                            title:'提示',
                            content:'删除成功'
                        })
                        location.reload();
                    },
                    error:function (a) {
                        layer.open({
                            title:'提示',
                            content:'删除失败'
                        })
                    }
                });
                return false;
                layer.close(index);
            });
        }else if (layEvent === 'edit'){
            layer.confirm('确定修改？',function (index) {
                $.ajax({
                    url:"/admin/update",
                    type:"post",
                    data:info,
                    success:function (a) {
                        layer.open({
                            title:'提示',
                            content:'修改成功'
                        })
                    },
                    error:function (a) {
                        layer.open({
                            title:'提示',
                            content:'修改失败'
                        })
                    }
                });
                return false;
                layer.close(index);
            })
        }
    })
});