<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HFQ
  Date: 2016/8/5
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
  <form:form cssClass="mywrapper form-horizontal" id="formAddCustomer" method="post" commandName="user" action="${pageContext.request.contextPath}/User/create">

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
      <label class="col-sm-2 control-label">用户类型</label>
      <div class="col-sm-3">
        <select class="form-control" name="Type">
          <option value="Accountant">财务员</option>
          <option value="Stockman">库管员</option>
          <option value="Salesman">销售员</option>
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
