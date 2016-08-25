<%--
  Created by IntelliJ IDEA.
  User: HFQ
  Date: 2016/8/20
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>岗位列表</title>
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
        <th>岗位</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${jobs}" var="job">
        <tr>
          <td>${job.job}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</div>
<jsp:include page="../Site/footer.jsp"/>
</body>
</html>

