<%--
  Created by IntelliJ IDEA.
  User: googo
  Date: 16/8/22
  Time: 下午2:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>顾客信息完善</title>
</head>

<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>
<body>
<form:form cssClass="mywrapper form-horizontal" id="formAddCustomer" method="post" commandName="customer" action="${pageContext.request.contextPath}/User/createCustomer">

    <div class="form-group" align="center">
        <label class="col-sm-2 control-label">姓名 :</label>
        <div class="col-sm-3">
            <form:input cssClass="form-control" ID="name" path="name"/>
        </div>
    </div>

    <div class="form-group" align="center">
        <label class="col-sm-2 control-label">手机号 :</label>
        <div class="col-sm-3">
            <form:input cssClass="form-control" ID="cellphone" path="cellphone"/>
        </div>
    </div>

    <div class="form-group" align="center">
        <label class="col-sm-2 control-label">微信 :</label>
        <div class="col-sm-3">
            <form:input cssClass="form-control" ID="wechat" path="wechat"/>
        </div>
    </div>

    <div class="form-group" align="center">
        <label class="col-sm-2 control-label">性别 :</label>
        <div class="col-sm-3">
            <select class="form-control" name="apartment">
                <option value="男">男</option>
                <option value="女">女</option>
            </select>
        </div>
    </div>

    <div class="form-group" align="center">
        <label class="col-sm-2 control-label">行业 :</label>
        <div class="col-sm-3">
            <select class="form-control" name="occupation">
                <option value="未知">未知</option>
                <option value="制造业">制造业</option>
                <option value="批发零售业">批发零售业</option>
                <option value="交通运输">交通运输</option>
                <option value="教育文化和广播电视业">教育文化和广播电视业</option>
                <option value="卫生体育和社会福利餐饮业">卫生体育和社会福利餐饮业</option>
                <option value="IT业">IT业</option>
                <option value="房地产">房地产</option>
                <option value="社会服务业">社会服务业</option>
                <option value="金融保险业">金融保险业</option>
                <option value="科研综合技术服务业">科研综合技术服务业</option>
                <option value="建筑业">建筑业</option>
                <option value="电力煤气水供应生产业">电力煤气水供应生产业</option>
                <option value="自由职业">自由职业</option>
            </select>
        </div>
    </div>

    <div class="form-group" align="center">
        <label class="col-sm-2 control-label">单位性质 :</label>
        <div class="col-sm-3">
            <select class="form-control" name="occupationType">
                <option value="政府部门">政府部门</option>
                <option value="军警司法机关">军警司法机关</option>
                <option value="事业单位">事业单位</option>
                <option value="国企">国企</option>
                <option value="合资企业">合资企业</option>
                <option value="民营企业">民营企业</option>
                <option value="股份制企业">股份制企业</option>
                <option value="其他">其他</option>
            </select>
        </div>
    </div>

    <div class="form-group" align="center">
        <label class="col-sm-2 control-label">职业 :</label>
        <div class="col-sm-3">
            <select class="form-control" name="job">
                <option value="企业主">企业主</option>
                <option value="公务员">公务员</option>
                <option value="企业一般管理者">企业一般管理者</option>
                <option value="企业中高级管理者">企业中高级管理者</option>
                <option value="学生或退休人员">学生或退休人员</option>
                <option value="家庭主妇">家庭主妇</option>
                <option value="专业技术人员">专业技术人员</option>
                <option value="自由职业者">自由职业者</option>
                <option value="其他">其他</option>
            </select>
        </div>
    </div>

    <div class="form-group" align="center">
        <label class="col-sm-2 control-label">家庭成员构成 :</label>
        <div class="col-sm-3">
            <select class="form-control" name="familySize">
                <option value="2">2人或以下</option>
                <option value="3">3人</option>
                <option value="4">4人</option>
                <option value="5">5人或以上</option>
            </select>
        </div>
    </div>
    <div class="form-group" align="center">
        <label class="col-sm-2 control-label">爱好 :</label>
        <div class="col-sm-3">
            <select class="form-control" name="hobby">
                <option value="旅游">旅游</option>
                <option value="钓鱼">钓鱼</option>
                <option value="高尔夫">高尔夫</option>
                <option value="聚会">聚会</option>
                <option value="篮球">篮球</option>
                <option value="美食">美食</option>
                <option value="爬山">爬山</option>
                <option value="摄影">摄影</option>
                <option value="室内健身">室内健身</option>
                <option value="书法">书法</option>
                <option value="拓展训练">拓展训练</option>
                <option value="舞蹈">舞蹈</option>
                <option value="写作">写作</option>
                <option value="知识讲座">知识讲座</option>
                <option value="足球">足球</option>
                <option value="其他">其他</option>
            </select>
        </div>
    </div>
    <div class="form-group" align="center">
        <label class="col-sm-2 control-label">个人年收入 :</label>
        <div class="col-sm-3">
            <select class="form-control" name="income">
                <option value="10">10万元以下</option>
                <option value="20">10-20万元</option>
                <option value="30">20-30万元</option>
                <option value="40">30-40万元</option>
                <option value="50">40万元以上</option>
            </select>
        </div>
    </div>

    <div class="form-group" align="center">
        <label class="col-sm-2 control-label">用车年限 :</label>
        <div class="col-sm-3">
            <select class="form-control" name="years">
                <option value="1">1年</option>
                <option value="2">2年</option>
                <option value="3">3年</option>
                <option value="4">4年</option>
                <option value="5">5年</option>
                <option value="6">5年以上</option>
            </select>
        </div>
    </div>

    <div class="form-group" align="center">
        <label class="col-sm-2 control-label">客户来源 :</label>
        <div class="col-sm-3">
            <select class="form-control" name="source">
                <option value="自然来店">自然来店</option>
                <option value="增换转">增换转</option>
                <option value="员工推荐">员工推荐</option>
                <option value="车展巡展">车展巡展</option>
                <option value="店头活动">店头活动</option>
                <option value="广播">广播</option>
                <option value="电视">电视</option>
                <option value="报纸">报纸</option>
                <option value="户外">户外</option>
                <option value="POP">POP</option>
                <option value="DM">DM</option>
                <option value="电话">电话</option>
                <option value="短信">短信</option>
                <option value="网站">网站</option>
                <option value="APP">APP</option>
                <option value="IM">IM</option>
                <option value="其他">其他</option>
            </select>
        </div>
    </div>

    <div class="form-group" align="center">
        <div class="col-sm-2"></div>
        <div class="col-sm-7">
            <button type="submit" class="btn btn-primary">提交</button>
        </div>
    </div>
</form:form>

<jsp:include page="../Site/footer.jsp"/>

</body>
</html>
