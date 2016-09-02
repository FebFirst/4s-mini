<%--
  Created by IntelliJ IDEA.
  User: googo
  Date: 16/8/31
  Time: 上午1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>年度全车型利润预算</title>
</head>
<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>
<body>
<div class="mywrapper form-group">
    <label class="control-label">年度全车型利润预算：</label>
    <div class="col-sm-12">
        <table class="table table-bordered table-responsive">
            <thead>
            <tr>
                <th colspan="2">品牌</th>
                <th colspan="4">整车</th>
                <th colspan="2">返利</th>
                <th colspan="2">置换</th>
                <th colspan="2">精品</th>
                <th colspan="2">保险</th>
                <th colspan="2">金融</th>
                <th colspan="2">服务费</th>
                <th colspan="2">延保</th>
                <th colspan="2">会员</th>
                <th colspan="2">租赁</th>
                <th colspan="2">价值链</th>
                <th rowspan="2" valign="middle">变动毛利</th>
                <th rowspan="2" valign="middle">变动费用</th>
                <th rowspan="2" valign="middle">边际利润</th>
            </tr>
            </thead>
            <thead>
            <tr>
                <th>车型</th>
                <th>配置</th>
                <th>台次</th>
                <th>收入</th>
                <th>折扣</th>
                <th>毛利1</th>
                <th>返利</th>
                <th>毛利2</th>
                <th>收入</th>
                <th>毛利</th>
                <th>收入</th>
                <th>毛利</th>
                <th>收入</th>
                <th>毛利</th>
                <th>收入</th>
                <th>毛利</th>
                <th>收入</th>
                <th>毛利</th>
                <th>收入</th>
                <th>毛利</th>
                <th>收入</th>
                <th>毛利</th>
                <th>收入</th>
                <th>毛利</th>
                <th>收入</th>
                <th>毛利</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${carTypeProfit}" var="profit">
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

                <c:set var="sum25" value="0"/>
                <c:set var="sum26" value="0"/>
                <c:set var="sum27" value="0"/>
                <c:set var="sum28" value="0"/>
                <c:set var="sum29" value="0"/>
                <c:forEach items="${profit.value}" var="sfx">
                    <tr>
                        <td class="tableFormat">${profit.key}</td>
                        <td>${sfx.key}</td>
                        <td><fmt:formatNumber value="${sfx.value.number}" pattern="#"/></td>
                        <td><fmt:formatNumber value="${sfx.value.carPrice}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.carDiscount}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.carProfit1}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.carPayBack}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.carProfit2}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.exchangePrice}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.exchangeProfit}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.giftPrice}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.giftProfit}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.insurancePrice}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.insuranceProfit}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.financePrice}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.financeProfit}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.servicePrice}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.serviceProfit}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.rebookInsurancePrice}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.rebookInsuranceProfit}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.vipPrice}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.vipProfit}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.renderPrice}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.renderProfit}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.exchangePrice + sfx.value.giftPrice + sfx.value.insurancePrice + sfx.value.financePrice +
                                sfx.value.servicePrice + sfx.value.rebookInsurancePrice + sfx.value.vipPrice + sfx.value.renderPrice}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.exchangeProfit + sfx.value.giftProfit + sfx.value.insuranceProfit + sfx.value.financeProfit +
                                sfx.value.serviceProfit + sfx.value.rebookInsuranceProfit + sfx.value.vipProfit + sfx.value.renderProfit}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.carDynamicProfit}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.carDynamicFee}" pattern="#.00"/></td>
                        <td><fmt:formatNumber value="${sfx.value.carBoundProfit}" pattern="#.00"/></td>

                        <c:set value="${sum0 + sfx.value.number}" var="sum0" />
                        <c:set value="${sum1 + sfx.value.carPrice}" var="sum1"/>
                        <c:set value="${sum2 + sfx.value.carDiscount}" var="sum2"/>
                        <c:set value="${sum3 + sfx.value.carProfit1}" var="sum3"/>
                        <c:set value="${sum4 + sfx.value.carPayBack}" var="sum4"/>
                        <c:set value="${sum5 + sfx.value.carProfit2}" var="sum5"/>
                        <c:set value="${sum6 + sfx.value.exchangePrice}" var="sum6"/>
                        <c:set value="${sum7 + sfx.value.exchangeProfit}" var="sum7"/>
                        <c:set value="${sum8 + sfx.value.giftPrice}" var="sum8"/>
                        <c:set value="${sum9 + sfx.value.giftProfit}" var="sum9"/>
                        <c:set value="${sum10 + sfx.value.insurancePrice}" var="sum10"/>
                        <c:set value="${sum11 + sfx.value.insuranceProfit}" var="sum11"/>
                        <c:set value="${sum12 + sfx.value.financePrice}" var="sum12"/>
                        <c:set value="${sum13 + sfx.value.financeProfit}" var="sum13"/>
                        <c:set value="${sum14 + sfx.value.servicePrice}" var="sum14"/>
                        <c:set value="${sum15 + sfx.value.serviceProfit}" var="sum15"/>
                        <c:set value="${sum16 + sfx.value.rebookInsurancePrice}" var="sum16"/>
                        <c:set value="${sum17 + sfx.value.rebookInsuranceProfit}" var="sum17"/>
                        <c:set value="${sum18 + sfx.value.vipPrice}" var="sum18"/>
                        <c:set value="${sum19 + sfx.value.vipProfit}" var="sum19"/>
                        <c:set value="${sum20 + sfx.value.renderPrice}" var="sum20"/>
                        <c:set value="${sum21 + sfx.value.renderProfit}" var="sum21"/>
                        <c:set value="${sum22 + sfx.value.exchangePrice + sfx.value.giftPrice + sfx.value.insurancePrice + sfx.value.financePrice +
                                sfx.value.servicePrice + sfx.value.rebookInsurancePrice + sfx.value.vipPrice + sfx.value.renderPrice}" var="sum22"/>
                        <c:set value="${sum23 + sfx.value.exchangeProfit + sfx.value.giftProfit + sfx.value.insuranceProfit + sfx.value.financeProfit +
                                sfx.value.serviceProfit + sfx.value.rebookInsuranceProfit + sfx.value.vipProfit + sfx.value.renderProfit}" var="sum23"/>
                        <c:set value="${sum24 + sfx.value.carDynamicProfit}" var="sum24"/>
                        <c:set value="${sum25 + sfx.value.carDynamicFee}" var="sum25"/>
                        <c:set value="${sum26 + sfx.value.carBoundProfit}" var="sum26"/>
                        <%--<c:set value="" var="sum27"/>--%>
                        <%--<c:set value="" var="sum28"/>--%>
                        <%--<c:set value="" var="sum29"/>--%>
                        <%--<td style="visibility: hidden">${sum0 += sfx.value.number; sum1 += sfx.value.carPrice; sum3 += sfx.value.carDiscount; sum4 += sfx.value.carProfit1;--%>
                                <%--sum5 += sfx.value.carPayBack; sum6 += sfx.value.carProfit2; sum7 += sfx.value.exchangePrice; sum8 +=sfx.value.exchangeProfit;--%>
                                <%--sum9 +=sfx.value.giftPrice; sum10 += sfx.value.giftProfit;  sum11 +=sfx.value.insurancePrice; sum12 +=sfx.value.insuranceProfit;--%>
                                <%--sum13 +=sfx.value.financePrice; sum14 +=sfx.value.financeProfit; sum15 +=sfx.value.servicePrice; sum16 +=sfx.value.serviceProfit;--%>
                                <%--sum17 +=sfx.value.rebookInsurancePrice; sum18 +=sfx.value.rebookInsuranceProfit; sum19 +=sfx.value.rebookInsuranceSaturate; sum20 +=sfx.value.vipPrice;--%>
                                <%--sum21 +=sfx.value.vipProfit; sum22 +=sfx.value.renderPrice; sum23 +=sfx.value.renderProfit; sum24 +=sfx.value.renderSaturate*sfx.value.number;--%>
                                <%--sum25 += (sfx.value.exchangePrice + sfx.value.giftPrice + sfx.value.insurancePrice + sfx.value.financePrice +--%>
                                        <%--sfx.value.servicePrice + sfx.value.rebookInsurancePrice + sfx.value.vipPrice + sfx.value.renderPrice);--%>
                                <%--sum26 += (sfx.value.exchangeProfit + sfx.value.giftProfit + sfx.value.insuranceProfit + sfx.value.financeProfit +--%>
                                        <%--sfx.value.serviceProfit + sfx.value.rebookInsuranceProfit + sfx.value.vipProfit + sfx.value.renderProfit);--%>
                                <%--sum27 += sfx.value.carDynamicProfit; sum28 += sfx.value.carDynamicFee; sum29 += sfx.value.carBoundProfit}--%>
                        <%--</td>--%>
                    </tr>
                </c:forEach>
                <tr bgcolor="gray">
                    <td class="tableFormat">${profit.key}</td>
                    <td>TOTAL</td>
                    <td><fmt:formatNumber value="${sum0}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum1}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum2}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum3}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum4}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum5}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum6}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum7}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum8}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum9}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum10}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum11}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum12}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum13}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum14}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum15}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum16}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum17}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum18}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum19}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum20}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum21}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum22}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum23}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum24}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum25}" pattern="#.00"/></td>
                    <td><fmt:formatNumber value="${sum26}" pattern="#.00"/></td>
                    <%--<td>${sum27}</td>--%>
                    <%--<td>${sum28}</td>--%>
                    <%--<td>${sum29}</td>--%>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>

</body>
<script src="/web_resources/js/tableFormat.js"></script>
</html>
