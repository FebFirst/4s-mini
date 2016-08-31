<%--
  Created by IntelliJ IDEA.
  User: googo
  Date: 16/8/30
  Time: 上午12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>销售计划添加</title>
</head>

<body>
<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>

<form:form cssClass="mywrapper form-horizontal" id="formSalesPlan" method="post" commandName="salesPlan" action="${pageContext.request.contextPath}/Plan/createSalesPlan">

    <div class="form-group">
        <label class="col-sm-1 control-label">厂家:</label>
        <div class="col-sm-2">
            <select class="form-control" name="garage" id="garage" onchange="brandSelect()">
                <c:forEach items="${garages}" var="garage">
                    <option value="${garage.brand}">${garage.brand}</option>
                </c:forEach>
            </select>
        </div>
        <label class="col-sm-1 control-label">车型品牌:</label>
        <div class="col-sm-1">
            <select class="form-control" name="brand" id="carBrand" onchange="sfxSelect()">
            </select>
        </div>
        <label class="col-sm-1 control-label">配置:</label>
        <div class="col-sm-2">
            <select class="form-control" name="sfx" id="sfx">
            </select>
        </div>
        <label class="col-sm-1 control-label">颜色:</label>
        <div class="col-sm-2">
            <select class="form-control" name="color" id="color">
                <c:forEach items="${colors}" var="color">
                    <option value="${color.color}">${color.color}</option>
                </c:forEach>
            </select>
        </div>
    </div>


    <div class="form-group">

        <label class="col-sm-1 control-label">计划月份:</label>
        <div class="col-sm-2">
            <input class="form-control" type="date" placeholder="计划月份"
                   id="planTime" name="planTime" required="required"/>
        </div>

        <label class="col-sm-1 control-label">购车成本:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="购车成本"
                   id="carCost" name="carCost" required="required"/>
        </div>

        <label class="col-sm-1 control-label">预计售价:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="预计售价"
                   id="carPrice" name="carPrice" required="required"/>
        </div>
        <label class="col-sm-1 control-label">折扣:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="折扣"
                   id="carDiscount" name="carDiscount" required="required"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-1 control-label">计划返利:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="计划返利"
                   id="carPayback" name="carPayback" required="required"/>
        </div>
        <label class="col-sm-1 control-label">计划销售数量:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="计划数量"
                   id="number" name="number" required="required"/>
        </div>

    </div>

    <div class="form-group">
        <label class="col-sm-1 control-label">二手车置换成本估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="二手车置换成本估计"
                   id="exchangeCost" name="exchangeCost" required="required"/>
        </div>

        <label class="col-sm-1 control-label">二手车置换售价估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="二手车置换售价估计"
                   id="exchangePrice" name="exchangePrice" required="required"/>
        </div>

        <label class="col-sm-1 control-label">二手车置换折扣估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="二手车置换折扣估计"
                   id="exchangeDiscount" name="exchangeDiscount" required="required"/>
        </div>

        <label class="col-sm-1 control-label">二手车置换渗透率估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="二手车置换渗透率估计"
                   id="exchangeSaturate" name="exchangeSaturate" required="required"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-1 control-label">精品成本估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="精品成本估计"
                   id="giftCost" name="giftCost" required="required"/>
        </div>

        <label class="col-sm-1 control-label">精品售价估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="精品售价估计"
                   id="giftPrice" name="giftPrice" required="required"/>
        </div>

        <label class="col-sm-1 control-label">精品折扣估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="精品折扣估计"
                   id="giftDiscount" name="giftDiscount" required="required"/>
        </div>

        <label class="col-sm-1 control-label">精品渗透率估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="精品渗透率估计"
                   id="giftSaturate" name="giftSaturate" required="required"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-1 control-label">保险成本估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="保险成本估计"
                   id="insuranceCost" name="insuranceCost" required="required"/>
        </div>

        <label class="col-sm-1 control-label">保险售价估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="保险售价估计"
                   id="insurancePrice" name="insurancePrice" required="required"/>
        </div>

        <label class="col-sm-1 control-label">保险折扣估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="保险折扣估计"
                   id="insuranceDiscount" name="insuranceDiscount" required="required"/>
        </div>

        <label class="col-sm-1 control-label">保险渗透率估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="保险渗透率估计"
                   id="insuranceSaturate" name="insuranceSaturate" required="required"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-1 control-label">金融成本估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="金融成本估计"
                   id="financeCost" name="financeCost" required="required"/>
        </div>

        <label class="col-sm-1 control-label">金融售价估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="金融售价估计"
                   id="financePrice" name="financePrice" required="required"/>
        </div>

        <label class="col-sm-1 control-label">金融折扣估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="金融折扣估计"
                   id="financeDiscount" name="financeDiscount" required="required"/>
        </div>

        <label class="col-sm-1 control-label">金融渗透率估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="金融渗透率估计"
                   id="financeSaturate" name="financeSaturate" required="required"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-1 control-label">服务费成本估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="服务费成本估计"
                   id="serviceCost" name="serviceCost" required="required"/>
        </div>

        <label class="col-sm-1 control-label">服务费售价估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="服务费售价估计"
                   id="servicePrice" name="servicePrice" required="required"/>
        </div>

        <label class="col-sm-1 control-label">服务费折扣估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="服务费折扣估计"
                   id="serviceDiscount" name="serviceDiscount" required="required"/>
        </div>

        <label class="col-sm-1 control-label">服务费渗透率估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="服务费渗透率估计"
                   id="serviceSaturate" name="serviceSaturate" required="required"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-1 control-label">延保成本估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="延保成本估计"
                   id="rebookInsuranceCost" name="rebookInsuranceCost" required="required"/>
        </div>

        <label class="col-sm-1 control-label">延保售价估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="延保售价估计"
                   id="rebookInsurancePrice" name="rebookInsurancePrice" required="required"/>
        </div>

        <label class="col-sm-1 control-label">延保折扣估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="延保折扣估计"
                   id="rebookInsuranceDiscount" name="rebookInsuranceDiscount" required="required"/>
        </div>

        <label class="col-sm-1 control-label">延保渗透率估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="延保渗透率估计"
                   id="rebookInsuranceSaturate" name="rebookInsuranceSaturate" required="required"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-1 control-label">会员成本估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="会员成本估计"
                   id="vipCost" name="vipCost" required="required"/>
        </div>

        <label class="col-sm-1 control-label">会员售价估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="会员售价估计"
                   id="vipPrice" name="vipPrice" required="required"/>
        </div>

        <label class="col-sm-1 control-label">会员折扣估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="会员折扣估计"
                   id="vipDiscount" name="vipDiscount" required="required"/>
        </div>

        <label class="col-sm-1 control-label">会员渗透率估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="会员渗透率估计"
                   id="vipSaturate" name="vipSaturate" required="required"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-1 control-label">租赁成本估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="租赁成本估计"
                   id="renderCost" name="renderCost" required="required"/>
        </div>

        <label class="col-sm-1 control-label">租赁售价估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="租赁售价估计"
                   id="renderPrice" name="renderPrice" required="required"/>
        </div>

        <label class="col-sm-1 control-label">租赁折扣估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="租赁折扣估计"
                   id="renderDiscount" name="renderDiscount" required="required"/>
        </div>

        <label class="col-sm-1 control-label">租赁渗透率估计:</label>
        <div class="col-sm-2">
            <input class="form-control" type="text" placeholder="租赁渗透率估计"
                   id="renderSaturate" name="renderSaturate" required="required"/>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-2"></div>
        <div class="col-sm-7">
            <button type="submit" class="btn btn-primary">登记</button>
        </div>
    </div>
</form:form>

<script>
    $(document).ready(function() {
        brandSelect();
        sfxSelect();
    });

    function brandSelect() {

        var obj = document.getElementById("garage");
        var index = obj.selectedIndex; // 选中索引
        var value = obj.options[index].value; // 选中值
        $.ajax({
            url:"${pageContext.request.contextPath}/Car/selectCarBrand",
            data: {"garage":value},
            type:'POST',
            dataType:'JSON',
            cache:true,
            success:function(data){
                //alert(data.size());
                var brand = document.getElementById("carBrand");
                var jsonObj=eval(data);
                brand.innerHTML = "";
                $.each(jsonObj, function (i, item) {
                    brand.innerHTML = brand.innerHTML + "<option value=" + JSON.stringify(item) + ">" +JSON.stringify(item).substr(1,JSON.stringify(item).length - 2) + "</option>";
                });

                sfxSelect();
            }
        })
    }

    function sfxSelect() {

        var obj = document.getElementById("garage");
        var index = obj.selectedIndex; // 选中索引
        var value = obj.options[index].value; // 选中值

        obj = document.getElementById("carBrand");
        index = obj.selectedIndex;
        var brand = obj.options[index].value;
        $.ajax({
            url:"${pageContext.request.contextPath}/Car/selectCarSfx",
            data: {"garage":value,"brand":brand},
            type:'POST',
            dataType:'JSON',
            cache:true,
            success:function(data){
                //alert(data.size());
                var brand = document.getElementById("sfx");
                var jsonObj=eval(data);
                brand.innerHTML = "";
                $.each(jsonObj, function (i, item) {
                    brand.innerHTML = brand.innerHTML + "<option value=" + JSON.stringify(item) + ">" +JSON.stringify(item).substr(1,JSON.stringify(item).length - 2) + "</option>";
                });
            }
        })
    }

</script>
<jsp:include page="../Site/footer.jsp"/>
</body>
</html>
