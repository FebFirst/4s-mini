<%--
  Created by IntelliJ IDEA.
  User: googo
  Date: 16/8/12
  Time: 下午7:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单详情</title>
</head>
<body>
<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>
<div class="col-sm-12">
    <div class="col-sm-2"></div>
    <div class="col-sm-8">
        <table class="table table-bordered table-responsive">
            <caption>订单信息</caption>
            <thead>
            <tr>
                <th>订单号</th>
                <th>应收款</th>
                <th>实收款</th>
                <th>销售员</th>
                <th>销售日期</th>
                <th>预计付款时间</th>
                <th>备注</th>
            </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${order.orderID}</td>
                    <td>${order.salePrice}</td>
                    <td>${order.actualGetMoney}</td>
                    <td>${order.salesmanID}</td>
                    <td>${order.date}</td>
                    <th>${order.predicted_pay_time}</th>
                    <td>${order.remark}</td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
<div class="col-sm-12">
    <div class="col-sm-2"></div>
    <div class="col-sm-8">
        <table class="table table-bordered table-responsive">
            <caption>车辆信息</caption>
            <thead>
            <tr>
                <th>车架号</th>
                <th>厂家</th>
                <th>品牌</th>
                <th>SFX</th>
                <th>颜色</th>
                <th>入库时间</th>
                <th>库存状态</th>
                <th>成本</th>
                <th>指导价</th>
                <th>折扣</th>
                <th>返利</th>
                <%--<th>车龄</th>--%>

            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${car.carID}</td>
                <td>${car.garage}</td>
                <td>${car.brand}</td>
                <td>${car.sfx}</td>
                <td>${car.color}</td>
                <td>${car.purchasedTime}</td>
                <td>${car.stockStatus}</td>
                <td>${car.cost}</td>
                <td>${car.price}</td>
                <td>${car.discount}</td>
                <th>${car.payback}</th>
                <%--<td>${car.value}</td>--%>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<%--<div class="mywrapper form-group">--%>
<div>
    <div class="col-sm-2"></div>
    <div class="col-sm-8">
        <table class="table table-bordered table-responsive">
            <caption>精品</caption>
            <thead>
            <tr>
                <th>编号</th>
                <th>名称</th>
                <th>品牌</th>
                <th>成本</th>
                <th>标价</th>
                <th>折扣</th>
                <th>应售价</th>
                <th>实际收款</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${gifts}" var="gift">
            <tr>
                <td>${gift.giftID}</td>
                <td>${gift.name}</td>
                <td>${gift.brand}</td>
                <td>${gift.cost}</td>
                <td>${gift.default_price}</td>
                <td>${gift.discount}</td>
                <td>${gift.selling_price}</td>
                <td>${gift.actualGetMoney}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<jsp:include page="../Site/footer.jsp"/>
</body>
</html>