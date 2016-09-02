<%--
  Created by IntelliJ IDEA.
  User: googo
  Date: 16/8/30
  Time: 下午1:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>年度全车型销量计划</title>
</head>
<body>
<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>
<div class="mywrapper form-group">
    <label class="control-label">年度全车型销量计划：</label>
    <div class="col-sm-12">
        <table class="table table-bordered table-responsive">
            <thead>
            <tr>
                <th>品牌</th>
                <th>配置</th>
                <th>1月</th>
                <th>2月</th>
                <th>3月</th>
                <th>4月</th>
                <th>5月</th>
                <th>6月</th>
                <th>7月</th>
                <th>8月</th>
                <th>9月</th>
                <th>10月</th>
                <th>11月</th>
                <th>12月</th>
                <th>TOTAL</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${carPlans}" var="carPlan">
                <c:set var="sum0" value="0"/>
                <c:set var="sum1" value="0"/>
                <c:set var="sum2" value="0"/>
                <c:set var="sum3" value="0"/>
                <c:set var="sum4" value="0"/>
                <c:set var="sum5" value="0"/>
                <c:set var="sum6" value="0"/>
                <c:set var="sum7" value="0"/>
                <c:set var="sum8" value="0"/>
                <c:set var="sum9" value="0"/>
                <c:set var="sum10" value="0"/>
                <c:set var="sum11" value="0"/>

                <c:forEach items="${carPlan.value}" var="sfx">
                <tr>
                    <td class="tableFormat">${carPlan.key}</td>
                    <td>${sfx.key}</td>
                    <td>${sfx.value[0]}</td>
                    <td>${sfx.value[1]}</td>
                    <td>${sfx.value[2]}</td>
                    <td>${sfx.value[3]}</td>
                    <td>${sfx.value[4]}</td>
                    <td>${sfx.value[5]}</td>
                    <td>${sfx.value[6]}</td>
                    <td>${sfx.value[7]}</td>
                    <td>${sfx.value[8]}</td>
                    <td>${sfx.value[9]}</td>
                    <td>${sfx.value[10]}</td>
                    <td>${sfx.value[11]}</td>
                    <td>${sfx.value[0] + sfx.value[1] +sfx.value[2] +sfx.value[3] + sfx.value[4] + sfx.value[5]
                        +sfx.value[6] +sfx.value[7] +sfx.value[8] +sfx.value[9]+ sfx.value[10]+ sfx.value[11]}</td>
                    <%--<td style="visibility: hidden">${sum0 += sfx.value[0]; sum1 += sfx.value[1]; sum2 += sfx.value[2]; sum3 += sfx.value[3]; sum4 += sfx.value[4]; sum5 += sfx.value[5];--%>
                           <%--sum6 += sfx.value[6]; sum7 += sfx.value[7]; sum8 += sfx.value[8]; sum9 += sfx.value[9]; sum10 += sfx.value[10]; sum11 += sfx.value[11]}--%>
                        <c:set value="${sum0 + sfx.value[0]}" var="sum0" />
                        <c:set value="${sum1 + sfx.value[1]}" var="sum1"/>
                        <c:set value="${sum2 + sfx.value[2]}" var="sum2"/>
                        <c:set value="${sum3 + sfx.value[3]}" var="sum3"/>
                        <c:set value="${sum4 + sfx.value[4]}" var="sum4"/>
                        <c:set value="${sum5 + sfx.value[5]}" var="sum5"/>
                        <c:set value="${sum6 + sfx.value[6]}" var="sum6"/>
                        <c:set value="${sum7 + sfx.value[7]}" var="sum7"/>
                        <c:set value="${sum8 + sfx.value[8]}" var="sum8"/>
                        <c:set value="${sum9 + sfx.value[9]}" var="sum9"/>
                        <c:set value="${sum10 + sfx.value[10]}" var="sum10"/>
                        <c:set value="${sum11 + sfx.value[11]}" var="sum11"/>

                </tr>
                </c:forEach>
                <tr bgcolor="gray">
                    <td class="tableFormat">${carPlan.key}</td>
                    <td>TOTAL</td>
                    <td>${sum0}</td>
                    <td>${sum1}</td>
                    <td>${sum2}</td>
                    <td>${sum3}</td>
                    <td>${sum4}</td>
                    <td>${sum5}</td>
                    <td>${sum6}</td>
                    <td>${sum7}</td>
                    <td>${sum8}</td>
                    <td>${sum9}</td>
                    <td>${sum10}</td>
                    <td>${sum11}</td>
                    <td>${sum0 + sum1 + sum2 + sum3 + sum4 + sum5 +
                          sum6 + sum7 + sum8 + sum9 + sum10 + sum11}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>

</body>
<script src="/web_resources/js/tableFormat.js"></script>
</html>