<%--
  Created by IntelliJ IDEA.
  User: HFQ
  Date: 2016/8/10
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>添加新品牌</title>
</head>

<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>


<body>
<form:form cssClass="mywrapper form-horizontal" id="formAddCarBrand" method="post" commandName="carBrand" action="${pageContext.request.contextPath}/Car/createCarBrand">

  <div class="form-group">
    <label class="col-sm-2 control-label">厂家：</label>
    <div class="col-sm-7">
      <select class="form-control" name="garage" id="Garage" required="required">
        <c:forEach items="${garages}" var="garage">
          <option value="${garage.brand}">${garage.brand}</option>
        </c:forEach>
      </select>
    </div>
  </div>

  <div class="form-group">
    <label class="col-sm-2 control-label">品牌：</label>
    <div class="col-sm-7">
      <form:input cssClass="form-control" id="Brand" path="brand"/>
    </div>
  </div>

  <div class="form-group">
    <div class="col-sm-2"></div>
    <div class="col-sm-7" id="msg">
      <input class="btn btn-primary" onclick="existsChecking()" value="提交" readonly/>
    </div>
  </div>
</form:form>
<script>
  function existsChecking() {

    var obj = document.getElementById("Brand");
    // alert(obj);
    var brand = obj.value;
//alert(brand);
    obj = document.getElementById("Garage");
    var index = obj.selectedIndex;
    var garage = obj.options[index].value;

    $.ajax({
      url: "${pageContext.request.contextPath}/Car/brandExists",
      data:{"brand":brand,"garage":garage},
      type: 'POST',
      dataType:'JSON',
      success:function (data) {
        if(data.message == "false"){
          var form = document.getElementById("formAddCarBrand");
          form.submit();
        }else{
          var html = document.getElementById("msg");
          html.innerHTML = "<input class='btn btn-primary' value='提交' onclick='existsChecking()' readonly='readonly'/>" + "此车型已经存在!";

        }
      },
      error:function () {
        var html = document.getElementById("msg");
        html.innerHTML = "<input class='btn btn-primary' value='提交' onclick='existsChecking()' readonly='readonly'/>" + "此车型已经存在!";
      }
    })
  }

</script>
<jsp:include page="../Site/footer.jsp"/>

</body>
</html>