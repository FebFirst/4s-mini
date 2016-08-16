<%--
  Created by IntelliJ IDEA.
  User: googo
  Date: 16/8/14
  Time: 下午11:05
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
<form:form cssClass="mywrapper form-horizontal" id="formAddAdditionalProduct" method="post" commandName="additionalProduct" action="${pageContext.request.contextPath}/Sale/createAdditionalProduct">


    <div class="form-group">
        <label class="col-sm-2 control-label">水平事业名称 :</label>
        <div class="col-sm-7">
            <form:input cssClass="form-control" ID="Name" path="Name"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">水平事业类别 :</label>
        <div class="col-sm-7">
                <%--<form:input cssClass="form-control" ID="Type" path="Type"/>--%>
            <select class="form-control" name="AdditionalProductType" id="AdditionalProductType">
                <c:forEach items="${types}" var="type">
                    <option value="${type.type}">${type.type}</option>
                </c:forEach>
            </select>
        </div>
        <button type="button" class="btn btn-primary" onclick="window.location='${pageContext.request.contextPath}/Sale/createAdditionalProductType'">添加一个类别</button>
    </div>


    <div class="form-group">
        <label class="col-sm-2 control-label">折让 :</label>
        <div class="col-sm-7">
            <form:input cssClass="form-control" ID="Discount" path="Discount"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">成本 :</label>
        <div class="col-sm-7">
            <form:input cssClass="form-control" ID="Cost" path="Cost"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">售价 :</label>
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

</body>
</html>