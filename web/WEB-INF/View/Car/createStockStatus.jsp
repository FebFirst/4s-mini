<%--
  Created by IntelliJ IDEA.
  User: HFQ
  Date: 2016/8/9
  Time: 0:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title>添加库存状态</title>
</head>

<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>


<body>
<form:form cssClass="mywrapper form-horizontal" id="formAddStockStatus" method="post" commandName="stockStatus" action="${pageContext.request.contextPath}/Car/createStockStatus">

  <div class="form-group">
    <label class="col-sm-2 control-label">库存状态：</label>
    <div class="col-sm-7">
      <form:input cssClass="form-control" id="State" path="State"/>
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
    //alert(1111);
    var obj = document.getElementById("State");
    //alert(obj);
    var status = obj.value;
//alert(brand);

    $.ajax({
      url: "${pageContext.request.contextPath}/Car/stockStatusExists",
      data:{"status":status},
      type: 'POST',
      dataType:'JSON',
      success:function (data) {
        if(data.message == "false"){
          var form = document.getElementById("formAddStockStatus");
          form.submit();
        }else{
          var html = document.getElementById("msg");
          html.innerHTML = "<input class='btn btn-primary' value='提交' onclick='existsChecking()' readonly='readonly'/>" + "此状态已经存在!";
        }
      },
      error:function () {
        var html = document.getElementById("msg");
        html.innerHTML = "<input class='btn btn-primary' value='提交' onclick='existsChecking()' readonly='readonly'/>" + "此状态已经存在!";
      }
    })
  }
</script><jsp:include page="../Site/footer.jsp"/>

</body>
</html>