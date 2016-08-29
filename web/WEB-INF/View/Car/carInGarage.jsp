<%--
  Created by IntelliJ IDEA.
  User: googo
  Date: 16/8/25
  Time: 下午9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>已订车辆列表</title>
</head>
<body>
<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>

<div class="mywrapper form-group">
    <div class="col-sm-12">
        <table class="table table-bordered table-responsive">
            <thead>
            <tr>
                <th>车架号</th>
                <th>厂家</th>
                <th>品牌</th>
                <th>配置</th>
                <th>颜色</th>
                <th>库存状态</th>
                <th>成本</th>
                <th>指导价</th>
                <th>折扣</th>
                <th>返利</th>
                <th>订车日</th>
                <th>在途日</th>
                <th>入库日</th>
                <th>计划出库日</th>
                <th>计划交车日</th>

            </tr>
            </thead>
            <tbody id="carInfo">
            <c:forEach items="${cars}" var="car">
                <tr>
                    <td>${car.key.carID}</td>
                    <td>${car.key.garage}</td>
                    <td>${car.key.brand}</td>
                    <td>${car.key.sfx}</td>
                    <td>${car.key.color}</td>
                    <td>${car.key.stockStatus}</td>
                    <td>${car.key.cost}</td>
                    <td>${car.key.price}</td>
                    <td>${car.key.discount}</td>
                    <td>${car.key.payback}</td>
                    <td>${car.key.predictedTime}</td>
                    <td>${car.key.purchasedTime}</td>
                    <td>${car.key.inGarageTime}</td>
                    <td>${car.value.outGarageTime}</td>
                    <td>${car.value.submitTime}</td>


                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<jsp:include page="../Site/footer.jsp"/>

</body>
</html>


