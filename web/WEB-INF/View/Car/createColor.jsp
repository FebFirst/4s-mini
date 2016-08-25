<%--
  Created by IntelliJ IDEA.
  User: HFQ
  Date: 2016/8/8
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title>添加新颜色</title>
</head>

<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>


<body>
<form:form cssClass="mywrapper form-horizontal" id="formAddColor" method="post" commandName="color" action="${pageContext.request.contextPath}/Car/createColor">

  <div class="form-group">
    <label class="col-sm-2 control-label">颜色：</label>
    <div class="col-sm-7">
      <form:input cssClass="form-control" id="Color" path="Color"/>
    </div>
  </div>

  <div class="form-group">
    <div class="col-sm-2"></div>
    <div class="col-sm-7" id="msg">
      <input class="btn btn-primary" value="提交" onclick="existsChecking()" readonly="readonly"/>
    </div>
  </div>
</form:form>

<script>
  function existsChecking() {
    //alert(1111);
    var obj = document.getElementById("Color");
    //alert(obj);
    var color = obj.value;
    //alert(color);

    $.ajax({
      url: "${pageContext.request.contextPath}/Car/colorExists",
      data:{"color":color},
      type: 'POST',
      dataType:'JSON',
      success:function (data) {
        if(data.message == "false"){
          var form = document.getElementById("formAddColor");
          form.submit();
        }else{
          var html = document.getElementById("msg");
          html.innerHTML = "<input class='btn btn-primary' value='提交' onclick='existsChecking()' readonly='readonly'/>" + " 此颜色已经存在! ";
        }
      },
      error:function () {
        var html = document.getElementById("msg");
        html.innerHTML = "<input class='btn btn-primary' value='提交' onclick='existsChecking()' readonly='readonly'/>" + "此颜色已经存在!";
      }
    })
  }
</script>
<jsp:include page="../Site/footer.jsp"/>

</body>

</html>