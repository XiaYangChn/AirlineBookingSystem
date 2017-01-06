<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ABS_IO</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script>
		function initDate(){
			document.getElementById('dDate').valueAsDate = new Date();
			document.getElementById('aDate').valueAsDate = new Date();
		}
	</script>

	<style>
		input{
			width: 120px;
			text-align: center;
		}
		select{
			width: 120px;
		}
		th, td{
			width: 100px;
			margin: 5px;
			text-align: center;
		}
		.but{
			width: 80px;
		}
	</style>

<body style="text-align: center;" onload="initDate()">

		{"whs", "天河国际机场", "武汉"}	{"shs", "浦东国际机场", "上海"}<br/>
		{"bjs", "首都国际机场", "北京"}	{"szs", "深圳国际机场", "深圳"}<br/>
		{"gzs", "广州国际机场", "广州"}	{"cds", "成都国际机场", "成都"}<br/>	
		{"sys", "沈阳国际机场", "沈阳"}	{"xzs", "西藏国际机场", "西藏"}<br/>	
		{"空客A380", "大"}	{"空客A320", "中"}<br/>
		{"波音747", "大"}	{"波音737", "中"}<br/><br/>

		<form action="servlet/InputServlet" method="post">
				出发日期
			<input id="dDate" type="date" name="depatureDate">
				出发时间
			<input type="time" name="depatureTime" value="00:00:00">
			<br/><br/>

				到达日期
			<input id="aDate" type="date" name="arrivalDate">
				到达时间
			<input type="time" name="arrivalTime" value="00:00:00">
			<br/><br/>

			出发城市
			<select name="depatureAirportCode">
				  <option value ="whs">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;武汉</option>
				  <option value ="bjs">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;北京</option>
				  <option value ="shs">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上海</option>
				  <option value ="gzs">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;广州</option>
				  <option value ="szs">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;深圳</option>
				  <option value ="cds">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;成都</option>
				  <option value ="sys">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;沈阳</option>
				  <option value ="xzs">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;西藏</option>
			</select>
			到达城市
			<select name="arrivalAirportCode">
				  <option value ="bjs">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;北京</option>
				  <option value ="whs">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;武汉</option>
				  <option value ="shs">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上海</option>
				  <option value ="gzs">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;广州</option>
				  <option value ="szs">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;深圳</option>
				  <option value ="cds">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;成都</option>
				  <option value ="sys">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;沈阳</option>
				  <option value ="xzs">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;西藏</option>
			</select>
			<br/><br/>

			飞机类型
			<select name="airplaneName">
				  <option value ="空客A380">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;空客A380</option>
				  <option value ="空客A320">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;空客A320</option>
				  <option value ="波音747">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;波音747</option>
				  <option value ="波音737">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;波音737</option>
			</select>
			航空公司
			<select name="airline">
				  <option value ="1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Airline_1</option>
				  <option value ="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Airline_2</option>
				  <option value ="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Airline_3</option>
			</select>
			<br/><br/>
			
			航班编号
			<input type="text" name="number"  value="1001">
			费&nbsp;&nbsp;用
			<input type="text" name="fare"  value="500">
			<br/><br/>

			<input class="but" type="submit" value="添加航班">
		</form>
		
		<br/><br/>
		<form action="servlet/OutputServlet" method="post">
			<span style="font-size: 20px; margin-right: 12px">实时订单列表</span>
			<input class="but" type="submit" value="刷新">
		</form>
		
		<table style="margin: 20px auto;">
			<tr>
			    <th>订单编号</th>
			    <th>创建日期</th>
			    <th>创建时间</th>
			    <th>订单总额</th>
			    <th>创建人</th>
			    <th>联系方式</th>
			</tr>
			
			<c:forEach items="${list}" var="item">
				<tr>
				    <td>${item.id}</td>
				    <td>${item.createDate}</td>
				    <td>${item.createTime}</td>
				    <td>${item.totalFare}</td>
				    <td>${item.contactName}</td>
				    <td>${item.contactPhone}</td>
				</tr>
			</c:forEach>
		</table>

</body>
</html>
