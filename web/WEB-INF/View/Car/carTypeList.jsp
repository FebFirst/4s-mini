<%--
  Created by IntelliJ IDEA.
  User: googo
  Date: 16/8/11
  Time: 下午9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>车辆列表</title>
</head>
<body>
<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>
<div class="mywrapper form-group">
    <div class="col-sm-2"></div>
    <div class="col-sm-8">
        <table class="table table-bordered table-responsive">
            <thead>
            <tr>
                <th>厂家</th>
                <th>品牌</th>
                <th>SFX</th>
                <th>颜色</th>
                <th>计划</th>
                <th>订单</th>
                <th>库存</th>
                <th>请求订车数</th>
                <th>成本</th>
                <th>指导价</th>
                <th>折让</th>
                <th colspan=5>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${carTypes}" var="carType">
                <tr>
                    <td>${carType.garage}</td>
                    <td>${carType.brand}</td>
                    <td>${carType.carSfx}</td>
                    <td>${carType.carColor}</td>

                    <td>${carType.plan}</td>
                    <td>${carType.order}</td>
                    <td>${carType.stock}</td>
                    <td>${carType.requestNumber}</td>

                    <td>${carType.cost}</td>
                    <td>${carType.price}</td>
                    <td>${carType.discount}</td>

                    <td><button type="button" class="btn btn-primary" onclick="deleteCarType('${carType.garage}','${carType.brand}','${carType.carSfx}','${carType.carColor}')">删除</button></td>
                    <td><button type="button" class="btn btn-primary" onclick="updatePlan('${carType.garage}','${carType.brand}','${carType.carSfx}','${carType.carColor}')">添加计划</button></td>
                    <td><button type="button" class="btn btn-primary" onclick="window.location='#'">设置价格</button></td>
                    <td><button type="button" class="btn btn-primary" onclick="getStock('${carType.garage}','${carType.brand}','${carType.carSfx}','${carType.carColor}')">查看库存</button></td>
                    <td><button type="button" class="btn btn-primary" onclick="stockRegister('${carType.garage}','${carType.brand}','${carType.carSfx}','${carType.carColor}')">向厂家订车请求</button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script>
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

    function stockRegister(garage,brand,sfx,color){
        var data = {"garage":garage, "brand":brand,"sfx":sfx,"color":color};
        post("${pageContext.request.contextPath}/Car/createCarByCarType", data);
    };

    function updatePlan(garage,brand,sfx,color) {
        var data = {"garageBrand":garage, "brand":brand,"sfx":sfx,"color":color};
        post("${pageContext.request.contextPath}/Car/updateCarTypePlanPage", data);
    };

    function getStock(garage,brand,sfx,color) {
        var data = {"garage":garage, "brand":brand,"sfx":sfx,"color":color};
        post("${pageContext.request.contextPath}/Car/carListByCarType", data);
    };

    function deleteCarType(garage,brand,sfx,color){
        var data = {"garage":garage, "brand":brand,"sfx":sfx,"color":color};
        post("${pageContext.request.contextPath}/Car/deleteCarType", data);
        <%--var temp = document.createElement("form");--%>
        <%--temp.action = "${pageContext.request.contextPath}/Car/deleteCarType";--%>
        <%--temp.method = "POST";--%>
        <%--temp.style.display = "none";--%>
        <%--var opt1 = document.createElement("textarea");--%>
        <%--opt1.name = "garage";--%>
        <%--opt1.value = garage;--%>
        <%--var opt2 = document.createElement("textarea");--%>
        <%--opt2.name = "brand";--%>
        <%--opt2.value = brand;--%>
        <%--var opt3 = document.createElement("textarea");--%>
        <%--opt3.name = "color";--%>
        <%--opt3.value = color;--%>
        <%--var opt4 = document.createElement("textarea");--%>
        <%--opt4.name = "sfx";--%>
        <%--opt4.value = sfx;--%>
        <%--temp.appendChild(opt1);--%>
        <%--temp.appendChild(opt2);--%>
        <%--temp.appendChild(opt3);--%>
        <%--temp.appendChild(opt4);--%>
        <%--document.body.appendChild(temp);--%>
        <%--temp.submit();--%>
        <%--return temp;--%>
    };
</script>

<script>

</script>
<jsp:include page="../Site/footer.jsp"/>
</body>
</html>
