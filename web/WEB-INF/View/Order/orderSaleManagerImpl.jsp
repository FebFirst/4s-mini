<%--
  Created by IntelliJ IDEA.
  User: googo
  Date: 16/8/20
  Time: 下午10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单跟进完善</title>
</head>

<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>


<body>
<form class="mywrapper form-horizontal" id="formSaleManagerImpl" method="post">

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


<c:choose>
        <c:when test="${financeMsg.equals('YES')}">
    <div class="form-group">
        <label class="col-sm-2 control-label">分期应收款：</label>
        <div class="col-sm-4">
            <label class="col-sm-2 control-label" >${finance.default_price}</label>
        </div>
        <label class="col-sm-2 control-label">分期已收款：</label>
        <div class="col-sm-4">
            <input placeholder="${finance.additionalProductID}"  class="form-control" id="finance"/>
        </div>
    </div>
        </c:when>

    <c:when test="${cardMsg.equals('YES')}">
        <div class="form-group">
            <label class="col-sm-2 control-label">上牌应收款：</label>
            <div class="col-sm-4">
                <label class="col-sm-2 control-label" >${card.default_price}</label>
            </div>
            <label class="col-sm-2 control-label">上牌已收款：</label>
            <div class="col-sm-4">
                <input placeholder="${card.default_price}"  class="form-control" id="card"/>
            </div>
        </div>

    </c:when>
    </c:choose>

<div id="long">
    <c:forEach items="${longTerm}" var="long">
        <div class="form-group">
            <label class="col-sm-2 control-label">延保${long.name}应收款：</label>
            <div class="col-sm-4">
                <label class="col-sm-2 control-label" >${long.default_price}</label>
            </div>
            <label class="col-sm-2 control-label">延保${long.name}已收款：</label>
            <div class="col-sm-4">
                <input placeholder="${long.default_price}" class="form-control" name="${long.additionalProductID}"/>
            </div>
        </div>
    </c:forEach>
</div>
<c:choose>
<c:when test="${VIPMsg.equals('YES')}">
    <div class="form-group">
        <label class="col-sm-2 control-label">会员应收款：</label>
        <div class="col-sm-4">
            <label class="col-sm-2 control-label" >${VIP.default_price}</label>
        </div>
        <label class="col-sm-2 control-label">会员已收款：</label>
        <div class="col-sm-4">
            <input id="vip"  class="form-control" placeholder="${VIP.default_price}"/>
        </div>
    </div>
</c:when>
    <c:when test="${rentMsg.equals('YES')}">
    <div class="form-group">
        <label class="col-sm-2 control-label">租赁应收款：</label>
        <div class="col-sm-4">
            <label class="col-sm-2 control-label" >${rent.default_price}</label>
        </div>
        <label class="col-sm-2 control-label">租赁已收款：</label>
        <div class="col-sm-4">
            <input id="rent"  class="form-control" placeholder="${rent.default_price}"/>
        </div>
    </div>
    </c:when>
    <c:when test="${hireMsg.equals('YES')}">
    <div class="form-group">
        <label class="col-sm-2 control-label">佣金应收款：</label>
        <div class="col-sm-4">
            <label class="col-sm-2 control-label" >${hire.default_price}</label>
        </div>
        <label class="col-sm-2 control-label">佣金已收款：</label>
        <div class="col-sm-4">
            <input id="hire"  class="form-control" placeholder="${hire.default_price}"/>
        </div>
    </div>

    </c:when>
    <c:when test="${presentMsg.equals('YES')}">
    <div class="form-group">
        <label class="col-sm-2 control-label">赠送应收款：</label>
        <div class="col-sm-4">
            <label class="col-sm-2 control-label" >${present.default_price}</label>
        </div>
        <label class="col-sm-2 control-label">赠送已收款：</label>
        <div class="col-sm-4">
            <input id="present"  class="form-control" placeholder="${present.default_price}"/>
        </div>
    </div>
    </c:when>
</c:choose>
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
        var orderId = "${order.orderID}";

        var finance = document.getElementById("finance");
        var card = document.getElementById("card");
        var VIP = document.getElementById("vip");
        var rent = document.getElementById("rent");
        var hire = document.getElementById("hire");


        var key ;
        var value;
        var financeData = [];
        var cardData = [];
        var VIPData = [];
        var rentData = [];
        var hireData = [];
        if(finance != null) {
            key = "${finance.additionalProductID}";
            value = finance.value;

            financeData.push({key:key, value: value});
        }
        if(card != null){
            key = "${card.additionalProductID}";
            value = card.value;

            cardData.push({key:key, value: value});
        }
        if(VIP != null){
            key = "${VIP.additionalProductID}";
            value = VIP.value;

            VIPData.push({key:key, value: value});
        }
        if(rent != null){
            key = "${rent.additionalProductID}";
            value = rent.value;

            rentData.push({key:key, value: value});
        }

        if(hire != null){
            key = "${hire.additionalProductID}";
            value = hire.value;

            hireData.push({key:key, value: value});
        }

        var longInput = document.getElementById("long");
        var longData = [];
        if(longInput != null) {
            var long = longInput.getElementsByTagName("input");
            var length = long.length;

            var i;
            var info;

            for (i = 0; i < length; i++) {
                value = long[i].value;
                if (value != "") {
                    key = long[i].name;
                    info = {value: value, key:key};

                    longData.push(info);
                }
            }

        }

        var data = {"orderId": orderId, "finance":JSON.stringify(financeData),"card":JSON.stringify(cardData),"VIP":JSON.stringify(VIPData),
                    "rent" : JSON.stringify(rentData),"hire":JSON.stringify(hireData),"longTerm":JSON.stringify(longData)};

        var url = "${pageContext.request.contextPath}/Order/orderSaleManagerImpl";

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

