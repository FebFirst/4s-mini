<%--
  Created by IntelliJ IDEA.
  User: googo
  Date: 16/8/9
  Time: 下午4:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>

<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>



<body>
<form:form cssClass="mywrapper form-horizontal" id="formAddGift" method="post" commandName="gift" action="${pageContext.request.contextPath}/Sale/createGift">


    <%--<div class="form-group">--%>
        <%--<label class="col-sm-2 control-label">精品名称 :</label>--%>
        <%--<div class="col-sm-7">--%>
            <%--<form:input cssClass="form-control" ID="Name" path="Name"/>--%>
        <%--</div>--%>
    <%--</div>--%>

    <div class="form-group">
        <label class="col-sm-2 control-label">精品类别 :</label>
        <div class="col-sm-7">
                <%--<form:input cssClass="form-control" ID="Type" path="Type"/>--%>
            <select class="form-control" name="GiftType" id="GiftType" onchange="brandSelect()">
                <c:forEach items="${types}" var="type">
                    <option value="${type.type}">${type.type}</option>
                </c:forEach>
            </select>
        </div>
        <%--<button type="button" class="btn btn-primary" onclick="window.location='${pageContext.request.contextPath}/Sale/createGiftType'">添加一个类别</button>--%>
    </div>


    <div class="form-group">
        <label class="col-sm-2 control-label">品牌:</label>
        <div class="col-sm-7">
            <select class="form-control" name="GiftBrand" id="GiftBrand">

            </select>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">折让 :</label>
        <div class="col-sm-7">
            <form:input cssClass="form-control" ID="Discount" path="Discount"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">精品成本 :</label>
        <div class="col-sm-7">
            <form:input cssClass="form-control" ID="Cost" path="Cost"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">精品售价 :</label>
        <div class="col-sm-7">
            <form:input cssClass="form-control" ID="default_price" path="default_price"/>
        </div>
    </div>


    <div class="form-group">
        <div class="col-sm-2"></div>
        <div class="col-sm-7">
            <button type="submit" class="btn btn-primary">提交</button>
        </div>
    </div>
</form:form>

<jsp:include page="../Site/footer.jsp"/>
<script>
    $(document).ready(function() {
        brandSelect();
    });

    function brandSelect() {

        var obj = document.getElementById("GiftType");
        var index = obj.selectedIndex; // 选中索引
        var value = obj.options[index].value; // 选中值
        $.ajax({
            url:"${pageContext.request.contextPath}/Sale/selectGiftBrand",
            data: {"type":value},
            type:'POST',
            dataType:'JSON',
            cache:true,
            success:function(data){
                //alert(data.size());
                var brand = document.getElementById("GiftBrand");
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