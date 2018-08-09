layui.use(['table','form','jquery'], function () {
    var table = layui.table;
    var form = layui.form;
    var $ = layui.$;

    form.on('submit(formDemo)',function (data) {
        //第一个实例
        table.render({
            elem: '#trans',
            height: 600,
            width:1053,
            url: '/acct/transList', //数据接口,
            page: true, //开启分页
            where:data.field,
            cols: [[ //表头
                {field: 'transName', title: '持卡姓名', width: 200, edit:'text'}
                , {field: 'transId', title: '银行卡号', width: 200, edit:'text'}
                , {field: 'transType', title: '交易类型', width: 200, edit:'text'}
                , {field: 'transAmount', title: '交易金额', width:200, edit:'text'}
                , {field: 'transTime', title: '交易时间',width:253, edit:'text'}
            ]]
        });
        return false;
    });
});