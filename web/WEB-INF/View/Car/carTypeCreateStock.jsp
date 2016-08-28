<%--
  Created by IntelliJ IDEA.
  User: HFQ
  Date: 2016/8/13
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>车辆入库登记</title>
</head>

<body>
<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>


<form:form cssClass="mywrapper form-horizontal" id="formCarStockRegister" method="post" commandName="car" action="${pageContext.request.contextPath}/Car/createStock/${planID}">

  <%--<div class="form-group">--%>
    <%--<label class="col-sm-2 control-label">车架号:</label>--%>
    <%--<div class="col-sm-7">--%>
      <%--<input class="form-control" placeholder="车架号"--%>
             <%--id="CarID" name="carID" required="required"/>--%>
    <%--</div>--%>
  <%--</div>--%>

  <div class="form-group">
    <label class="col-sm-2 control-label">厂家:</label>
    <div class="col-sm-7">
      <select class="form-control" name="garage" id="Garage">
        <%--<c:forEach items="${garages}" var="garage">--%>
          <option value="${garage}" selected="selected">${garage}</option>
        <%--</c:forEach>--%>
      </select>
    </div>
    <button type="button" class="btn btn-primary" onclick="window.location='${pageContext.request.contextPath}/Car/createGarage'">没有这个厂家，添加一个</button>
  </div>

  <div class="form-group">
    <label class="col-sm-2 control-label">车型品牌:</label>
    <div class="col-sm-7">
      <select class="form-control" name="Brand" id="Brand">
        <%--<c:forEach items="${carBrands}" var="carBrand">--%>
          <option value="${brand}">${brand}</option>
        <%--</c:forEach>--%>
      </select>
    </div>
    <button type="button" class="btn btn-primary" onclick="window.location='${pageContext.request.contextPath}/Car/createCarBrand'">没有这个车型，添加一个</button>
  </div>

  <div class="form-group">
    <label class="col-sm-2 control-label">配置:</label>
    <div class="col-sm-7">
      <select class="form-control" name="sfx" id="Sfx">
        <%--<c:forEach items="${sfxList}" var="sfx">--%>
          <option value="${sfx}">${sfx}</option>
        <%--</c:forEach>--%>
      </select>

    </div>
    <button type="button" class="btn btn-primary" onclick="window.location='${pageContext.request.contextPath}/Car/createSFX'">没有这个SFX，添加一个</button>
  </div>

  <div class="form-group">
    <label class="col-sm-2 control-label">颜色:</label>
    <div class="col-sm-7">
      <select class="form-control" name="color" id="Color">
        <%--<c:forEach items="${colors}" var="color">--%>
          <option value="${color}">${color}</option>
        <%--</c:forEach>--%>
      </select>
        <%--<input class="form-control" type="text" placeholder="颜色"--%>
        <%--id="CarColor" name="carColor" required="required"/>--%>
    </div>
    <button type="button" class="btn btn-primary" onclick="window.location='${pageContext.request.contextPath}/Car/createColor'">没有这个颜色，添加一个</button>
  </div>

  <div class="form-group">
    <label class="col-sm-2 control-label">库存状态:</label>
    <div class="col-sm-7">
      <select class="form-control" name="stockStatus" id="StockStatus">
          <option value="订车">订车</option>
        <c:forEach items="${statusList}" var="status">
          <option value="${status.state}">${status.state}</option>
        </c:forEach>
      </select>
        <%--<input class="form-control" type="text" placeholder="颜色"--%>
        <%--id="CarColor" name="carColor" required="required"/>--%>
    </div>
    <button type="button" class="btn btn-primary" onclick="window.location='${pageContext.request.contextPath}/Car/createStockStatus'">添加一个库存状态</button>
  </div>

  <div class="form-group">
    <label class="col-sm-2 control-label">车辆状态:</label>
    <div class="col-sm-7">
      <select class="form-control" name="normal" id="Normal">
        <option value="Y">正常</option>
        <option value="N">特殊</option>
      </select>

    </div>
  </div>

  <div class="form-group">
    <div class="col-sm-2"></div>
    <div class="col-sm-7">
      <button type="submit" class="btn btn-primary">登记</button>
    </div>
  </div>
</form:form>
<jsp:include page="../Site/footer.jsp"/>
</body>
</html>