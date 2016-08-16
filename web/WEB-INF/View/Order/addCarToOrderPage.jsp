<%--
  Created by IntelliJ IDEA.
  User: HFQ
  Date: 2016/8/13
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>添加订单</title>
</head>

<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>


<body>
<form class="mywrapper form-horizontal" id="formAddGarage" method="post" action="${pageContext.request.contextPath}/Order/addCarToOrder">

  <div class="form-group">
    <label class="col-sm-2 control-label">订单号：</label>
    <div class="col-sm-7">
     <input id="orderId" class="form-control"/>
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-2 control-label">顾客姓名：</label>
    <div class="col-sm-7">
      <input id="customer" class="form-control">
      <%--<label class="control-label">${car.garage}</label>--%>
      <%--<form:input cssClass="form-control" ID="orderId" path="orderId"/>--%>
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-2 control-label">车架号：</label>
    <div class="col-sm-3">
      <label class="control-label" id="carId">${car.carID}</label>
      <%--<form:input cssClass="form-control" ID="Brand" path="Brand"/>--%>
    </div>
    <div class="col-sm-3">
      <%--<label class="control-label">${car.carID}</label>--%>
      <%--<form:input cssClass="form-control" ID="Brand" path="Brand"/>--%>
      <input class="btn btn-primary" value="车辆详情" onclick="carInfoShow()" readonly="readonly"/>
    </div>
  </div>
<div id="gift">

</div>
  <div id="insurance">

  </div>
  <div class="form-group">
    <div class="col-sm-7">
     <input class="btn btn-primary" value="添加精品" onclick="addGift()">
      <%--<form:input cssClass="form-control" ID="Brand" path="Brand"/>--%>
    </div>
  </div>


  <div class="form-group">
    <div class="col-sm-7">
      <input class="btn btn-primary" value="添加保险" onclick="addInsurance()">
      <%--<form:input cssClass="form-control" ID="Brand" path="Brand"/>--%>
    </div>
  </div>

  <div class="form-group">
    <div class="col-sm-7">
      <input class="form-control" value="" id="predictDate" type="date">
      <%--<form:input cssClass="form-control" ID="Brand" path="Brand"/>--%>
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-2"></div>
    <div class="col-sm-7" id="msg">
      <input class="btn btn-primary" value="提交" onclick="existsChecking()"/>
    </div>
  </div>
</form>


<div class="modal fade" id="carModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close"
                data-dismiss="modal" aria-hidden="true">
        </button>
        <h4 class="modal-title" id="myModalLabel">
         选择精品
        </h4>
      </div>
      <div class="modal-body">
        
        <div class="form-group">
          <label class="col-sm-2 control-label">厂家：</label>
          <div class="col-sm-7">
            <label class="control-label">${car.garage}</label>
            <%--<form:input cssClass="form-control" ID="Brand" path="Brand"/>--%>
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-2 control-label">型号：</label>
          <div class="col-sm-7">
            <label class="control-label">${car.brand}</label>
            <%--<form:input cssClass="form-control" ID="Brand" path="Brand"/>--%>
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-2 control-label">SFX：</label>
          <div class="col-sm-7">
            <label class="control-label">${car.sfx}</label>
            <%--<form:input cssClass="form-control" ID="Brand" path="Brand"/>--%>
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-2 control-label">颜色：</label>
          <div class="col-sm-7">
            <label class="control-label">${car.color}</label>
            <%--<form:input cssClass="form-control" ID="Brand" path="Brand"/>--%>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default"
                data-dismiss="modal">关闭
        </button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal -->
</div>
To be implemented 检查重复
<jsp:include page="../Site/footer.jsp"/>
<script>
  function carInfoShow() {
    $('#carModal').modal('show');
  }

  function getGiftName(divNum) {
    var obj = document.getElementById("GiftType" + divNum);
    var index = obj.selectedIndex; // 选中索引

    var value = obj.options[index].value; // 选中值
    $.ajax({
      url:"${pageContext.request.contextPath}/Sale/selectGiftName",
      data: {"type":value},
      type:'POST',
      dataType:'JSON',
      cache:true,
      success:function(data){
        var nameHtml = document.getElementById("giftName" + divNum);
        var jsonObj=eval(data);
        nameHtml.innerHTML = "";
        $.each(jsonObj, function (i, item) {
          nameHtml.innerHTML = nameHtml.innerHTML + "<option value=" + item + ">" +item + "</option>";
        });
      },
      error:function () {
        alert("gift name error");
      }
    })
  }

  function addGift() {
    var gift = document.getElementById("gift");
    var divNum = gift.getElementsByTagName("div").length/4 + 1;
    gift.innerHTML = gift.innerHTML +
            "<div class='form-group'> <label class='col-sm-2 control-label'>精品类别 :</label> " +
            "<div class='col-sm-7'> <select class='form-control'  id='GiftType" + divNum +
            "' onchange='getGiftName(" +divNum +
            ")'></select> </div> </div>" +  "<div class='form-group'> <label class='col-sm-2 control-label'>精品名称 :</label> " +
            "<div class='col-sm-7'> <select class='form-control'  id='giftName" + divNum +
            "'></select> </div> </div>";
    $.ajax({
      url:"${pageContext.request.contextPath}/Sale/getGiftType",
      type:'POST',
      dataType:'JSON',
      cache:true,
      success:function(data){
        var type = document.getElementById("GiftType"+divNum);
        var jsonObj=eval(data);
        type.innerHTML = "";
        $.each(jsonObj, function (i, item) {
         type.innerHTML = type.innerHTML + "<option value=" + item + ">" +item + "</option>";
        });
        getGiftName(divNum);
      },
      error:function () {
        alert("error");
      }
    });
  }


  function getInsuranceName(divNum) {
    var obj = document.getElementById("insuranceType" + divNum);
    var index = obj.selectedIndex; // 选中索引

    var value = obj.options[index].value; // 选中值
    $.ajax({
      url:"${pageContext.request.contextPath}/Sale/selectInsuranceName",
      data: {"type":value},
      type:'POST',
      dataType:'JSON',
      cache:true,
      success:function(data){
        var nameHtml = document.getElementById("insuranceName" + divNum);
        var jsonObj=eval(data);
        nameHtml.innerHTML = "";
        $.each(jsonObj, function (i, item) {
          nameHtml.innerHTML = nameHtml.innerHTML + "<option value=" + item + ">" +item + "</option>";
        });
      },
      error:function () {
        alert("gift name error");
      }
    })
  }
  function addInsurance() {
    var insurance = document.getElementById("insurance");
    var divNum = insurance.getElementsByTagName("div").length/4 + 1;
    insurance.innerHTML = insurance.innerHTML +
            "<div class='form-group'> <label class='col-sm-2 control-label'>保险类别 :</label> " +
            "<div class='col-sm-7'> <select class='form-control'  id='insuranceType" + divNum +
            "' onchange='getInsuranceName(" +divNum +
            ")'></select> </div> </div>" +  "<div class='form-group'> <label class='col-sm-2 control-label'>保险名称 :</label> " +
            "<div class='col-sm-7'> <select class='form-control'  id='insuranceName" + divNum +
            "'></select> </div> </div>";
    $.ajax({
      url:"${pageContext.request.contextPath}/Sale/getInsuranceType",
      type:'POST',
      dataType:'JSON',
      cache:true,
      success:function(data){
        var type = document.getElementById("insuranceType"+divNum);
        var jsonObj=eval(data);
        type.innerHTML = "";
        $.each(jsonObj, function (i, item) {
          type.innerHTML = type.innerHTML + "<option value=" + item + ">" +item + "</option>";
        });
        getInsuranceName(divNum);
      },
      error:function () {
        alert("error");
      }
    });
  }
</script>

<script>
  function existsChecking() {
    var orderId = document.getElementById("orderId").value;
    infoSubmit(orderId);
    <%--$.ajax({--%>
      <%--url: "${pageContext.request.contextPath}/Order/orderExists",--%>
      <%--data:{"orderId":orderId},--%>
      <%--type: 'POST',--%>
      <%--dataType:'JSON',--%>
      <%--success:function (data) {--%>
        <%--if(data.message == "false"){--%>
         <%--infoSubmit(orderId);--%>
        <%--}else{--%>
          <%--var html = document.getElementById("msg");--%>
          <%--html.innerHTML = "<input class='btn btn-primary' value='提交' onclick='existsChecking()' readonly='readonly'>" + "此类型已经存在!";--%>
        <%--}--%>
      <%--},--%>
      <%--error:function () {--%>
        <%--var html = document.getElementById("msg");--%>
        <%--html.innerHTML = "<input class='btn btn-primary' value='提交' onclick='existsChecking()' readonly='readonly'>" + "此类型已经存在!";--%>
      <%--}--%>
    <%--})--%>
  }

  function infoSubmit(orderId) {
    var carId = document.getElementById("carId").innerHTML;
    var customer = document.getElementById("customer").value;
    var predictDate = document.getElementById("predictDate").value;

    var giftDivNum = document.getElementById("gift").getElementsByTagName("div").length/4;
    var insuranceDivNum = document.getElementById("insurance").getElementsByTagName("div").length/4;

    var obj;
    var index;
    var type
    var name;
    var info;

    var giftsData = [];
    for(var i = 1; i <= giftDivNum; i ++){

      obj = document.getElementById("GiftType" + i);
      index = obj.selectedIndex; // 选中索引

      type = obj.options[index].value; // 选中值


      obj = document.getElementById("giftName" + i);
      index = obj.selectedIndex;
      name = obj.options[index].value;

      info = {"type": type, "name": name};
      giftsData.push(info);
    }


    var insuranceData = [];
    //alert(insuranceDivNum);
    for( i = 1; i <= insuranceDivNum; i++){


      obj = document.getElementById("insuranceType" + i);
      index = obj.selectedIndex; // 选中索引
      type = obj.options[index].value; // 选中值
     // alert(type);

      obj = document.getElementById("insuranceName" + i);
      index = obj.selectedIndex;
      name = obj.options[index].value;

      info = {"type": type, "name": name};
      insuranceData.push(info);
    }



    var data = {"orderId":orderId,"carId":carId,"customer":customer,"predictDate":predictDate,"gifts": JSON.stringify(giftsData),"insurances":JSON.stringify(insuranceData)};

    post("${pageContext.request.contextPath}/Order/createOrder", data);

  }

  function post(url, params) {
    var temp = document.createElement("form");
    temp.action = url;
    temp.method = "post";
    temp.style.display = "none";
    for (var x in params) {
      var opt = document.createElement("input");
      opt.name = x;
      opt.value = params[x];
      temp.appendChild(opt);
    }
    document.body.appendChild(temp);
    temp.submit();
    return temp;
  };
</script>
</body>
</html>