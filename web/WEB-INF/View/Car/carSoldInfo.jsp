<%--
  Created by IntelliJ IDEA.
  User: googo
  Date: 16/8/19
  Time: 下午3:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<title></title>
<link href="/web_resources/css/bootstrap-3.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="/web_resources/css/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
<script src="/web_resources/js/jquery.min.js"></script>
<script src="/web_resources/css/bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>
<script src="/web_resources/css/bootstrap-table/bootstrap-table.min.js"></script>



<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="row">
    <div class="col-lg-12">
        <h2>已售出车辆</h2>
        <div class="table-responsive">
            <table 	id="carSoldList"
                      data-show-columns="true">
            </table>
        </div>
    </div>
</div>


</body>

<script>
    function initData(){
        $.ajax({
            url:"${pageContext.request.contextPath}/Car/carSoldInfo",
            dataType: 'json',
            type: 'POST',
            success:function (data) {
                $('#carSoldList').bootstrapTable({
                    data:data,
                    dataType:'json',
                    search:true,
                    pagination:true,
                    pageList:[5,10,20,50],
                    pageSize:10,
                    pageNumber:1,
                    columns:[[
                        {
                            title: '车架号',
                            field: 'carId',
                            align: 'center',
                            rowspan:2,
                            valign: 'middle'
                        },
                        {
                            title: '车型',
                            colspan: 2,
                            align: 'center',
                            valign: 'middle'
                        },
                        {
                            title: '整车',
                            colspan: 4,
                            align: 'center',
                            valign: 'middle'
                        },
                        {
                            title: '返利',
                            field: 'payback',
                            align: 'center',
                            rowspan:2
                        },
                        {
                            title: '二手车',
                            colspan: 2,
                            align: 'center',
                            valign: 'middle'
                        },
                        {
                            title: '精品',
                            colspan: 2,
                            align: 'center',
                            valign: 'middle'
                        },
                        {
                            title: '保险',
                            colspan: 2,
                            align: 'center',
                            valign: 'middle'
                        },
                        {
                            title: '金融',
                            colspan: 2,
                            align: 'center',
                            valign: 'middle'
                        },
                        {
                            title: '服务费',
                            colspan: 2,
                            align: 'center',
                            valign: 'middle'
                        },
                        {
                            title: '延保',
                            colspan: 2,
                            align: 'center',
                            valign: 'middle'
                        },
                        {
                            title: '会员',
                            colspan: 2,
                            align: 'center',
                            valign: 'middle'
                        },
                        {
                            title: '租赁',
                            colspan: 2,
                            align: 'center',
                            valign: 'middle'
                        },
                        {
                            title: '价值链',
                            colspan: 2,
                            align: 'center',
                            valign: 'middle'
                        },
                        {
                            title: '单车综合毛利',
                            field: 'getMoney',
                            align: 'center',
                            rowspan:2,
                            valign: 'middle'
                        },
                        {
                            title: '变动费用',
                            field: 'dynamic',
                            align: 'center',
                            rowspan:2,
                            valign: 'middle'
                        },
                        {
                            title: '销售利润',
                            field:'earn',
                            align: 'center',
                            rowspan:2,
                            valign: 'middle'
                        }
                    ],[
                        {
                            title: '品牌',
                            field: 'brand',
                            align: 'center',
                            valign: 'middle',
                        },
                        {
                            title: 'SFX',
                            field: 'sfx',
                            align: 'center',
                            valign: 'middle',
                        },
                        {
                            title: '指导价',
                            field: 'price',
                            align: 'center',
                            valign: 'middle',
                        },
                        {
                            title: '折扣',
                            field: 'discount',
                            align: 'center',
                            valign: 'middle',
                        },
                        {
                            title: '成本价',
                            field: 'cost',
                            align: 'center',
                            valign: 'middle',
                        },
                        {
                            title: '毛利',
                            field: 'carEarn',
                            align: 'center',
                            valign: 'middle',
                        },
                        {
                            title: '收入',
                            field: 'secondHandCarGet',
                            align: 'center',
                            valign: 'middle',
                        },
                        {
                            title: '毛利',
                            field: 'secondHandCarEarn',
                            align: 'center',
                            valign: 'middle',
                        },
                        {
                            title: '收入',
                            field: 'giftGet',
                            align: 'center',
                            valign: 'middle',
                        },
                        {
                            title: '毛利',
                            field: 'giftEarn',
                            align: 'center',
                            valign: 'middle',
                        },
                        {
                            title: '收入',
                            field: 'insuranceGet',
                            align: 'center',
                            valign: 'middle',
                        },
                        {
                            title: '毛利',
                            field: 'insuranceEarn',
                            align: 'center',
                            valign: 'middle',
                        },
                        {
                            title: '收入',
                            field: 'financeGet',
                            align: 'center',
                            valign: 'middle',
                        },
                        {
                            title: '毛利',
                            field: 'financeEarn',
                            align: 'center',
                            valign: 'middle',
                        },
                        {
                            title: '收入',
                            field: 'serviceGet',
                            align: 'center',
                            valign: 'middle',
                        },
                        {
                            title: '毛利',
                            field: 'serviceEarn',
                            align: 'center',
                            valign: 'middle',
                        },
                        {
                            title: '收入',
                            field: 'longInsuranceGet',
                            align: 'center',
                            valign: 'middle',
                        },
                        {
                            title: '毛利',
                            field: 'longInsuranceEarn',
                            align: 'center',
                            valign: 'middle',
                        },
                        {
                            title: '收入',
                            field: 'VIPGet',
                            align: 'center',
                            valign: 'middle',
                        },
                        {
                            title: '毛利',
                            field: 'VIPEarn',
                            align: 'center',
                            valign: 'middle',
                        },
                        {
                            title: '收入',
                            field: 'rentGet',
                            align: 'center',
                            valign: 'middle',
                        },
                        {
                            title: '毛利',
                            field: 'rentEarn',
                            align: 'center',
                            valign: 'middle',
                        },
                        {
                            title: '收入',
                            field: 'peripheralGet',
                            align: 'center',
                            valign: 'middle',
                        },
                        {
                            title: '毛利',
                            field: 'peripheralEarn',
                            align: 'center',
                            valign: 'middle',
                        }
                    ]]
                });
            },
            error:function () {
                alert("内部错误");
            }

    })}

    initData();
</script>
</html>
