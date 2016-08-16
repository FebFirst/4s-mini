<%--
  Created by IntelliJ IDEA.
  User: HFQ
  Date: 2016/8/5
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>用户列表</title>
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
        <th>ID</th>
        <th>用户名</th>
        <th>职位</th>
        <th colspan=2>Action</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${users}" var="user">
        <tr>
          <td>${user.userID}</td>
          <td>${user.username}</td>
          <td>${user.type}</td>
          <td><button type="button" class="btn btn-primary" onclick="window.location='${pageContext.request.contextPath}/User/delete/${user.userID}'">删除用户</button></td>
          <td><button type="button" class="btn btn-primary" onclick="window.location='#'">权限管理</button></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</div>
<jsp:include page="../Site/footer.jsp"/>
</body>
</html>
