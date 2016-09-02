<%--
  Created by IntelliJ IDEA.
  User: googo
  Date: 16/8/30
  Time: 下午9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>年度全车型价值链预算</title>
</head>
<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>
<body>
<div class="mywrapper form-group">
    <label class="control-label">年度全车型价值链预算：</label>
    <div class="col-sm-12">
        <table class="table table-bordered table-responsive">
            <thead>
            <tr>
                <th colspan="2">车辆信息</th>
                <th colspan="3">置换</th>
                <th colspan="3">精品</th>
                <th colspan="3">保险</th>
                <th colspan="3">金融</th>
                <th colspan="3">服务费</th>
                <th colspan="3">延保</th>
                <th colspan="3">会员</th>
                <th colspan="3">租赁</th>
            </tr>
            </thead>
            <thead>
            <tr>
                <th>车型</th>
                <th>配置</th>
                <th>收入</th>
                <th>毛利</th>
                <th>渗透率</th>
                <th>收入</th>
                <th>毛利</th>
                <th>渗透率</th>
                <th>收入</th>
                <th>毛利</th>
                <th>渗透率</th>
                <th>收入</th>
                <th>毛利</th>
                <th>渗透率</th>
                <th>收入</th>
                <th>毛利</th>
                <th>渗透率</th>
                <th>收入</th>
                <th>毛利</th>
                <th>渗透率</th>
                <th>收入</th>
                <th>毛利</th>
                <th>渗透率</th>
                <th>收入</th>
                <th>毛利</th>
                <th>渗透率</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${valueChains}" var="valueChain">
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

                <c:set var="sum12" value="0"/>
                <c:set var="sum13" value="0"/>
                <c:set var="sum14" value="0"/>
                <c:set var="sum15" value="0"/>
                <c:set var="sum16" value="0"/>
                <c:set var="sum17" value="0"/>
                <c:set var="sum18" value="0"/>
                <c:set var="sum19" value="0"/>
                <c:set var="sum20" value="0"/>
                <c:set var="sum21" value="0"/>
                <c:set var="sum22" value="0"/>
                <c:set var="sum23" value="0"/>
                <c:set var="sum24" value="0"/>

                <c:forEach items="${valueChain.value}" var="sfx">
                    <tr>
                        <td class="tableFormat" valign="middle" align="center">${valueChain.key}</td>
                        <td>${sfx.key}</td>
                        <td><fmt:formatNumber value="${sfx.value.exchangePrice}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.exchangeProfit}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.exchangeSaturate}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.giftPrice}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.giftProfit}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.giftSaturate}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.insurancePrice}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.insuranceProfit}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.insuranceSaturate}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.financePrice}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.financeProfit}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.financeSaturate}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.servicePrice}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.serviceProfit}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.serviceSaturate}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.rebookInsurancePrice}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.rebookInsuranceProfit}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.rebookInsuranceSaturate}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.vipPrice}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.vipProfit}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.vipSaturate}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.renderPrice}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.renderProfit}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.renderSaturate}" pattern="#.00"/></td>

                        <c:set value="${sum0 + sfx.value.exchangePrice}" var="sum0" />
                        <c:set value="${sum1 + sfx.value.exchangeProfit}" var="sum1"/>
                        <c:set value="${sum2 + sfx.value.exchangeSaturate}" var="sum2"/>
                        <c:set value="${sum3 + sfx.value.giftPrice}" var="sum3"/>
                        <c:set value="${sum4 + sfx.value.giftProfit}" var="sum4"/>
                        <c:set value="${sum5 + sfx.value.giftSaturate}" var="sum5"/>
                        <c:set value="${sum6 + sfx.value.insurancePrice}" var="sum6"/>
                        <c:set value="${sum7 + sfx.value.insuranceProfit}" var="sum7"/>
                        <c:set value="${sum8 + sfx.value.insuranceSaturate}" var="sum8"/>
                        <c:set value="${sum9 + sfx.value.financePrice}" var="sum9"/>
                        <c:set value="${sum10 + sfx.value.financeProfit}" var="sum10"/>
                        <c:set value="${sum11 + sfx.value.financeSaturate}" var="sum11"/>
                        <c:set value="${sum12 + sfx.value.servicePrice}" var="sum12"/>
                        <c:set value="${sum13 + sfx.value.serviceProfit}" var="sum13"/>
                        <c:set value="${sum14 + sfx.value.serviceSaturate}" var="sum14"/>
                        <c:set value="${sum15 + sfx.value.rebookInsurancePrice}" var="sum15"/>
                        <c:set value="${sum16 + sfx.value.rebookInsuranceProfit}" var="sum16"/>
                        <c:set value="${sum17 + sfx.value.rebookInsuranceSaturate}" var="sum17"/>
                        <c:set value="${sum18 + sfx.value.vipPrice}" var="sum18"/>
                        <c:set value="${sum19 + sfx.value.vipProfit}" var="sum19"/>
                        <c:set value="${sum20 + sfx.value.vipSaturate}" var="sum20"/>
                        <c:set value="${sum21 + sfx.value.renderPrice}" var="sum21"/>
                        <c:set value="${sum22 + sfx.value.renderProfit}" var="sum22"/>
                        <c:set value="${sum23 + sfx.value.renderSaturate}" var="sum23"/>
                        <c:set value="${sum24 + sfx.value.number}" var="sum24"/>

                    </tr>
                </c:forEach>
                <tr bgcolor="gray">
                    <td class="tableFormat">${valueChain.key}</td>
                    <td>WAN</td>
                    <td><fmt:formatNumber value="${sum0 /sum24}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum1/sum24}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum2/sum24}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum3/sum24}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum4/sum24}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum5/sum24}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum6/sum24}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum7/sum24}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum8/sum24}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum9/sum24}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum10/sum24}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum11/sum24}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum12/sum24}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum13/sum24}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum14/sum24}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum15/sum24}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum16/sum24}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum17/sum24}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum18/sum24}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum19/sum24}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum20/sum24}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum21/sum24}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum22/sum24}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum23/sum24}" pattern="#.00"/></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>

</body>
<script src="/web_resources/js/tableFormat.js"></script>
</html>
