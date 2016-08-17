<%--
  Created by IntelliJ IDEA.
  User: HFQ
  Date: 2016/8/5
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>
</head>
<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>
<script>
  $(function(){
    $("#formLogin").validate({
      rules:{
        Username:{
          required:true,
          minlength:5,
          maxlength:32
        },
        Password:{
          required:true,
          maxlength:32
        }
      }
    });
  });
</script>
<body>

<form:form cssClass="mywrapper form-horizontal" id="formLogin" method="post" commandName="user" action="${pageContext.request.contextPath}/User/login" align="center">
  <div class="form-group" align="center">
    <div class="col-sm-4"></div>
    <div class="col-sm-2">
      <h3>登录系统</h3>
      <br>
    </div>
  </div>
  <div class="form-group" align="center">
    <label class="col-sm-4 control-label">用户名</label>
    <div class="col-sm-3">
      <input class="form-control" placeholder="用户名"  name="Username" id="Username" type="text"/>
      <br>
    </div>
  </div>

  <div class="form-group" align="center">
    <label class="col-sm-4 control-label">密码</label>
    <div class="col-sm-3">
      <input class="form-control " placeholder="密码"  name="Password" id="Password" type="password"/>
      <br>
      <label class="control-label">${message}</label>
    </div>
  </div>
  <div class="form-group" align="center">
    <div class="col-sm-4">
    </div>
    <div class="col-sm-3">
      <input type="checkbox" value="1" id="admin" name="admin">
      管理员身份登录
    </div>

  </div>
  <div class="form-group" align="center">
    <div class="col-sm-4"></div>
    <div class="col-sm-2">
      <button class="btn btn-primary" type="submit" value="Login">登录</button>
    </div>
  </div>
</form:form>

<jsp:include page="../Site/footer.jsp"/>
</body>
</html>