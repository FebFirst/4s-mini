<%--
  Created by IntelliJ IDEA.
  User: HFQ
  Date: 2016/8/8
  Time: 7:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>添加新品牌</title>
</head>

<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>


<body>
<form:form cssClass="mywrapper form-horizontal" id="formAddGarage" method="post" commandName="garage" action="${pageContext.request.contextPath}/Car/createGarage">

  <div class="form-group">
    <label class="col-sm-2 control-label">厂家品牌：</label>
    <div class="col-sm-7">
      <form:input cssClass="form-control" id="Brand" path="Brand"/>
    </div>
  </div>

  <div class="form-group">
    <div class="col-sm-2"></div>
    <div class="col-sm-7" id="msg">
      <input class="btn btn-primary" onclick="existsChecking()" value="提交" readonly="readonly"/>
    </div>
  </div>
</form:form>
<script>
  function existsChecking() {
    var obj = document.getElementById("Brand");
    var brand = obj.value;
    $.ajax({
      url: "${pageContext.request.contextPath}/Car/garageExists",
      data:{"brand":brand},
      type: 'POST',
      dataType:'JSON',
      success:function (data) {
        if(data.message == "false"){
          // alert("haha");
          var form = document.getElementById("formAddGarage");
          form.submit();
        }else{
          var html = document.getElementById("msg");
          html.innerHTML = "<input class='btn btn-primary' value='提交' onclick='existsChecking()' readonly='readonly'/>" + "此类型已经存在!";

        }
      },
      error:function () {
        var html = document.getElementById("msg");
        html.innerHTML = "<input class='btn btn-primary' value='提交' onclick='existsChecking()' readonly='readonly'/>" + "此类型已经存在!";
      }
    })



  }

</script>
<jsp:include page="../Site/footer.jsp"/>

</body>
</html>
