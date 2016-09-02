<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: googo--%>
  <%--Date: 16/8/26--%>
  <%--Time: 下午6:49--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>订车计划列表</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<jsp:include page="../Site/header.jsp"/>--%>
<%--<jsp:include page="../Site/seperator.jsp"/>--%>
<%--<div class="mywrapper form-group">--%>
    <%--<label class="control-label">现金实绩：</label>--%>
    <%--<div class="col-sm-12">--%>
        <%--<table class="table table-bordered table-responsive">--%>
            <%--<thead>--%>
            <%--<tr>--%>
                <%--<th colspan="2"></th>--%>
                <%--<th>1</th>--%>
                <%--<th>2</th>--%>
                <%--<th>3</th>--%>
                <%--<th>4</th>--%>
                <%--<th>5</th>--%>
                <%--<th>6</th>--%>
                <%--<th>7</th>--%>
                <%--<th>8</th>--%>
                <%--<th>9</th>--%>
                <%--<th>10</th>--%>
                <%--<th>11</th>--%>
                <%--<th>12</th>--%>
                <%--<th>13</th>--%>
                <%--<th>14</th>--%>
                <%--<th>15</th>--%>
                <%--<th>16</th>--%>
                <%--<th>17</th>--%>
                <%--<th>18</th>--%>
                <%--<th>19</th>--%>
                <%--<th>20</th>--%>
                <%--<th>21</th>--%>
                <%--<th>22</th>--%>
                <%--<th>23</th>--%>
                <%--<th>24</th>--%>
                <%--<th>25</th>--%>
                <%--<th>26</th>--%>
                <%--<th>27</th>--%>
                <%--<th>28</th>--%>
                <%--<th>29</th>--%>
                <%--<th>30</th>--%>
                <%--<th>31</th>--%>
            <%--</tr>--%>
            <%--</thead>--%>
            <%--<tbody>--%>
                <%--<tr>--%>
                   <%--<tb rowspan="2">日入</tb>--%>
                    <%--<tb>台次</tb>--%>
                    <%--<c:forEach items="${carsSold}" var="car">--%>
                        <%--<tb>${car.key}</tb>--%>
                    <%--</c:forEach>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<tb>现金</tb>--%>
                    <%--<c:forEach items="${carsSold}" var="car">--%>
                        <%--<tb>${car.value}</tb>--%>
                    <%--</c:forEach>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<tb rowspan="2">日出</tb>--%>
                    <%--<tb>台次</tb>--%>
                    <%--<c:forEach items="${carsPurchased}" var="car">--%>
                        <%--<tb>${car.key}</tb>--%>
                    <%--</c:forEach>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<tb>现金</tb>--%>
                    <%--<c:forEach items="${carsPurchased}" var="car">--%>
                        <%--<tb>${car.value}</tb>--%>
                    <%--</c:forEach>--%>
                <%--</tr>--%>
            <%--<tr>--%>
                <%--<tb colspan="2"> 现金缺口</tb>--%>
            <%--</tr>--%>
            <%--</tbody>--%>
        <%--</table>--%>
    <%--</div>--%>


    <%--<div class="col-sm-12">--%>
        <%--<table class="table table-bordered table-responsive">--%>
            <%--<thead>--%>
            <%--<tr>--%>
                <%--<th colspan="2"></th>--%>
                <%--<th>1</th>--%>
                <%--<th>2</th>--%>
                <%--<th>3</th>--%>
                <%--<th>4</th>--%>
                <%--<th>5</th>--%>
                <%--<th>6</th>--%>
                <%--<th>7</th>--%>
                <%--<th>8</th>--%>
                <%--<th>9</th>--%>
                <%--<th>10</th>--%>
                <%--<th>11</th>--%>
                <%--<th>12</th>--%>
                <%--<th>13</th>--%>
                <%--<th>14</th>--%>
                <%--<th>15</th>--%>
                <%--<th>16</th>--%>
                <%--<th>17</th>--%>
                <%--<th>18</th>--%>
                <%--<th>19</th>--%>
                <%--<th>20</th>--%>
                <%--<th>21</th>--%>
                <%--<th>22</th>--%>
                <%--<th>23</th>--%>
                <%--<th>24</th>--%>
                <%--<th>25</th>--%>
                <%--<th>26</th>--%>
                <%--<th>27</th>--%>
                <%--<th>28</th>--%>
                <%--<th>29</th>--%>
                <%--<th>30</th>--%>
                <%--<th>31</th>--%>
            <%--</tr>--%>
            <%--</thead>--%>
            <%--<tbody>--%>
            <%--<tr>--%>
                <%--<tb rowspan="2">日入</tb>--%>
                <%--<tb>台次</tb>--%>
                <%--<c:forEach items="${carsSold}" var="car">--%>
                    <%--<tb>${car.key}</tb>--%>
                <%--</c:forEach>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<tb>现金</tb>--%>
                <%--<c:forEach items="${carsSold}" var="car">--%>
                    <%--<tb>${car.value}</tb>--%>
                <%--</c:forEach>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<tb rowspan="2">日出</tb>--%>
                <%--<tb>台次</tb>--%>
                <%--<c:forEach items="${carsPurchased}" var="car">--%>
                    <%--<tb>${car.key}</tb>--%>
                <%--</c:forEach>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<tb>现金</tb>--%>
                <%--<c:forEach items="${carsPurchased}" var="car">--%>
                    <%--<tb>${car.value}</tb>--%>
                <%--</c:forEach>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<tb colspan="2"> 现金缺口</tb>--%>
            <%--</tr>--%>
            <%--</tbody>--%>
        <%--</table>--%>
    <%--</div>--%>

<%--</div>--%>
<%--<script>--%>
    <%--function post(url, params) {--%>
        <%--var temp = document.createElement("form");--%>
        <%--temp.action = url;--%>
        <%--temp.method = "post";--%>
        <%--temp.style.display = "none";--%>
        <%--for (var x in params) {--%>
            <%--var opt = document.createElement("input");--%>
            <%--opt.name = x;--%>
            <%--opt.value = params[x];--%>
            <%--temp.appendChild(opt);--%>
        <%--}--%>
        <%--document.body.appendChild(temp);--%>
        <%--temp.submit();--%>
        <%--return temp;--%>
    <%--};--%>

    <%--function stockRegister(garage,brand,sfx,color){--%>
        <%--var data = {"garage":garage, "brand":brand,"sfx":sfx,"color":color};--%>
        <%--post("${pageContext.request.contextPath}/Car/createCarByCarType", data);--%>
    <%--};--%>


<%--</script>--%>

<%--<script>--%>

<%--</script>--%>
<%--<jsp:include page="../Site/footer.jsp"/>--%>
<%--</body>--%>
<%--</html>--%>

