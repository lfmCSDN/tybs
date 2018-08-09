layui.use(['table','form','jquery'], function () {
    var table = layui.table;
    var form = layui.form;
    var $ = layui.$;

    form.on('submit(formDemo)',function (data) {
        //第一个实例
        table.render({
            elem: '#User',
            height: 600,
            width:1053,
            url: '/operator/queryUser', //数据接口,
            page: true, //开启分页
            where:data.field,
            cols: [[ //表头
                 {field: 'userName', title: '姓名', width: 100, edit:'text'}
                , {field: 'userCardId', title: '身份证号', width: 130, edit:'text'}
                , {field: 'cardId', title: '卡号', width: 120, edit:'text'}
                , {field: 'userMobilePhone', title: '手机号', width: 103, edit:'text'}
                , {field: 'userAddress', title: '家庭住址',width:120, edit:'text'}
                , {field: 'stat', title: '卡状态',width:80, edit:'text'}
                , {field: 'oveage', title: '账户余额',width:120,edit: 'text'}
                , {field: 'openDate', title: '开户日期', width: 120, edit: 'text'}
                , {fixed: 'right', width:160, title:'操作', toolbar: '#user'}
            ]]
        });
        return false;
    });
    table.on('tool',function (obj) {
        var info = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值
        var tr = obj.tr; //获得当前行 tr 的DOM对象

        if (layEvent ==='del'){
            layer.confirm('确定注销？',function (index) {
                obj.del();
                $.ajax({
                    url:"/operator/deleteUser",
                    type:"post",
                    data:info,
                    success:function (a) {
                        layer.open({
                            title:'提示',
                            content:'注销成功！'
                        })
                    },
                    error:function (a) {
                        layer.open({
                            title:'提示',
                            content:'注销失败！'
                        })
                    }
                });
                return false;
                layer.close(index);
            });
        }
        else if (layEvent === 'edit'){
            layer.confirm('确定修改？',function (index) {
                $.ajax({
                    url:"/operator/updateUser",
                    type:"post",
                    data:info,
                    success:function (a) {
                        layer.open({
                            title:'提示',
                            content:'修改成功！'
                        })
                    },
                    error:function (a) {
                        layer.open({
                            title:'提示',
                            content:'修改失败!'
                        })
                    }
                });
                return false;
                layer.close(index);
            })
        }
    })
});