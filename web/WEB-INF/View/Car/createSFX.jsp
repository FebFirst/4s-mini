<%--
  Created by IntelliJ IDEA.
  User: HFQ
  Date: 2016/8/11
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>添加SFX</title>
</head>

<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>


<body>
<form:form cssClass="mywrapper form-horizontal" id="formAddGarage" method="post" commandName="SFX" action="${pageContext.request.contextPath}/Car/createSFX">

  <div class="form-group">
    <label class="col-sm-2 control-label">SFX：</label>
    <div class="col-sm-7">
      <form:input cssClass="form-control" ID="sfx" path="sfx"/>
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
    var obj = document.getElementById("sfx");
    //alert(obj);
    var sfx = obj.value;
//alert(brand);

    $.ajax({
      url: "${pageContext.request.contextPath}/Car/sfxExists",
      data:{"sfx":sfx},
      type: 'POST',
      dataType:'JSON',
      success:function (data) {
        if(data.message == "false"){
          var form = document.getElementById("formAddSfx");
          form.submit();
        }else{
          var html = document.getElementById("msg");
          html.innerHTML = "<input class='btn btn-primary' value='提交' onclick='existsChecking()' readonly='readonly'>" + "此SFX已经存在!";
        }
      },
      error:function () {
        var html = document.getElementById("msg");
        html.innerHTML = "<input class='btn btn-primary' value='提交' onclick='existsChecking()' readonly='readonly'>" + "此SFX已经存在!";
      }
    })
  }
</script>
<jsp:include page="../Site/footer.jsp"/>

</body>
</html>