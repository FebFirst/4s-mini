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
    <title>车型列表</title>
</head>
<body>
<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>
<div id="search-box">
    <div class="form-group">
        <label class="col-sm-1 control-label">按厂家搜索:</label>
        <div class="col-sm-1" id ="garage_div">
            <select class="form-control" name="garage" id="garage" >
                <option value="empty"></option>
                <c:forEach items="${garages}" var="garage">
                    <option value="${garage.brand}">${garage.brand}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-1 control-label">按车型搜索:</label>
        <div class="col-sm-1" id ="brand_div">
            <select class="form-control" name="brand" id="carbrand" >
                <option value="empty"></option>
                <c:forEach items="${brands}" var="brand">
                    <option value="${brand.brand}">${brand.brand}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-1 control-label">按配置搜索:</label>
        <div class="col-sm-1" id ="sfx_div">
            <select class="form-control" name="sfx" id="sfx">
                <option value="empty"></option>
                <c:forEach items="${sfxes}" var="sfx">
                    <option value="${sfx.sfx}">${sfx.sfx}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-1 control-label">按颜色搜索:</label>
        <div class="col-sm-1" id ="color_div">
            <select class="form-control" name="color" id="color">
                <option value="empty"></option>
                <c:forEach items="${colors}" var="color">
                    <option value="${color.color}">${color.color}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="form-group">

        <div class="col-sm-1" id="msg">
            <input class="btn btn-primary" value="点击搜索" onclick="carSelect()" readonly="readonly"/>
        </div>
        <div class="col-sm-1"></div>
    </div>

</div>
<div class="mywrapper form-group">
    <div class="col-sm-2"></div>
    <div class="col-sm-8">
        <table class="table table-bordered table-responsive">
            <thead>
            <tr>
                <th>厂家</th>
                <th>品牌</th>
                <th>配置</th>
                <th>颜色</th>
                <th>计划</th>
                <th>订单</th>
                <th>库存</th>
                <th>请求订车数</th>
                <th>成本</th>
                <th>指导价</th>
                <th>折让</th>
                <th colspan=4>操作</th>
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
                    <td><button type="button" class="btn btn-primary" onclick="showModal('${carType.garage}','${carType.brand}','${carType.carSfx}','${carType.carColor}')">设置价格</button></td>
                    <td><button type="button" class="btn btn-primary" onclick="getStock('${carType.garage}','${carType.brand}','${carType.carSfx}','${carType.carColor}')">查看库存</button></td>
                    <%--<td><button type="button" class="btn btn-primary" onclick="stockRegister('${carType.garage}','${carType.brand}','${carType.carSfx}','${carType.carColor}')">向厂家订车请求</button></td>--%>
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
                    设置车型价格
                </h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group  required"><label class="control-label">更新成本：</label>
                        <input id="cost" placeholder="填写成本" class="form-control">
                    </div>
                    <div class="form-group  required" ><label class="control-label">更新售价：</label>
                        <input id="price"  class="form-control" placeholder="填写售价" >
                    </div>
                    <div class="form-group  required" ><label class="control-label">更新折扣：</label>
                        <input id="discount"  class="form-control" placeholder="填写折扣">
                    </div>

                    <div class="form-group  required" style="visibility: hidden">
                        <input id="moGarage"  class="form-control" type="text" required="required">
                    </div>
                    <div class="form-group  required" style="visibility: hidden">
                    <input id="moBrand"  class="form-control" type="text" required="required">
                    </div>
                    <div class="form-group  required" style="visibility: hidden">
                        <input id="moSfx"  class="form-control" type="text" required="required">
                    </div>

                    <div class="form-group  required" style="visibility: hidden">
                        <input id="moColor"  class="form-control" type="text" required="required">
                    </div>
                </form>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default"
                        data-dismiss="modal">关闭
                </button>

                <button type="button" class="btn btn-default"
                        onclick="updatePrice()">确定
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
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
    };

    function showModal(garage,brand,sfx,color) {
        document.getElementById("moGarage").value = garage;
        document.getElementById("moBrand").value = brand;
        document.getElementById("moSfx").value = sfx;
        document.getElementById("moColor").value = color;
        $('#carModal').modal('show');
    }
    function updatePrice() {
        var garage = document.getElementById("moGarage").value;
        var brand = document.getElementById("moBrand").value;
        var sfx = document.getElementById("moSfx").value;
        var color = document.getElementById("moColor").value;
        var cost = document.getElementById("cost").value;
        var price = document.getElementById("price").value;
        var discount = document.getElementById("discount").value;

        if(cost == ""){
            cost = "null";
        }

        if(price == ""){
            price = "null";
        }

        if(discount == ""){
            discount = "null";
        }
        var data = {"garage":garage, "brand":brand,"sfx":sfx,"color":color,"cost":cost,"price":price,"discount":discount};

        post("${pageContext.request.contextPath}/Car/updateCarTypePrice", data);

    }
</script>

<script>

    <%--搜索过滤功能--%>

    function carSelect() {
        var garage = document.getElementById("garage");
        var brand = document.getElementById("carbrand");
        var sfx = document.getElementById("sfx");
        var color = document.getElementById("color");

        var index = garage.selectedIndex;
        var gValue = garage.options[index].value;

        index = brand.selectedIndex;
        var bValue = brand.options[index].value;

        index = sfx.selectedIndex;
        var sValue = sfx.options[index].value;

        index = color.selectedIndex;
        var cValue = color.options[index].value;

        $.ajax({
            url:"${pageContext.request.contextPath}/Car/carTypeSelect",
            data:{"garage":gValue,"brand":bValue,"sfx":sValue,"color":cValue},
            type:'POST',
            dataType:'JSON',
            cache:true,
            success:function(data){
                var jsonObj=eval(data);
                var table = document.getElementById("carInfo");
                table.innerHTML = "";
                $.each(jsonObj, function (i, item) {
                    table.innerHTML = table.innerHTML + " <tr>" +
                            "<td>" + item.garage + "</td>" +
                            "<td>" + item.brand + "</td>" +
                            "<td>" + item.sfx + "</td>" +
                            "<td>" + item.color + "</td>" +
                            "<td>" + item.plan + "</td>" +
                            "<td>" + item.order + "</td>" +
                            "<td>" + item.stock + "</td>" +
                            "<td>" + item.requestNumber + "</td>" +
                            "<td>" + item.cost + "</td>" +
                            "<td>" + item.price + "</td>" +
                            "<td>" + item.discount + "</td>" +
                            '<td><button type="button" class="btn btn-primary" onclick= "deleteCarType(\'' + item.garage + '\' + ',' + \'' + item.brand + '\' + ',' + \'' + item.carSfx + '\' +',' + \'' + item.carColor+ '\')">删除</button></td>' +
                            '<td><button type="button" class="btn btn-primary" onclick= "updatePlan(\'' + item.garage + '\' + ',' + \'' + item.brand + '\' + ',' + \'' + item.carSfx + '\' +',' + \'' + item.carColor+ '\')">添加计划</button></td>' +
                            '<td><button type="button" class="btn btn-primary" onclick= "showModal(\'' + item.garage + '\' + ',' + \'' + item.brand + '\' + ',' + \'' + item.carSfx + '\' +',' + \'' + item.carColor+ '\')">设置价格</button></td>' +
                            '<td><button type="button" class="btn btn-primary" onclick= "getStock(\'' + item.garage + '\' + ',' + \'' + item.brand + '\' + ',' + \'' + item.carSfx + '\' +',' + \'' + item.carColor+ '\')">查看库存</button></td>';

                });
            }
        });

    }
</script>
<jsp:include page="../Site/footer.jsp"/>
</body>
</html>
