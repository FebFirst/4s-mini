<%--
  Created by IntelliJ IDEA.
  User: googo
  Date: 16/8/31
  Time: 上午1:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>月度全车型实际利润</title>
</head>
<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>
<body>
<div class="mywrapper form-group">
    <label class="control-label">月度全车型实际利润：</label>
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
                <th rowspan="2" valign="center">变动毛利</th>
                <th rowspan="2" valign="center">变动费用</th>
                <th rowspan="2" valign="center">边际利润</th>
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
                        <td>${profit.key}</td>
                        <td>${sfx.key}</td>
                        <td>${sfx.value.number}</td>
                        <td>${sfx.value.carPrice}</td>
                        <td>${sfx.value.carDiscount}</td>
                        <td>${sfx.value.carProfit1}</td>
                        <td>${sfx.value.carPayBack}</td>
                        <td>${sfx.value.carProfit2}</td>
                        <td>${sfx.value.exchangePrice}</td>
                        <td>${sfx.value.exchangeProfit}</td>
                        <td>${sfx.value.giftPrice}</td>
                        <td>${sfx.value.giftProfit}</td>
                        <td>${sfx.value.insurancePrice}</td>
                        <td>${sfx.value.insuranceProfit}</td>
                        <td>${sfx.value.financePrice}</td>
                        <td>${sfx.value.financeProfit}</td>
                        <td>${sfx.value.servicePrice}</td>
                        <td>${sfx.value.serviceProfit}</td>
                        <td>${sfx.value.rebookInsurancePrice}</td>
                        <td>${sfx.value.rebookInsuranceProfit}</td>
                        <td>${sfx.value.vipPrice}</td>
                        <td>${sfx.value.vipProfit}</td>
                        <td>${sfx.value.renderPrice}</td>
                        <td>${sfx.value.renderProfit}</td>
                        <td>${sfx.value.exchangePrice + sfx.value.giftPrice + sfx.value.insurancePrice + sfx.value.financePrice +
                                sfx.value.servicePrice + sfx.value.rebookInsurancePrice + sfx.value.vipPrice + sfx.value.renderPrice}</td>
                        <td>${sfx.value.exchangeProfit + sfx.value.giftProfit + sfx.value.insuranceProfit + sfx.value.financeProfit +
                                sfx.value.serviceProfit + sfx.value.rebookInsuranceProfit + sfx.value.vipProfit + sfx.value.renderProfit}</td>

                        <td>${sfx.value.carDynamicProfit}</td>
                        <td>${sfx.value.carDynamicFee}</td>
                        <td>${sfx.value.carBoundProfit}</td>

                            ${sum0 += sfx.value.number; sum1 += sfx.value.carPrice; sum3 += sfx.value.carDiscount; sum4 += sfx.value.carProfit1;
                                    sum5 += sfx.value.carPayBack; sum6 += sfx.value.carProfit2; sum7 += sfx.value.exchangePrice; sum8 +=sfx.value.exchangeProfit;
                                    sum9 +=sfx.value.giftPrice; sum10 += sfx.value.giftProfit;  sum11 +=sfx.value.insurancePrice; sum12 +=sfx.value.insuranceProfit;
                                    sum13 +=sfx.value.financePrice; sum14 +=sfx.value.financeProfit; sum15 +=sfx.value.servicePrice; sum16 +=sfx.value.serviceProfit;
                                    sum17 +=sfx.value.rebookInsurancePrice; sum18 +=sfx.value.rebookInsuranceProfit; sum19 +=sfx.value.rebookInsuranceSaturate; sum20 +=sfx.value.vipPrice;
                                    sum21 +=sfx.value.vipProfit; sum22 +=sfx.value.renderPrice; sum23 +=sfx.value.renderProfit; sum24 +=sfx.value.renderSaturate*sfx.value.number;
                                    sum25 += (sfx.value.exchangePrice + sfx.value.giftPrice + sfx.value.insurancePrice + sfx.value.financePrice +
                                            sfx.value.servicePrice + sfx.value.rebookInsurancePrice + sfx.value.vipPrice + sfx.value.renderPrice);
                                    sum26 += (sfx.value.exchangeProfit + sfx.value.giftProfit + sfx.value.insuranceProfit + sfx.value.financeProfit +
                                            sfx.value.serviceProfit + sfx.value.rebookInsuranceProfit + sfx.value.vipProfit + sfx.value.renderProfit);
                                    sum27 += sfx.value.carDynamicProfit; sum28 += sfx.value.carDynamicFee; sum29 += sfx.value.carBoundProfit}
                    </tr>
                </c:forEach>
                <tr>
                    <td>${profit.key}</td>
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
                    <td>${sum12}</td>
                    <td>${sum13}</td>
                    <td>${sum14}</td>
                    <td>${sum15}</td>
                    <td>${sum16}</td>
                    <td>${sum17}</td>
                    <td>${sum18}</td>
                    <td>${sum19}</td>
                    <td>${sum20}</td>
                    <td>${sum21}</td>
                    <td>${sum22}</td>
                    <td>${sum23}</td>
                    <td>${sum24}</td>
                    <td>${sum25}</td>
                    <td>${sum26}</td>
                    <td>${sum27}</td>
                    <td>${sum28}</td>
                    <td>${sum29}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>

</body>
</html>

