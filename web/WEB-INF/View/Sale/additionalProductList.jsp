<%--
  Created by IntelliJ IDEA.
  User: googo
  Date: 16/8/14
  Time: 下午11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>其他水平事业列表</title>
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
                <th>编号</th>
                <th>名称</th>
                <th>类别</th>
                <th colspan=2>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${AdditionalProducts}" var="additionalProduct">
                <tr>
                    <td>${additionalProduct.additionalProductID}</td>
                    <td>${additionalProduct.name}</td>
                    <td>${additionalProduct.additionalProductType}</td>
                    <td><button type="button" class="btn btn-primary" onclick="window.location='${pageContext.request.contextPath}/Sale/deleteAdditionalProduct/${additionalProduct.additionalProductID}'">删除</button></td>
                    <td><button type="button" class="btn btn-primary" onclick="window.location='#'">修改</button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="../Site/footer.jsp"/>
</body>
</html>

