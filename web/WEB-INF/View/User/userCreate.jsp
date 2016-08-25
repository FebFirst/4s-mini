<%--
  Created by IntelliJ IDEA.
  User: HFQ
  Date: 2016/8/5
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Register</title>
</head>

<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>

<script>
//  $(function(){
//    $("#formAddCustomer").validate({
//      rules:{
//        Username:{
//          required:true,
//          minlength:5,
//          maxlength:32
//        },
//        Password:{
//          required:true,
//          maxlength:32
//        },
//        PasswordValidate:{
//          required:true,
//          maxlength:32,
//          equalTo:"#Password"
//        }
//      },
//      messages:{
//        Password:{
//          required:"Please enter password"
//        },
//        PasswordValidate:{
//          required:"Please enter password",
//          equalTo:"Two Passwords don't match"
//        }
//      }
//    });
//  });
</script>

<body>
  <form:form cssClass="mywrapper form-horizontal" id="formAddUser" method="post" commandName="user" action="${pageContext.request.contextPath}/User/create">

    <div class="form-group" align="center">
      <label class="col-sm-2 control-label">用户名 :</label>
      <div class="col-sm-3">
        <form:input cssClass="form-control" ID="Username" path="Username"/>
      </div>
    </div>

    <div class="form-group" align="center">
      <label class="col-sm-2 control-label">密码 :</label>
      <div class="col-sm-3">
        <form:password cssClass="form-control" ID="Password" path="Password"/>
      </div>
    </div>

    <div class="form-group" align="center">
      <label class="col-sm-2 control-label">密码确认:</label>
      <div class="col-sm-3">
        <input class="form-control" type="password" id="PasswordValidate" name="PasswordValidate" required="required"/>
      </div>
    </div>

    <div class="form-group" align="center">
      <label class="col-sm-2 control-label">用户部门</label>
      <div class="col-sm-3">
        <select class="form-control" name="apartment">
          <c:forEach items="${apartments}" var="apartment">
            <option value="${apartment}">${apartment.apartment}</option>
          </c:forEach>
        </select>
      </div>
    </div>

    <div class="form-group" align="center">
      <label class="col-sm-2 control-label">岗位</label>
      <div class="col-sm-3">
        <select class="form-control" name="job">
          <c:forEach items="${jobs}" var="job">
            <option value="${job.job}">${job.job}</option>
          </c:forEach>
        </select>
      </div>
    </div>

    <div class="form-group" align="center">
      <label class="col-sm-2 control-label">级别</label>
      <div class="col-sm-3">
        <select class="form-control" name="level">
          <c:forEach items="${levels}" var="level">
            <option value="${level.level}">${level.level}</option>
          </c:forEach>
        </select>
      </div>
    </div>

    <div class="form-group" align="center">
      <label class="col-sm-2 control-label">在职状态</label>
      <div class="col-sm-3">
        <select class="form-control" name="job_status">
          <c:forEach items="${jobStatuses}" var="jobStatus">
            <option value="${jobStatus.jobStatus}">${jobStatus.jobStatus}</option>
          </c:forEach>
        </select>
      </div>
    </div>

    <div class="form-group" align="center">
      <label class="col-sm-2 control-label">职员姓名</label>
      <div class="col-sm-3">
        <form:input cssClass="form-control" ID="name" path="name"/>
      </div>
    </div>
    <div class="form-group" align="center">
      <label class="col-sm-2 control-label">手机号码</label>
      <div class="col-sm-3">
        <form:input cssClass="form-control" ID="cellphone" path="cellphone"/>
      </div>
    </div>
    <div class="form-group" align="center">
      <label class="col-sm-2 control-label">性别</label>
      <div class="col-sm-3">
        <select class="form-control" name="gender">
          <option value="男">男</option>
          <option value="女">女</option>
        </select>
      </div>
    </div>

    <div class="form-group" align="center">
      <div class="col-sm-2"></div>
      <div class="col-sm-7">
        <button type="submit" class="btn btn-primary">提交</button>
      </div>
    </div>
  </form:form>

  <jsp:include page="../Site/footer.jsp"/>

</body>
</html>
