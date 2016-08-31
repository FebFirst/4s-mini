<%--
  Created by IntelliJ IDEA.
  User: HFQ
  Date: 2016/8/19
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: HFQ
  Date: 2016/8/11
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>添加精品品牌</title>
</head>

<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>


<body>
<form:form cssClass="mywrapper form-horizontal" id="formAddGiftBrand" method="post" commandName="giftBrand" action="${pageContext.request.contextPath}/Sale/createGiftBrand">

  <div class="form-group">
    <label class="col-sm-2 control-label">精品类别：</label>
    <div class="col-sm-7">
      <select class="form-control" name="Type" id="Type">
        <c:forEach items="${giftTypes}" var="type">
          <option value="${type.type}">${type.type}</option>
        </c:forEach>
      </select>
    </div>
  </div>

  <div class="form-group">
    <label class="col-sm-2 control-label">精品品牌：</label>
    <div class="col-sm-7">
      <form:input cssClass="form-control" id="giftBrand" path="giftBrand"/>
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
    var obj = document.getElementById("giftBrand");
    var type = obj.value;

    obj = document.getElementById("Type");
    var index = obj.selectedIndex;
    var giftType = obj.options[index].value;

    //alert(type);
    $.ajax({
      url: "${pageContext.request.contextPath}/Sale/giftBrandExists",
      data:{"giftBrand":type,"giftType":giftType},
      type: 'POST',
      dataType:'JSON',
      success:function (data) {
        if(data.message == "false"){
          //alert("haha");
          var form = document.getElementById("formAddGiftBrand");
          form.submit();
        }else{
          var html = document.getElementById("msg");
          html.innerHTML = "<input class='btn btn-primary' value='提交' onclick='existsChecking()' readonly='readonly'/>" + "此品牌已经存在!";

        }
      },
      error:function () {
        var html = document.getElementById("msg");
        html.innerHTML = "<input class='btn btn-primary' value='提交' onclick='existsChecking()' readonly='readonly'/>" + "此品牌已经存在!";
      }
    })



  }

</script>
<jsp:include page="../Site/footer.jsp"/>

</body>
</html>
