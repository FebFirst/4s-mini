<%--
  Created by IntelliJ IDEA.
  User: googo
  Date: 16/8/12
  Time: 上午11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>车型计划添加</title>
</head>

<body>
<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>

<form:form cssClass="mywrapper form-horizontal" id="formCarTypePlan" method="post" commandName="carPlan" action="${pageContext.request.contextPath}/Car/updateCarTypePlan">

    <div class="form-group">
        <label class="col-sm-2 control-label">厂家:</label>
        <div class="col-sm-7">
            <select class="form-control" name="garage" id="garage">
                    <option value="${carType.garage}">${carType.garage}</option>
            </select>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">车型品牌:</label>
        <div class="col-sm-7">
            <select class="form-control" name="Brand" id="Brand">
                    <option value="${carType.brand}">${carType.brand}</option>
            </select>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">配置:</label>
        <div class="col-sm-7">
            <select class="form-control" name="carSfx" id="carSfx">
                    <option value="${carType.carSfx}">${carType.carSfx}</option>
            </select>

        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">颜色:</label>
        <div class="col-sm-7">
            <select class="form-control" name="carColor" id="carColor">
                    <option value="${carType.carColor}">${carType.carColor}</option>
            </select>
                <%--<input class="form-control" type="text" placeholder="颜色"--%>
                <%--id="CarColor" name="carColor" required="required"/>--%>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">计划数量:</label>
        <div class="col-sm-7">
                <input class="form-control" type="text" placeholder="计划数量"
                id="number" name="number" required="required"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">计划订车日:</label>
        <div class="col-sm-7">
            <input class="form-control" type="date" placeholder="计划订车日"
                   id="predictedTime" name="predictedTime" required="required"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">计划在途日:</label>
        <div class="col-sm-7">
            <input class="form-control" type="date" placeholder="计划在途日"
                   id="purchasedTime" name="purchasedTime" required="required"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">计划入库日:</label>
        <div class="col-sm-7">
            <input class="form-control" type="date" placeholder="计划入库日"
                   id="inGarageTime" name="inGarageTime" required="required"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">计划出库日:</label>
        <div class="col-sm-7">
            <input class="form-control" type="date" placeholder="计划出库日"
                   id="outGarageTime" name="outGarageTime" required="required"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">计划交车日:</label>
        <div class="col-sm-7">
            <input class="form-control" type="date" placeholder="计划交车日"
                   id="submitTime" name="submitTime" required="required"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">指导价:</label>
        <div class="col-sm-7">
            <input class="form-control" type="text" placeholder="计划指导价" value="${carType.price}"
                   id="defaultPrice" name="defaultPrice" required="required"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">计划折让:</label>
        <div class="col-sm-7">
            <input class="form-control" type="text" placeholder="计划折让" value="${carType.discount}"
                   id="discount" name="discount" required="required"/>
        </div>
    </div>


    <div class="form-group">
        <label class="col-sm-2 control-label">车型库存:</label>
        <div class="col-sm-7">
            <label class="control-label">${carType.stock}</label>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">订单库存:</label>
        <div class="col-sm-7">

            <label class="control-label">${carType.order}</label>
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