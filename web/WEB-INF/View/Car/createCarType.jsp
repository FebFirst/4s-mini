<%--
  Created by IntelliJ IDEA.
  User: googo
  Date: 16/8/11
  Time: 下午9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>创建车型</title>
</head>

<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>

<body>
<form:form cssClass="mywrapper form-horizontal" id="formCreateCarType" method="post" commandName="car" action="${pageContext.request.contextPath}/Car/createCarType">


    <div class="form-group">
        <label class="col-sm-2 control-label">厂家:</label>
        <div class="col-sm-7" id ="garage_div">
            <select class="form-control" name="Garage" id="Garage" onchange="brandSelect()">
                <%--<option value="posche" onclick="brandSelect">保时捷</option>--%>
                <%--<option value="BMW" onclick="brandSelect">宝马</option>--%>
                <c:forEach items="${garages}" var="garage">
                    <option value="${garage.brand}">${garage.brand}</option>
                </c:forEach>
            </select>
        </div>

    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">车型品牌:</label>
        <div class="col-sm-7">
            <select class="form-control" name="Brand" id="Brand">

            </select>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">配置:</label>
        <div class="col-sm-7">
            <select class="form-control" name="carSfx" id="carSfx">
                <c:forEach items="${sfxes}" var="sfx">
                    <option value="${sfx.sfx}">${sfx.sfx}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">颜色:</label>
        <div class="col-sm-7">
            <select class="form-control" name="carColor" id="carColor">
                <c:forEach items="${colors}" var="color">
                    <option value="${color.color}">${color.color}</option>
                </c:forEach>
            </select>

        </div>
    </div>


    <div class="form-group">
        <div class="col-sm-2"></div>
        <div class="col-sm-7" id="msg">
            <input class="btn btn-primary" onclick="existsChecking()" value="提交" readonly="readonly"/>
        </div>
    </div>
</form:form>
<jsp:include page="../Site/footer.jsp"/>

<script>

    function existsChecking() {
        var obj = document.getElementById("Garage");
        var index = obj.selectedIndex; // 选中索引
        var garage = obj.options[index].value; // 选中值

        obj = document.getElementById("Brand");
        index = obj.selectedIndex; // 选中索引
        var brand = obj.options[index].value;


        obj = document.getElementById("carSfx");
        index = obj.selectedIndex;
        var sfx = obj.options[index].value;


        obj = document.getElementById("carColor");
        index = obj.selectedIndex;
        var color = obj.options[index].value;

        $.ajax({
            url: "${pageContext.request.contextPath}/Car/carTypeExists",
            data:{"garage":garage, "brand":brand,"sfx":sfx,"color":color},
            type: 'POST',
            dataType:'JSON',
            success:function (data) {
                if(data.message == "false"){
                    // alert("haha");
                    var form = document.getElementById("formCreateCarType");
                    form.submit();
                }else{
                    var html = document.getElementById("msg");
                    html.innerHTML = "<input class='btn btn-primary' value='提交' onclick='existsChecking()' readonly='readonly'/>" + "此车型已经存在!";

                }
            },
            error:function () {
                var html = document.getElementById("msg");
                html.innerHTML = "<input class='btn btn-primary' value='提交' onclick='existsChecking()' readonly='readonly'/>" + "此车型已经存在!";
            }
        })
    };

    $(document).ready(function() {
        brandSelect();
    });

    function brandSelect() {

        var obj = document.getElementById("Garage");
        var index = obj.selectedIndex; // 选中索引
        var value = obj.options[index].value; // 选中值
        $.ajax({
            url:"${pageContext.request.contextPath}/Car/selectCarBrand",
            data: {"garage":value},
            type:'POST',
            dataType:'JSON',
            cache:true,
            success:function(data){
                //alert(data.size());
                var brand = document.getElementById("Brand");
                var jsonObj=eval(data);
                brand.innerHTML = "";
                $.each(jsonObj, function (i, item) {
                    brand.innerHTML = brand.innerHTML + "<option value=" + JSON.stringify(item) + ">" +JSON.stringify(item).substr(1,JSON.stringify(item).length - 2) + "</option>";
                });
            }
        })
    }

</script>
</body>
</html>