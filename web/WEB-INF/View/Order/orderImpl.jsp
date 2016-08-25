<%--
  Created by IntelliJ IDEA.
  User: googo
  Date: 16/8/20
  Time: 下午7:52
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
<form class="mywrapper form-horizontal" id="formAddGarage" method="post" action="${pageContext.request.contextPath}/Order/orderImplementation">

    <div class="form-group">
        <label class="col-sm-2 control-label">订单号：</label>
        <div class="col-sm-7">
            <input id="orderId" name="orderId" class="form-control" value="${orderId}" readonly="readonly"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">顾客姓名：</label>
        <div class="col-sm-7">
            <input id="customer" class="form-control" value="${customer}" readonly="readonly"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">车架号：</label>
        <label class="control-label" id="carId">${car.carID}</label>
        <label  class="col-sm-2 control-label"></label>
        <input class="btn btn-primary" value="车辆详情" onclick="carInfoShow()" readonly="readonly"/>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">整车应收款：</label>
        <div class="col-sm-4">
            <input id="sellPrice" class="form-control" value="${car.price}" readonly="readonly"/>
        </div>
        <label class="col-sm-2 control-label">整车已收款：</label>
        <div class="col-sm-4">
            <input id="actualGetMoney" name="actualGetMoney" class="form-control"/>
        </div>
    </div>


    <div class="form-group">
        <label class="col-sm-2 control-label">二手车置换价值：</label>
        <div class="col-sm-7">
            <input id="secondCar" class="form-control" />
        </div>
    </div>
    <c:forEach item="${gifts}" var="gift">
    <div class="form-group">
        <label class="col-sm-2 control-label">精品${gift.name}应收款：</label>
        <div class="col-sm-4">
            <input id="giftPrice" class="form-control" value="${gift.price}" readonly="readonly"/>
        </div>
        <label class="col-sm-2 control-label">精品${gift.name}已收款：</label>
        <div class="col-sm-4">
            <input id="${gift.giftI}" name="giftGetMoney" class="form-control"/>
        </div>
    </div>
    </c:forEach>

    <c:forEach item="${insurances}" var="insurance">
        <div class="form-group">
            <label class="col-sm-2 control-label">保险${insurance.name}应收款：</label>
            <div class="col-sm-4">
                <input id="insurancePrice" class="form-control" value="${insurance.price}" readonly="readonly"/>
            </div>
            <label class="col-sm-2 control-label">保险${insurance.name}已收款：</label>
            <div class="col-sm-4">
                <input id="${insurance.insuranceID}"  class="form-control"/>
            </div>
        </div>
    </c:forEach>


        <div class="form-group">
            <label class="col-sm-2 control-label">分期应收款：</label>
            <div class="col-sm-4">
                <input id="financePrice" class="form-control" value="${finance.default_price}" readonly="readonly"/>
            </div>
            <label class="col-sm-2 control-label">分期已收款：</label>
            <div class="col-sm-4">
                <input id="${finance.additionalProductID}"  class="form-control"/>
            </div>
        </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">上牌应收款：</label>
        <div class="col-sm-4">
            <input id="cardPrice" class="form-control" value="${card.default_price}" readonly="readonly"/>
        </div>
        <label class="col-sm-2 control-label">上牌已收款：</label>
        <div class="col-sm-4">
            <input id="${finance.additionalProductID}"  class="form-control"/>
        </div>
    </div>


    <c:forEach item="${longTerm}" var="long">
    <div class="form-group">
        <label class="col-sm-2 control-label">延保${long.name}应收款：</label>
        <div class="col-sm-4">
            <input id="longPrice" class="form-control" value="${long.default_price}" readonly="readonly"/>
        </div>
        <label class="col-sm-2 control-label">延保${long.name}已收款：</label>
        <div class="col-sm-4">
            <input id="${long.additionalProductID}" class="form-control"/>
        </div>
    </div>
    </c:forEach>

    <div class="form-group">
        <label class="col-sm-2 control-label">会员应收款：</label>
        <div class="col-sm-4">
            <input id="VIPPrice" class="form-control" value="${VIP.default_price}" readonly="readonly"/>
        </div>
        <label class="col-sm-2 control-label">分期已收款：</label>
        <div class="col-sm-4">
            <input id="${VIP.additionalProductID}"  class="form-control"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">租赁应收款：</label>
        <div class="col-sm-4">
            <input id="rentPrice" class="form-control" value="${rent.default_price}" readonly="readonly"/>
        </div>
        <label class="col-sm-2 control-label">租赁已收款：</label>
        <div class="col-sm-4">
            <input id="${rent.additionalProductID}"  class="form-control"/>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-2"></div>
        <div class="col-sm-7" id="msg">
            <input class="btn btn-primary" value="提交" onclick="existsChecking()"/>
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

</body>
</html>
