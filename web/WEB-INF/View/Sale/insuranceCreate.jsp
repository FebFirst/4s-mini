<%--
  Created by IntelliJ IDEA.
  User: googo
  Date: 16/8/9
  Time: 下午4:42
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
<form:form cssClass="mywrapper form-horizontal" id="formAddInsurance" method="post" commandName="insurance" action="${pageContext.request.contextPath}/Sale/createInsurance">


    <div class="form-group">
        <label class="col-sm-2 control-label">保险名称 :</label>
        <div class="col-sm-7">
            <form:input cssClass="form-control" ID="Name" path="Name"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">保险类别 :</label>
        <div class="col-sm-7">
            <%--<form:input cssClass="form-control" ID="Type" path="Type"/>--%>
            <select class="form-control" name="Type" id="Type">
                <c:forEach items="${types}" var="type">
                    <option value="${type.type}">${type.type}</option>
                </c:forEach>
            </select>
        </div>
        <button type="button" class="btn btn-primary" onclick="window.location='${pageContext.request.contextPath}/Sale/createInsuranceType'">添加一个类别</button>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">折让 :</label>
        <div class="col-sm-7">
            <form:input cssClass="form-control" ID="Discount" path="Discount"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">保险成本 :</label>
        <div class="col-sm-7">
            <form:input cssClass="form-control" ID="Cost" path="Cost"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">保险售价 :</label>
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