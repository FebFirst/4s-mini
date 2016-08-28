<%--
  Created by IntelliJ IDEA.
  User: HFQ
  Date: 2016/8/20
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>订车计划列表</title>
</head>
<body>
<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>
<div class="mywrapper form-group">
  <div class="col-sm-2"></div>
  <div class="col-sm-8">
    <table class="table table-bordered table-responsive">
      <thead>
      <tr>
        <th>计划ID</th>
        <th>厂家</th>
        <th>品牌</th>
        <th>配置</th>
        <th>颜色</th>
        <th>未订车数</th>
        <th>计划订车日</th>
        <th>计划在途日</th>
        <th>计划入库日</th>
        <th>计划出库日</th>
        <th>计划交车日</th>
        <th>指导价</th>
        <th>折让</th>
        <th colspan=1>操作</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${plans}" var="plan">
        <tr>
          <td>${plan.planID}</td>
          <td>${plan.garage}</td>
          <td>${plan.brand}</td>
          <td>${plan.carSfx}</td>
          <td>${plan.carColor}</td>
          <td>${plan.number}</td>
          <td>${plan.predictedTime}</td>
          <td>${plan.purchasedTime}</td>
          <td>${plan.inGarageTime}</td>
          <td>${plan.outGarageTime}</td>
          <td>${plan.submitTime}</td>
          <td>${plan.defaultPrice}</td>
          <td>${plan.discount}</td>
          <td><button type="button" class="btn btn-primary" onclick="window.location='${pageContext.request.contextPath}/Car/createCarByCarPlan/${plan.planID}'">订车</button></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</div>
<script>
  function post(url, params) {
    var temp = document.createElement("form");
    temp.action = url;
    temp.method = "post";
    temp.style.display = "none";
    for (var x in params) {
      var opt = document.createElement("input");
      opt.name = x;
      opt.value = params[x];
      temp.appendChild(opt);
    }
    document.body.appendChild(temp);
    temp.submit();
    return temp;
  };

  function stockRegister(garage,brand,sfx,color){
    var data = {"garage":garage, "brand":brand,"sfx":sfx,"color":color};
    post("${pageContext.request.contextPath}/Car/createCarByCarType", data);
  };


</script>

<script>

</script>
<jsp:include page="../Site/footer.jsp"/>
</body>
</html>
