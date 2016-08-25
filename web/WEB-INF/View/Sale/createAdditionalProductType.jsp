<%--
  Created by IntelliJ IDEA.
  User: googo
  Date: 16/8/14
  Time: 下午11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加水平事业类别</title>
</head>

<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>


<body>
<form:form cssClass="mywrapper form-horizontal" id="formAddAdditionalProductType" method="post" commandName="AdditionalProductType" action="${pageContext.request.contextPath}/Sale/createAdditionalProductType">

    <div class="form-group">
        <label class="col-sm-2 control-label">水平事业类别：</label>
        <div class="col-sm-7">
            <form:input cssClass="form-control" id="type" path="type"/>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-2"></div>
        <div class="col-sm-7" id="msg">
            <input class="btn btn-primary" onclick="existsChecking()" value="提交" readonly="readonly"/>
        </div>
    </div>
</form:form>
<script>
    function existsChecking() {
        var obj = document.getElementById("type");
        var type = obj.value;
        //alert(type);
        $.ajax({
            url: "${pageContext.request.contextPath}/Sale/additionalProductTypeExists",
            data:{"type":type},
            type: 'POST',
            dataType:'JSON',
            success:function (data) {
                if(data.message == "false"){
                    // alert("haha");
                    var form = document.getElementById("formAddAdditionalProductType");
                    form.submit();
                }else{
                    var html = document.getElementById("msg");
                    html.innerHTML = "<input class='btn btn-primary' value='提交' onclick='existsChecking()' readonly='readonly'/>" + "此类型已经存在!";

                }
            },
            error:function () {
                //alert("是啊");
                var html = document.getElementById("msg");
                html.innerHTML = "<input class='btn btn-primary' value='提交' onclick='existsChecking()' readonly='readonly'/>" + "此类型已经存在!";
            }
        })



    }

</script>
<jsp:include page="../Site/footer.jsp"/>

</body>
</html>