<%--
  Created by IntelliJ IDEA.
  User: HFQ
  Date: 2016/8/10
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>用户中心</title>
</head>

<body>
<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>
<div class="mywrapper">
  <div class="form-group">
    <div class="col-sm-2"></div>
    <div class="col-sm-4 mywrapper">
      <div class="panel panel-success">
        <div class="panel-heading">
          用户ID:
        </div>
        <div class="panel-body">
          ${user.userID}
        </div>
      </div>

      <div class="panel panel-success">
        <div class="panel-heading">
          用户名:
        </div>
        <div class="panel-body">
          ${user.username}
        </div>
      </div>

      <div class="panel panel-success">
        <div class="panel-heading">
          职位:
        </div>
        <div class="panel-body">
          ${user.type}
        </div>
      </div>

      <button type="button" class="btn btn-primary" onclick="window.location='#'">修改用户信息</button>
      <button type="button" class="btn btn-primary" onclick="window.location='#'">修改密码</button>
    </div>

  </div>
</div>


<jsp:include page="../Site/footer.jsp"/>
</body>
</html>

