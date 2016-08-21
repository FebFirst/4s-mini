<%--
  Created by IntelliJ IDEA.
  User: googo
  Date: 16/8/20
  Time: 下午10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单跟进完善</title>
</head>

<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>


<body>
<form class="mywrapper form-horizontal" id="formSaleImpl" method="post">

    <div class="form-group">
        <label class="col-sm-2 control-label">订单号：</label>
        <div class="col-sm-7">
            <input id="orderId" name="orderId" class="form-control" value="${order.orderID}" readonly="readonly"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">顾客编号：</label>
        <div class="col-sm-7">
            <input id="customer" class="form-control" value="${order.customerID}" readonly="readonly"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">车架号：</label>
        <label class="control-label" id="carId">${car.carID}</label>
        <label  class="col-sm-2 control-label"></label>
        <input class="btn btn-primary" value="车辆详情" onclick="carInfoShow()" readonly="readonly"/>
    </div>
    <div id = "gift">
    <c:forEach items="${gifts}" var="gift">
        <div class="form-group">
            <label class="col-sm-2 control-label">精品${gift.name}应收款：</label>
            <div class="col-sm-4">
                <label  class="col-sm-2 control-label">${gift.default_price}</label>
            </div>
            <label class="col-sm-2 control-label">精品${gift.name}已收款：</label>
            <div class="col-sm-4">
                <input name="${gift.giftID}" class="form-control" placeholder="${gift.default_price}"/>
            </div>
        </div>
    </c:forEach>
    </div>
    <c:forEach items="${insurances}" var="insurance">
        <div class="form-group">
            <label class="col-sm-2 control-label">保险${insurance.name}应收款：</label>
            <div class="col-sm-4">
                <label  class="col-sm-2 control-label" >${insurance.default_price}</label>
            </div>
            <label class="col-sm-2 control-label">保险${insurance.name}已收款：</label>
            <div class="col-sm-4">
                <input id="${insurance.insuranceID}"  class="form-control" placeholder="${insurance.default_price}"/>
            </div>
        </div>
    </c:forEach>




    <div class="form-group">
        <div class="col-sm-2"></div>
        <div class="col-sm-7" id="msg">
            <input class="btn btn-primary" value="提交" onclick="updateOrder()"/>
        </div>
    </div>
</form>

<div class="modal fade" id="carModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close"
                        data-dismiss="modal" aria-hidden="true">
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    车辆详情
                </h4>
            </div>
            <div class="modal-body">

                <div class="form-group  required"><label class="control-label">厂家：</label>
                    <label class="control-label">${car.garage}</label>
                </div>
                <div class="form-group  required"> <label class="control-label">型号：</label>
                    <label class="control-label">${car.brand}</label>
                </div>

                <div class="form-group  required"> <label class="control-label">SFX：</label>
                    <label class="control-label">${car.sfx}</label>
                </div>
                <div class="form-group  required">  <label class="control-label">颜色：</label>
                    <label class="control-label">${car.color}</label>
                </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default"
                        data-dismiss="modal">关闭
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script>
    function carInfoShow() {
        $('#carModal').modal('show');
    }

    function updateOrder() {
        var giftInput = document.getElementById("gift");
        var giftData = [];

        var length = gifts.length;

        var actualGetMoney;
        var i;
        var key;
        var info;

        if(giftInput != null) {
            var gifts = giftInput.getElementsByTagName("input");


            for (i = 0; i < length; i++) {
                actualGetMoney = gifts[i].value;
                if (actualGetMoney != "") {
                    key = gifts[i].name;
                    info = {money: actualGetMoney, giftId:key};

                    giftData.push(info);
                }
            }

        }


        var insuranceInput = document.getElementById("insurance");
        var insuranceData = [];

        if(insuranceInput != null) {
            var insurances = insuranceInput.getElementsByTagName("input");
            length = insurances.length;

            for (i = 0; i < length; i++) {
                actualGetMoney = insurances[i].value;

                if (actualGetMoney != "") {
                    key = insurances[i].name;
                    info = {money: actualGetMoney, insuranceId:key};

                    insuranceData.push(info);
                }
            }
        }

        var data = {"orderId":"${order.orderID}","gifts":JSON.stringify(giftData),"insurances":JSON.stringify(insuranceData)};
        var url = "${pageContext.request.contextPath}/Order/orderWaitressImpl";

//        alert(JSON.stringify(data));
        post(url,data);
    }

    function post(url, params) {
        var temp = document.createElement("form");
        temp.action = url;
        temp.method = "post";
        temp.style.display = "none";
        for (var x in params) {
            var opt = document.createElement("input");
            opt.name = x;
            opt.value = params[x];
            temp.appendChild(opt);
        }
        document.body.appendChild(temp);
        temp.submit();
        return temp;
    };
</script>

</body>
</html>

