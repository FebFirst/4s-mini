<%--
  Created by IntelliJ IDEA.
  User: googo
  Date: 16/8/30
  Time: 下午2:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>计划查询框</title>
</head>
<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>
<body>
<form cssClass="mywrapper form-horizontal" id="formSearchBox">

    <div class="form-group">
        <label class="col-sm-12 control-label">年度全车型销售计划查询：</label>
        <div class="col-sm-12">
            <select class="form-control" name="year" id="year" required="required">
                <option value="2010">2010</option>
                <option value="2011">2011</option>
                <option value="2011">2011</option>
                <option value="2013">2013</option>
                <option value="2014">2014</option>
                <option value="2015">2015</option>
                <option value="2016">2016</option>
                <option value="2017">2017</option>
                <option value="2018">2018</option>
                <option value="2019">2019</option>
                <option value="2020">2020</option>
                <option value="2021">2021</option>
                <option value="2022">2022</option>
                <option value="2023">2023</option>
                <option value="2024">2024</option>
                <option value="2025">2025</option>
                <option value="2026">2026</option>
                <option value="2027">2027</option>
                <option value="2028">2028</option>
                <option value="2029">2029</option>
                <option value="2030">2030</option>
                <option value="2031">2031</option>
                <option value="2032">2032</option>
                <option value="2033">2033</option>
                <option value="2034">2034</option>
                <option value="2035">2035</option>
                <option value="2036">2036</option>
                <option value="2037">2037</option>
                <option value="2038">2038</option>
                <option value="2039">2039</option>
                <option value="2040">2040</option>
            </select>
        </div>
        <div class="col-sm-10">
            <input class="btn btn-primary" onclick="selectCarPlan()" value="搜索" readonly="readonly"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-12 control-label">年度全车型价值链预算查询：</label>
        <div class="col-sm-12">
            <select class="form-control" name="year" id="valueChainPlanYear" required="required">
                <option value="2010">2010</option>
                <option value="2011">2011</option>
                <option value="2011">2011</option>
                <option value="2013">2013</option>
                <option value="2014">2014</option>
                <option value="2015">2015</option>
                <option value="2016">2016</option>
                <option value="2017">2017</option>
                <option value="2018">2018</option>
                <option value="2019">2019</option>
                <option value="2020">2020</option>
                <option value="2021">2021</option>
                <option value="2022">2022</option>
                <option value="2023">2023</option>
                <option value="2024">2024</option>
                <option value="2025">2025</option>
                <option value="2026">2026</option>
                <option value="2027">2027</option>
                <option value="2028">2028</option>
                <option value="2029">2029</option>
                <option value="2030">2030</option>
                <option value="2031">2031</option>
                <option value="2032">2032</option>
                <option value="2033">2033</option>
                <option value="2034">2034</option>
                <option value="2035">2035</option>
                <option value="2036">2036</option>
                <option value="2037">2037</option>
                <option value="2038">2038</option>
                <option value="2039">2039</option>
                <option value="2040">2040</option>
            </select>
        </div>
        <div class="col-sm-10">
            <input class="btn btn-primary" onclick="selectValueChainPlanYear()" value="搜索" readonly="readonly"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-12 control-label">年度全车型单车预算查询：</label>
        <div class="col-sm-12">
            <select class="form-control" name="year" id="singleCarPlanYear" required="required">
                <option value="2010">2010</option>
                <option value="2011">2011</option>
                <option value="2011">2011</option>
                <option value="2013">2013</option>
                <option value="2014">2014</option>
                <option value="2015">2015</option>
                <option value="2016">2016</option>
                <option value="2017">2017</option>
                <option value="2018">2018</option>
                <option value="2019">2019</option>
                <option value="2020">2020</option>
                <option value="2021">2021</option>
                <option value="2022">2022</option>
                <option value="2023">2023</option>
                <option value="2024">2024</option>
                <option value="2025">2025</option>
                <option value="2026">2026</option>
                <option value="2027">2027</option>
                <option value="2028">2028</option>
                <option value="2029">2029</option>
                <option value="2030">2030</option>
                <option value="2031">2031</option>
                <option value="2032">2032</option>
                <option value="2033">2033</option>
                <option value="2034">2034</option>
                <option value="2035">2035</option>
                <option value="2036">2036</option>
                <option value="2037">2037</option>
                <option value="2038">2038</option>
                <option value="2039">2039</option>
                <option value="2040">2040</option>
            </select>
        </div>
        <div class="col-sm-12">
            <select class="form-control" name="year" id="singleMonth" required="required">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
            </select>
        </div>
        <div class="col-sm-10">
            <input class="btn btn-primary" onclick="selectSingleCarPlanYear()" value="搜索" readonly/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-12 control-label">年度全车型利润预算查询：</label>
        <div class="col-sm-12">
            <select class="form-control" name="year" id="carTypePlanYear" required="required">
                <option value="2010">2010</option>
                <option value="2011">2011</option>
                <option value="2011">2011</option>
                <option value="2013">2013</option>
                <option value="2014">2014</option>
                <option value="2015">2015</option>
                <option value="2016">2016</option>
                <option value="2017">2017</option>
                <option value="2018">2018</option>
                <option value="2019">2019</option>
                <option value="2020">2020</option>
                <option value="2021">2021</option>
                <option value="2022">2022</option>
                <option value="2023">2023</option>
                <option value="2024">2024</option>
                <option value="2025">2025</option>
                <option value="2026">2026</option>
                <option value="2027">2027</option>
                <option value="2028">2028</option>
                <option value="2029">2029</option>
                <option value="2030">2030</option>
                <option value="2031">2031</option>
                <option value="2032">2032</option>
                <option value="2033">2033</option>
                <option value="2034">2034</option>
                <option value="2035">2035</option>
                <option value="2036">2036</option>
                <option value="2037">2037</option>
                <option value="2038">2038</option>
                <option value="2039">2039</option>
                <option value="2040">2040</option>
            </select>
        </div>
        <div class="col-sm-10">
            <input class="btn btn-primary" onclick="selectCarTypePlanYear()" value="搜索" readonly="readonly"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-12 control-label">月度全车型利润预算查询：</label>
        <div class="col-sm-12">
            <select class="form-control" name="year" id="carTypePlanMonth" required="required">
                <option value="2010">2010</option>
                <option value="2011">2011</option>
                <option value="2011">2011</option>
                <option value="2013">2013</option>
                <option value="2014">2014</option>
                <option value="2015">2015</option>
                <option value="2016">2016</option>
                <option value="2017">2017</option>
                <option value="2018">2018</option>
                <option value="2019">2019</option>
                <option value="2020">2020</option>
                <option value="2021">2021</option>
                <option value="2022">2022</option>
                <option value="2023">2023</option>
                <option value="2024">2024</option>
                <option value="2025">2025</option>
                <option value="2026">2026</option>
                <option value="2027">2027</option>
                <option value="2028">2028</option>
                <option value="2029">2029</option>
                <option value="2030">2030</option>
                <option value="2031">2031</option>
                <option value="2032">2032</option>
                <option value="2033">2033</option>
                <option value="2034">2034</option>
                <option value="2035">2035</option>
                <option value="2036">2036</option>
                <option value="2037">2037</option>
                <option value="2038">2038</option>
                <option value="2039">2039</option>
                <option value="2040">2040</option>
            </select>
        </div>
        <div class="col-sm-12">
            <select class="form-control" name="year" id="month" required="required">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
            </select>
        </div>
        <div class="col-sm-10">
            <input class="btn btn-primary" onclick="selectCarTypePlanMonth()" value="搜索" readonly="readonly"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-12 control-label">月度全车型实际利润查询：</label>
        <div class="col-sm-12">
            <select class="form-control" name="year" id="carTypeProfitMonth" required="required">
                <option value="2010">2010</option>
                <option value="2011">2011</option>
                <option value="2011">2011</option>
                <option value="2013">2013</option>
                <option value="2014">2014</option>
                <option value="2015">2015</option>
                <option value="2016">2016</option>
                <option value="2017">2017</option>
                <option value="2018">2018</option>
                <option value="2019">2019</option>
                <option value="2020">2020</option>
                <option value="2021">2021</option>
                <option value="2022">2022</option>
                <option value="2023">2023</option>
                <option value="2024">2024</option>
                <option value="2025">2025</option>
                <option value="2026">2026</option>
                <option value="2027">2027</option>
                <option value="2028">2028</option>
                <option value="2029">2029</option>
                <option value="2030">2030</option>
                <option value="2031">2031</option>
                <option value="2032">2032</option>
                <option value="2033">2033</option>
                <option value="2034">2034</option>
                <option value="2035">2035</option>
                <option value="2036">2036</option>
                <option value="2037">2037</option>
                <option value="2038">2038</option>
                <option value="2039">2039</option>
                <option value="2040">2040</option>
            </select>
        </div>
        <div class="col-sm-12">
            <select class="form-control" name="year" id="profitMonth" required="required">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
            </select>
        </div>
        <div class="col-sm-10">
            <input class="btn btn-primary" onclick="selectCarTypeProfitMonth()" value="搜索" readonly ="readonly"/>
        </div>
    </div>
</form>


</body>
<jsp:include page="../Site/footer.jsp"/>
<script>
    function selectCarPlan() {
        var obj = document.getElementById("year");
        var index = obj.selectedIndex;
        var year = obj.options[index].value;

        window.location="${pageContext.request.contextPath}" +  "/Plan/carPlan/" + year;
    }

    function selectValueChainPlanYear() {
        var obj = document.getElementById("valueChainPlanYear");
        var index = obj.selectedIndex;
        var year = obj.options[index].value;

        window.location="${pageContext.request.contextPath}" +  "/Plan/valueChain/" + year;
    }

    function selectSingleCarPlanYear() {
        var obj = document.getElementById("singleCarPlanYear");
        var index = obj.selectedIndex;
        var year = obj.options[index].value;

        obj = document.getElementById("singleMonth");
        index = obj.selectedIndex;
        var month = obj.options[index].value;
        window.location="${pageContext.request.contextPath}" +  "/Plan/singleCar/" + year + "/" + month;
    }

    function selectCarTypePlanYear() {
        var obj = document.getElementById("carTypePlanYear");
        var index = obj.selectedIndex;
        var year = obj.options[index].value;
        window.location="${pageContext.request.contextPath}" +  "/Plan/carTypeProfitYear/" + year;
    }

    function selectCarTypePlanMonth() {
        var obj = document.getElementById("carTypePlanMonth");
        var index = obj.selectedIndex;
        var year = obj.options[index].value;

        obj = document.getElementById("month");
        index = obj.selectedIndex;
        var month = obj.options[index].value;
        window.location="${pageContext.request.contextPath}" +  "/Plan/carTypeProfitMonth/" + year + "/" +month;
    }

    function selectCarTypeProfitMonth() {
        var obj = document.getElementById("carTypeProfitMonth");
        var index = obj.selectedIndex;
        var year = obj.options[index].value;

        obj = document.getElementById("profitMonth");
        index = obj.selectedIndex;
        var month = obj.options[index].value;
        window.location="${pageContext.request.contextPath}" +  "/Car/carTypeProfit/" + year + "/" +month;
    }
</script>
</html>
