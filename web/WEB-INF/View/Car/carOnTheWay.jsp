<%--
  Created by IntelliJ IDEA.
  User: googo
  Date: 16/8/25
  Time: 下午8:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>在途车辆列表</title>
</head>
<body>
<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>

<%--<div id="search-box">--%>
<%--<div class="form-group">--%>
<%--<label class="col-sm-1 control-label">按厂家搜索:</label>--%>
<%--<div class="col-sm-1" id ="garage_div">--%>
<%--<select class="form-control" name="garage" id="garage" >--%>
<%--<option value="empty"></option>--%>
<%--<c:forEach items="${garages}" var="garage">--%>
<%--<option value="${garage.brand}">${garage.brand}</option>--%>
<%--</c:forEach>--%>
<%--</select>--%>
<%--</div>--%>
<%--</div>--%>

<%--<div class="form-group">--%>
<%--<label class="col-sm-1 control-label">按车型搜索:</label>--%>
<%--<div class="col-sm-1" id ="brand_div">--%>
<%--<select class="form-control" name="brand" id="carbrand" >--%>
<%--<option value="empty"></option>--%>
<%--<c:forEach items="${brands}" var="brand">--%>
<%--<option value="${brand.brand}">${brand.brand}</option>--%>
<%--</c:forEach>--%>
<%--</select>--%>
<%--</div>--%>
<%--</div>--%>

<%--<div class="form-group">--%>
<%--<label class="col-sm-1 control-label">按SFX搜索:</label>--%>
<%--<div class="col-sm-1" id ="sfx_div">--%>
<%--<select class="form-control" name="sfx" id="sfx">--%>
<%--<option value="empty"></option>--%>
<%--<c:forEach items="${sfxes}" var="sfx">--%>
<%--<option value="${sfx.sfx}">${sfx.sfx}</option>--%>
<%--</c:forEach>--%>
<%--</select>--%>
<%--</div>--%>
<%--</div>--%>

<%--<div class="form-group">--%>
<%--<label class="col-sm-1 control-label">按颜色搜索:</label>--%>
<%--<div class="col-sm-1" id ="color_div">--%>
<%--<select class="form-control" name="color" id="color">--%>
<%--<option value="empty"></option>--%>
<%--<c:forEach items="${colors}" var="color">--%>
<%--<option value="${color.color}">${color.color}</option>--%>
<%--</c:forEach>--%>
<%--</select>--%>
<%--</div>--%>
<%--</div>--%>

<%--<div class="form-group">--%>

<%--<div class="col-sm-1" id="msg">--%>
<%--<input class="btn btn-primary" value="点击搜索" onclick="carSelect()" readonly="readonly"/>--%>
<%--</div>--%>
<%--<div class="col-sm-1"></div>--%>
<%--</div>--%>

<%--</div>--%>
<div class="mywrapper form-group">
    <div class="col-sm-12">
        <table class="table table-bordered table-responsive">
            <thead>
            <tr>
                <th>厂家</th>
                <th>品牌</th>
                <th>SFX</th>
                <th>颜色</th>
                <th>库存状态</th>
                <th>成本</th>
                <th>指导价</th>
                <th>折扣</th>
                <th>返利</th>
                <th>计划订车日</th>
                <th>计划在途日</th>
                <th>计划入库日</th>
                <th>计划出库日</th>
                <th>计划交车日</th>
                <th>订车日</th>
                <th>在途日</th>
                <th colspan=2>操作</th>
            </tr>
            </thead>
            <tbody id="carInfo">
            <c:forEach items="${cars}" var="car">
                <tr>
                    <td>${car.key.garage}</td>
                    <td>${car.key.brand}</td>
                    <td>${car.key.sfx}</td>
                    <td>${car.key.color}</td>
                    <td>${car.key.stockStatus}</td>
                    <td>${car.key.cost}</td>
                    <td>${car.key.price}</td>
                    <td>${car.key.discount}</td>
                    <td>${car.key.payback}</td>
                    <td>${car.value.predictedTime}</td>
                    <td>${car.value.purchasedTime}</td>
                    <td>${car.value.inGarageTime}</td>
                    <td>${car.value.outGarageTime}</td>
                    <td>${car.value.submitTime}</td>
                    <td>${car.key.predictedTime}</td>
                    <td>${car.key.purchasedTime}</td>
                    <td><button type="button" class="btn btn-primary" onclick="showModal('${car.key.carID}')">入库登记</button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div class="modal fade" id="carModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close"
                        data-dismiss="modal" aria-hidden="true">
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    单车预警
                </h4>
            </div>
            <div class="modal-body">
                <div class="form-group  required"><label class="control-label">填写车架号：</label>
                    <input id="newCarId" placeholder="填写车架号" required="required">
                </div>
                <div class="form-group  required" style="visibility: hidden">
                    <input id="oldCarId">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default"
                        data-dismiss="modal">关闭
                </button>

                <button type="button" class="btn btn-default"
                        onclick="updateCarId()">确定
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<jsp:include page="../Site/footer.jsp"/>

<script>
    function showModal(oldCarId) {
        document.getElementById("oldCarId").value = oldCarId;
        $('#carModal').modal('show');
    }

    function updateCarId() {
        var old = document.getElementById("oldCarId").value;
        var newId = document.getElementById("newCarId").value;

        var data = {"oldId":old,"newId":newId};
        var url = "${pageContext.request.contextPath}/Car/carStock";
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
<%--<script>--%>
<%--&lt;%&ndash;显示预警&ndash;%&gt;--%>
<%--function predict(carId) {--%>

<%--var day = document.getElementById("dayLeft");--%>
<%--var earn = document.getElementById("earn");--%>
<%--$.ajax({--%>
<%--url:"${pageContext.request.contextPath}/Car/predict",--%>
<%--data:{"carId":carId},--%>
<%--type:'POST',--%>
<%--dataTpe:'JSON',--%>
<%--cache:true,--%>
<%--success:function (data) {--%>
<%--//alert(JSON.stringify(data));--%>
<%--day.innerHTML = data.day;--%>
<%--earn.innerHTML = data.loss;--%>
<%--},--%>
<%--error:function () {--%>
<%--day.innerHTML = "内部错误";--%>
<%--earn.innerHTML = "内部错误";--%>
<%--}--%>

<%--});--%>
<%--$('#carModal').modal('show');--%>
<%--}--%>
<%--</script>--%>
<%--<script>--%>
<%--&lt;%&ndash;搜索过滤功能&ndash;%&gt;--%>
<%--&lt;%&ndash;function redirectBuy(carId) {&ndash;%&gt;--%>
<%--&lt;%&ndash;window.location="${pageContext.request.contextPath}" +  "/Order/addCarToOrder/" + carId;&ndash;%&gt;--%>
<%--&lt;%&ndash;}&ndash;%&gt;--%>
<%--&lt;%&ndash;function redirectCost(carId) {&ndash;%&gt;--%>
<%--&lt;%&ndash;window.location="${pageContext.request.contextPath}" +  "/Car/setCost/" + carId;&ndash;%&gt;--%>
<%--&lt;%&ndash;}&ndash;%&gt;--%>
<%--&lt;%&ndash;function redirectStock(carId) {&ndash;%&gt;--%>
<%--&lt;%&ndash;window.location="${pageContext.request.contextPath}" +  "/Car/setStockStatus/" + carId;&ndash;%&gt;--%>
<%--&lt;%&ndash;}&ndash;%&gt;--%>

<%--//    $(document).ready(function() {--%>
<%--//        carSelect();--%>
<%--//    });--%>

<%--function formatTime(time) {--%>
<%--var year= 1900;--%>
<%--var month = 1;--%>

<%--year += time.year;--%>
<%--month += time.month;--%>
<%--var result = year + "-" + month + "-" + time.date +" " + time.hours + ":" +time.minutes;--%>

<%--return result;--%>
<%--}--%>
<%--//--%>
<%--//    function statusChose(status) {--%>
<%--//        var result;--%>
<%--//        if(status == '在途'){--%>
<%--//            result = '入库';--%>
<%--//        }else if(status == '在库'){--%>
<%--//            result = '出库';--%>
<%--//        }else if(status == '出库'){--%>
<%--//            result = '交车';--%>
<%--//        }else if(status == '交车'){--%>
<%--//            result = '已交车';--%>
<%--//        }else if(status == '订车'){--%>
<%--//            result = '在途';--%>
<%--//        }else{--%>
<%--//            result = '车辆状态错误';--%>
<%--//        }--%>
<%--//        return result--%>
<%--//    }--%>
<%--function carSelect() {--%>
<%--var garage = document.getElementById("garage");--%>
<%--var brand = document.getElementById("carbrand");--%>
<%--var sfx = document.getElementById("sfx");--%>
<%--var color = document.getElementById("color");--%>

<%--var index = garage.selectedIndex;--%>
<%--var gValue = garage.options[index].value;--%>

<%--index = brand.selectedIndex;--%>
<%--var bValue = brand.options[index].value;--%>

<%--index = sfx.selectedIndex;--%>
<%--var sValue = sfx.options[index].value;--%>

<%--index = color.selectedIndex;--%>
<%--var cValue = color.options[index].value;--%>

<%--$.ajax({--%>
<%--url:"${pageContext.request.contextPath}/Car/select",--%>
<%--data:{"garage":gValue,"brand":bValue,"sfx":sValue,"color":cValue},--%>
<%--type:'POST',--%>
<%--dataType:'JSON',--%>
<%--cache:true,--%>
<%--success:function(data){--%>
<%--var jsonObj=eval(data);--%>
<%--var table = document.getElementById("carInfo");--%>
<%--table.innerHTML = "";--%>
<%--$.each(jsonObj, function (i, item) {--%>
<%--var purchasedTime = formatTime(item.purchasedTime);--%>
<%--var predictedTime = formatTime(item.predictedTime);--%>
<%--var inGarageTime = formatTime(item.inGarageTime);--%>
<%--var outGarageTime = formatTime(item.outGarageTime);--%>
<%--table.innerHTML = table.innerHTML + " <tr>" +--%>
<%--"<td>" + item.carID + "</td>" +--%>
<%--"<td>" + item.garage + "</td>" +--%>
<%--"<td>" + item.brand + "</td>" +--%>
<%--"<td>" + item.sfx + "</td>" +--%>
<%--"<td>" + item.color + "</td>" +--%>
<%--"<td>" + item.stockStatus + "</td>" +--%>
<%--"<td>" + item.cost + "</td>" +--%>
<%--"<td>" + item.price + "</td>" +--%>
<%--"<td>" + item.discount + "</td>" +--%>
<%--"<td>" + item.payback + "</td>" +--%>
<%--"<td>" + item.age + "</td>" +--%>
<%--"<td>" + predictedTime + "</td>" +--%>
<%--"<td>" + purchasedTime + "</td>" +--%>
<%--"<td>" + inGarageTime + "</td>" +--%>
<%--"<td>" + outGarageTime + "</td>" +--%>
<%--'<td><button type="button" class="btn btn-primary" onclick= "redirectBuy(\'' + item.carID + '\')">购买</button></td>' +--%>
<%--'<td><button type="button" class="btn btn-primary" onclick= "redirectCost(\''+item.carID + '\')">设置成本</button></td>' +--%>
<%--'<td><button type="button" class="btn btn-primary" onclick= "redirectStock(\''+item.carID+'\')">' + statusChose(item.stockStatus) + '</button></td>' +--%>
<%--'<td><button type="button" class="btn btn-primary" onclick= "predict(\''+item.carID +'\')">预警明细</button></td>';--%>

<%--});--%>
<%--}--%>
<%--});--%>

<%--}--%>
<%--</script>--%>
</body>
</html>


