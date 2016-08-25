<%--
  Created by IntelliJ IDEA.
  User: HFQ
  Date: 2016/4/23
  Time: 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <link href="/web_resources/css/bootstrap-3.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="/web_resources/css/menutopbar.css" rel="stylesheet">
  <link href="/web_resources/css/index.css" media="all" rel="stylesheet">
  <link href="/web_resources/css/layout.css" rel="stylesheet">
  <script src="/web_resources/js/jquery.min.js"></script>
  <script src="/web_resources/css/bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>

  <script src="/web_resources/js/jquery-validation-1.15.0/dist/jquery.validate.min.js"></script>
</head>
<body>

<div class="navbar navbar-default navbar-fixed-top u-navbar" role="navigation">
  <div class="container">

    <!-- Collapsed navigation -->
    <div class="navbar-header">
      <!-- Expander button -->
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>

      <!-- Main title -->
      <a class="navbar-brand brand-white scrolled" id="brand" href="../">

      </a>

    </div>

    <!-- Expanded navigation -->
    <div class="navbar-collapse collapse">
      <!-- Main navigation -->
      <ul class="nav navbar-nav">
        <li class=""><a href="${pageContext.request.contextPath}/Site/home">首页</a></li>

        <li class=""><a href="${pageContext.request.contextPath}/Car/carTypeList">车型列表</a></li>
        <li class=""><a href="${pageContext.request.contextPath}/Site/DataManagement">基本数据管理页面</a></li>

        <%
          if(session.getAttribute("userID") != null){
        %>


        <%if(session.getAttribute("admin") == null){%>
        <li><a data-no-turbolink="true" href="#">页面三</a></li>
        <%}else{%>
        <li><a data-no-turbolink="true" href="#">页面3</a></li>
        <li class=""><a href="#">页面4</a></li>
        <li><a data-no-turbolink="true" href="#">页面5</a></li>

        <%
            }
          }
        %>

      </ul>

      <form class="navbar-form navbar-right">
        <%
          if(session.getAttribute("userID") == null){
        %>
        <a class="btn btn-primary u-2 login" href="${pageContext.request.contextPath}/User/login">Log In</a>
        <a class="btn btn-primary u-1 signup" href="${pageContext.request.contextPath}/User/create">Sign Up</a>
        <%
        }
        else {
        %>
        <a class="btn btn-primary u-2 login" href="${pageContext.request.contextPath}/User/logout">Log Out</a>
        <a class="text-white" href="${pageContext.request.contextPath}/User/profile"><%out.print(session.getAttribute("username"));%></a>
        <%

          }
        %>

      </form>

    </div>
  </div>
  <span class="spinner sk-rotating-plane u-loading"></span>
</div>



</body>
</html>
