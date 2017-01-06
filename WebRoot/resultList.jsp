<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>ABS_ResultList</title>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<base href="<%=basePath%>">
	<link rel="SHORTCUT ICON" href="<%=path %>/images/airplane.icon"/>
	
	<link rel="stylesheet" href="css/cube.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/absBase.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/resultList.css">

	<script type="text/javascript" src="<%=path %>/js/reslutList.js"></script>
</head>
<body onload="InitSelect('${currentDepartureCity}', '${currentArrivalCity}')">
	<div class="abs_container clearfix r_container" id="tripItemContainer">
		<form action="servlet/SearchServlet" method="post" class="r_top clearfix">
			<select class="r_top_select" onchange="selectChange(this)">
			  <option value ="oneWay">单程</option>
			  <option value ="roundTrip">往返</option>
			</select>
			<div class="r_top_text">
				<img class="r_icon" src="images/departure_icon.png">
				<!-- <input type="text" name="departureCity" placeholder="出发城市" onfocus="textOnFocus(this)" onblur="textOnBlur(this)" value="${currentDepartureCity}"> -->
				<select id="departureSelect" name="departureCity" onfocus="textOnFocus(this)" onblur="textOnBlur(this)" >
				  <option></option>
				  <option value ="武汉">武汉</option>
				  <option value ="北京">北京</option>
				  <option value ="上海">上海</option>
				  <option value ="广州">广州</option>
				  <option value ="深圳">深圳</option>
				  <option value ="成都">成都</option>
				  <option value ="沈阳">沈阳</option>
				  <option value ="西藏">西藏</option>
				</select>
			</div>
			<div class="r_top_text">
				<img class="r_icon" src="images/departure_time_icon.png">
				<!-- <input type="text" name="arrivalCity" placeholder="到达城市" onfocus="textOnFocus(this)" onblur="textOnBlur(this)" value="${currentArrivalCity}"> -->
				<select id="arrivalSelect" name="arrivalCity" onfocus="textOnFocus(this)" onblur="textOnBlur(this)" >
				  <option></option>
				  <option value ="武汉">武汉</option>
				  <option value ="北京">北京</option>
				  <option value ="上海">上海</option>
				  <option value ="广州">广州</option>
				  <option value ="深圳">深圳</option>
				  <option value ="成都">成都</option>
				  <option value ="沈阳">沈阳</option>
				  <option value ="西藏">西藏</option>
				</select>
			</div>
			<div class="r_top_text">
				<img class="r_icon" src="images/desi_icon.png">
				<input id="dDate" type="date" name="departureDate" onfocus="textOnFocus(this)" onblur="textOnBlur(this)" value="${currentDepartureDate}">
			</div>
			<div class="r_top_text">
				<img class="r_icon" src="images/desi_time_icon.png">
				<input id="aDate" type="date" name="returnDate" onfocus="textOnFocus(this)" onblur="textOnBlur(this)" id="s_returnDate" disabled="disabled">
			</div>
			<input class="r_top_but" type="submit" value="重新搜索">
		</form>

		<div class="r_title clearfix" id="r_title">
			<span class="r_title_header">航班信息</span>

			<label id="r_label_1" class="r_title_item1 user_unSelect" onclick="changeSortType('r_label_1')">
				<span>起飞时间</span>
				<div class="r_title_sortIcon">
					<img src="images/icon_up_blue.png">
					<img src="images/icon_down_gray.png">
				</div>
			</label>

			<label id="r_label_2" class="r_title_item2 user_unSelect" onclick="changeSortType('r_label_2')">
				<span>到达时间</span>
				<div class="r_title_sortIcon">
					<img src="images/icon_up_gray.png">
					<img src="images/icon_down_gray.png">
				</div>
			</label>

			<label id="r_label_3" class="r_title_item3 user_unSelect" onclick="changeSortType('r_label_3')">
				<span>价格</span>
				<div class="r_title_sortIcon">
					<img src="images/icon_up_gray.png">
					<img src="images/icon_down_gray.png">
				</div>
			</label>
		</div>

		<!-- result list area -->
		<%-- 直达航班 --%>
		<c:forEach items="${list}" var="item" varStatus="current">
			<div class="r_resultItem clearfix tripItem">
				<div class="r_resultItemBox clearfix">
					<div class="r_result_col width_20"></div>
					<div class="r_result_col width_180">
						<span class="r_airline">${item.airlineName}  <span>${item.airlineCode}${item.number}</span></span> 
						<span class="r_airplane">${item.airplaneName} </span>
					</div>
					<div class="r_result_col width_140">
						<span class="r_departureTime">
							<fmt:formatDate value="${item.depatureTime}" type="both" pattern="HH:mm"/>
						</span>
						<span class="r_departureCity">${item.depatureAirportName}</span>
					</div>
					<div class="r_result_col width_100">
						<img class="r_arrow" src="images/result_arrow.png">
					</div>
					<div class="r_result_col width_140">
						<span class="r_destinationTime">
							<fmt:formatDate value="${item.arrivalTime}" type="both" pattern="HH:mm"/>
						</span>
						<span class="r_destinationCity">${item.arrivalAirportName}</span>
					</div>
					<div class="r_result_col width_150 r_detail">
						<span>
							<fmt:formatNumber type="number" groupingUsed="false" value="${item.fare}" />
							 * ${1}
						</span>
					</div>
					<div class="r_result_col width_150">
						<span class="r_price">￥
							<span>
								<fmt:formatNumber type="number" groupingUsed="false" value="${item.fare}" />
							</span>
						</span>
					</div>
					
					<div class="r_result_col width_100">
						<form action="servlet/BookingServlet" method="post" class="r_button_box">
							<%-- 提交被选中的 FlightInfo的 id --%>
							<input type="hidden" name="flightInfoID" value="${item.id}">
							<input  class="r_button" type="submit" value="提交">
							<c:if test="${item.airplaneEmptySeats < 10}">
								<span class="r_emptySeats">${item.airplaneEmptySeats}张</span>
							</c:if>
						</form>
					</div>
				</div>
			</div>
		</c:forEach>
		
		<%-- 中转组合航班 --%>
		<c:forEach items="${transferList}" var="listItem" varStatus="current">
			<div class="r_resultItem clearfix tripItem">
				<div class="r_resultItemBox clearfix">
					<div class="r_result_col width_20"></div>
					<div class="r_result_col width_180">
						<c:forEach items="${listItem}" var="item" begin="0" end="0">
							<span class="r_airline">${item.airlineName} <span>${item.airlineCode}${item.number}</span></span> 
						</c:forEach>
						<c:forEach items="${listItem}" var="item" begin="1" end="1">
							<span class="r_airline">${item.airlineName} <span>${item.airlineCode}${item.number}</span></span> 
						</c:forEach>
					</div>
					<div class="r_result_col width_140">
						<c:forEach items="${listItem}" var="item" begin="0" end="0">
							<span class="r_departureTime">
								<fmt:formatDate value="${item.depatureTime}" type="both" pattern="HH:mm"/>
							</span>
							<span class="r_departureCity">${item.depatureAirportName}</span>
						</c:forEach>
					</div>
					<div class="r_result_col width_100">
						<span class="r_transfer1_trans1">经停</span>
						<img class="r_transfer1_arrow" src="images/result_arrow.png">
						<c:forEach items="${listItem}" var="item" begin="0" end="0">
							<span class="r_transfer1_trans2">${item.arrivalAirportCity}</span>
						</c:forEach>
					</div>
					<div class="r_result_col width_140">
						<c:forEach items="${listItem}" var="item" begin="1" end="1">
							<span class="r_destinationTime">
								<fmt:formatDate value="${item.arrivalTime}" type="both" pattern="HH:mm"/>
							</span>
							<span class="r_destinationCity">${item.arrivalAirportName}</span>
						</c:forEach>
					</div>
					<div class="r_result_col width_150">
						<c:forEach items="${listItem}" var="item" begin="0" end="0">
							<span class="r_transfer1_fare">
							 	<fmt:formatNumber type="number" groupingUsed="false" value="${item.fare}" />
							 	* 1
							 </span>
							 <c:set var="fare1" value="${item.fare}"/>
						</c:forEach>
						
						<c:forEach items="${listItem}" var="item" begin="1" end="1">
							<span class="r_transfer1_fare">
							 	<fmt:formatNumber type="number" groupingUsed="false" value="${item.fare}" />
							 	* 1
							 </span>
							 <c:set var="fare2" value="${item.fare}"/>
						</c:forEach>
					</div>
					<div class="r_result_col width_150">
						<span class="r_price">
							￥
							<span>
								<fmt:formatNumber type="number" groupingUsed="false" value="${fare1 + fare2}" />
							</span>
						</span>
					</div>
					<div class="r_result_col width_100">
						<form action="servlet/BookingServlet" method="post" class="r_button_box">
							<%-- 提交被选中的 FlightInfo的 id --%>
							<c:forEach items="${listItem}" var="item">
								<input type="hidden" name="flightInfoID" value="${item.id}">
							</c:forEach>
							<input  class="r_button" type="submit" value="提交">
							
							<c:forEach items="${listItem}" var="item" begin="0" end="0">
								<c:set var="seat1" value="${item.airplaneEmptySeats}"/>
							</c:forEach>
							<c:forEach items="${listItem}" var="item" begin="1" end="1">
								<c:set var="seat2" value="${item.airplaneEmptySeats}"/>
							</c:forEach>
							
							<c:if test="${(seat1<seat2?seat1:seat2) < 10}">
								<span class="r_emptySeats">${seat1<seat2?seat1:seat2}张</span>
							</c:if>
						</form>
					</div>
				</div>
			</div>
		</c:forEach>
		
		<c:if test="${noResult == 'noResult'}">
			<div class="r_noResult">
				<span>抱歉！ 没有查询到结果</span>
			</div>
		</c:if>
		
	</div>
</body>
</html>